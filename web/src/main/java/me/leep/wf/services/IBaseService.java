/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services;

/**
 * 所有services的基类，实现基本的增删改查功能
 * 
 * @author 李鹏
 */
public interface IBaseService<V, P> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(V vo, P entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 *            entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(V vo, P entity);

	/**
	 * 修改实体
	 * 
	 * @param entity
	 *            entity to update
	 * @param vo
	 *            vo
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public void update(V vo, P entity);

	/**
	 * 通过id查找view对象
	 * 
	 * @param id
	 *            对象的id
	 * @param vo
	 *            用于装结果的VO。
	 * @return 抄造到的实体结果
	 */
	public V findById(String id, V vo);

	/**
	 * 按照某个属性查找全部
	 * 
	 * @param propertyName
	 *            the name of the property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<BaseEntiy> found by query
	 */
	// public List<BaseEntiy> findByProperty(Class clazz, String propertyName,
	// Object value,
	// int... rowStartIdxAndCount);

	/**
	 * 查找全部实体
	 * 
	 * @param clazz
	 *            数据来源from实体对象类
	 * @param targetClass
	 *            结果类
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List 返回全部结果集
	 */
	// public List<BaseDto> findAll(Class clazz,Class targetClass,String
	// filterString, int... rowStartIdxAndCount);

	// public void deleteList(String[] rowids, Class clazz);

	// public int coutAll(Class clazz);

}