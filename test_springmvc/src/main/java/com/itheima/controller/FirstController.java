package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
	@RequestMapping(value="/test")
	public static String test() {
		System.out.println("HelloController 的 sayHello 方法执行了。。。。");
		return "success";
	}
}
