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
@Table(name = "sys_dict_value")
public class SysDictValue implements java.io.Serializable {

	/** 
	 * 主键
	 */

	private Long id;

	/** 
	 * 字典类型名称
	 */

	private String name;

	private String value;

	/** 
	 * 字典类型代码
	 */

	private String codeType;

	/** 
	 * 排序
	 */

	private Short sortIndex;

	/** 
	 * 状态 -1隐藏 1显示
	 */

	private Byte status;

	/** 
	 * 版本号
	 */

	private Integer version;

	public SysDictValue() {
	}

	public SysDictValue(String name) {
		setName(name);
	}

	public SysDictValue(String name, String value, String codeType, Short sortIndex, Byte status, Integer version) {
		setName(name);
		setValue(value);
		setCodeType(codeType);
		setSortIndex(sortIndex);
		setStatus(status);
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

	@Column(name = "value", length = 32)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "code_type", length = 50)
	public String getCodeType() {
		return this.codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	@Column(name = "sort_index")
	public Short getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Short sortIndex) {
		this.sortIndex = sortIndex;
	}

	@Column(name = "status")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
