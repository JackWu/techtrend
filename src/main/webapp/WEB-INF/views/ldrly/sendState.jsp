<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pageTitle" value="" scope="request" />
<jsp:include page="../includes/header.jsp" />


		
<ul>
<li><a href="/techtrend/ldrly/sendState">sendState</a></li>
<li><a href="/techtrend/ldrly/getState">getState</a></li>
<li><a href="/techtrend/ldrly/getLeaderBoard">getLeaderBoard</a></li>
</ul>

	<input id="username" type=text placeholder="username"><input
		id="state" type=text placeholder="state" /><input id="value" type=text
		placeholder="value" /> <button onclick="jsonPost()">submit</button>

<script>
function jsonPost(url){
		var username = $("#username").val();
		console.log(username);
		var data = {username: username};
		console.log(data);
		var url = "http://localhost:3002/sendState/ldrly";
		$.ajax(
				   {
				    url:url
				   ,type: "post"
				   ,contentType: "application/json"
				   ,data:JSON.stringify(data)
				   ,success: function(data){
					   
	
					   
	
					   alert(data);
				   }
				   ,crossDomain: true
				   ,dataType:"json"
				    }
				  );
}
	
</script>

<jsp:include page="../includes/footer.jsp" />