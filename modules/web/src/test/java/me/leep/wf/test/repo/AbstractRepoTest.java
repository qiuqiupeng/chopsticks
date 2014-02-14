package me.leep.wf.test.repo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations={"classpath:spring_*_test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class AbstractRepoTest {
	
	@Before
	  public void setUp() {
		
		UsernamePasswordToken token = new UsernamePasswordToken("admin",
				"admin");//采用ini文件中配置的用户名和密码登录测试
		
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(token);
	  }

	@BeforeClass
    public static void setUpClass() throws Exception {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiroTest.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

    }
	
	@Test
	public void test() {
		
	}
	
}
