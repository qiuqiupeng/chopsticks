/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.repository.system;



import java.util.List;

import me.leep.wf.entity.system.UserBean;
import me.leep.wf.repository.BaseRepository;


/**
 * 用户持久层接口
 * 
 * @author 李鹏 2012-8-31
 */
public interface UserRepository extends BaseRepository<UserBean, String> {
	/**
	 * 根据用户名和密码查找
	 * 
	 * @param number 用户名
	 * @param passowrd 密码
	 * @return 结果集
	 */
	List<UserBean> findByNumberAndPassword(String number, String passowrd);

}