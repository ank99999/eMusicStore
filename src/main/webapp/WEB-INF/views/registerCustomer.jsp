<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h3>Customer Registration</h3>
<p class="lead">Fill in the information below for registration</p>
</div>
</div>
</div>
<div class="container-wrapper">
<div class="container">
<h4>Basic Information</h4>
<form:form  name="customerRegister" action="${pageContext.request.contextPath}/register" id="customerRegister" method="post" modelAttribute="customer">

<div class="form-group">
<label for="customerName">Full Name</label><form:errors path="customerName" cssStyle="color:#ff0000"/>
<form:input path="customerName" id="customerName" class="form-control"/>
</div>

<div class="form-group">
<label for="email">Email</label><form:errors path="email" cssStyle="color:#ff0000"/>
<form:input path="email" id="email" class="form-control"/><span style="color:#ff0000">${EmailMsg}</span>
</div>

<div class="form-group">
<label for="phone">Phone</label><form:errors path="phone" cssStyle="color:#ff0000"/>
<form:input path="phone" id="phone" class="form-control"/>
</div>

<div class="form-group">
<label for="userName">UserName</label><form:errors path="userName" cssStyle="color:#ff0000"/><span style="color:#ff0000">${userNameMsg}</span>
<form:input path="userName" id="userName" class="form-control"/>
</div>

<div class="form-group">
<label for="password">Password</label><form:errors path="passw" cssStyle="color:#ff0000"/>
<form:input path="passw" id="passw" class="form-control"/>
</div>

<br/>
<h4>Billing Information</h4>

<div class="form-group">
<label for="billingStreet">Street</label>
<form:input path="billingAddress.StreetName" id="billingStreet" class="form-control"/>
</div>

<div class="form-group">
<label for="billingCity">City</label>
<form:input path="billingAddress.City" id="billingCity" class="form-control"/>
</div>

<div class="form-group">
<label for="billingState">State</label>
<form:input path="billingAddress.State" id="billingState" class="form-control"/>
</div>

<div class="form-group">
<label for="billingCountry">Country</label>
<form:input path="billingAddress.Country" id="billingCountry" class="form-control"/>
</div>

<br/>
<h4>Shipping Information</h4>

<div class="form-group">
<label for="shippingStreet">Street</label>
<form:input path="shippingAddress.StreetName" id="shippingStreet" class="form-control"/>
</div>

<div class="form-group">
<label for="shippingCity">City</label>
<form:input path="shippingAddress.City" id="shippingCity" class="form-control"/>
</div>

<div class="form-group">
<label for="shippingState">State</label>
<form:input path="shippingAddress.State" id="shippingState" class="form-control"/>
</div>

<div class="form-group">
<label for="shippingCountry">Country</label>
<form:input path="shippingAddress.Country" id="shippingCountry" class="form-control"/>
</div>

<input type=submit value ="submit" class="btn btn-default" />
<a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>


</form:form>
</div>
</div>