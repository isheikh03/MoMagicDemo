package com.isheikh03.moMagicDemo.outbox;

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
@Table(name = "outbox")
public class OutboxEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "sms_id")
	private Long smsId;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "ins_date")
	private Date insDate;

	@Column(name = "sms_text")
	private String smsText;

	@Column(name = "reply_addr")
	private String replyAddr;

	@Column(name = "status")
	private String status;

	@Column(name = "send_date")
	private Date sendDate;

}
