/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.util;

import me.leep.wf.entity.system.UserBean;

import org.activiti.engine.identity.Picture;
import org.activiti.engine.impl.persistence.entity.UserEntity;

public class ActivitiUtils {

	public static UserEntity toActivitiUser(UserBean bUser) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(bUser.getId().toString());
		userEntity.setFirstName(bUser.getName());
		Picture picture = new Picture(bUser.getPicture(), "image/jpeg");
		userEntity.setPicture(picture);
		// userEntity.setLastName(bUser.getLoginName());
		userEntity.setPassword(bUser.getPassword());
		userEntity.setEmail(bUser.getEmail());
		userEntity.setRevision(1);
		return userEntity;
	}

	// public static GroupEntity toActivitiGroup(Group bGroup){
	// GroupEntity groupEntity = new GroupEntity();
	// groupEntity.setRevision(1);
	// groupEntity.setType("assignment");
	//
	// groupEntity.setId(bGroup.getGroupId());
	// groupEntity.setName(bGroup.getName());
	// return groupEntity;
	// }
	//
	// public static List<org.activiti.engine.identity.Group>
	// toActivitiGroups(List<Group> bGroups){
	//
	// List<org.activiti.engine.identity.Group> groupEntitys = new
	// ArrayList<org.activiti.engine.identity.Group>();
	//
	// for (Group bGroup : bGroups) {
	// GroupEntity groupEntity = toActivitiGroup(bGroup);
	// groupEntitys.add(groupEntity);
	// }
	// return groupEntitys;
	// }
}