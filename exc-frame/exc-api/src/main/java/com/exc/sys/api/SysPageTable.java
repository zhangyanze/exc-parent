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
@Table(name = "sys_page_table")
public class SysPageTable implements java.io.Serializable {

	/** 
	 * 主键ID
	 */

	private Long id;

	private Long pageId;

	/** 
	 * 英文名称
	 */

	private String name;

	/** 
	 * 中文名称
	 */

	private String text;

	/** 
	 * 编辑类型，1是，0否
	 */

	private String edit;

	/** 
	 * 类型：text输入框，select下拉框
	 */

	private String type;

	/** 
	 * 下拉框数据字典
	 */

	private String options;

	/** 
	 * 版本号
	 */

	private Integer version;

	public SysPageTable() {
	}

	public SysPageTable(Long pageId, String name, String text, String edit, String type, String options,
			Integer version) {
		setPageId(pageId);
		setName(name);
		setText(text);
		setEdit(edit);
		setType(type);
		setOptions(options);
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

	@Column(name = "name", length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "text", length = 32)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "edit", length = 1)
	public String getEdit() {
		return this.edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	@Column(name = "type", length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "options", length = 20)
	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
