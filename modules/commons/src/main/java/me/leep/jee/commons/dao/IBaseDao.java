/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.dao;

import java.util.List;
import java.util.Map;

/**
 * 基本dao的父类，数据访问对象的接口类，定义了增删改查等基本功能。
 * 使用时直接指定实体类型，
 * 
 * @author 李鹏
 * @version v 1.0
 */
public interface IBaseDao<T> extends Dao {

	/**
	 * 新增保存对象
	 * 
	 * @param obj
	 */
	void save(T obj);

	/**
	 * 批量删除实体
	 * 
	 * @param clazz 实体类名称
	 * @param ids 实体id数组
	 */
	void delete(Class<T> clazz, String[] ids);

	/**
	 * 修改保存实体对象
	 * 
	 * @param obj 对象参数
	 */
	void update(T obj);

	/**
	 * 查找全部对象 
	 * 
	 * @param clazz 实体类名称
	 * @return 实体对象数组。
	 */
	List<T> findAll(Class<T> clazz);

	/**
	 * 通过id查找对象
	 * 
	 * @param clazz 对象类名称
	 * @param id 对象id
	 * @return 实体对象
	 */
	T findOneById(Class<T> clazz, Object id);

	/**
	 * 获取全部实体记录行数
	 * 
	 * @param clazz 实体类名称
	 * @return 行数
	 */
	long countAll(Class<T> clazz);

	/**
	 * 根据条件获取记录行数
	 * 
	 * @param clazz 实体类名称
	 * @param map 条件行数
	 * @return 实体数
	 */
	long countAllByEqual(Class<T> clazz, Map<String, Object> map);
	
	/**
	 * 根据条件模糊查询记录行数
	 * 
	 * @param clazz 实体类名称
	 * @param map 条件行数
	 * @return 实体数
	 */
	long countAllByLike(Class<T> clazz, Map<String, String> map);

	/**
	 * 根据jpql文进行原始查询
	 * 
	 * @param sql jpql文
	 * @return 实体集
	 */
	List<?> query(String sql);
	
	/**
	 * 根据原生sql文进行原始查询
	 * 
	 * @param sql jpql文
	 * @return 实体集
	 */
	List<?> nativeQuery(String sql);
	
	/**
	 * 根据原生sql文进行原始查询
	 * 
	 * @param sql jpql文
	 * @return 实体集
	 */
	int nativeExecUpdate(String sql);

	/**
	 * 按字段条件来进行查询
	 * @param clazz 实体类名称。
	 * @param paramsMap 条件集
	 * @return 结果集
	 */
	List<T> findByEqual(Class<T> clazz, Map<String, Object> paramsMap);
	
	/**
	 * 按字段模糊匹配查询
	 * 
	 * @param clazz 实体类名称。
	 * @param map 条件集
	 * @return 查询结果集
	 */
	List<T> findByLike(Class<T> clazz, Map<String, String> map);
	
	/**
	 * 分页查询
	 * 
	 * @param clazz 实体类名称。
	 * @param from 分页开始
	 * @param size 分页尺寸
	 * @return 分页查询结果集
	 */
	List<T> findPager(Class<T> clazz, int from, int size);
	
	/**
	 * 按字段是否相等来查询获得分页数据
	 * 
	 * @param clazz 实体类名称。
	 * @param paramsMap 条件集
	 * @param from 分页条件开始
	 * @param size 分页尺寸
	 * @return 查询结果集
	 */
	List<T> findPagerByEqual(Class<T> clazz, Map<String, Object> paramsMap, int from, int size);

	/**
	 * 按字段模糊匹配来查询获得分页数据
	 * 
	 * @param clazz 实体类名称。
	 * @param map 条件集
	 * @param from 分页条件开始
	 * @param size 分页尺寸
	 * @return 查询结果集
	 */
	List<T> findPagerByLike(Class<T> clazz, Map<String, String> map, int from, int size);

}