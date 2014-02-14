package me.leep.wf.test.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring_ds_test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BoneCPTest {


//	@Autowired
	DataSource ds;

	@Test
	public void testBoneCP() throws SQLException {
//		Connection connection = ds.getConnection();
//		System.out.println(connection); 
		ds = (DataSource) extracted().getBean("dataSource");
		Connection connection = ds.getConnection();
		System.out.println(connection);
	}

	private ClassPathXmlApplicationContext extracted() {
		return new ClassPathXmlApplicationContext("classpath:spring_ds_test.xml");
	}

}
