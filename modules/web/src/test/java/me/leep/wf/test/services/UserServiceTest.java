package me.leep.wf.test.services;

import static org.junit.Assert.assertNotNull;
import me.leep.wf.services.system.aware.IUserServices;
import me.leep.wf.vo.system.User;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations={"classpath:spring_*_test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	
	private static final Logger logger = Logger.getLogger(UserServiceTest.class.getName() );
	
	@Autowired
	IUserServices userServices;

	@Test
	public void testFindbyEmplid() {
		
//		UserBean user = (UserBean) userServices.findById("f6af2550-86f3-4b5f-acac-5fcbbc980fa6", UserBean.class);
//		UserBean user = (UserBean) userServices.findById("01b1c2ea-dc0d-478b-8526-6724ecb40e35");
		
		User vuser = new User();
		userServices.findById("01b1c2ea-dc0d-478b-8526-6724ecb40e35", vuser);
		
		assertNotNull("Person object is null but should not be.", vuser);
		
		logger.info("Person state is " + vuser.getName());
		
		
	}

}
