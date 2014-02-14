/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package me.leep.wf.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Picture;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Servlet implementation class ShowPic
 */
@WebServlet("/ShowPic.slt")
public class ShowPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IdentityService identityService;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPicServlet() {
		super();
	}


	/*
	 * （非 Javadoc）
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		Subject currentUser = SecurityUtils.getSubject();
		
		//通过spring配置初始化服务对象
		ServletContext application = getServletContext();  
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);// 获取spring的context  
		identityService = (IdentityService)wac.getBean("identityService");
		
		Picture userPicture = identityService.getUserPicture(currentUser.getPrincipal().toString());
		

		response.setContentType("image/jpg;charset=GB2312");
		OutputStream output = response.getOutputStream();// 得到输出流
		InputStream imageIn = userPicture.getInputStream();// 文件流
		BufferedInputStream bis = new BufferedInputStream(imageIn);// 输入缓冲流
		BufferedOutputStream bos = new BufferedOutputStream(output);// 输出缓冲流
		byte data[] = new byte[4096];// 缓冲字节数
		int size = 0;
		size = bis.read(data);
		while (size != -1) {
			bos.write(data, 0, size);
			size = bis.read(data);
		}
		bis.close();
		bos.flush();// 清空输出缓冲流
		bos.close();
		output.close();
	}

}
