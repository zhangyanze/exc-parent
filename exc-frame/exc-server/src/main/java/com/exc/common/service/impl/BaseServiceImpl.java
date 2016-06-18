package com.exc.common.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exc.common.BaseService;
import com.exc.common.api.Paginator;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public void save(T t) {
		hibernateTemplate.save(t);
	}

	@Override
	@Transactional
	public void update(T t) {
		hibernateTemplate.update(t);
	}

	@Override
	@Transactional
	public void delete(T t) {
		hibernateTemplate.delete(t);
		
	}

	@Override
	@Transactional
	public T getOne(Long id) {
		Type genType = getClass().getGenericSuperclass();   
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();   
		return (T) hibernateTemplate.get((Class)params[0], id);
	}

	@Override
	@Transactional
	public List<T> queryList(T t) {
		return hibernateTemplate.findByExample(t);
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public Paginator queryPage(String sql,int currentPage,int pageSize,Map<String,Object> params){
		StringReader sr = new StringReader(sql);
		StringWriter sw = new StringWriter();
		Paginator page = new Paginator();
		try {
			Template t = new Template("", sr);
			t.process(params, sw);
			String sql1 = sw.toString();
			sr.close();
			sw.close();
			
			System.out.println(sql1);
			Pattern pattern = Pattern.compile("#\\w+#");
			Matcher matcher = pattern.matcher(sql1);
			List list = new ArrayList();
			while(matcher.find()){
				String _key = matcher.group();
				sql1 = sql1.replace(_key, "?");
				String _key1 = _key.substring(1, _key.length()-1);
				list.add(params.get(_key1));
				System.out.println(_key1);
			}
			System.out.println(sql1);
			Long totalItems = 0L;
			if(list.isEmpty()){
				totalItems = this.getJdbcTemplate().queryForLong("select count(1) from ("+sql1+") t");
				if(totalItems>0){
					List data = this.getJdbcTemplate().queryForList(sql1+"limit "+(pageSize*(currentPage-1))+","+pageSize);
					page.setData(data);
				}
			}else{
				totalItems = this.getJdbcTemplate().queryForLong("select count(1) from ("+sql1+") t", list.toArray());
				if(totalItems>0){
					List data = this.getJdbcTemplate().queryForList(sql1+"limit "+(pageSize*(currentPage-1))+","+pageSize, list.toArray());
					page.setData(data);
				}
			}
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalItems(totalItems);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return page;
	}
	public void page(){
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
