package com.kurui.kums.finance._entity;

// Generated 2011-12-2 4:17:12 by Hibernate Tools 3.2.2.GA

import java.math.BigDecimal;
import java.sql.Timestamp;
import com.kurui.kums.finance.Budget;


/**
 * BudgetOrder generated by hbm2java
 */

public class _BudgetOrder extends org.apache.struts.action.ActionForm implements
		Cloneable {

	private static final long serialVersionUID = 1L;

	protected long id;
	protected Budget budget;
	protected String name;
	protected BigDecimal budgetAmount;
	protected Timestamp budgeTime;
	protected BigDecimal statementAmount;
	protected Timestamp statementTime;
	protected String memo;
	protected Long status;

	public Long getId() {

		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Budget getBudget() {

		return this.budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public String getName() {

		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBudgetAmount() {
		if (budgetAmount == null) {
			return BigDecimal.ZERO;
		}
		return this.budgetAmount;
	}

	public void setBudgetAmount(BigDecimal budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public Timestamp getBudgeTime() {

		return this.budgeTime;
	}

	public void setBudgeTime(Timestamp budgeTime) {
		this.budgeTime = budgeTime;
	}

	public BigDecimal getStatementAmount() {
		if (statementAmount == null) {
			return BigDecimal.ZERO;
		}
		return this.statementAmount;
	}

	public void setStatementAmount(BigDecimal statementAmount) {
		this.statementAmount = statementAmount;
	}

	public Timestamp getStatementTime() {

		return this.statementTime;
	}

	public void setStatementTime(Timestamp statementTime) {
		this.statementTime = statementTime;
	}

	public String getMemo() {

		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
