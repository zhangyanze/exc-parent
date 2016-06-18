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
@Table(name = "sys_page_search")
public class SysPageSearch implements java.io.Serializable {

	/** 
	 * 主键
	 */

	private Long id;

	/** 
	 * 页面id
	 */

	private Long pageId;

	/** 
	 * 中文名称
	 */

	private String text;

	/** 
	 * 英文名称
	 */

	private String name;

	/** 
	 * 默认值
	 */

	private String value;

	/** 
	 * 类型：text文本框，select下拉框
	 */

	private String type;

	/** 
	 * 下拉框数据字典
	 */

	private String options;

	/** 
	 * 说明备注
	 */

	private String remark;

	/** 
	 * 版本号
	 */

	private Integer version;

	public SysPageSearch() {
	}

	public SysPageSearch(Long pageId, String text, String name, String value, String type, String options,
			String remark, Integer version) {
		setPageId(pageId);
		setText(text);
		setName(name);
		setValue(value);
		setType(type);
		setOptions(options);
		setRemark(remark);
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

	@Column(name = "page_id")
	public Long getPageId() {
		return this.pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	@Column(name = "text", length = 32)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "name", length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "value", length = 32)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "options", length = 32)
	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
