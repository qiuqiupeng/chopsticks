/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services;


import java.util.Date;

import me.leep.wf.entity.system.UserBean;
import me.leep.wf.repository.system.UserRepository;

import org.activiti.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("rawtypes")
@Repository
public class InitDataGenerator implements ApplicationListener {

	@Autowired
	private UserRepository userRepository;// 注入UserRepository
	@Autowired
	private IdentityService identityService;

	public void onApplicationEvent(ApplicationEvent event) {

		initArticleCategory();

	}

	@Transactional
	private void initArticleCategory() {
		
		
//		createAdminUser();
		

		// 检测数据库是否有初始化数据，若没有则在此初始化数据

		// if(testDao.getCount(ArticleCategory.class)==0){
		//
		// //将文章的分类数据初始化到数据库
		//
		// }

	}
	
	@SuppressWarnings("unused")
	private void createAdminUser() {
		String adminid = "01b1c2ea-dc0d-478b-8526-6724ecb40e35";
		UserBean user = userRepository.findOne(adminid);
		if (user == null) {

			System.out.println("****************************************");
			System.out.println("*             开始初始化数据                                                        *");
			System.out.println("****************************************");
			
			user = new UserBean();//创建一个admin用户
			user.setId(adminid);
			user.setNumber("admin");
			user.setName("管理员");
			user.setEmail("admin@admin.com");
			user.setPassword("21232f297a57a5a743894a0e4a801fc3");
			user.setCreater("系统自动创建");
			user.setLastUpdater("系统自动修改");
			user.setLastUpdateTime(new Date());
			user.setCreteTime(new Date());
//			user.setRemoveFlag("0");

			userRepository.save(user);
			
			org.activiti.engine.identity.User auser = identityService.newUser(user.getId());
			auser.setId(user.getNumber());
			auser.setEmail(user.getEmail());
			auser.setFirstName(user.getName());
			auser.setPassword(user.getPassword());
			
			identityService.saveUser(auser);
			

			System.out.println("****************************************");
			System.out.println("*             结束初始化数据                                                        *");
			System.out.println("****************************************");
		}
	}

}