package org.fkit.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/json")
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	// @RequestBody 根据json数据，转换成对应的Object
	@RequestMapping("/testRequestBody")
	public void setJson(@RequestBody Book book,HttpServletResponse response) throws Exception{
		//ObjectMapper类是Jackson库的主要类。它提供一些功能将Java对象转换成对应的JSON格式的数据
		ObjectMapper mapper = new ObjectMapper();
		//将book对象转换成json输出
		logger.info(mapper.writeValueAsString(book));
		book.setAuthor("刘小松");
		logger.info(mapper.writeValueAsString(book));
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(mapper.writeValueAsString(book));
	}
}
