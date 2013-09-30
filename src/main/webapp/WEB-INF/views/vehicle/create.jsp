<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Welcome to myCalendar!" scope="request"/>
<jsp:include page="../includes/header.jsp"/>
<form:form action="./new" method="post" modelAttribute="createVehicleForm" cssClass="form-horizontal">
    <form:errors path="*" element="div" cssClass="alert alert-error"/>
    <fieldset>
        <legend>Vehicle Information</legend>

        <div class="control-group">
            <label class="control-label" for="color">Color</label>
            <div class="controls">
                <form:input class="input-xlarge" path="color" id="color"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="summary">Wheel</label>
            <div class="controls">
                <form:input class="input-xlarge" path="wheel" id="wheel"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="seat">Seat</label>
            <div class="controls">
                <form:input class="input-xlarge" path="seat" id="seat"/>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input id="submit" type="submit" value="Create"/>
            </div>
        </div>
    </fieldset>
</form:form>
<jsp:include page="../includes/footer.jsp"/>