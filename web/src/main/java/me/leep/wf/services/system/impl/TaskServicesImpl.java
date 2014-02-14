/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services.system.impl;

import java.util.List;
import java.util.Map;

import me.leep.wf.services.system.aware.ITaskServices;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李鹏
 * 
 */
@Service("taskServices")
public class TaskServicesImpl implements ITaskServices {

	@Autowired
	private TaskService taskService;

	public List<Task> getAllTasks(String user, Map<String, Object> var) {
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(user)
				.orderByDueDate()
				.asc().list();
		return tasks;
	}

}
