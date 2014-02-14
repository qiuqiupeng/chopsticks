/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.vo.system;

import me.leep.wf.vo.BaseVO;

public class User extends BaseVO {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4580658445397237252L;

	private String password;
	private String repassword;
	private String removeFlag;
	private Boolean islocked;
	private String type;
	private Boolean isRegister;
	private String groupID;
	private String mainRoleID;
	private String agentUser;
	private String email;
	private String homePhone;
	private String officePhone;
	private String cellPhone;
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return removeFlag
	 */
	public String getRemoveFlag() {
		return removeFlag;
	}
	/**
	 * @param removeFlag 要设置的 removeFlag
	 */
	public void setRemoveFlag(String removeFlag) {
		this.removeFlag = removeFlag;
	}
	/**
	 * @return islocked
	 */
	public Boolean getIslocked() {
		return islocked;
	}
	/**
	 * @param islocked 要设置的 islocked
	 */
	public void setIslocked(Boolean islocked) {
		this.islocked = islocked;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type 要设置的 type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return isRegister
	 */
	public Boolean getIsRegister() {
		return isRegister;
	}
	/**
	 * @param isRegister 要设置的 isRegister
	 */
	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}
	/**
	 * @return groupID
	 */
	public String getGroupID() {
		return groupID;
	}
	/**
	 * @param groupID 要设置的 groupID
	 */
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	/**
	 * @return mainRoleID
	 */
	public String getMainRoleID() {
		return mainRoleID;
	}
	/**
	 * @param mainRoleID 要设置的 mainRoleID
	 */
	public void setMainRoleID(String mainRoleID) {
		this.mainRoleID = mainRoleID;
	}
	/**
	 * @return agentUser
	 */
	public String getAgentUser() {
		return agentUser;
	}
	/**
	 * @param agentUser 要设置的 agentUser
	 */
	public void setAgentUser(String agentUser) {
		this.agentUser = agentUser;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email 要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @param homePhone 要设置的 homePhone
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	/**
	 * @return officePhone
	 */
	public String getOfficePhone() {
		return officePhone;
	}
	/**
	 * @param officePhone 要设置的 officePhone
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	/**
	 * @return cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}
	/**
	 * @param cellPhone 要设置的 cellPhone
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	/**
	 * @return repassword
	 */
	public String getRepassword() {
		return repassword;
	}
	/**
	 * @param repassword 要设置的 repassword
	 */
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}


}
