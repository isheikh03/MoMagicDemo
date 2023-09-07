package com.isheikh03.moMagicDemo.inbox;

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
@Table(name = "inbox")
public class InboxEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="msisdn")
	private String msisdn;

	@Column(name="ins_date")
	private Date insDate;

	@Column(name="sms_text")
	private String smsText;

	@Column(name="status")
	private String status;

	@Column(name="pro_date")
	private Date proDate;
}
