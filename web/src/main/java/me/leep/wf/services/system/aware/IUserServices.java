/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services.system.aware;


import java.util.List;

import me.leep.wf.entity.system.UserBean;
import me.leep.wf.services.IBaseService;
import me.leep.wf.vo.system.User;

/**
 * @author 李鹏
 *
 */
public interface IUserServices extends IBaseService<User, UserBean> {
	
	User initUserDto(String id);

	String save(User dto);

	void deleteList(String[] rowids);

	void delete(UserBean entity);
	
	List<User> findAll(int page, int size);
	
	UserBean findById(String id);
	
	Integer countAll();
	
	boolean exists(String id);
}
