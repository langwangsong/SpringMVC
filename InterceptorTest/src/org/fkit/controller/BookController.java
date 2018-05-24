package org.fkit.controller;

import java.util.ArrayList;
import java.util.List;

import org.fkit.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	/**
	 * 处理main请求
	 */
	@RequestMapping(value="/main")
	public String main(Model model) {
		//模拟数据库得到所有图书集合
		List<Book> book_list = new ArrayList<Book>();
		book_list.add(new Book("java.jpg","疯狂Java讲义","李刚 编著",74.2));
		book_list.add(new Book("ee.jpg","轻量级Java EE企业应用实战","李刚 编著",59.2));
		book_list.add(new Book("android.jpg","疯狂android讲义","李刚 编著",60.6));
		book_list.add(new Book("ajax.jpg","疯狂Ajax讲义","李刚 编著",66.6));
		//将图书集合添加到model中
		model.addAttribute("book_list",book_list);
		//跳转到main页面
		return "main";
	}
}
