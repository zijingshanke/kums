﻿<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/tld/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="../_css/reset.css" rel="stylesheet" type="text/css" />
		<link href="../_css/global.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" language="javascript" src="../_js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="../_js/prototype/common.js"></script>

		<script type="text/javascript">
	function add(){
	    document.forms[0].thisAction.value="save";
	    document.forms[0].submit();
	}	
	
	function edit()	{
		if(document.forms[0].selectedItems==null){
			alert("没有数据，无法修改！");
		}else if (sumCheckedBox(document.forms[0].selectedItems)<1){
	   		alert("您还没有选择数据！");
		}else if (sumCheckedBox(document.forms[0].selectedItems)>1){
	      	alert("您一次只能选择一个数据！");
		}else {
	    	document.forms[0].thisAction.value="edit";
	    	document.forms[0].submit();
	  	}
	}
	
	function del()	{	
	 if(document.forms[0].selectedItems==null){
		alert("没有数据，无法修改！");
	 }else if (sumCheckedBox(document.forms[0].selectedItems)<1){
	 	 alert("您还没有选择数据！");
	 }else if(confirm("您真的要删除选择的这些数据吗？")){
	    document.forms[0].thisAction.value="delete";
	    document.forms[0].submit();
	  }
	}	
	
	</script>
	</head>
	<body>
		<div id="mainContainer">
			<div id="container">
				<html:form action="/market/saleEventList.do">
					<html:hidden property="thisAction" />
					<html:hidden property="lastAction" />
					<html:hidden property="intPage" />
					<html:hidden property="pageCount" />

					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td width="10" height="10" class="tblt"></td>
							<td height="10" class="tbtt"></td>
							<td width="10" height="10" class="tbrt"></td>
						</tr>
						<tr>
							<td width="10" class="tbll"></td>
							<td valign="top" class="body">
								<c:import url="../page/mainTitle.jsp" charEncoding="UTF-8">
									<c:param name="title1" value="市场管理" />
									<c:param name="title2" value="活动列表" />
								</c:import>
								<div class="searchBar">
									<table cellpadding="0" cellspacing="0" border="0" class="searchPanel">
										<tr>
											<td>
												名称：
											</td>
											<td>
												<html:text property="name" styleClass="colorblue2 p_5" style="width:150px;" />
											</td>
											<td>
												类型：
											</td>
											<td>
												<html:select property="type" value="${saleEventListForm.type}" styleClass="colorblue2 p_5" style="width:180px;">
													<html:option value="">-请选择-</html:option>
													<html:option value="1">默认</html:option>
												</html:select>
											</td>
											<td>
												<input type="submit" name="button" id="button" value="提交" class="submit greenBtn" />
											</td>
										</tr>
									</table>
								</div>
								<table width="100%" cellpadding="0" cellspacing="0" border="0" class="dataList">
									<tr>
										<th width="60">
											<div>
												&nbsp;请选择
											</div>
										</th>
										<th width="35">
											<div>
												&nbsp;序号
											</div>
										</th>
										<th>
											<div>
												名称
											</div>
										</th>
										<th>
											<div>
												类型
											</div>
										</th>
										<th>
											<div>
												备注
											</div>
										</th>
										<th>
											<div>
												状态
											</div>
										</th>
									</tr>
									<c:forEach var="saleEvent" items="${saleEventListForm.list}" varStatus="status">
										<tr>
											<td>
												<html:multibox property="selectedItems" value="${saleEvent.id}"></html:multibox>
											</td>
											<td>
												<c:out value="${status.count+(saleEventListForm.intPage-1)*saleEventListForm.perPageNum}" />
											</td>
											<td style="text-align: left">
												<a href="<%=path%>/market/saleEventList.do?thisAction=view&id=<c:out value="${saleEvent.id}" />"> <c:out value="${saleEvent.name}" /> </a>
											</td>


											<td>
												<c:out value="${saleEvent.typeInfo}" />
											</td>
											<td>
												<c:out value="${saleEvent.memo}" />
											</td>
											<td>
												<c:out value="${saleEvent.statusInfo}" />
											</td>
										</tr>
									</c:forEach>
								</table>

								<table width="100%" style="margin-top: 5px;">
									<tr>
										<td>
											<input name="label" type="button" class="button1" value="新 增" onclick="add();">
											<input name="label" type="button" class="button1" value="修 改" onclick="edit();">
											<input name="label" type="button" class="button1" value="删 除" onclick="del();">
										</td>
										<td align="right">
											<div>
												共有记录&nbsp;
												<c:out value="${saleEventListForm.totalRowCount}"></c:out>
												&nbsp;条&nbsp;&nbsp;&nbsp;&nbsp; [
												<a href="JavaScript:turnToPage(document.forms[0],0)">首页</a> |
												<a href="JavaScript:turnToPage(document.forms[0],1)">上一页</a> |
												<a href="JavaScript:turnToPage(document.forms[0],2)">下一页</a> |
												<a href="JavaScript:turnToPage(document.forms[0],3)"> 末页</a>] 页数:
												<c:out value="${saleEventListForm.intPage}" />
												/
												<c:out value="${saleEventListForm.pageCount}" />
												]
											</div>
										</td>
									</tr>
								</table>
								<div class="clear"></div>

							</td>
							<td width="10" class="tbrr"></td>
						</tr>
						<tr>
							<td width="10" class="tblb"></td>
							<td class="tbbb"></td>
							<td width="10" class="tbrb"></td>
						</tr>
					</table>
				</html:form>
			</div>
		</div>
	</body>
</html>
