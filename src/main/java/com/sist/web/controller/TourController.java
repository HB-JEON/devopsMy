package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.entity.TourEntity;
import com.sist.web.service.TourService;

@Controller
public class TourController {
	@Autowired
	private TourService tService;
	
	@GetMapping("/detail")
	public String tour_detail(@RequestParam("no") int no, Model model)
	{
		TourEntity vo = tService.tourDetailData(no);
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_html", "tour/detail");
		return "index";
	}
	
	@RequestMapping("/find")
	public String tour_find(Model model)
	{
		model.addAttribute("main_html", "tour/find");
		return "index";
	}
}
