package com.kurui.kums.transaction._entity;


/**
 * Company generated by hbm2java
 */

public class _ImageLibrary

extends org.apache.struts.action.ActionForm implements Cloneable {
	private static final long serialVersionUID = 1L;

	// Fields

	protected long id;
	protected String name;
	protected byte[] content;
	protected String memo;
	protected Long type;
	protected Long status;
	protected java.sql.Timestamp updateTime;
	protected String userNo;
	
	
	
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	



}
