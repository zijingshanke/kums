package com.kurui.kums.report._entity;

// Generated 2011-11-6 3:39:34 by Hibernate Tools 3.2.2.GA

import java.math.BigDecimal;

/**
 * CreditReport generated by hbm2java
 */

public class _CreditReport extends org.apache.struts.action.ActionForm
		implements Cloneable {

	private static final long serialVersionUID = 1L;

	protected long id;
	protected Long agentId;
	protected String agentName;
	protected BigDecimal beginAmount;
	protected BigDecimal endAmount;
	protected BigDecimal addAmount;
	protected BigDecimal lessenAmount;
	protected Long type;
	protected Long status;
	protected String sessionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getAgentId() {

		return this.agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {

		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public BigDecimal getBeginAmount() {
		if (beginAmount == null) {
			return BigDecimal.ZERO;
		}
		return this.beginAmount;
	}

	public void setBeginAmount(BigDecimal beginAmount) {
		this.beginAmount = beginAmount;
	}

	public BigDecimal getEndAmount() {
		if (endAmount == null) {
			return BigDecimal.ZERO;
		}
		return this.endAmount;
	}

	public void setEndAmount(BigDecimal endAmount) {
		this.endAmount = endAmount;
	}

	public BigDecimal getAddAmount() {
		if (addAmount == null) {
			return BigDecimal.ZERO;
		}
		return this.addAmount;
	}

	public void setAddAmount(BigDecimal addAmount) {
		this.addAmount = addAmount;
	}

	public BigDecimal getLessenAmount() {
		if (lessenAmount == null) {
			return BigDecimal.ZERO;
		}
		return this.lessenAmount;
	}

	public void setLessenAmount(BigDecimal lessenAmount) {
		this.lessenAmount = lessenAmount;
	}
	
	

	public Long getType() {
		return type;
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
	
	

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
