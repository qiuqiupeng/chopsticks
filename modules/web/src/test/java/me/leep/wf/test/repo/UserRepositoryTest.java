package me.leep.wf.test.repo;

import java.util.List;

import me.leep.wf.entity.system.UserBean;
import me.leep.wf.repository.system.OrgUnitRepository;
import me.leep.wf.repository.system.UserRepository;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRepositoryTest extends AbstractRepoTest {
	@Autowired
	private UserRepository userRepository;// 需要测试的repo
	@Autowired
	private OrgUnitRepository orgUnitRepository;// 需要测试的repo
	
	private static final Logger logger = Logger.getLogger( UserRepositoryTest.class.getName() );

	@Test
	public void testCountAllUser() {
		List<UserBean> users= userRepository.findByNumberAndPassword("admin", "jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=");//.count();
		
//		assertEquals(34, count);
		
		logger.info("人数 " + users.size());
		
		
	}
	
	

}
