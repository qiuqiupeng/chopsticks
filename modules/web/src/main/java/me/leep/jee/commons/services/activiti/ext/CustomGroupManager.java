/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.services.activiti.ext;


import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomGroupManager extends GroupEntityManager {

    private static Logger log = LoggerFactory.getLogger(CustomGroupManager.class.getName());
 

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.GroupEntityManager#findGroupsByUser(java.lang.String)
     */
    @Override
    public List<Group> findGroupsByUser(String userId) {
        log.debug("findGroupByUser called with userId: " + userId);
        return super.findGroupsByUser(userId);
    }
  
   
    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.GroupEntityManager#createNewGroup(java.lang.String)
     */
    @Override
    public Group createNewGroup(String groupId) {
        throw new UnsupportedOperationException();
    }

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.GroupEntityManager#deleteGroup(java.lang.String)
     */
    @Override
    public void deleteGroup(String groupId) {
        throw new UnsupportedOperationException();
    }

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.GroupEntityManager#insertGroup(org.activiti.engine.identity.Group)
     */
    @Override
    public void insertGroup(Group group) {
        throw new UnsupportedOperationException();
    }

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.GroupEntityManager#updateGroup(org.activiti.engine.impl.persistence.entity.GroupEntity)
     */
    @Override
    public void updateGroup(GroupEntity updatedGroup) {
        throw new UnsupportedOperationException();
    }

    /** 
     * 必须覆盖实现
     * @see org.activiti.engine.impl.persistence.entity.GroupEntityManager#findGroupsByUser(java.lang.String)
     */
    public GroupEntity findGroupById(String groupId) {
        log.debug("findGroupById called with groupId: " + groupId);
//        return super.findGroupById(groupId);
        return null;
    }
    

    /* (non-Javadoc)
     * @see org.activiti.engine.impl.persistence.entity.GroupEntityManager#findPotentialStarterUsers(java.lang.String)
     */
    public List<Group> findPotentialStarterUsers(String proceDefId) {
        throw new UnsupportedOperationException();
    }
}
