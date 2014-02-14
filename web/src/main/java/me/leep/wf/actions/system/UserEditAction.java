/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.actions.system;

import java.io.File;
import java.util.logging.Level;

import me.leep.wf.actions.base.EditAction;
import me.leep.wf.services.system.aware.IUserServices;
import me.leep.wf.util.LogUtil;
import me.leep.wf.vo.system.User;

public class UserEditAction extends EditAction {

	private static final long serialVersionUID = 4096802666866337184L;

	private String rowid;
	private User user;

	/* 以下是图片属性 */
	private static final int BUFFER_SIZE = 16 * 1024;
	private File myFile;
	private String contentType;
	private String fileName;
	private String imageFileName;
	private String caption;
	/* 以上是图片属性 */

	private IUserServices userServices;

	@Override
	public String execute() throws Exception {
		imageFileName = "img/profile.png";
		user = userServices.initUserDto(rowid);
		return SUCCESS;
	}

	@Override
	public String save() throws Exception {
		LogUtil.log(">>>>>用户保存>>>>", Level.INFO, null);

		user.setId(userServices.save(user));

		return SUCCESS;
	}

	@Override
	public String addNew() throws Exception {
		System.out.println("-------------new--------------");
		user = new User();
		return SUCCESS;
	}

	@Override
	public String delete() throws Exception {
		System.out.println("----------------delete--------------");
		userServices.delete(userServices.findById(user.getId()));
		return addNew();
	}

	/**
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            要设置的 user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return userServices
	 */
	public IUserServices getUserServices() {
		return userServices;
	}

	/**
	 * @param userServices
	 *            要设置的 userServices
	 */
	public void setUserServices(IUserServices userServices) {
		this.userServices = userServices;
	}

	/**
	 * @return rowid
	 */
	public String getRowid() {
		return rowid;
	}

	/**
	 * @param rowid
	 *            要设置的 rowid
	 */
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	/**
	 * @return myFile
	 */
	public File getMyFile() {
		return myFile;
	}

	/**
	 * @param myFile
	 *            要设置的 myFile
	 */
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	/**
	 * @return contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            要设置的 contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            要设置的 fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName
	 *            要设置的 imageFileName
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * @return caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption
	 *            要设置的 caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return bufferSize
	 */
	public static int getBufferSize() {
		return BUFFER_SIZE;
	}

}
