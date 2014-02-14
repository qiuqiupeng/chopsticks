package me.leep.wf.test.repo;

import java.util.Date;

import me.leep.wf.entity.system.MessageBean;
import me.leep.wf.entity.system.UserBean;
import me.leep.wf.repository.system.MessageRepository;
import me.leep.wf.repository.system.UserRepository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MsgRepositoryTest extends AbstractRepoTest {
	@Autowired
	private UserRepository userRepository;// 需要测试的repo
	@Autowired
	private MessageRepository messageRepository;// 需要测试的repo
	
	
	
	
	@Test
	public void testSaveMsg() {
		MessageBean message = new MessageBean();
		UserBean fromuser = userRepository.findOne("67fef98f-a257-40b4-8268-b036e5d71723");
		UserBean touser = userRepository.findOne("01b1c2ea-dc0d-478b-8526-6724ecb40e35");
		message.setSender(fromuser);
		message.setReciever(touser);
		message.setTitle("test");
		message.setBody("body");
		message.setSendtime(new Date());
		message.setPriority("1");

//		user.setOrgUnit(org);
		messageRepository.save(message);
		System.out.println("这是《" + fromuser.getName() + "》发送到《" + touser.getName() + "》消息");
	}
	

}
