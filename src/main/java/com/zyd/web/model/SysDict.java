package com.zyd.web.model;

import java.io.Serializable;

/**
 * 字典
 * 
 * @author ZYD
 *
 */
public class SysDict implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Long id;
	/**
	 * 类别
	 */
	private String code;
	/**
	 * 字典名
	 */
	private String name;
	/**
	 * 字典值
	 */
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
