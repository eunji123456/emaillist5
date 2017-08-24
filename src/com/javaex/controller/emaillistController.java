package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.EamillstDao;
import com.javaex.vo.EmaillistVo;

@Controller
public class emaillistController {
	@Autowired private EamillstDao dao;
	
	
	@RequestMapping ("/list")
	public String list(Model model) { 
		List<EmaillistVo> list = dao.getlist();
		System.out.println(list.toString());
	model.addAttribute("list",list);
	
	return"list";
	}
	@RequestMapping("/add")
	public String add(@ModelAttribute EmaillistVo vo) {
		dao.insert(vo);
		return"redirect:/list ";
	}
	@RequestMapping("/form")
	public String add() {
		
		return"form";
	}
	
	
	@RequestMapping ("/hello")
	public String hello() {
		System.out.println("리스트 찍음 ");
		return "hello";
	}
}
