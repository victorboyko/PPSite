
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Currencies profitability</title>
<link rel="stylesheet" href="css/tab.css">
<meta http-equiv="refresh" content="5">
<script>
	function PlaySound(soundObj) {
		var sound = document.getElementById(soundObj);
		sound.Play();
	}
</script>
</head>
<body>
<h1>Currencies profitability</h1>


<c:if test="${not empty message}">       
	    <font color="red"><c:out value="${message}"/></font><p>
	  <c:remove var="message" scope="session" />
</c:if>



<table class="rwd-table">
  <tr>
    <th>Coin</th>
    <th>BTC price in NiceHash (-<c:out value="${percent}"/>%)</th>
  </tr>
<%
// 	Character current = (Character)request.getSession().getAttribute("character");
// 	Map<String, String> params = new HashMap<String, String>();
// 	params.put("characterId", current.getId().toString());
// 	request.setAttribute("keys", ApplicationModule.INJECTOR.getInstance(ApiKeyDAO.class).list(params));
%>   
  <c:forEach var="coin" items="${coins}" varStatus="loop">
  <tr>
    <td data-th="Coin"><c:out value="${coin.name}"/></td>
    <td data-th="Price">
    	<c:if test="${loop.index eq 0}">   
		    <c:if test="${not empty highBeep}">
		  		<font color="green"><b>
		  	</c:if>
		  	<c:if test="${not empty lowBeep}">
		  		<font color="red"><b>
		  	</c:if>
		</c:if>
		<c:out value="${coin.price}"/></td>
		<c:if test="${nloop.index eq 0}">  
		    <c:if test="${not empty lowBeep}">
		  		<font color="red"><b>
		  	</c:if>
		    <c:if test="${not empty highBeep}">
		  		</b></font>
		  	</c:if>	  	
	  	</c:if>
  	</td>
  </tr>
  </c:forEach>
</table>
<br/>
<p><p>
<c:if test="${not empty highBeepVal}">
	High value alert : <b><c:out value="${highBeepVal}"/></b>
</c:if>
<c:if test="${not empty highBeep}">
	<embed src="sounds/success.mp3" autostart="true" width="0" height="0" id="sound1" enablejavascript="true">
</c:if>
<c:if test="${not empty lowBeepVal}">
	Low value alert : <b><c:out value="${lowBeepVal}"/></b>
</c:if>
<p><p>
<c:if test="${not empty lowBeep}">
	<embed src="sounds/fail.wav" autostart="true" width="0" height="0" id="sound2" enablejavascript="true">
</c:if>




</body>
</html>