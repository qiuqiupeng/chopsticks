/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.entity.system;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import me.leep.wf.entity.BaseBill;

@Entity
@Table(name = "sys_t_user")
public class UserBean extends BaseBill {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2774777982417824244L;
	private String password;
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
	
	private byte[] picture;
	/**
	 * @return password
	 */
	@Column(name = "fpicture")
	@Lob
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	private List<RoleBean> roles = new ArrayList<RoleBean>();
	private OrgUnitBean orgUnitBean;
	/**
	 * @return password
	 */
	@Column(name = "fpassword")
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return islocked
	 */
	@Column(name = "fislocked")
	public Boolean getIslocked() {
		return islocked;
	}

	/**
	 * @param islocked
	 *            要设置的 islocked
	 */
	public void setIslocked(Boolean islocked) {
		this.islocked = islocked;
	}

	/**
	 * @return type
	 */
	@Column(name = "ftype")
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            要设置的 type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return isRegister
	 */
	@Column(name = "fisregister")
	public Boolean getIsRegister() {
		return isRegister;
	}

	/**
	 * @param isRegister
	 *            要设置的 isRegister
	 */
	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}

	/**
	 * @return groupID
	 */
	@Column(name = "fgroupid")
	public String getGroupID() {
		return groupID;
	}

	/**
	 * @param groupID
	 *            要设置的 groupID
	 */
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	/**
	 * @return mainRoleID
	 */
	@Column(name = "fmainroleid")
	public String getMainRoleID() {
		return mainRoleID;
	}

	/**
	 * @param mainRoleID
	 *            要设置的 mainRoleID
	 */
	public void setMainRoleID(String mainRoleID) {
		this.mainRoleID = mainRoleID;
	}

	/**
	 * @return agentUser
	 */
	@Column(name = "fagentuser")
	public String getAgentUser() {
		return agentUser;
	}

	/**
	 * @param agentUser
	 *            要设置的 agentUser
	 */
	public void setAgentUser(String agentUser) {
		this.agentUser = agentUser;
	}

	/**
	 * @return email
	 */
	@Column(name = "femail")
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return homePhone
	 */
	@Column(name = "fhomephone")
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone
	 *            要设置的 homePhone
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return officePhone
	 */
	@Column(name = "fofficephone")
	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * @param officePhone
	 *            要设置的 officePhone
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	/**
	 * @return cellPhone
	 */
	@Column(name = "fcellphone")
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone
	 *            要设置的 cellPhone
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return roles
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sys_mm_user_role", joinColumns = { @JoinColumn(name = "fuserid") }, inverseJoinColumns = { @JoinColumn(name = "froleid") })
	public List<RoleBean> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            要设置的 roles
	 */
	public void setRoles(List<RoleBean> roles) {
		this.roles = roles;
	}

	@ManyToOne
	@JoinColumn(name = "forgunitid", referencedColumnName = "fid")
	public OrgUnitBean getOrgUnitBean() {
		return orgUnitBean;
	}

	public void setOrgUnitBean(OrgUnitBean param) {
		this.orgUnitBean = param;
	}

}
