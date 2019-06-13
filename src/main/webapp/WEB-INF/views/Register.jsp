<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{
	color: red;
}
</style>
</head>
<body>
<a href="?lang=en">English</a>
<a href="?lang=hi">Hindi</a>
<a href="?lang=te">Telugu</a>
<a href="?lang=kn">Kannada</a>


<h3><spring:message code="title"/>  </h3>
<form:form action="save" method="POST" modelAttribute="employee">
<pre>
 <spring:message code="ename"/>  : <form:input path="empName"/>
  <form:errors path="empName" cssClass="err"/>    
 <spring:message code="epwd"/> : <form:password path="empPwd"/>
  <form:errors path="empPwd" cssClass="err"/>
 <spring:message code="egen"/>   : <form:radiobutton path="empGen" value="Male"/> <spring:message code="genLabelMale"/> <form:radiobutton path="empGen" value="Female"/> <spring:message code="genLabelFemale"/>
 <form:errors path="empGen" cssClass="err"/>
 <spring:message code="eaddr"/>  : <form:textarea path="empAddr"/> 
 <form:errors path="empAddr" cssClass="err"/>
 <spring:message code="ecntry"/>  : <form:select path="empCntry">
 				<form:option value="">-SELECT-</form:option>
 				<form:option value="IND">India</form:option>
 				<form:option value="AUS">AUS</form:option>
 				<form:option value="US">US</form:option>
 			</form:select>
 <form:errors path="empCntry" cssClass="err"/> 			
 <spring:message code="elang"/>:
   <form:checkbox path="empLangs" value="ENGLISH"/> <spring:message code="langLabelEn"/> 			
   <form:checkbox path="empLangs" value="HINDI"/> <spring:message code="langLabelHi"/> 			
   <form:checkbox path="empLangs" value="TELUGU"/> <spring:message code="langLabelTe"/>
   <form:checkbox path="empLangs" value="KANNADA"/> <spring:message code="langLabelKn"/>
  <form:errors path="empLangs" cssClass="err"/>   
   
   <input type="submit" value="REGISTER"/> 			
</pre>
</form:form>
</body>
</html>





