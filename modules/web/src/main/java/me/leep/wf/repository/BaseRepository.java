/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 基础持久层接口
 * 
 * @author 李鹏 2013-10-7
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends
		JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
	/**
	 * 根据编码找出实体列表
	 * 
	 * @param number
	 *            编码
	 * @return 实体列表结果集
	 */
	List<T> findByNumber(String number);

	/**
	 * 根据编码查找实体数量
	 * 
	 * @param number
	 *            编码
	 * @return 结果数量
	 */
	long countByNumber(String number);


}