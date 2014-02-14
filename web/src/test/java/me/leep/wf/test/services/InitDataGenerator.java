package me.leep.wf.test.services;

import me.leep.wf.services.system.impl.DataGenerator;
import me.leep.wf.test.repo.AbstractRepoTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class InitDataGenerator extends AbstractRepoTest {
	@Autowired
	private DataGenerator dataGenerator;// 需要测试的repo
	
	private static final Logger logger = Logger.getLogger( InitDataGenerator.class.getName() );

	
	@Test
	public void initSystemData() {
		logger.info(">>>初始化开始：");

		//创建管理员
		dataGenerator.setCreateUsers(true);
		dataGenerator.setInitMenuItems(true);
		dataGenerator.init();
		
		logger.info("初始化结束.<<<");
	}
	

}
