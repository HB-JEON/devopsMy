package com.sist.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.entity.TourEntity;
import com.sist.web.service.TourService;
import com.sist.web.vo.TourVO;

@Controller
public class MainController {
	@Autowired
	private TourService tService;
	
	@GetMapping("/")
	public String tour_main(@RequestParam(value = "page", required = false) String page, Model model) 
	{
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;
		
		List<TourVO> list = tService.tourListData(start, end);
		int totalpage = tService.tourTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) +1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) +BLOCK;
		if(endPage > totalpage)
			endPage = totalpage;
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "main/home");
		return "index";
	}
}
