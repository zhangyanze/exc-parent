package com.exc.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exc.controller.BaseController;
import com.exc.entity.comp.PageInfo;
import com.exc.test.service.TestBS;

@Controller
@RequestMapping
public class TestController extends BaseController{
	
	@Autowired
	private TestBS testBS;

	@RequestMapping(value="/index")
	public ModelAndView index(){
		ModelAndView view = this.initPageView(new PageInfo("test/index.jsp"));
		view.addObject("hello", testBS.test());
		return view;
	}
	
	@RequestMapping(value="/index1")
	public String str(){
		return "index";
	}
	
	@RequestMapping(value="/test")
	@ResponseBody
	public List test(String member_name,HttpServletRequest request){
		List list = new ArrayList();
		Map map = new HashMap();
		map.put("id", "1");
		map.put("name", "zhangsan");
		map.put("age", "11");
		map.put("sex", "1");
		list.add(map);
		map = new HashMap();
		map.put("id", "2");
		map.put("name", "李四");
		map.put("age", "22");
		map.put("sex", "0");
		list.add(map);
		return list;
	}
}
