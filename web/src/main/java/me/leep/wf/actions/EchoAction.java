/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.actions;


import me.leep.wf.actions.base.EditAction;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


/**
 * @author 李鹏
 * 
 */
@Results({ @Result(name = "result", location = "/${nextAction}", type = "redirect") })
public class EchoAction extends EditAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String echo;
	private String nextAction;

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		String url = ServletActionContext.getRequest().getParameter("echo");
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + url);
		if (StringUtils.isBlank(url))
			this.nextAction = "system/user-list";
		else
			this.nextAction = "system/user-list";
//			this.nextAction = url;
		return "result";
	}

	/**
	 * @return nextAction
	 */
	public String getNextAction() {
		return nextAction;
	}

	/**
	 * @param nextAction
	 *            要设置的 nextAction
	 */
	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

	/**
	 * @return echo
	 */
	public String getEcho() {
		return echo;
	}

	/**
	 * @param echo 要设置的 echo
	 */
	public void setEcho(String echo) {
		this.echo = echo;
	}

}
