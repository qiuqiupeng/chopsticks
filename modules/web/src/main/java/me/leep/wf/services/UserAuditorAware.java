/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.services;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.AuditorAware;
  
public class UserAuditorAware implements AuditorAware<String> {
  
    @Override  
    public String getCurrentAuditor() {  

		Subject subject = SecurityUtils.getSubject();
		String user = subject.getPrincipal().toString();
        return user;
    }  
  
} 