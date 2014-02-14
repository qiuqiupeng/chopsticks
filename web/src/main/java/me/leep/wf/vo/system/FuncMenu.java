/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
/**
 * 
 */
package me.leep.wf.vo.system;


import me.leep.wf.vo.BaseVO;

/**
 * @author 李鹏
 * 
 *
 */
public class FuncMenu extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -73932657755532374L;
	
	private String dataicon;

	private String shortcode;
	private String herf;
	private String target;
	/**
	 * @return dataicon
	 */
	public String getDataicon() {
		return dataicon;
	}
	/**
	 * @param dataicon 要设置的 dataicon
	 */
	public void setDataicon(String dataicon) {
		this.dataicon = dataicon;
	}
	/**
	 * @return shortcode
	 */
	public String getShortcode() {
		return shortcode;
	}
	/**
	 * @param shortcode 要设置的 shortcode
	 */
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}
	/**
	 * @return herf
	 */
	public String getHerf() {
		return herf;
	}
	/**
	 * @param herf 要设置的 herf
	 */
	public void setHerf(String herf) {
		this.herf = herf;
	}
	/**
	 * @return target
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * @param target 要设置的 target
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	

	
}
