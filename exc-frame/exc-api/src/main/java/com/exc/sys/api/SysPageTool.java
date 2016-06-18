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
@Table(name = "sys_page_tool")
public class SysPageTool implements java.io.Serializable {

	/** 
	 * 主键
	 */

	private Long id;

	/** 
	 * 页面id
	 */

	private long pageId;

	/** 
	 * 中文名称
	 */

	private String text;

	/** 
	 * 图标
	 */

	private String icon;

	/** 
	 * 单击事件
	 */

	private String click;

	/** 
	 * url地址
	 */

	private String url;

	/** 
	 * 备注
	 */

	private String remark;

	/** 
	 * 版本号
	 */

	private Integer version;

	public SysPageTool() {
	}

	public SysPageTool(long pageId) {
		setPageId(pageId);
	}

	public SysPageTool(long pageId, String text, String icon, String click, String url, String remark,
			Integer version) {
		setPageId(pageId);
		setText(text);
		setIcon(icon);
		setClick(click);
		setUrl(url);
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

	@Column(name = "page_id", nullable = false)
	public long getPageId() {
		return this.pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	@Column(name = "text", length = 20)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "icon", length = 20)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "click", length = 20)
	public String getClick() {
		return this.click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	@Column(name = "url", length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
