package me.leep.jee.commons.dao;


import java.sql.Connection;
import java.util.List;
import java.util.Map;


/**
 * 可以执行存储过程的DAO。
 * 
 * @author Wang Yuxing
 * 
 */
public interface IProcedureDao extends Dao {

	/**
	 * 执行无参数和返回值的存储过程。
	 * 
	 * @param spName 存储过程名。
	 * @throws Exception	
	 */
	void execute(String spName) throws Exception;

	/**
	 * 执行无返回值的存储过程
	 * 
	 * @param spName 存储过程名。
	 * @param parameters 存储过程参数。
	 * @throws Exception
	 */
	void execute(String spName, Map<String, Object> parameters) throws Exception;

	/**
	 * 
	 * @param spName
	 * @param parameters
	 * @param outParams
	 * @param cursorName
	 * @return 查询结果集
	 * @throws Exception
	 */
	Map<String, Object> executeWithResult(String spName, Map<String, Object> parameters,
			Map<String, Integer> outParams, String cursorName) throws Exception;

	/**
	 * 
	 * @param conn
	 * @param spName
	 * @param parameters
	 * @param outParams
	 * @param cursorName
	 * @return 查询结果集
	 * @throws Exception
	 */
	Map<String, Object> executeWithResult(Connection conn, String spName, Map<String, Object> parameters,
			Map<String, Integer> outParams, String cursorName) throws Exception;

	/**
	 * 执行存储过程并返回多条记录。
	 * 
	 * @param spName
	 * @return 查询结果集
	 * @throws Exception
	 */
	List<?> executeWithResultset(String spName) throws Exception;

	/**
	 * 执行带参数的存储过程并返回多条记录。
	 * 
	 * @param spName
	 * @param parameters
	 * @return 查询结果集
	 * @throws Exception
	 */
	List<?> executeWithResultset(String spName, Map<String, Object> parameters) throws Exception;

}
