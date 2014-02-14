/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.actions.json;

//import java.util.List;

import me.leep.wf.actions.base.BaseDataProvider;
import me.leep.wf.vo.system.FuncMenu;

/**
 * @author 李鹏
 * 
 */
public class FuncmenuDataProvider extends BaseDataProvider<FuncMenu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4302036849790278738L;

//	private IFuncmenuServices funcmenuServices;

	public String execute() throws Exception {

//		initGridParam(UserBean.class);
//		initGridParam(funcmenuServices.countAll());
//
//		List<BaseDto> result = funcmenuServices.findAll(FuncMenuBean.class,
//				FuncMenu.class, null, getFrom(), getTo());
//
//		this.setGridModel(result);

		return SUCCESS;
	}

//	/**
//	 * @param funcmenuServices
//	 *            要设置的 funcmenuServices
//	 */
//	public void setFuncmenuServices(IFuncmenuServices funcmenuServices) {
//		this.funcmenuServices = funcmenuServices;
//	}

}
