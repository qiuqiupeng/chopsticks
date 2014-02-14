/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.repository.system;

import me.leep.wf.entity.system.MessageBean;
import me.leep.wf.repository.BaseRepository;

/**
 * 消息中心持久层接口
 * 
 * @author 李鹏 2012-8-31
 */
public interface MessageRepository extends BaseRepository<MessageBean, String> {

}