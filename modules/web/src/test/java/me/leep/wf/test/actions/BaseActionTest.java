package me.leep.wf.test.actions;

import java.util.HashMap;
import java.util.Map;

import me.leep.jee.commons.util.ResourceLoaderUtil;

import org.apache.struts2.StrutsSpringTestCase;
import org.apache.struts2.dispatcher.Dispatcher;

public abstract class BaseActionTest extends StrutsSpringTestCase {

	@Override
	public String[] getContextLocations() {

		return new String[] { "spring_*_test.xml" };

	}

	@Override
	protected Dispatcher initDispatcher(Map<String, String> params) {
		if (params == null)
			params = new HashMap<String, String>();
		params.put("config",
				"struts-default.xml,struts-plugin.xml,conf/struts/struts.xml");
		params.put("struts.convention.result.path", "/WEB-INF/jsp");// 当然这里可以需要也可以不要，看你的具体情况
		return super.initDispatcher(params);
	}

	@Override
	protected void injectStrutsDependencies(Object object) {
		super.injectStrutsDependencies(object);
	}

	@Override
	protected void initServletMockObjects() {
		resourceLoader = new ResourceLoaderUtil();
		super.initServletMockObjects();
	}

}
