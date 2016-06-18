package com.exc.entity.comp;

import java.util.ArrayList;
import java.util.List;

import com.exc.sys.api.SysPageSearch;
import com.exc.sys.api.SysPageTable;
import com.exc.sys.api.SysPageTool;


public class PageInfo {
	private String contentPage;
	
	private List<SysPageSearch> searchs = new ArrayList<SysPageSearch>();

	private List<SysPageTable> tables = new ArrayList<SysPageTable>();
	
	private List<SysPageTool> tools = new ArrayList<SysPageTool>();
	
	public PageInfo(String contentPage) {
		super();
		this.contentPage = contentPage;
	}

	public String getContentPage() {
		return contentPage;
	}

	public void setContentPage(String contentPage) {
		this.contentPage = contentPage;
	}

	public List<SysPageSearch> getSearchs() {
		return searchs;
	}

	public void setSearchs(List<SysPageSearch> searchs) {
		this.searchs = searchs;
	}

	public List<SysPageTable> getTables() {
		return tables;
	}

	public void setTables(List<SysPageTable> tables) {
		this.tables = tables;
	}

	public List<SysPageTool> getTools() {
		return tools;
	}

	public void setTools(List<SysPageTool> tools) {
		this.tools = tools;
	}
	
	
}
