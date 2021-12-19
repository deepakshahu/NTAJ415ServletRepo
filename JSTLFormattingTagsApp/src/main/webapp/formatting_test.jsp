<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale	value="de_DE"/>

<fmt:formatNumber var="salary" value="450000" type="currency"/>
<b>Salary :: ${salary}</b>
<br>
<fmt:formatNumber var="range" value="450.99" type="number" maxFractionDigits="2" maxIntegerDigits="10" minIntegerDigits="4"/>
<b>Range :: ${range}</b>
<br>
<fmt:formatNumber var="per" value="0.45" type="percent"/>
<b>Percent :: ${per}</b>
<br>
<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formatDate value="${dt}" var="fdate" type="both" dateStyle="full"/>
<b>Date and Time :: ${fdate}</b>
<br>
<fmt:setBundle basename="com/nit/commons/App"/>
<fmt:message var="message" key="welcome.msg"/>
<b>Message is :: ${message}</b>