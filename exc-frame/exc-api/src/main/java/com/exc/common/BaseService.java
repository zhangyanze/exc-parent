package com.exc.common;

import java.util.List;
import java.util.Map;

import com.exc.common.api.Paginator;

public interface BaseService<T> {
	/**
	 * 保存对象
	 * @param t
	 */
	public void save(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 删除对象
	 * @param t
	 */
	public void delete(T t);
	/**
	 * 通过id获取对象
	 * @param id
	 * @return
	 */
	public T getOne(Long id);
	/**
	 * 通过对象条件查询列表
	 * @return
	 */
	public List<T> queryList(T t);
	
	/**
	 * 分页查询
	 * @param sql
	 * @param currentPage
	 * @param pageSize
	 * @param params
	 * @return
	 */
	public Paginator queryPage(String sql,int currentPage,int pageSize,Map<String,Object> params);
}
