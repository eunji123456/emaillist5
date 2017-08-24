package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.guestBookDao;
import com.javaex.vo.guestBookVo;

@Controller("/gb")
public class guestBookController {
	@Autowired guestBookDao dao;
	
	@RequestMapping("/gb/list")
	public String list (Model model) {
		System.out.println("기본값 리스트 ");
		List <guestBookVo> list = dao.getlist();
		
		model.addAttribute("list", list);
		
		return"guestBook/list";
		
	}
	@RequestMapping("/gb/add")
	public String add (@ModelAttribute guestBookVo vo) {
		dao.insert(vo);
		return"redirect:/gb/list";
		
	}

	@RequestMapping("/gb/deleteform")
	public String delteform (@ModelAttribute guestBookVo vo) {
		System.out.println("클릭한번호 :" +vo.getNo());
		return"guestBook/deleteform";
		
	}

	@RequestMapping("/gb/delete")
	public String delte (@ModelAttribute guestBookVo vo) {
		dao.delete(vo.getNo(), vo.getPassword());
		
		return"redirect:/gb/list";
		
	}

}
