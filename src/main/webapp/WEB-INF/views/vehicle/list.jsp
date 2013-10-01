<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageTitle" value="All Events" scope="request"/>
<jsp:include page="../includes/header.jsp"/>

<p>This shows all Vehicles</p>
<c:url var="createUrl" value="/vehicle/form"/>
<div id="create" class="pull-right"><a href="${createUrl}">Create Vehicle</a></div>
<table class="table table-bordered table-striped table-condensed">
    <thead>
        <tr>
            <th>ID</th>
            <th>Color</th>
            <th>Wheel</th>
            <th>Seat</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${empty vehicles}">
            <tr>
                <td colspan="4" class="msg">No Vehicles.</td>
            </tr>
        </c:if>
         <c:forEach items="${vehicles}" var="vehicle">
            <tr>
                <td><c:out value="${vehicle.id}"/></td>
                <td><c:out value="${vehicle.color}" /></td>
                <td><c:out value="${vehicle.wheel}" /></td>
                <td><c:out value="${vehicle.seat}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jsp:include page="../includes/footer.jsp"/>