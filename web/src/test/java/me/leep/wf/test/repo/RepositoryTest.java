package me.leep.wf.test.repo;

import me.leep.wf.entity.system.OrgUnitBean;
import me.leep.wf.repository.system.OrgUnitRepository;
import me.leep.wf.repository.system.UserRepository;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class RepositoryTest extends AbstractRepoTest {
	@Autowired
	private UserRepository userRepository;// 需要测试的repo
	@Autowired
	private OrgUnitRepository orgUnitRepository;// 需要测试的repo
	
	private static final Logger logger = Logger.getLogger( RepositoryTest.class.getName() );

	@Test
	public void testCountAllUser() {
		long count = userRepository.count();
		
//		assertEquals(34, count);
		
		logger.info("人数 " + count);
		
		
	}
	
//	@Test
//	public void testSaveUser() {
//		UserBean user = new UserBean();
//		user.setNumber("testtttt");
//		OrgUnitBean org = orgUnitRepository.findOne("16656472-679d-4a68-94b2-3361fb152be0");
//		user.setOrgUnitBean(org);
//		userRepository.save(user);
//	}
	
	@Test
	public void testSaveOrg() {
		logger.info(">>>测试开始：");
		OrgUnitBean org = new OrgUnitBean();
		org.setNumber("01.05");
//		org.setParent(EntityUtil.read(new OrgUnitBean(), "da8135dd-5fc7-46fc-a3cc-ff8b51d3e87f"));
		OrgUnitBean parent = new OrgUnitBean();
		parent.read("da8135dd-5fc7-46fc-a3cc-ff8b51d3e87f");
		org.setParent(parent);
		org.setName("公司5");
		orgUnitRepository.save(org);
		logger.info("测试结束.<<<");
	}
	

}
