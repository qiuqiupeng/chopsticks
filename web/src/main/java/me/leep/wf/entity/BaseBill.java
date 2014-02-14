/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 所有单据及基础资料类的超类. 
 * 
 * @author 李鹏
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseBill extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4562370210152651953L;
	
	@CreatedBy
	private String creater;
	@LastModifiedBy
	private String lastUpdater;
	@CreatedDate
	private Date creteTime;
	@LastModifiedDate
	private Date lastUpdateTime;
	private String number;
	private String name;
	private String description;


	/**
	 * 静态变量块
	 */
	static {

	}

	/**
	 * @return creater
	 */
	@Column(name = "fcreater", length = 50, updatable = false)
	public String getCreater() {
		return creater;
	}

	/**
	 * @param creater
	 *            要设置的 creater
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}

	/**
	 * @return lastUpdater
	 */
	@Column(name = "flastupdater", length = 50)
	public String getLastUpdater() {
		return lastUpdater;
	}

	/**
	 * @param lastUpdater
	 *            要设置的 lastUpdater
	 */
	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	/**
	 * @return creteTime
	 */
	@Column(name = "fcretetime", length = 10, updatable = false)
	public Date getCreteTime() {
		return creteTime;
	}

	/**
	 * @param creteTime
	 *            要设置的 creteTime
	 */
	public void setCreteTime(Date creteTime) {
		this.creteTime = creteTime;
	}

	/**
	 * @return lastUpdateTime
	 */
	@Column(name = "flastupdatetime", length = 10)
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime
	 *            要设置的 lastUpdateTime
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return number
	 */
	@Column(name = "fnumber", length = 50)
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            要设置的 number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return name
	 */
	@Column(name = "fname", length = 50)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return description
	 */
	@Column(name = "fdescription")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@PrePersist
	public void prePersist() {
		if (StringUtils.isEmpty(getId()))
			setId(UUID.randomUUID().toString());

	}

	@PreUpdate
	public void preUpdate() {
	}
}