﻿<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/tld/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>

<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="<%=path%>/_css/reset.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/_css/global.css" rel="stylesheet" type="text/css" />
		<script src="<%=path%>/_js/prototype/common.js" type="text/javascript"></script>
		<script src="<%=path%>/_js/base/FormUtil.js" type="text/javascript"></script>
		<script type="text/javascript">
		function updateOrderStatement(){
			if(setSubmitButtonDisable("submitUpdateOrderStatement")){
				document.forms[0].thisAction="updateOrderStatement";
		    	document.forms[0].submit();
		    }
		}
		
		function updateOrderOldStatement(){
			if(setSubmitButtonDisable("submitUpdateOrderOldStatement")){
				 document.forms[0].thisAction="updateOrderOldStatement";
		    	 document.forms[0].submit();
		    }
		}
		</script>
	</head>
	<body>
		<div id="mainContainer">
			<div id="container">
				<html:form action="/finance/statementList.do" method="post">
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
									<c:param name="title1" value="结算管理" />
									<c:param name="title2" value="结算数据管理" />
								</c:import>

								<div class="searchBar">
									<table cellpadding="0" cellspacing="0" border="0"
										class="searchPanel">
										<tr>
											<td>

											</td>
											<td>
											</td>

										</tr>
									</table>
								</div>
								<table width="100%" cellpadding="0" cellspacing="0" border="0"
									class="dataList">
									<tr>
										<td class="lef">
											更新订单表结算金额
										</td>
										<td>
											<input type="button" type="button" class="button1" value="执行"
												onclick="updateOrderStatement();"
												id="submitUpdateOrderStatement"></input>
										</td>
									</tr>
									<tr>
										<td class="lef">
											更新退废改订单出票金额
										</td>
										<td>
											<input type="button" class="button1" value="执行"
												onclick="updateOrderOldStatement();"
												id="submitUpdateOrderOldStatement"></input>
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
