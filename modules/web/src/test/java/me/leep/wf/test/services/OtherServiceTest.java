package me.leep.wf.test.services;

import java.beans.PropertyDescriptor;

import me.leep.wf.entity.system.UserBean;
import me.leep.wf.util.BeanUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations={"classpath:spring_*_test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OtherServiceTest {

	@Test
	public void testMain() {
		try {
			PropertyDescriptor[] pds = BeanUtil.getProperty(UserBean.class);
			for (PropertyDescriptor pd : pds) {
				System.out.println(">>>" + pd.getDisplayName() + ">>" + pd.getPropertyType().getSimpleName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
