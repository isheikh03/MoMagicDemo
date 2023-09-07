package com.isheikh03.moMagicDemo.appConfig;

import java.sql.Timestamp;
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
@Table(name = "app_conf")
public class AppConfigEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "app_name")
	private String appName;

	@Column(name = "number_of_thread")
	private Integer numberOfThread;

	@Column(name = "number_of_row")
	private Integer numberOfRow;

	@Column(name = "status")
	private int status;

	@Column(name = "last_start_time")
	private Date lastStartTime;

	@Column(name = "last_stop_time")
	private Date lastStopTime;

	@Column(name = "stop_by")
	private String stopBy;

	@Column(name = "data_reload")
	private Integer dataReload;

	@Column(name = "last_reload_time")
	private Timestamp lastReloadTime;

}
