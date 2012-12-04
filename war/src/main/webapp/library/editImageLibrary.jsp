<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<html>
<head>
<TITLE>上传附件</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../_css/css.css" rel="stylesheet" type="text/css">
<script src="../_js/prototype.js" type="text/javascript"></script>
<script src="../_js/prototype/common.js" type="text/javascript"></script>
<script type="text/javascript" src="../_js/jquery-1.3.2.min.js"></script>

<script>
 function submitForm() {
    if (valid()){
      document.forms[0].thisAction.value="add";
  	  document.forms[0].submit();	
  	}
 }
 
 function valid() {
   if(document.forms[0].uploadFile.value==""){
     alert("附件名不能为空！");
     document.forms[0].uploadFile.focus();
     return false;
   }else{
     return true; 
   }
}
</script>
</head>

<body class="body_m">
	<html:form method="post" action="/library/imageLibrary.do"
		enctype="multipart/form-data">
		<html:hidden property="thisAction" value="editImageLibrary" />
		<table width="100%" cellspacing="1" class="table_li">
			<tr>
				<td class="fbg">添加附件</td>
				<td colspan="3" class="fbg2"><html:file property="uploadFile"
						styleClass="colorblue2 p_5" size="40" /> <input type="button"
					class="button1" value="上 传" onclick="submitForm();"> <input
					name="label" type="button" class="button1" value="完 成"
					onclick="finish();"></td>
			</tr>
		</table>


		<table width="100%" style="margin-top: 5px;">
			<tr style="display: none">
				<td><input type="button" class="button1" value="返 回"
					onclick="window.history.back();"> <input name="label"
					type="button" class="button1" value="完 成" onclick="finish();">
			</tr>
		</table>
	</html:form>

</body>
</html>
