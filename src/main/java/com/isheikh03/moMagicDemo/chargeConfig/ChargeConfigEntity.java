package com.isheikh03.moMagicDemo.chargeConfig;

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
@Table(name = "charge_conf")
public class ChargeConfigEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="charge_code")
	private String chargeCode;

	@Column(name="price")
	private Integer price;

	@Column(name="price_with_vat")
	private Float priceWithVat;

	@Column(name="validity")
	private int validity;
	
}
