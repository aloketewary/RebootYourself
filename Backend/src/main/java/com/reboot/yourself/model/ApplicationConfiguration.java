/**
 * 
 */
package com.reboot.yourself.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Amrita Sarkar
 *
 */
@Entity
@Table(name = "app_config", schema = "master")

public class ApplicationConfiguration {
	private int id;
	private String key;
	private String value;
	private Boolean isDelete;

	public ApplicationConfiguration() {
		// TODO Auto-generated constructor stub
	}

	public ApplicationConfiguration(int id, String key, String value,Boolean isDelete) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.key = key;
		this.value = value;
		this.isDelete = isDelete;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "key_id")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "key_value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "isdelete")
	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}
