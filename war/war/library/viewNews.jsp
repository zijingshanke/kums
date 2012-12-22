<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<html>
	<head>
		<title>main</title>
		<link href="../_css/reset.css" rel="stylesheet" type="text/css" />
		<link href="../_css/global.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
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
							<c:import url="../page/mainTitle.jsp?title1=新闻发布&title2=查看新闻"
								charEncoding="UTF-8" />
							<hr>
							<html:form action="/information/newsList.do">
								<table width="100%" cellpadding="0" cellspacing="0" border="0"
									class="dataList">
									<tr>
										<td>
											标题
										</td>
										<td>
											<c:out value="${news.title}"></c:out>
										</td>
									</tr>
									<tr>
										<td>
											排名
										</td>
										<td>
											<c:out value="${news.rank}"></c:out>
										</td>
									</tr>
									<tr>
										<td>
											发布人
										</td>
										<td>
											<c:out value="${news.userName}"></c:out>
											|
											<c:out value="${news.createDate}"></c:out>
										</td>
									</tr>
									<tr>
										<td>
											阅读数
										</td>
										<td>
											<c:out value="${news.readNum}"></c:out>
										</td>
									</tr>
									<tr>
									<tr>
										<td>
											内容
										</td>
										<td>
											<c:out value="${news.content}" escapeXml="false"></c:out>
										</td>
									</tr>
								</table>
								<table width="100%" style="margin-top: 5px;">
									<tr>
										<td align="center">
											<html:hidden property="selectedItems" value="${news.id}" />
											<html:hidden property="thisAction" name="news" />
											
											<input name="label" type="button" class="button1" value="返回首页"
												onclick="listNotice();">
											<input name="label" type="button" class="button1" value="新 增"
												onclick="add();">
											<input name="label" type="button" class="button1" value="返 回"
												onclick="window.history.back();">

											<input name="label" type="button" class="button1" value="修 改"
												onclick="edit();">

										</td>

									</tr>
								</table>
							</html:form>
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
	</body>
	<script type="text/javascript">
		function add(){		   
		    document.forms[0].action="<%=path%>/information/newsList.do?thisAction=add";
		    document.forms[0].submit();
		}
		
		function listNotice(){		   
		    document.forms[0].action="<%=path%>/information/newsList.do?thisAction=listNotice";
		    document.forms[0].submit();
		}
		
		function edit(){
		    document.forms[0].action="<%=path%>/information/newsList.do?thisAction=edit";
		    document.forms[0].submit();
		}
	</script>
</html>