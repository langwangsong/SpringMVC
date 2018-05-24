package org.fkit.controller;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	public static final Log logger = LogFactory.getLog(BookController.class);
	//@RequestBody Book book 会将传递的xml数据自动绑定到Book对象
	@RequestMapping(value="/sendxml",method=RequestMethod.POST)
	public void sendxml(@RequestBody Book book) {
		logger.info(book);
		logger.info("接收XML数据成功");
	}
	//
	@RequestMapping(value="/readxml",method=RequestMethod.POST)
	public @ResponseBody Book readXml() throws Exception {
		//通过JAXBContext 的 newInstance方法，传递一个class就可以获得上下文
		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
		//创建 一个 Unmarshaller对象
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		InputStream is = this.getClass().getResourceAsStream("/book.xml");
		//Unmarshaller对象的 Unmarshal方法可以进行xml到Java对象的转换
		Book book = (Book) unmarshaller.unmarshal(is);
		logger.info(book);
		return book;
	}
}
