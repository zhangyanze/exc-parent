package com.exc.controller;

import org.springframework.web.servlet.ModelAndView;

import com.exc.entity.comp.PageInfo;

public class BaseController {

	public ModelAndView initPageView(PageInfo pageInfo){
		ModelAndView view = new ModelAndView("index");
		view.addObject("page", pageInfo);
		return view;
	}
	
	public ModelAndView initPageDialogView(PageInfo pageInfo){
		ModelAndView view = new ModelAndView("dialog");
		view.addObject("page", pageInfo);
		return view;
	}
}
