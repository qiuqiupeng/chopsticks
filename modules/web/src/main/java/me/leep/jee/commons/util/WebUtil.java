/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.util;

public class WebUtil {
	/**
	 * 拼接成一个超链接.
	 * 
	 * @param icon 超链接图标
	 * @param id ID
	 * @param dispName 显示名称或者字符串
	 * @return 返回URL超链接
	 */
	public static String getAnchorTag(String icon, String id, String dispName) {
		String result;
		String jqueryId = "options_" + id;

		StringBuffer sb = new StringBuffer("");
		sb.append("<li><a id=").append(id)
				.append(" href='javascript:void(0)'>");
		sb.append("<i class=").append(icon).append("></i>").append(dispName)
				.append("</a>");
		sb.append("<script type='text/javascript'>");
		sb.append("jQuery(document).ready(function () {");
		sb.append("var ").append(jqueryId).append(" = {};");
		sb.append(jqueryId).append(".jqueryaction = 'anchor';");
		sb.append(jqueryId).append(".id = '").append(id).append("';");
		sb.append(jqueryId).append(".href = '#';");
		sb.append(jqueryId).append(".onclick = 'openURL';");
		sb.append("jQuery.struts2_jquery.bind(jQuery('#").append(id)
				.append("'),").append(jqueryId).append(");");
		sb.append(" });");
		sb.append("</script></li>");

		result = sb.toString();
		return result;
	}

}
