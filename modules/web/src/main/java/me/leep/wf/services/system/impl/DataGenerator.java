/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services.system.impl;

import java.io.InputStream;
import java.util.List;

import me.leep.jee.commons.util.BeanUtil;
import me.leep.wf.dto.system.AcordionItemBean;
import me.leep.wf.entity.system.UserBean;
import me.leep.wf.repository.system.UserRepository;
import me.leep.wf.services.system.aware.IMenuItemServices;

import org.activiti.engine.impl.util.IoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joram Barrez
 */
@Service("dataGenerator")
public class DataGenerator {

	protected static final Logger LOGGER = LoggerFactory
			.getLogger(DataGenerator.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IMenuItemServices services;

	protected boolean createUsers;
	protected boolean initMenuItems;

	public void setCreateUsers(boolean createUsers) {
		this.createUsers = createUsers;
	}

	public void init() {

		if (createUsers) {
			// LOGGER.info("Initializing demo groups");
			// initDemoGroups();
			LOGGER.info("Initializing demo users");
			initDemoUsers();
		}

		if (initMenuItems) {
			LOGGER.info("Initializing menu items");
			initMenuItems();
		}

	}

	@SuppressWarnings("unchecked")
	protected void initMenuItems() {
		InputStream is;
		try {
			is = this.getClass().getClassLoader()
					.getResourceAsStream("resources/menuall.xml");
			List<AcordionItemBean> items = (List<AcordionItemBean>) BeanUtil
					.xml2Bean(is);
			services.vo2entity(items);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// protected void initDemoGroups() {
	// String[] assignmentGroups = new String[] {"management", "sales",
	// "marketing", "engineering"};
	// for (String groupId : assignmentGroups) {
	// createGroup(groupId, "assignment");
	// }
	//
	// String[] securityGroups = new String[] {"user", "admin"};
	// for (String groupId : securityGroups) {
	// createGroup(groupId, "security-role");
	// }
	// }

	// protected void createGroup(String groupId, String type) {
	// if (identityService.createGroupQuery().groupId(groupId).count() == 0) {
	// Group newGroup = identityService.newGroup(groupId);
	// newGroup.setName(groupId.substring(0, 1).toUpperCase() +
	// groupId.substring(1));
	// newGroup.setType(type);
	// identityService.saveGroup(newGroup);
	// }
	// }

	public void setInitMenuItems(boolean initMenuItems) {
		this.initMenuItems = initMenuItems;
	}

	protected void initDemoUsers() {
		createUser("admin", "系统管理员", "",
				"jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=",
				"admin@admin.com", "resources/profile.jpg", "初始化数据", null, null);

		// createUser("gonzo", "Gonzo", "The Great", "gonzo",
		// "gonzo@activiti.org", "org/activiti/explorer/images/gonzo.jpg",
		// Arrays.asList("management", "sales", "marketing", "user"), null);
		// createUser("fozzie", "Fozzie", "Bear", "fozzie",
		// "fozzie@activiti.org",
		// "org/activiti/explorer/images/fozzie.jpg",
		// Arrays.asList("marketing", "engineering", "user"), null);
	}

	protected void createUser(String number, String firstName, String lastName,
			String password, String email, String imageResource,
			String description, List<String> groups, List<String> userInfo) {

		if (userRepository.findByNumber(number).size() == 0) {
			UserBean user = new UserBean();
			user.setNumber(number);
			user.setName(firstName);
			user.setPassword(password);
			user.setEmail(email);
			user.setDescription(description);
			// image
			if (imageResource != null) {
				byte[] pictureBytes = IoUtil.readInputStream(this.getClass()
						.getClassLoader().getResourceAsStream(imageResource),
						null);
				user.setPicture(pictureBytes);
			}

			userRepository.save(user);
		}

		// if (identityService.createUserQuery().userId(userId).count() == 0) {
		//
		// // Following data can already be set by demo setup script
		//
		// User user = identityService.newUser(userId);
		// user.setFirstName(firstName);
		// user.setLastName(lastName);
		// user.setPassword(password);
		// user.setEmail(email);
		// identityService.saveUser(user);
		//
		// if (groups != null) {
		// for (String group : groups) {
		// identityService.createMembership(userId, group);
		// }
		// }
		// }

		// Following data is not set by demo setup script

		// image
		// if (imageResource != null) {
		// byte[] pictureBytes = IoUtil.readInputStream(this.getClass()
		// .getClassLoader().getResourceAsStream(imageResource), null);
		// Picture picture = new Picture(pictureBytes, "image/jpeg");
		// identityService.setUserPicture(userId, picture);
		// }

		// user info
		// if (userInfo != null) {
		// for (int i = 0; i < userInfo.size(); i += 2) {
		// identityService.setUserInfo(userId, userInfo.get(i),
		// userInfo.get(i + 1));
		// }
		// }

	}

	// protected void initProcessDefinitions() {
	//
	// String deploymentName = "Demo processes";
	// List<Deployment> deploymentList =
	// repositoryService.createDeploymentQuery().deploymentName(deploymentName).list();
	//
	// if (deploymentList == null || deploymentList.size() == 0) {
	// repositoryService.createDeployment()
	// .name(deploymentName)
	// .addClasspathResource("org/activiti/explorer/demo/process/createTimersProcess.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/VacationRequest.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/VacationRequest.png")
	// .addClasspathResource("org/activiti/explorer/demo/process/FixSystemFailureProcess.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/FixSystemFailureProcess.png")
	// .addClasspathResource("org/activiti/explorer/demo/process/simple-approval.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/Helpdesk.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/Helpdesk.png")
	// .addClasspathResource("org/activiti/explorer/demo/process/reviewSalesLead.bpmn20.xml")
	// .deploy();
	// }

	// String reportDeploymentName = "Demo reports";
	// deploymentList =
	// repositoryService.createDeploymentQuery().deploymentName(reportDeploymentName).list();
	// if (deploymentList == null || deploymentList.size() == 0) {
	// repositoryService.createDeployment()
	// .name(reportDeploymentName)
	// .addClasspathResource("org/activiti/explorer/demo/process/reports/taskDurationForProcessDefinition.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/reports/processInstanceOverview.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/reports/helpdeskFirstLineVsEscalated.bpmn20.xml")
	// .addClasspathResource("org/activiti/explorer/demo/process/reports/employeeProductivity.bpmn20.xml")
	// .deploy();
	// }
	//
	// }

	// protected void generateReportData() {
	// if (generateReportData) {
	//
	// // Report data is generated in background thread
	//
	// Thread thread = new Thread(new Runnable() {
	//
	// public void run() {
	//
	// // We need to temporarily disable the job executor or it would interfere
	// with the process execution
	// ((ProcessEngineImpl)
	// processEngine).getProcessEngineConfiguration().getJobExecutor().shutdown();
	//
	// Random random = new Random();
	//
	// Date now = new Date(new Date().getTime() - (24 * 60 * 60 * 1000));
	// ClockUtil.setCurrentTime(now);
	//
	// for (int i=0; i<50; i++) {
	//
	// if (random.nextBoolean()) {
	// processEngine.getRuntimeService().startProcessInstanceByKey("fixSystemFailure");
	// }
	//
	// if (random.nextBoolean()) {
	// processEngine.getIdentityService().setAuthenticatedUserId("kermit");
	// Map<String, Object> variables = new HashMap<String, Object>();
	// variables.put("customerName", "testCustomer");
	// variables.put("details", "Looks very interesting!");
	// variables.put("notEnoughInformation", false);
	// processEngine.getRuntimeService().startProcessInstanceByKey("reviewSaledLead",
	// variables);
	// }
	//
	// if (random.nextBoolean()) {
	// processEngine.getRuntimeService().startProcessInstanceByKey("escalationExample");
	// }
	//
	// if (random.nextInt(100) < 20) {
	// now = new Date(now.getTime() - ((24 * 60 * 60 * 1000) - (60 * 60 *
	// 1000)));
	// ClockUtil.setCurrentTime(now);
	// }
	// }
	//
	// List<Job> jobs =
	// processEngine.getManagementService().createJobQuery().list();
	// for (int i=0; i<jobs.size()/2; i++) {
	// ClockUtil.setCurrentTime(jobs.get(i).getDuedate());
	// processEngine.getManagementService().executeJob(jobs.get(i).getId());
	// }
	//
	// List<Task> tasks =
	// processEngine.getTaskService().createTaskQuery().list();
	// while (tasks.size() > 0) {
	// for (Task task : tasks) {
	//
	// if (task.getAssignee() == null) {
	// String assignee = random.nextBoolean() ? "kermit" : "fozzie";
	// processEngine.getTaskService().claim(task.getId(), assignee);
	// }
	//
	// ClockUtil.setCurrentTime(new Date(task.getCreateTime().getTime() +
	// random.nextInt(60 * 60 * 1000)));
	//
	// processEngine.getTaskService().complete(task.getId());
	// }
	//
	// tasks = processEngine.getTaskService().createTaskQuery().list();
	// }
	//
	// ClockUtil.reset();
	//
	// ((ProcessEngineImpl)
	// processEngine).getProcessEngineConfiguration().getJobExecutor().start();
	// LOGGER.info("Demo report data generated");
	// }
	//
	// });
	// thread.start();
	//
	// }
	// }

}
