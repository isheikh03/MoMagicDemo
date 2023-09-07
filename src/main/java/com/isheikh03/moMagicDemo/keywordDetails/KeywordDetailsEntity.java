package com.isheikh03.moMagicDemo.keywordDetails;

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
@Table(name = "keyword_details")
public class KeywordDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "keyword")
	private String keyword;

	@Column(name = "game_name")
	private String gameName;

	@Column(name = "sms_spliter")
	private String smsSpliter;

	@Column(name = "unlockurl")
	private String unlockurl;

	@Column(name = "unlockurl_response_splitter")
	private String unlockurlResponseSplitter;

	@Column(name = "unlock_sms")
	private String unlockSms;

	@Column(name = "chargeurl")
	private String chargeurl;

	@Column(name = "ins_date")
	private Date insDate;

}
