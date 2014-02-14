package me.leep.wf.test.dao;



import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.leep.wf.dao.aware.ICrudDao;
import me.leep.wf.entity.system.UserBean;
import me.leep.wf.test.repo.AbstractRepoTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CrudDaoTest extends AbstractRepoTest {
	
	@Autowired
	ICrudDao<UserBean> crudDao;
	
	private static final Logger logger = Logger.getLogger( CrudDaoTest.class.getName() );

//	@Test
//	public void testCountAllUser() {
//		
//		long count = dao.count(UserBean.class);
//		
//		assertEquals(34, count);
//		
//		logger.info("人数 " + count);
//		
//		
//	}
//	
//	@Test
//	public void testfindUserById() {
//		
//		UserBean user = dao.findOneById(UserBean.class, "034a28d1-7f21-4925-9160-cf16303943ce");
//		
//		assertEquals(34, count);
//		
//		logger.info("人数 " + user);
//		
//		
//	}
	
	@Test
	public void testQuery() {
		String sql = "from UserBean model where model.number = 'admin'";
		List<?> list = crudDao.query(sql);
		assertEquals(1, list.size());
		logger.info("用户名称" + ((UserBean)list.get(0)).getName());
		logger.info("全部记录条数: " + crudDao.countAll());
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("number", "admin");
		List<UserBean> users = crudDao.findByEqual(paramsMap);
		assertEquals(1, users.size());
		for(UserBean user : users) {
			logger.info("用户编码" + user.getNumber() + " 名称:" + user.getName());
		}
	}
	
//	@Test
//	public void testSave() {
//		UserBean bean = new UserBean();
//		bean.setNumber("ttttttttttt");
//		crudDao.create(bean);
//	}

}
