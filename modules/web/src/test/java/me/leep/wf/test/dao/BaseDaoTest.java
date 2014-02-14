package me.leep.wf.test.dao;



import static org.junit.Assert.assertEquals;

import java.util.List;

import me.leep.jee.commons.dao.IBaseDao;
import me.leep.wf.entity.system.UserBean;
import me.leep.wf.test.repo.AbstractRepoTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseDaoTest extends AbstractRepoTest {
	
	@Autowired
	IBaseDao<UserBean> dao;
	
	private static final Logger logger = Logger.getLogger( BaseDaoTest.class.getName() );

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
		List<?> list = dao.query(sql);
		assertEquals(1, list.size());
		logger.info("用户名称" + ((UserBean)list.get(0)).getName());
	}
	
	@Test
	public void testSave() {
		UserBean bean = new UserBean();
		bean.setNumber("ttttttttttt");
		dao.save(bean);
	}

}
