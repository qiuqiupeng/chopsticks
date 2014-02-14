package me.leep.wf.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import me.leep.wf.dao.aware.IBatchDao;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 基于JDBC的DAO基础实现，提供了一些用于JDBC操作的常用方法。<BR>
 * 所有方法都必须声明为抛出Spring统一的Exception异常，以便于做统一的异常处理。<BR>
 * 可用的异常类如下：
 * 
 * <pre>
 * Exception
 *    EntityNotFoundException
 * </pre>
 * 
 * @author Wang Yuxing
 * @version 1.0
 */
public abstract class SimpleBatchDaoImpl extends JdbcDaoSupport implements
		IBatchDao {

	public int[] batchUpdate(String sql, final List<List<Object>> parameters)
			throws Exception {
		if (sql == null) {
			throw new BadSqlGrammarException("Batch Update", sql, null);
		}
		if (parameters == null || parameters.size() <= 0) {
			throw new IllegalArgumentException(
					"Invalid parameters for batch update");
		}
		int[] counts = this.getJdbcTemplate().batchUpdate(sql,
				new BatchPreparedStatementSetter() {

					public int getBatchSize() {
						return parameters.size();
					}

					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						List<Object> row = parameters.get(i);
						for (int j = 0; j < row.size(); j++) {
							ps.setObject(j + 1, row.get(j));
						}
					}
				});
		return counts;
	}

}
