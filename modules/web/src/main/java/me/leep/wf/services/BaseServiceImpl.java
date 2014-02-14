/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services;


import me.leep.wf.entity.BaseEntity;
import me.leep.wf.repository.BaseRepository;
import me.leep.wf.util.BeanUtil;
import me.leep.wf.vo.BaseVO;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 李鹏
 * @param <V>
 * @param <P>
 * 
 */
public class BaseServiceImpl<V extends BaseVO, P extends BaseEntity> implements IBaseService<V, P> {

	@Autowired
	BaseRepository<P, String> baseRepository;

	public void save(V vo, P entity) {
		BeanUtil.copyBean(vo, entity);
		baseRepository.save(entity);
	}

	public void delete(V vo, P entity) {
		BeanUtil.copyBean(vo, entity);
		baseRepository.delete(entity);

	}

	public void update(V vo, P entity) {
		BeanUtil.copyBean(vo, entity);
		baseRepository.delete(entity);
	}

	public V findById(String id, V vo){
		P entity = baseRepository.findOne(id);
		if (entity != null) {
			BeanUtil.copyBean(entity, vo);
			return vo;
		} else {
			return null;
		}
		
	}

//	public List<BaseEntiy> findByProperty(Class clazz, String propertyName,
//			Object value, int... rowStartIdxAndCount) {
//		return dao.findByProperty(clazz, propertyName, value,
//				rowStartIdxAndCount);
//	}

//	public List<BaseDto> findAll(Class clazz, Class targetClass,String filterString,
//			int... rowStartIdxAndCount) {
//		List<BaseEntiy> beanList = dao.findAll(clazz, filterString, rowStartIdxAndCount);
//		List<BaseDto> result = new ArrayList<BaseDto>();
//		for (int i = 0; i < beanList.size(); i++) {
//			BaseEntiy bean = (BaseEntiy) beanList.get(i);
//			BaseDto dto;
//			try {
//				dto = (BaseDto) targetClass.newInstance();
//				BeanUtil.copyBean(bean, dto);
//				result.add(dto);
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}

//	public void deleteList(String[] rowids, Class clazz) {
//		for (int i = 0; i < rowids.length; i++) {
//			BaseEntiy entity = dao.findById(rowids[i], clazz);
//			dao.delete(entity, clazz);
//		}
//	}

//	/**
//	 * @return dao
//	 */
//	public IBaseDAO getDao() {
//		return dao;
//	}
//
//	/**
//	 * @param dao
//	 *            要设置的 dao
//	 */
//	public void setDao(IBaseDAO dao) {
//		this.dao = dao;
//	}

	
//	public int coutAll(Class clazz) {
//		return dao.countAll(clazz);
//	}


	

}
