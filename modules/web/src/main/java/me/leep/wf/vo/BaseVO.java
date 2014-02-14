/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.vo;

import java.util.Date;

/**
 * 所有entity类的超类. @author 李鹏
 */
public abstract class BaseVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4562370210152651953L;
	private String id;
	private String creater;
	private String lastUpdater;
	private Date creteTime;
	private Date lastUpdateTime;
	private String number;
	private String name;
	private String description;
	private String removeFlag;

	public String getRemoveFlag() {
		return removeFlag;
	}

	public void setRemoveFlag(String removeFlag) {
		this.removeFlag = removeFlag;
	}

	/**
	 * 静态变量块
	 */
	static {
		
	}

//	/**
//	 * 超类构造方法
//	 */
//	public BaseDto() {
//		String user = SecurityUtils.getSubject().getPrincipal().toString();
//		if (StringUtils.isEmpty(creater))
//			creater = user;
//		lastUpdater = user;
//		if (creteTime == null)
//			creteTime = new Date();
//		lastUpdateTime = new Date();
//		id = UUID.randomUUID().toString();
//	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return creater
	 */
	public String getCreater() {
		return creater;
	}

	/**
	 * @param creater 要设置的 creater
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}

	/**
	 * @return lastUpdater
	 */
	public String getLastUpdater() {
		return lastUpdater;
	}

	/**
	 * @param lastUpdater 要设置的 lastUpdater
	 */
	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	/**
	 * @return creteTime
	 */
	public Date getCreteTime() {
		return creteTime;
	}

	/**
	 * @param creteTime 要设置的 creteTime
	 */
	public void setCreteTime(Date creteTime) {
		this.creteTime = creteTime;
	}

	/**
	 * @return lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime 要设置的 lastUpdateTime
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number 要设置的 number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description 要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}