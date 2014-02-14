/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.entity.system;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import me.leep.wf.entity.BaseBill;

@Entity
@Table(name = "sys_t_message")
public class MessageBean extends BaseBill implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserBean sender;
	private UserBean reciever;
	private String title;
	private String body;
	private Date sendtime;
	private String priority;
	private boolean msgtype;

	public MessageBean() {
	}

	@ManyToOne
	@JoinColumn(name = "fsenderid", referencedColumnName = "fid")
	public UserBean getSender() {
		return sender;
	}

	public void setSender(UserBean param) {
		this.sender = param;
	}

	@ManyToOne
	@JoinColumn(name = "frecieverid", referencedColumnName = "fid")
	public UserBean getReciever() {
		return reciever;
	}

	public void setReciever(UserBean param) {
		this.reciever = param;
	}

	@Column(name = "ftitle")
	public String getTitle() {
		return title;
	}

	public void setTitle(String param) {
		this.title = param;
	}

	@Column(name = "fbody")
	public String getBody() {
		return body;
	}

	public void setBody(String param) {
		this.body = param;
	}

	@Column(name = "fpriority")
	public String getPriority() {
		return priority;
	}

	@Temporal(TIMESTAMP)
	@Column(name = "fsendtime")
	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	@Column(name = "fmsgtype")
	public boolean isMsgtype() {
		return msgtype;
	}

	public void setMsgtype(boolean msgtype) {
		this.msgtype = msgtype;
	}

	public void setPriority(String param) {
		this.priority = param;
	}



}