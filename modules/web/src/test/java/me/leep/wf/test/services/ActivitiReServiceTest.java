package me.leep.wf.test.services;


import org.activiti.engine.IdentityService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations={"classpath:spring_*_test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivitiReServiceTest {
	
	private static final Logger logger = Logger.getLogger(ActivitiReServiceTest.class.getName() );
	

	@Autowired
	private IdentityService identityService;
	

	@Test
	public void testInsertUser() {
			
	        

//			assertNotNull("Person object is null but should not be.", activitiUser);
//			
			logger.info("<<<<<<<<<<<<<<<<<<<<结束>>>>>>>>>>>>>>>>>>>>>");

		

		
		
	}
	
	
}
