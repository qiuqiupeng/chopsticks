/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.actions;

import java.util.List;
import java.util.Map;

import me.leep.wf.actions.base.EditAction;
import me.leep.wf.dto.system.AcordionItemBean;
import me.leep.wf.services.system.aware.IMenuItemServices;
import me.leep.wf.services.system.impl.ShiroRealmImpl.ShiroUser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author 李鹏
 *
 */
@Results({ @Result(name = "login", location = "/login", type = "redirect") })
public class IndexAction extends EditAction {
	
	private String username;
	private List<AcordionItemBean> items;
	
	@Autowired
	private IMenuItemServices services;

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username 要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 66427915185034101L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		ActionContext context = ActionContext.getContext();   
	    Map<String, Object> session = context.getSession();  
	    System.out.println("@@@@@@@" + session);
	    
//		Reader reader = FileUtil.getFile("resources/menuall.xml", "UTF-8");
//		items = (List<AcordionItemBean>) BeanUtil.xml2Bean(reader);
		
		
		
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			return "login";
		} else {
			this.setUsername(((ShiroUser)currentUser.getPrincipal()).number);
			items = services.entity2vo();
			return SUCCESS;
		}
	}

	/**
	 * @return items
	 */
	public List<AcordionItemBean> getItems() {
		return items;
	}

	/**
	 * @param items 要设置的 items
	 */
	public void setItems(List<AcordionItemBean> items) {
		this.items = items;
	}
	

	

}
