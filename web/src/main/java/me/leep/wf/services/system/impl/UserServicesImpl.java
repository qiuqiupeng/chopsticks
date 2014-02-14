/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services.system.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.leep.wf.entity.BaseEntity;
import me.leep.wf.entity.system.UserBean;
import me.leep.wf.repository.system.UserRepository;
import me.leep.wf.services.BaseServiceImpl;
import me.leep.wf.services.system.aware.IUserServices;
import me.leep.wf.util.BeanUtil;
import me.leep.wf.vo.system.User;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author 李鹏
 * 
 */
@Service("userServices")
public class UserServicesImpl extends BaseServiceImpl<User, UserBean> implements
		IUserServices {
	@Autowired
	private UserRepository userRepository;// 注入UserRepository

	@Override
	public User initUserDto(String rowid) {
		User user = new User();
		if (StringUtils.isNotEmpty(rowid)) {
			UserBean userBean = (UserBean) findById(rowid);
			if (userBean != null)
				BeanUtil.copyBean(userBean, user);
		}
		return user;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see me.leep.wf.services.BaseServiceImpl#save(me.leep.wf.dto.BaseDto,
	 * java.lang.Class)
	 */
	@Override
	public String save(User user) {
		if (exists(user.getId())) {// 更新
			UserBean bean = (UserBean) findById(user.getId());
			if (user.getPassword() == null) {
				user.setPassword(bean.getPassword());
			} else {
				user.setPassword(new Sha256Hash(user.getPassword()).toBase64());
			}

		} else
			user.setPassword(new Sha256Hash(user.getPassword()).toBase64());

		UserBean entity = new UserBean();
		BeanUtil.copyBean(user, entity);

		entity = userRepository.save(entity);
		user.setId(entity.getId());

		return entity.getId();
	}

	public List<User> findAll(int page, int size) {
		List<UserBean> beanList = userRepository.findAll(
				new PageRequest(page, size)).getContent();
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < beanList.size(); i++) {
			BaseEntity bean = (BaseEntity) beanList.get(i);
			User dto = new User();
			BeanUtil.copyBean(bean, dto);
			result.add(dto);

		}
		return result;

	}

	public void delete(UserBean entity) {
		userRepository.delete(entity);
	}

	public UserBean findById(String id) {
		return userRepository.findOne(id);
	}

	public boolean exists(String id) {
		return userRepository.exists(id);
	}

	public void deleteList(String[] rowids) {
		userRepository.delete(userRepository.findAll(Arrays.asList(rowids)));
	}

	public Integer countAll() {
		return Integer.valueOf((int) userRepository.count());
	}

}
