/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.util;

import me.leep.wf.entity.BaseEntity;


/**
 * @author 李鹏
 * 
 * 
 */
public class EntityUtil {

//	public static void checkEntity(BaseEntity entity) {
//		String user = SecurityUtils.getSubject().getPrincipal().toString();
//		if (StringUtils.isEmpty(entity.getCreater()))
//			entity.setCreater(user);
//		entity.setLastUpdater(user);
//
//		if (entity.getCreteTime() == null)
//			entity.setCreteTime(new Date());
//		entity.setLastUpdateTime(new Date());
//
//		if (StringUtils.isNotBlank(entity.getRemoveFlag()))
//			entity.setRemoveFlag("0");// 有效
//
//		if (StringUtils.isEmpty(entity.getId()))
//			entity.setId(UUID.randomUUID().toString());
//	}
	
	/**
	 * 根据ID来虚拟一个对象，相当于load方法，用于弱关联的外键对象关系
	 * @param entity 虚拟构造的实体对象
	 * @param param 传入的参数ID
	 * @return 实体对象
	 */
	public static <T extends BaseEntity> T read(T entity, String param) {
		entity.setId(param);
		return entity;
	}

}
