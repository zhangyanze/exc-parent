package com.exc.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.exc.entity.comp.PageInfo;
import com.exc.sys.api.SysPage;
import com.exc.sys.api.SysPageSearch;
import com.exc.sys.api.SysPageTable;
import com.exc.sys.api.SysPageTool;
import com.exc.sys.service.SysPageBS;
import com.exc.sys.service.SysPageSearchBS;
import com.exc.sys.service.SysPageTableBS;
import com.exc.sys.service.SysPageToolBS;
import com.exc.util.JsonUtils;

public class PageInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SysPageBS sysPageBS;
	
	@Autowired
	private SysPageSearchBS sysPageSearchBS;
	
	@Autowired
	private SysPageToolBS sysPageToolBS;
	
	@Autowired
	private SysPageTableBS sysPageTableBS;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("method:"+request.getMethod()+"url:"+request.getServletPath());
		/*if("POST".equals(request.getMethod())){
			SysPage page = new SysPage();
			page.setUrl(request.getServletPath());
			List<SysPage> pages = sysPageBS.queryList(page);
			if(pages != null && !pages.isEmpty()){
				page = pages.get(0);
				page.getSql();
				//sysPageTableBS.queryPage(sql, currentPage, pageSize, params)
			}
		}else{
			if(modelAndView!=null){
				Map<String,Object> map = modelAndView.getModel();
				if(map != null){
					PageInfo pageInfo = (PageInfo) map.get("page");
					if(pageInfo != null){
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
						modelAndView.addObject("jsonPage", JsonUtils.toJSONString(pageMap));
					}
				}
			}
		}*/
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	
	/*@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}*/

	
}
