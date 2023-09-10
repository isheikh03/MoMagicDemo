package com.isheikh03.moMagicDemo.appProcess;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.isheikh03.moMagicDemo.appConfig.AppConfigEntity;
import com.isheikh03.moMagicDemo.appConfig.AppConfigService;
import com.isheikh03.moMagicDemo.chargeConfig.ChargeConfigEntity;
import com.isheikh03.moMagicDemo.chargeConfig.ChargeConfigService;
import com.isheikh03.moMagicDemo.chargeFailLog.ChargeFailLogEntity;
import com.isheikh03.moMagicDemo.chargeFailLog.ChargeFailLogService;
import com.isheikh03.moMagicDemo.chargeSuccessLog.ChargeSuccessLogEntity;
import com.isheikh03.moMagicDemo.chargeSuccessLog.ChargeSuccessLogService;
import com.isheikh03.moMagicDemo.inbox.InboxEntity;
import com.isheikh03.moMagicDemo.inbox.InboxService;
import com.isheikh03.moMagicDemo.keywordDetails.KeywordDetailsEntity;
import com.isheikh03.moMagicDemo.keywordDetails.KeywordDetailsService;

@Service
public class AppProcessService extends Thread {
	
	@Autowired
	public AppConfigService appConfigService;
	@Autowired
	public InboxService inboxService;
	@Autowired
	public KeywordDetailsService keywordDetailsService;
	@Autowired
	public ChargeConfigService chargeConfigService;
	@Autowired
	public ChargeFailLogService chargeFailLogService;
	@Autowired
	public ChargeSuccessLogService chargeSuccessLogService;
	   
    public void appProcess() {
       
		AppConfigEntity appConfig = appConfigService.findAppConfig();
		if(appConfig !=null && appConfig.getStatus()==1) {
			System.out.println("App Process===================>On");
			List<InboxEntity> smsList = inboxService.findListByLimit(appConfig.getNumberOfRow());
			
			if(smsList!=null) {
				RestTemplate restTemplate = new RestTemplate();
				
				for (InboxEntity inboxSms : smsList) {
					KeywordDetailsEntity keywordDtl = keywordDetailsService.findByKeyword(inboxSms.getSmsText().split(" ")[0]);
					if(keywordDtl != null) {
						System.out.println("KeywordDetails===================>Found");
						String unlockUrl = keywordDtl.getUnlockurl().replace("<sms_text>", inboxSms.getSmsText());
						try {
							String unlockResponse = restTemplate.getForObject(unlockUrl, String.class);
							if(unlockResponse != null) {
								System.out.println("Unlock Code===================>Found");
//								String chargeCode 	= unlockResponse.split("::")[0];
								String amountStr 	= unlockResponse.split("::")[1];
								
								ChargeConfigEntity chargeConfig = chargeConfigService.findByPrice(Integer.parseInt(amountStr));
								if(chargeConfig !=null) {
									System.out.println("ChargeConfig===================>Found");
									String chargeUrl = keywordDtl.getChargeurl()
											.replace("<charge_code>", chargeConfig.getChargeCode())
											.replace("<msisdn>", inboxSms.getMsisdn());
//									System.out.println("chargeUrl===============>"+chargeUrl);
									
									String chargeResponse = restTemplate.getForObject(chargeUrl, String.class);
									if(Integer.parseInt(chargeResponse.split("::")[1])==100) {
										System.out.println("Charge=======================>Success");
										//If Success insert corresponding value to success-log 
										ChargeSuccessLogEntity chargeSuccessLog = new ChargeSuccessLogEntity();
										chargeSuccessLog.setSmsId(inboxSms.getId());
										chargeSuccessLog.setChargeId(chargeConfig.getId());
										chargeSuccessLog.setKeywordId(keywordDtl.getId());
										chargeSuccessLog.setMsisdn(inboxSms.getMsisdn());
										chargeSuccessLog.setAmount(chargeConfig.getPrice());
										chargeSuccessLog.setAmountWithVat(chargeConfig.getPriceWithVat());
										chargeSuccessLog.setValidity(chargeConfig.getValidity());
										chargeSuccessLog.setInsDate(new Date());
										
										chargeSuccessLog.setTidRef(chargeResponse.split("::")[0]);
										chargeSuccessLog.setResponse(chargeResponse.split("::")[2]);
										
										chargeSuccessLogService.save(chargeSuccessLog);
										//In Success update the inbox table status column S for success
										inboxService.updateStatus(inboxSms, "S");
									} else {
										System.out.println("Charge=======================>Failed");
										//otherwise fail_log 
										ChargeFailLogEntity chargeFailLog = new ChargeFailLogEntity();
										chargeFailLog.setSmsId(inboxSms.getId());
										chargeFailLog.setChargeId(chargeConfig.getId());
										chargeFailLog.setKeywordId(keywordDtl.getId());
										chargeFailLog.setMsisdn(inboxSms.getMsisdn());
										chargeFailLog.setAmount(Integer.parseInt(amountStr));
										chargeFailLog.setInsDate(new Date());
										
										chargeFailLog.setTidRef(chargeResponse.split("::")[0]);
										chargeFailLog.setFailCode(Integer.parseInt(chargeResponse.split("::")[1]));
										chargeFailLog.setResponse(chargeResponse.split("::")[2]);
										
										chargeFailLogService.save(chargeFailLog);
										//otherwise update the inbox table status column F for fail
										inboxService.updateStatus(inboxSms, "F");
									}
								} else {
									System.out.println("ChargeConfig===================>Not Found");
								}
							} else {
								System.out.println("Unlock Code===================>Not Found");
							}
						} catch (Exception e) {
//							System.out.println("Exception===================>"+e.getMessage());
						}
					} else {
						System.out.println("KeywordDetails===================>Not Found");
					}
				}
			}
		} else {
			System.out.println("App Process===================>Off");
		}
		
   }

}
