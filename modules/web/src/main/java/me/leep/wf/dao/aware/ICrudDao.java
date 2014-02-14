package me.leep.wf.dao.aware;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import me.leep.wf.dao.Dao;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 提供了常用增删改查(CRUD)功能的DAO基础接口。<BR>
 * 实体状态说明：需要扩展并实现该接口， {@link me.leep.wf.dao.impl.SimpleCrudDaoImpl}
 * {@link me.leep.wf.dao.impl.CrudDaoImpl} 建议扩展接口并实现该接口
 * 
 * @param <E>
 * @author 李鹏
 * @version 1.0
 */
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public interface ICrudDao<E> extends Dao {

	/**
	 * 持久化一个实体。
	 * 
	 * @param entity
	 *            处于临时状态的实体。
	 * @throws DataAccessException
	 */
	void create(E entity);

	/**
	 * 持久化多个实体。
	 * 
	 * @param entities
	 *            处于临时状态的实体的集合。
	 * @throws DataAccessException
	 */
	void create(Collection<E> entities);

	/**
	 * 更新实体。
	 * 
	 * @param entity
	 *            处于持久化状态的实体。
	 * @throws DataAccessException
	 */
	void update(E entity);

	/**
	 * 更新多个实体。
	 * 
	 * @param entities
	 *            处于持久化状态的实体的集合。
	 * @throws DataAccessException
	 */
	void update(Collection<E> entities);

	/**
	 * 持久化或者更新实体。
	 * 
	 * @param entity
	 *            处于临时或者持久化状态的实体。
	 * @throws DataAccessException
	 */
	void createOrUpdate(E entity);

	/**
	 * 持久化或者更新多个实体。
	 * 
	 * @param entities
	 *            处于临时或者持久化状态的实体的集合。
	 * @throws DataAccessException
	 */
	void createOrUpdate(Collection<E> entities);

	/**
	 * 更新处于游离状态的实体，更新后实体对象仍然处于游离状态。
	 * 
	 * @param entity
	 *            处于游离状态的实体。
	 * @throws DataAccessException
	 */
	void merge(E entity);

	/**
	 * 保存处于游离状态的多个实体，更新后实体对象仍然处于游离状态。
	 * 
	 * @param entities
	 *            处于游离状态的实体的集合。
	 * @throws DataAccessException
	 */
	void merge(Collection<E> entities);

	/**
	 * 删除一个持久化的实体。
	 * 
	 * @param entity
	 *            处于持久化状态的实体。
	 * @throws DataAccessException
	 */
	void delete(E entity);

	/**
	 * 删除多个持久化的实体。
	 * 
	 * @param entities
	 *            处于持久化状态的实体的集合。
	 * @throws DataAccessException
	 */
	void delete(Collection<E> entities);

	/**
	 * 获取全部实体记录行数
	 * 
	 * @return 行数
	 */
	long countAll();

	/**
	 * 根据条件获取记录行数
	 * 
	 * @param map
	 *            条件行数
	 * @return 实体数
	 */
	long countAllByEqual(Map<String, Object> map);

	/**
	 * 根据条件模糊查询记录行数
	 * 
	 * @param map
	 *            条件行数
	 * @return 实体数
	 */
	long countAllByLike(Map<String, String> map);
	
	/**
	 * 查找全部对象 
	 * 
	 * @return 实体对象数组。
	 */
	List<E> findAll();


	/**
	 * 按字段条件来进行查询
	 * 
	 * @param paramsMap
	 *            条件集
	 * @return 结果集
	 */
	List<E> findByEqual(Map<String, Object> paramsMap);
	
	/**
	 * 根据jpql文进行原始查询
	 * 
	 * @param jpql jpql文
	 * @return 实体集
	 */
	List<?> query(String jpql);
	
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
	 * 按字段模糊匹配查询
	 * 
	 * @param map
	 *            条件集
	 * @return 查询结果集
	 */
	List<E> findByLike(Map<String, String> map);

	/**
	 * 分页查询
	 * 
	 * @param from
	 *            分页开始
	 * @param size
	 *            分页尺寸
	 * @return 分页查询结果集
	 */
	List<E> findPager(int from, int size);

	/**
	 * 按字段是否相等来查询获得分页数据
	 * 
	 * @param paramsMap
	 *            条件集
	 * @param from
	 *            分页条件开始
	 * @param size
	 *            分页尺寸
	 * @return 查询结果集
	 */
	List<E> findPagerByEqual(Map<String, Object> paramsMap, int from, int size);

	/**
	 * 按字段模糊匹配来查询获得分页数据
	 * 
	 * @param map
	 *            条件集
	 * @param from
	 *            分页条件开始
	 * @param size
	 *            分页尺寸
	 * @return 查询结果集
	 */
	List<E> findPagerByLike(Map<String, String> map, int from, int size);

}
