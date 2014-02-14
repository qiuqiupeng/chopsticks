/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.jee.commons.util;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author 李鹏
 */
public class LogUtil {
	private static final Logger logger;
	
	static {
		logger = Logger.getLogger("wf");
		logger.setLevel(Level.ALL);
	}
	
	public static void log(String info, Level level, Throwable ex) {
    	logger.log(level, info, ex);
    }
    
}
