/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.dao.impl;

import me.leep.wf.entity.system.UserBean;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author lipeng 2014年2月8日 下午7:20:35 
 *
 */
@Repository("crudDao")
public class CrudDaoImpl extends SimpleCrudDaoImpl<UserBean> {

}
