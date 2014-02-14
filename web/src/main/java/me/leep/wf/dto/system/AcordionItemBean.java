/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.dto.system;

import java.util.List;

public class AcordionItemBean {

	private String id;
	private String number;
	private String name;
	private String icon;
	private boolean isleaf;
	private List<AcordionItemBean> subMenu;

	/**
	 * @param number
	 * @param name
	 * @param icon
	 */
	public AcordionItemBean(String number, String name, String icon) {
		this.id = number;
		this.number = number;
		this.name = name;
		this.icon = icon;
		this.isleaf = true;
	}

	/**
	 * 
	 */
	public AcordionItemBean() {
	}

	/**
	 * @param id
	 * @param number
	 * @param name
	 * @param icon
	 * @param isleaf
	 * @param subMenu
	 */
	public AcordionItemBean(String id, String number, String name, String icon,
			boolean isleaf, List<AcordionItemBean> subMenu) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.icon = icon;
		this.isleaf = isleaf;
		this.subMenu = subMenu;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            要设置的 icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return isleaf
	 */
	public boolean isIsleaf() {
		return isleaf;
	}

	/**
	 * @param isleaf
	 *            要设置的 isleaf
	 */
	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}

	/**
	 * @return subMenu
	 */
	public List<AcordionItemBean> getSubMenu() {
		return subMenu;
	}

	/**
	 * @param subMenu
	 *            要设置的 subMenu
	 */
	public void setSubMenu(List<AcordionItemBean> subMenu) {
		this.subMenu = subMenu;
	}

	/**
	 * @return number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            要设置的 number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

}
