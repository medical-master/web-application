package com.medicalmaster.common.bean;

import java.io.Serializable;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月18日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class KeyValue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -959290385406997901L;

	private Object key;
	private Object value;

	/**
	 * 
	 */
	public KeyValue(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(Object key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
