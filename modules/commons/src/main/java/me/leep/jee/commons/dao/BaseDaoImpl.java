/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * 全部dao的父类，数据访问对象的接口类，定义了增删改查等基本功能。
 * 
 * @author 李鹏
 * @version v 1.0
 */
@Repository("dao")
public class BaseDaoImpl<T> implements IBaseDao<T> {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(T obj) {
		entityManager.persist(obj);
	}

	public void delete(Class<T> clazz, String[] ids) {
		T obj = null;
		for (String id : ids) {
			obj = entityManager.find(clazz, id);
			entityManager.remove(obj);
		}
	}

	public void update(T obj) {
		entityManager.merge(obj);
	}

	public List<?> query(String sql) {
		return entityManager.createQuery(sql).getResultList();
	}

	public List<?> nativeQuery(String sql) {
		return entityManager.createNativeQuery(sql).getResultList();
	}

	public int nativeExecUpdate(String sql) {
		return entityManager.createNativeQuery(sql).executeUpdate();
	}

	public List<T> findAll(Class<T> clazz) {
		return findBy(false, false, clazz, null, 0, 0);
	}

	public T findOneById(Class<T> clazz, Object id) {
		return entityManager.find(clazz, id);
	}

	public long countAll(Class<T> clazz) {
		return new Long(findBy(true, true, clazz, null, 0, 0).get(0).toString());
	}

	public long countAllByEqual(Class<T> clazz, Map<String, Object> paramsMap) {
		return new Long(findBy(true, false, clazz, paramsMap, 0, 0).get(0).toString());
	}

	public long countAllByLike(Class<T> clazz, Map<String, String> paramsMap) {
		Map<String, Object> map = toStringObjectMap(paramsMap);
		return new Long(findBy(true, true, clazz, map, 0, 0).get(0).toString());
	}

	public List<T> findByEqual(Class<T> clazz, Map<String, Object> paramsMap) {
		return findBy(false, false, clazz, paramsMap, 0, 0);
	}

	public List<T> findByLike(Class<T> clazz, Map<String, String> paramsMap) {
		Map<String, Object> map = toStringObjectMap(paramsMap);
		return findBy(false, true, clazz, map, 0, 0);
	}
	
	public List<T> findPager(Class<T> clazz, int from, int size) {
		return findBy(false, false, clazz, null, from, size);
	}

	public List<T> findPagerByEqual(Class<T> clazz, Map<String, Object> paramsMap, int from, int size) {
		return findBy(false, false, clazz, paramsMap, from, size);
	}


	public List<T> findPagerByLike(Class<T> clazz, Map<String, String> paramsMap, int from, int size) {
		Map<String, Object> map = toStringObjectMap(paramsMap);
		return findBy(false, true, clazz, map, from, size);
	}

	/**
	 * 可构造性的原始查询
	 * 
	 * @param getRowCount
	 *            是否计算记录条数的查询（即，select count(*)）
	 * @param isVagou
	 *            是否模糊查询like（相对于精确查询equal）
	 * @param clazz
	 *            对应的实体类名
	 * @param paramsMap
	 *            查询字段映射数据
	 * @param from
	 *            起始记录序号
	 * @param size
	 *            本次查询的记录数
	 * @return 查询结果集
	 */
	@SuppressWarnings("unchecked")
	private List<T> findBy(boolean getRowCount, boolean isVagou, Class<T> clazz, Map<String, Object> paramsMap, int from, int size) {
		String paramTag = null;		// sql语句中的占位参数标记名
		String paramValue = null;	// sql语句中的参数值
		String entityValue = null;	// sql语句中的实体参数名
		String className = clazz.getSimpleName(); // 对应的类名
		String preSql = getRowCount ? "select count(e) from " : "select e from ";
		StringBuffer sql = new StringBuffer(preSql);
		sql.append(className).append(" e where e.id!=0 and 1=1 ");
		Query query = null;

		if (null != paramsMap) {
			// 构型
			for (String key : paramsMap.keySet()) {
				paramTag = ":".concat(key.replace(".", "_"));
				entityValue = "lower(e.".concat(key).concat(")");
				if (!isVagou) {
					sql.append(" and ").append(entityValue).append("=").append(paramTag).append(" ");
				} else if(paramTag.endsWith("_id")){
					// 如果对应的是主键，则将like改为equal
					sql.append(" and ").append(entityValue).append("=").append(paramTag).append(" ");
				} else {
					sql.append(" and ").append(entityValue).append(" like ").append(paramTag).append(" ");
				}
				System.out.println("sql== "+sql.toString()+"---"+paramsMap.get(key));
			}
		}
		query = entityManager.createQuery(sql.toString());

		if (null != paramsMap) {
			// 填值
			for (String key : paramsMap.keySet()) {
				paramTag = key.replace(".", "_");
				paramValue = paramsMap.get(key).toString().toLowerCase();
				if (!isVagou) {
					try {
						query.setParameter(paramTag, new Long(paramValue));
					} catch (Exception ex) {
						query.setParameter(paramTag, paramValue);
					}
				} else {
					// 如果对应的是主键，则将like改为equal
					if(paramTag.endsWith("_id")){
						query.setParameter(paramTag, new Long(paramValue));
					} else{
						query.setParameter(paramTag, "%" + paramValue + "%");
					}
				}
			}
		}
		if (from == 0 && size == 0) {
			return query.getResultList();
		}
		return query.setFirstResult(from).setMaxResults(size).getResultList();
	}

	/**
	 * 将<String, String>类型的映射转换为<String, Object>类型
	 * 
	 * @param paramsMap
	 * @return 转换后的Map集
	 */
	private Map<String, Object> toStringObjectMap(Map<String, String> paramsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (String key : paramsMap.keySet()) {
			map.put(key, paramsMap.get(key));
		}
		return map;
	}

}
