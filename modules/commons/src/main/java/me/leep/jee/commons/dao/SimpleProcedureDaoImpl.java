package me.leep.jee.commons.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public abstract class SimpleProcedureDaoImpl extends JdbcDaoSupport
		implements IProcedureDao {

	protected Logger log = null;

	public SimpleProcedureDaoImpl() {
		log = LoggerFactory.getLogger(this.getClass().getName());
	}
}
