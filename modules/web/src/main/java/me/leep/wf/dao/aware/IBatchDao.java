package me.leep.wf.dao.aware;

import java.util.List;

import me.leep.wf.dao.Dao;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 所有基于JDBC的DAO接口的基础接口。
 * 
 * @author Wang Yuxing
 * @version 1.0
 * 
 */
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public interface IBatchDao extends Dao{

	/**
	 * 批量执行插入或者更新操作。
	 * @param sql 批量更新语句，变量值用”?“表示，如”UPDATE SET NAME=? WHERE ID = ?“。
	 * @param parameters
	 * @return 查询结果集
	 * @throws DataAccessException
	 */
	int[] batchUpdate(String sql, List<List<Object>> parameters) throws Exception;

}
