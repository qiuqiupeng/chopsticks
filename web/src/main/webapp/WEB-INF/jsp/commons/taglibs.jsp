<%@ page language="java" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*,org.apache.commons.lang.StringUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<s:set id="contextPath"
	value="#request.get('javax.servlet.forward.context_path')" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	//jquery.ui主题
	String defaultTheme = "redmond";
	String themeVersion = "1.8.16";

	session.setAttribute("themeName", defaultTheme);
	session.setAttribute("themeVersion", themeVersion);
	pageContext.setAttribute("timeInMillis", System.currentTimeMillis());
%>