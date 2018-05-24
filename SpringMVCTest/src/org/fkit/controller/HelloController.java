package org.fkit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *HelloController是一个实现Controller的控制器，
 *可以处理一个单一的请求 
 * @author Mr_lang
 *
 */
public class HelloController implements Controller {
	private static final Log logger = LogFactory.getLog(HelloController.class);
	/**
	 * HandleRequest是Controller接口必须实现的方法
	 * 该方法的参数是对应请求的HeepServletRequest和HttpServletResponse
	 * 该方必须返回一个包含视图名或视图名和模型的ModelAndView对象 
	 *
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("HandleRequest 被调用");
		//创建准备返回的ModelAndView对象，该对象通常包含了返回视图名、模型的名称以及模型对象
		ModelAndView mv = new ModelAndView();
		//添加模型数据，可以是任意的POJO对象
		mv.addObject("message","Hello World!");
		//设置逻辑视图名，视图解析器会根据改名字解析到具体的视图页面
		mv.setViewName("/WEB-INF/content/welcome.jsp");
		return mv;
	}
}
