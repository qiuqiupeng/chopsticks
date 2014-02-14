package me.leep.jee.commons.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于Hibernate的CRUD DAO基础实现，所有使用Hibernate并支持CRUD操作的DAO都继承该类。<BR>
 * 所有方法都必须声明为抛出统一的Exception异常，以便于做统一的异常处理。<BR>
 * 可用的异常类如下：
 * 
 * <pre>
 * Exception
 *    EntityNotFoundException
 * 
 * </pre>
 * 
 * @param <E>
 * @author Wang Yuxing
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public abstract class SimpleCrudDaoImpl<E> implements
		ICrudDao<E> {

	protected final Logger log = LoggerFactory
			.getLogger(SimpleCrudDaoImpl.class);
	protected Class<E> entityClass;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construct with generic type.
	 */
	public SimpleCrudDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			entityClass = (Class<E>) ((ParameterizedType) type)
					.getActualTypeArguments()[0];
		} else {
			// throw new IllegalStateException("Not parameterized entity type");
			System.out.println("&&&&&&" + type);
		}
	}

	/**
	 * 获得DAO类对应的实体类型，所有继承者必须实现该方法并给出相应的实体类型。
	 */
	protected Class<E> getEntityClass() {
		return entityClass;
	}

	public boolean checkDatabaseAvailable() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void create(E entity) {
		this.entityManager.persist(entity);
		log.info("Created one entity: {}", entity);
	}

	public void create(Collection<E> entities) {
		if (entities != null && entities.size() > 0) {
			Iterator<E> it = entities.iterator();
			for (E e = null; it.hasNext();) {
				e = it.next();
				create(e);
				log.info("Created one entity: {}", e);
			}
			log.info("{} entities created.", entities.size());
		}
	}

	public void delete(E entity) {
		entityManager.remove(entity);
		log.info("Deleted one entity: {}", entity);
	}

	public void delete(Collection<E> entities) {
		if (entities != null && entities.size() > 0) {
			Iterator<E> it = entities.iterator();
			for (E e = null; it.hasNext();) {
				e = it.next();
				delete(e);
				log.info("Deleted one entity: {}", e);
			}
			log.info("{} entities deleted.", entities.size());
		}
	}

	public void update(E entity) {
		entityManager.merge(entity);
		log.info("Updated one entity: {}", entity);
	}

	public void update(Collection<E> entities) {
		if (entities != null && entities.size() > 0) {
			Iterator<E> it = entities.iterator();
			for (E e = null; it.hasNext();) {
				e = it.next();
				update(e);
				log.info("Updated one entity: {}", e);
			}
			log.info("{} entities updated.", entities.size());
		}
	}

	public void createOrUpdate(E entity) {
		entityManager.merge(entity);
		log.info("Created or Updated one entity: {}", entity);
	}

	public void createOrUpdate(Collection<E> entities) {
		if (entities != null && entities.size() > 0) {
			Iterator<E> it = entities.iterator();
			for (E e = null; it.hasNext();) {
				e = it.next();
				createOrUpdate(e);
				log.info("Created or Updated one entity: {}", e);
			}
			log.info("{} entities updated.", entities.size());
		}
	}

	public void merge(E entity) {
		entityManager.merge(entity);
		log.info("Merged one entity: {}", entity);
	}

	public void merge(Collection<E> entities) {
		if (entities != null && entities.size() > 0) {
			Iterator<E> it = entities.iterator();
			for (E e = null; it.hasNext();) {
				e = it.next();
				merge(e);
				log.info("Merged one entity: {}", e);
			}
			log.info("{} entities merged.", entities.size());
		}
	}

	public List<?> query(String jpql) {
		return entityManager.createQuery(jpql).getResultList();
	}

	public List<?> nativeQuery(String sql) {
		return entityManager.createNativeQuery(sql).getResultList();
	}

	public int nativeExecUpdate(String sql) {
		return entityManager.createNativeQuery(sql).executeUpdate();
	}

	public List<E> findAll() {
		return findBy(false, false, getEntityClass(), null, 0, 0);
	}

	public E findOneById(Object id) {
		return entityManager.find(getEntityClass(), id);
	}

	public long countAll() {
		return new Long(findBy(true, true, getEntityClass(), null, 0, 0).get(0)
				.toString());
	}

	public long countAllByEqual(Map<String, Object> paramsMap) {
		return new Long(findBy(true, false, getEntityClass(), paramsMap, 0, 0)
				.get(0).toString());
	}

	public long countAllByLike(Map<String, String> paramsMap) {
		Map<String, Object> map = toStringObjectMap(paramsMap);
		return new Long(findBy(true, true, getEntityClass(), map, 0, 0).get(0)
				.toString());
	}

	public List<E> findByEqual(Map<String, Object> paramsMap) {
		return findBy(false, false, getEntityClass(), paramsMap, 0, 0);
	}

	public List<E> findByLike(Map<String, String> paramsMap) {
		Map<String, Object> map = toStringObjectMap(paramsMap);
		return findBy(false, true, getEntityClass(), map, 0, 0);
	}

	public List<E> findPager(int from, int size) {
		return findBy(false, false, getEntityClass(), null, from, size);
	}

	public List<E> findPagerByEqual(Map<String, Object> paramsMap, int from,
			int size) {
		return findBy(false, false, getEntityClass(), paramsMap, from, size);
	}

	public List<E> findPagerByLike(Map<String, String> paramsMap, int from,
			int size) {
		Map<String, Object> map = toStringObjectMap(paramsMap);
		return findBy(false, true, getEntityClass(), map, from, size);
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
	@SuppressWarnings({ "rawtypes" })
	private List findBy(boolean getRowCount, boolean isVagou, Class<E> clazz,
			Map<String, Object> paramsMap, int from, int size) {
		String paramTag = null; // sql语句中的占位参数标记名
		String paramValue = null; // sql语句中的参数值
		String entityValue = null; // sql语句中的实体参数名
		String className = clazz.getSimpleName(); // 对应的类名
		String preSql = getRowCount ? "select count(e) from "
				: "select e from ";
		StringBuffer sql = new StringBuffer(preSql);
		sql.append(className).append(" e where 1=1 ");
		Query query = null;

		if (null != paramsMap) {
			// 构型
			for (String key : paramsMap.keySet()) {
				paramTag = ":".concat(key.replace(".", "_"));
				entityValue = "lower(e.".concat(key).concat(")");
				if (!isVagou) {
					sql.append(" and ").append(entityValue).append("=")
							.append(paramTag).append(" ");
				} else if (paramTag.endsWith("_id")) {
					// 如果对应的是主键，则将like改为equal
					sql.append(" and ").append(entityValue).append("=")
							.append(paramTag).append(" ");
				} else {
					sql.append(" and ").append(entityValue).append(" like ")
							.append(paramTag).append(" ");
				}
				System.out.println("sql== " + sql.toString() + "---"
						+ paramsMap.get(key));
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
					if (paramTag.endsWith("_id")) {
						query.setParameter(paramTag, new Long(paramValue));
					} else {
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
