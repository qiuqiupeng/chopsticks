/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services.activiti.ext;


import java.util.List;

import me.leep.wf.entity.system.UserBean;
import me.leep.wf.repository.system.UserRepository;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/** 
 * 自定义的Activiti用户管理器 
 *  
 * @author dragon 
 *  
 */  
@Service
public class CustomUserManager extends UserEntityManager {
    
    private static Logger log = LoggerFactory.getLogger(CustomUserManager.class.getName());

	@Autowired
	private UserRepository userRepository;// 注入UserRepository

	private static UserEntity toActivitiUser(UserBean bUser) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(bUser.getId().toString());
		userEntity.setFirstName(bUser.getName());
		Picture picture = new Picture(bUser.getPicture(), "image/jpeg");
		userEntity.setPicture(picture);
		// userEntity.setLastName(bUser.getLoginName());
		userEntity.setPassword(bUser.getPassword());
		userEntity.setEmail(bUser.getEmail());
		userEntity.setRevision(1);
		return userEntity;
	}

	/* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#findUserById(java.lang.String)
     */
	@Override
    public UserEntity findUserById(String userId) {
        log.debug("findUserById called with userId: " + userId);
        UserEntity foundUser = toActivitiUser(userRepository.findByNumber(userId).get(0));
        log.debug("Found user - id:" + foundUser.getId() + " fullname:" + foundUser.getFirstName() + " " + foundUser.getLastName());
        return foundUser;
    }

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#checkPassword(java.lang.String, java.lang.String)
     */
	@Override
    public Boolean checkPassword(String userId, String password) {
    	log.debug("checkPassword called with userId: " + userId + " passwd: " + password );
    	List<UserBean> users = userRepository.findByNumberAndPassword(userId, password);
    	boolean result = users.size() == 0 ? false : true;
        log.debug("checkPassword called with userId: " + userId + " passwd: " + password + " result: " + result);
        return result;
    }

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#findGroupsByUser(java.lang.String)
     */
	@Override
    public List<Group> findGroupsByUser(String userId) {
        log.debug("findGroupsByUser called with userId: " + userId);
        List<Group> userGroups = super.findGroupsByUser(userId);
        log.debug("User: " + userId + " belongs to groups: ");
        for(Group group : userGroups) {
            log.debug("Id: " + group.getId() + " name: " + group.getName() + " type: " + group.getType()); 
        }
        return userGroups;
    }
    
    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#createNewUserQuery()
     */
    @Override
    public UserQuery createNewUserQuery() {
        log.debug("CreateNewUserQuery called");
        return super.createNewUserQuery();
    }
    
    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#findUserCountByQueryCriteria(org.activiti.engine.impl.UserQueryImpl)
     */
    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        log.debug("findUserCountByQueryCriteria called, query: " + query);
        long count = super.findUserCountByQueryCriteria(query);
        log.debug("Found " + count + " users");
        return count;
    }
    
    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#findUserByQueryCriteria(org.activiti.engine.impl.UserQueryImpl, org.activiti.engine.impl.Page)
     */
    @Override
    public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
        log.debug("FindUserByQueryCriteria called, query: " + query + " page: " + page);
        return super.findUserByQueryCriteria(query, page);
    }


    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#createNewUser(java.lang.String)
     */
    @Override
    public User createNewUser(String userId) {
        throw new UnsupportedOperationException();
    }
    
    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#insertUser(org.activiti.engine.identity.User)
     */
    @Override
    public void insertUser(User user) {
        throw new UnsupportedOperationException();
    }

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#updateUser(org.activiti.engine.impl.persistence.entity.UserEntity)
     */
    @Override
    public void updateUser(UserEntity updatedUser) {
        throw new UnsupportedOperationException();
    } 
    
    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.UserEntityManager#deleteUser(java.lang.String)
     */
    @Override
    public void deleteUser(String arg0) {
        throw new UnsupportedOperationException();
    }
}