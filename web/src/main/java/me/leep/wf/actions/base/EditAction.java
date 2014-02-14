/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.actions.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author 李鹏
 *
 */
public class EditAction extends BaseAction {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fUserName;
	private String fid;
	private String fCreater;
	private String fLastUpdater;
	private Date fCreteTime;
	private Date fLastUpdateTime;
	private List<String> messages;
	
	public String addNew() throws Exception {
		System.out.println(">>>>>>>>新增数据>>>>>>>>>>>>>");
		Subject currentUser = SecurityUtils.getSubject();
		setfUserName(currentUser.getPrincipal().toString());
		setfLastUpdater(currentUser.getPrincipal().toString());
		setfCreteTime(new Date());
		setfLastUpdateTime(new Date());
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		System.out.println(">>>>>>>>删除数据>>>>>>>>>>>>>");
		return SUCCESS;
	}
	
	public String save() throws Exception {
		System.out.println(">>>>>>>>save>>>>>>>>>>>>>");	
		
		messages = new ArrayList<String>();
		messages.add("保存成功");
		setActionMessages(messages);
		return SUCCESS;
	}

	/**
	 * @return fUserName
	 */
	public String getfUserName() {
		return fUserName;
	}

	/**
	 * @param fUserName 要设置的 fUserName
	 */
	public void setfUserName(String fUserName) {
		this.fUserName = fUserName;
	}

	/**
	 * @return fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid 要设置的 fid
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return fCreater
	 */
	public String getfCreater() {
		return fCreater;
	}

	/**
	 * @param fCreater 要设置的 fCreater
	 */
	public void setfCreater(String fCreater) {
		this.fCreater = fCreater;
	}

	/**
	 * @return fLastUpdater
	 */
	public String getfLastUpdater() {
		return fLastUpdater;
	}

	/**
	 * @param fLastUpdater 要设置的 fLastUpdater
	 */
	public void setfLastUpdater(String fLastUpdater) {
		this.fLastUpdater = fLastUpdater;
	}

	/**
	 * @return fCreteTime
	 */
	public Date getfCreteTime() {
		return fCreteTime;
	}

	/**
	 * @param fCreteTime 要设置的 fCreteTime
	 */
	public void setfCreteTime(Date fCreteTime) {
		this.fCreteTime = fCreteTime;
	}

	/**
	 * @return fLastUpdateTime
	 */
	public Date getfLastUpdateTime() {
		return fLastUpdateTime;
	}

	/**
	 * @param fLastUpdateTime 要设置的 fLastUpdateTime
	 */
	public void setfLastUpdateTime(Date fLastUpdateTime) {
		this.fLastUpdateTime = fLastUpdateTime;
	}

	/**
	 * @return messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages 要设置的 messages
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}


}
