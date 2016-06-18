package com.exc.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exc.common.api.Paginator;
import com.exc.entity.comp.PageInfo;
import com.exc.sys.api.SysPage;
import com.exc.sys.api.SysPageForm;
import com.exc.sys.api.SysPageSearch;
import com.exc.sys.api.SysPageTable;
import com.exc.sys.api.SysPageTool;
import com.exc.sys.service.SysPageBS;
import com.exc.sys.service.SysPageFormBS;
import com.exc.sys.service.SysPageSearchBS;
import com.exc.sys.service.SysPageTableBS;
import com.exc.sys.service.SysPageToolBS;
import com.exc.util.JsonUtils;

@Controller
@RequestMapping
public class TableController extends BaseController{
	
	@Autowired
	private SysPageBS sysPageBS;
	
	@Autowired
	private SysPageSearchBS sysPageSearchBS;
	
	@Autowired
	private SysPageToolBS sysPageToolBS;
	
	@Autowired
	private SysPageTableBS sysPageTableBS;
	
	@Autowired
	private SysPageFormBS sysPageFormBS;

	@RequestMapping(value="{module}/{function}/list",method=RequestMethod.GET)
	public ModelAndView list(@PathVariable("module")String module,@PathVariable("function")String function,HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = this.initPageView(new PageInfo("system/page.jsp"));
		Map pageMap = new HashMap();
		SysPage page = new SysPage();
		page.setUrl(request.getServletPath());
		pageMap.put("url", request.getContextPath()+page.getUrl());
		List<SysPage> pages = sysPageBS.queryList(page);
		if(pages != null && !pages.isEmpty()){
			page = pages.get(0);
			//查询搜索条件
			SysPageSearch pageSearch = new SysPageSearch();
			pageSearch.setPageId(page.getId());
			List<SysPageSearch> searchs = sysPageSearchBS.queryList(pageSearch);
			pageMap.put("searchs", searchs);
			//查询按钮
			SysPageTool pageTool = new SysPageTool();
			pageTool.setPageId(page.getId());
			List<SysPageTool> tools = sysPageToolBS.queryList(pageTool);
			pageMap.put("tools", tools);
			//查询表格
			SysPageTable pageTable = new SysPageTable();
			pageTable.setPageId(page.getId());
			List<SysPageTable> tables = sysPageTableBS.queryList(pageTable);
			pageMap.put("tables", tables);
		}
		view.addObject("jsonPage", JsonUtils.toJSONString(pageMap));
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="{module}/{function}/list",method=RequestMethod.POST)
	public Paginator list(@PathVariable("module")String module,@PathVariable("function")String function,int currentPage,int pageSize,HttpServletRequest request){
		SysPage page = new SysPage();
		page.setUrl(request.getServletPath());
		List<SysPage> pages = sysPageBS.queryList(page);
		if(pages != null && !pages.isEmpty()){
			page = pages.get(0);
			page.getSql();
			Map params = new HashMap();
			//request.getParameterMap();
			Enumeration<String> names = request.getParameterNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				String value = request.getParameter(name);
				if(value != null && !value.equals("")){
					params.put(name, value);
				}
			}
			return sysPageTableBS.queryPage(page.getSql(), currentPage,pageSize, params);
		}
		return null;
	}
	
	
	@RequestMapping(value="{module}/{function}/add",method=RequestMethod.GET)
	public ModelAndView add(@PathVariable("module")String module,@PathVariable("function")String function,HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = this.initPageDialogView(new PageInfo("system/form.jsp"));
		Map pageMap = new HashMap();
		SysPage page = new SysPage();
		page.setUrl(request.getServletPath());
		pageMap.put("submit_url", request.getContextPath()+page.getUrl());
		List<SysPage> pages = sysPageBS.queryList(page);
		if(pages != null && !pages.isEmpty()){
			page = pages.get(0);
			SysPageForm pageForm = new SysPageForm();
			pageForm.setPageId(page.getId());
			List<SysPageForm> forms = sysPageFormBS.queryList(pageForm);
			pageMap.put("forms", forms);
		}
		view.addObject("jsonForms", JsonUtils.toJSONString(pageMap));
		return view;
	}
}
