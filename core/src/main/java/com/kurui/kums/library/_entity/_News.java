package com.kurui.kums.library._entity;

import com.kurui.kums.right.UserStore;

/**
 * News generated by hbm2java
 */

public class _News

extends org.apache.struts.action.ActionForm implements Cloneable {
	private static final long serialVersionUID = 1L;

	// Fields

	protected long id;
	protected String title;
	protected String content;

	protected Long readNum;
	protected Long type;
	protected Long status;
	protected Long rank;
	
	protected String userNo;
	
	protected java.sql.Timestamp createTime;
	protected java.sql.Timestamp updateTime;

	// Constructors

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Long getReadNum() {
		if(readNum==null){
			return Long.valueOf(0);
		}
		return this.readNum;
	}

	public void setReadNum(Long readNum) {
		this.readNum = readNum;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getRank() {
		return this.rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public String getUserName() {
		if (userNo != null && "".equals(userNo.trim()) == false) {
			return UserStore.getUserNameByNo(userNo);
		} else {
			return "";
		}
	}
	
	

	// The following is extra code specified in the hbm.xml files

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	private String thisAction = "";

	public String getThisAction() {
		return thisAction;
	}

	public void setThisAction(String thisAction) {
		this.thisAction = thisAction;
	}

	private int index = 0;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	// end of extra code specified in the hbm.xml files

}