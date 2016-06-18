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
import com.exc.sys.api.SysDictType;
import com.exc.sys.service.SysDictTypeBS;
import com.exc.sys.service.SysPageBS;

@Controller
@RequestMapping(value="/system")
public class SysDictTypeController extends BaseController{
	
	@Autowired
	private SysDictTypeBS sysDictTypeBS;

	@ResponseBody
	@RequestMapping(value="/dict_type/add",method=RequestMethod.POST)
	public Object add(SysDictType dictType,HttpServletRequest request){
		sysDictTypeBS.save(dictType);
		return "ok";
	}
	
}
