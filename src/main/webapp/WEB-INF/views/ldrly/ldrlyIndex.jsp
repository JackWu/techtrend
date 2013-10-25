<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="" scope="request"/>
<jsp:include page="../includes/header.jsp"/>

LDRLY Development take home
<ul>
<li><a href="/techtrend/ldrly/sendState">sendState</a></li>
<li><a href="/techtrend/ldrly/getState">getState</a></li>
<li><a href="/techtrend/ldrly/getLeaderBoard">getLeaderBoard</a></li>
</ul>

<jsp:include page="../includes/footer.jsp"/>