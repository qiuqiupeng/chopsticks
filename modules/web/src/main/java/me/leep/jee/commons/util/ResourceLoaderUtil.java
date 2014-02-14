/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.util;

import java.net.URL;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

/**
 * @author 王建明
 * @since 2013-06-26 09:22:03
 * @version V 1.0
 */
public class ResourceLoaderUtil extends DefaultResourceLoader {
	@Override
	public Resource getResource(String location) {

		// 这里我们对要加载的文件资源进行自定义的解析，我们判断下文件路径是否是以“/WEB-INF/”开头，从而进行处理

		if (location != null && location.startsWith("/WEB-INF/")) {
			try {
				// 由于我的工程是maven工程，所以我的路径重定向到web应用的路径下

				URL url = new URL("file:/" + System.getProperty("user.dir")
						+ "/src/main/webapp" + location);
				return new UrlResource(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return super.getResource(location);
	}
}