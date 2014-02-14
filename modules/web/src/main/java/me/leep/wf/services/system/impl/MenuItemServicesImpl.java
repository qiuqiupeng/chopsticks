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
import java.util.List;

import me.leep.jee.commons.util.MenuItemUtil;
import me.leep.wf.dto.system.AcordionItemBean;
import me.leep.wf.entity.system.ItemBean;
import me.leep.wf.repository.system.MenuItemRepository;
import me.leep.wf.services.system.aware.IMenuItemServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李鹏
 * 
 */
@Service("menuItemServices")
public class MenuItemServicesImpl implements IMenuItemServices {
	@Autowired
	private MenuItemRepository menuItemRepository;// 注入menuItemRepository

	public void vo2entity(List<AcordionItemBean> items) {
		List<ItemBean> entities = new ArrayList<ItemBean>();
		MenuItemUtil.vo2entity(null, items, entities);
		menuItemRepository.save(entities);
	}

	public List<AcordionItemBean> entity2vo() {
		List<ItemBean> src = menuItemRepository.findAll();
		List<AcordionItemBean> result = MenuItemUtil.entity2vo(null, src);

		return result;
	}

}
