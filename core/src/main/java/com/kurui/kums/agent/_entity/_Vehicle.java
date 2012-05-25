package com.kurui.kums.agent._entity;

// Generated 2011-11-15 23:07:41 by Hibernate Tools 3.2.2.GA

import java.sql.Timestamp;

import com.kurui.kums.agent.Agent;

/**
 * Vehicle generated by hbm2java
 */

public class _Vehicle extends org.apache.struts.action.ActionForm implements
		Cloneable {

	private static final long serialVersionUID = 1L;

	protected long id;
	protected Agent agent;
	protected String carNo;
	protected String carType;
	protected String engineNo;
	protected String carcaseNo;
	protected String seatCount;
	protected String color;
	protected String memo;
	protected Timestamp updateTime;
	protected Long type;
	protected Long status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Agent getAgent() {

		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getCarNo() {

		return this.carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarType() {

		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getEngineNo() {

		return this.engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getCarcaseNo() {

		return this.carcaseNo;
	}

	public void setCarcaseNo(String carcaseNo) {
		this.carcaseNo = carcaseNo;
	}

	public String getSeatCount() {

		return this.seatCount;
	}

	public void setSeatCount(String seatCount) {
		this.seatCount = seatCount;
	}

	public String getColor() {

		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getMemo() {

		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getType() {

		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getStatus() {

		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
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