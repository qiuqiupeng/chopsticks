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

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import me.leep.wf.entity.BaseBill;

@Entity
@Table(name = "sys_t_role")
public class RoleBean extends BaseBill {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2774777982417824244L;
	
	private List<UserBean> users = new ArrayList<UserBean>();

	/**
	 * @return users
	 */
	@ManyToMany(mappedBy="roles")
	public List<UserBean> getUsers() {
		return users;
	}

	/**
	 * @param users 要设置的 users
	 */
	public void setUsers(List<UserBean> users) {
		this.users = users;
	}

}
