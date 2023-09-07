package com.isheikh03.moMagicDemo.chargeFailLog;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "charge_fail_log")
public class ChargeFailLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "sms_id")
	private Long smsId;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "keyword_id")
	private Long keywordId;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "charge_id")
	private Long chargeId;

	@Column(name = "fail_code")
	private Integer failCode;

	@Column(name = "ins_date")
	private Date insDate;

	@Column(name = "tid_ref")
	private String tidRef;

	@Column(name = "response")
	private String response;

}
