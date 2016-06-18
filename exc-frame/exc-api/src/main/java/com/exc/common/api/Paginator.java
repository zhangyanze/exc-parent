package com.exc.common.api;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("unchecked")
public class Paginator implements Serializable{

    private int pageSize;
    private int totalPage; 
    private long totalItems;
    private int currentPage;
    private List data;

    public Paginator() {
        this.pageSize=10;
    }

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}