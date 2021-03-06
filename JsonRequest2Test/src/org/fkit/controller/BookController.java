package org.fkit.controller;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/json")
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	@RequestMapping("/testRequestBody")
	public void setJson(@RequestBody Book book,HttpServletResponse response) throws Exception {
		//JSONObject-lib包是一个beans，collections,maps,java arrays和xml和JSON互换的包
		//使用JSONObject将Book对象转换成json输出
		logger.info(JSONObject.toJSONString(book));
		book.setAuthor("刘小松123");
		response.setContentType("text/html;charset=UTF-8");
		//将Book对象转换成json写入到客户端
		response.getWriter().println(JSONObject.toJSONString(book));
	}
}
