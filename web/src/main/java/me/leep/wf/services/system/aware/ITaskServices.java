/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services.system.aware;


import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;

/**
 * @author 李鹏
 *
 */
public interface ITaskServices {
	public List<Task> getAllTasks(String user, Map<String, Object> var);
}
