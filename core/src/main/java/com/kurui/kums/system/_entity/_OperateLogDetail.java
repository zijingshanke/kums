package com.kurui.kums.system._entity;


// Generated 2011-11-16 1:15:50 by Hibernate Tools 3.2.2.GA

/**
 * OperateLogDetail generated by hbm2java
 */

public class _OperateLogDetail extends org.apache.struts.action.ActionForm
		implements Cloneable {

	private static final long serialVersionUID = 1L;

	protected long id;

	protected String orderNo;
	protected String ip;
	protected String content;
	protected java.util.Set operateLogs = new java.util.HashSet(0);

	public long getId() {

		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNo() {

		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getIp() {

		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getContent() {

		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Set getOperateLogs() {
		return operateLogs;
	}

	public void setOperateLogs(java.util.Set operateLogs) {
		this.operateLogs = operateLogs;
	}

	// The following is extra code
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

	// end of extra code

}
