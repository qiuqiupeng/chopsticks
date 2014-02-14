/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

/**
 * 
 * @author 李鹏
 * 
 */
public class FileUtil {

	/**
	 * 获取配置资源文件
	 * 
	 * @param filename
	 *            文件相对路径名（包括文件夹的相对路径）
	 * @return 读取资源配置文件流
	 * @throws FileNotFoundException
	 *             文件未找到。
	 * @throws URISyntaxException
	 *             路径同步错误
	 */
	public static InputStream getFile(String filename)
			throws FileNotFoundException, URISyntaxException {
		String configFilePath = Thread.currentThread().getContextClassLoader()
				.getResource("").toURI().getPath()
				+ filename;

		return new FileInputStream(new File(configFilePath));

	}

	/**
	 * 获取配置资源文件
	 * 
	 * @param filename
	 *            文件相对路径名（包括文件夹的相对路径）
	 * @return 读取资源配置文件串
	 * @throws FileNotFoundException
	 *             文件未找到。
	 * @throws URISyntaxException
	 *             路径同步错误
	 * @throws UnsupportedEncodingException
	 *             默认按UTF-8编码
	 */
	public static Reader getFile(String filename, String encoding)
			throws FileNotFoundException, URISyntaxException,
			UnsupportedEncodingException {
		if (encoding == null)
			encoding = "UTF-8"; // 字符编码
		return new InputStreamReader(getFile(filename), encoding);
	}
}
