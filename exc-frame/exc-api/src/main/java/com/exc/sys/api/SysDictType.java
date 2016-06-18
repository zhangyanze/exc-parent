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
@Table(name = "sys_dict_type")
public class SysDictType implements java.io.Serializable {

	/** 
	 * 主键
	 */

	private Long id;

	/** 
	 * 字典类型名称
	 */

	private String name;

	/** 
	 * 字典类型代码
	 */

	private String code;

	/** 
	 * 状态 -1禁用 1正常
	 */

	private Byte status;

	/** 
	 * 版本号
	 */

	private Integer version;

	public SysDictType() {
	}

	public SysDictType(String name) {
		setName(name);
	}

	public SysDictType(String name, String code, Byte status, Integer version) {
		setName(name);
		setCode(code);
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

	@Column(name = "code", length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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
