package com.exc.sys.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity: 
 */
@Entity
@Table(name = "sys_page")
public class SysPage implements java.io.Serializable {

	/** 
	 * 主键
	 */

	private Long id;

	/** 
	 * 名称
	 */

	private String name;

	/** 
	 * 页面地址
	 */

	private String url;

	/** 
	 * 类型：列表-table，表单-form，其他-other
	 */

	private String type;

	/** 
	 * 备注
	 */

	private String remark;

	/** 
	 * 查询sql，使用freemarker语法
	 */

	private String sql;

	/** 
	 * 版本号
	 */

	private Integer version;

	public SysPage() {
	}

	public SysPage(String name) {
		setName(name);
	}

	public SysPage(String name, String url, String type, String remark, String sql, Integer version) {
		setName(name);
		setUrl(url);
		setType(type);
		setRemark(remark);
		setSql(sql);
		setVersion(version);
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "type", length = 200)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "sql", length = 65535)
	public String getSql() {
		return this.sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
