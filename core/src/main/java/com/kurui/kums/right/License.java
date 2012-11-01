package com.kurui.kums.right;

import java.util.Date;

import com.kurui.kums.base.util.DateUtil;
import com.kurui.kums.right._entity._License;

public class License extends _License {
	private static final long serialVersionUID = 1L;

	private String updateDate="";
	public String getUpdateDate() {
		String mydate = "";
		if (updateDate != "") {
			return updateDate;
		}else{
		if (this.updateTime != null && "".equals(updateTime) == false) {
			Date tempDate = new Date(updateTime.getTime());
			mydate = DateUtil.getDateString(tempDate, "yyyy-MM-dd");
		}}
		return mydate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
