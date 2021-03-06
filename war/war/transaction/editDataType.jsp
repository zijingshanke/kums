﻿<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>

<%
	String path = request.getContextPath();
%>
<html>
	<head>
		<title>main</title>
		<link href="../_css/reset.css" rel="stylesheet" type="text/css" />
		<link href="../_css/global.css" rel="stylesheet" type="text/css" />
		<script src="../_js/calendar/WdatePicker.js" type="text/javascript"></script>
		<script src="../_js/base/FormUtil.js" type="text/javascript"></script>
	</head>
	<script type="text/javascript">	
		function add()		{	
			var thisAction =document.forms[0].thisAction.value;			   
		    document.forms[0].action="<%=path%>/transaction/dataType.do?thisAction="+thisAction;
		    document.forms[0].submit();
		}		
	</script>
	<body>
		<c:import url="../page/mainTitle.jsp" charEncoding="UTF-8">
			<c:param name="title1" value="系统管理" />
			<c:param name="title2" value="编辑交易类型" />
		</c:import>
		<html:form action="/transaction/dataType.do" method="post">
			<div id="mainContainer">
				<div id="container">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td width="10" height="10" class="tblt"></td>
							<td height="10" class="tbtt"></td>
							<td width="10" height="10" class="tbrt"></td>
						</tr>
						<tr>
							<td width="10" class="tbll"></td>
							<td valign="top" class="body">

								<hr>
								<table width="100%" cellpadding="0" cellspacing="0" border="0"
									class="dataList">
									<html:hidden property="id" value="${dataType.id}"></html:hidden>
									<c:if test="${!empty dataTypeList}">
										<tr>
											<td class="lef">
												上级
											</td>
											<td style="text-align: left">
												<html:select property="superNo" value="${dataType.superNo}"
													name="dataType" styleClass="colorblue2 p_5"
													style="width:200px;">
													<html:option value="0">一级</html:option>
													<c:forEach items="${dataTypeList}" var="data">
														<html:option value="${data.no}">
															<c:out value="${data.name}" />
														</html:option>
													</c:forEach>
												</html:select>
											</td>
										</tr>
									</c:if>
									<tr>
										<td class="lef">
											代码
										</td>
										<td style="text-align: left">
											<html:text property="no" name="dataType"
												value="${dataType.no}" styleClass="colorblue2 p_5"
												style="width:200px;"></html:text>
										</td>
									</tr>
									<tr>
										<td class="lef">
											名称
										</td>
										<td style="text-align: left">
											<html:text property="name" name="dataType"
												value="${dataType.name}" styleClass="colorblue2 p_5"
												style="width:200px;"></html:text>
										</td>
									</tr>
									<tr>
										<td class="lef">
											说明
										</td>
										<td style="text-align: left">
											<html:text property="memo" name="dataType"
												value="${dataType.memo}" styleClass="colorblue2 p_5"
												style="width:200px;"></html:text>
										</td>
									</tr>
									<tr>
										<td class="lef">
											状态
										</td>
										<td style="text-align: left">

											<html:select property="status" name="dataType"
												styleClass="colorblue2 p_5" style="width:50px;">
												<html:option value="1">有效</html:option>
												<html:option value="0">无效</html:option>
											</html:select>
										</td>
									</tr>
								</table>
								<table width="100%" style="margin-top: 5px;">
									<tr>
										<td>
											<html:hidden property="thisAction" name="dataType" />
											<input name="label" type="button" class="button1" value="返 回"
												onclick="window.history.back();">
											<input name="label" type="button" class="button1" value="提交"
												onclick="add();">
											<input name="label" type="reset" class="button1" value="重 置">
											
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
				</div>
			</div>
		</html:form>
	</body>
</html>