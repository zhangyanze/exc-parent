package com.exc.controller.sys;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exc.controller.BaseController;
import com.exc.entity.comp.PageInfo;
import com.exc.sys.service.SysPageBS;

@Controller
@RequestMapping(value="/system")
public class SysPageController extends BaseController{
	
	@Autowired
	private SysPageBS sysPageBS;

	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ModelAndView page(){
		ModelAndView view = this.initPageView(new PageInfo("system/page.jsp"));
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="/page",method=RequestMethod.POST)
	public Object page(HttpServletRequest request){
		return "ok";
	}
	
}
