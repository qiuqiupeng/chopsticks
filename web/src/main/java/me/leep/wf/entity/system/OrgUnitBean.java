/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.entity.system;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import me.leep.wf.entity.BaseBill;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "SYS_T_ORGUNIT")
public class OrgUnitBean extends BaseBill {

	private static final long serialVersionUID = 1L;
	private List<UserBean> userBean;
	private OrgUnitBean parent;

	public OrgUnitBean() {
	}
	
	public OrgUnitBean(String param) {
		this.setId(param);
	}

	@OneToMany(mappedBy = "orgUnitBean")
	public List<UserBean> getUserBean() {
		return userBean;
	}

	public void setUserBean(List<UserBean> param) {
		this.userBean = param;
	}

	@ManyToOne(cascade = REMOVE)
	public OrgUnitBean getParent() {
	    return parent;
	}

	public void setParent(OrgUnitBean param) {
	    this.parent = param;
	}
}