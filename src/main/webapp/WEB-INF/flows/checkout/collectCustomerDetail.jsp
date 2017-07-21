<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br/>
<div class="container-wrapper">
<div class="container">
<h2>Customer Details</h2>
</div>
</div>

<div class="container-wrapper">
<div class="container">
<form:form class="form-horizontal" commandName="order">

<h4>Basic Information</h4>

<div class="form-group">
<label for="customerName">Full Name</label>
<form:input path="cart.customer.customerName" id="customerName" class="form-control"/>
</div>

<div class="form-group">
<label for="email">Email</label>
<form:input path="cart.customer.email" id="email" class="form-control"/>
</div>

<div class="form-group">
<label for="phone">Phone</label>
<form:input path="cart.customer.phone" id="phone" class="form-control"/>
</div>

<br/>
<h4>Billing Information</h4>

<div class="form-group">
<label for="billingStreet">Street</label>
<form:input path="cart.customer.billingAddress.StreetName" id="billingStreet" class="form-control"/>
</div>

<div class="form-group">
<label for="billingCity">City</label>
<form:input path="cart.customer.billingAddress.City" id="billingCity" class="form-control"/>
</div>

<div class="form-group">
<label for="billingState">State</label>
<form:input path="cart.customer.billingAddress.State" id="billingState" class="form-control"/>
</div>

<div class="form-group">
<label for="billingCountry">Country</label>
<form:input path="cart.customer.billingAddress.Country" id="billingCountry" class="form-control"/>
</div>

<input type="hidden" name="_flowExecutionKey"/>

<input type=submit value ="Next" class="btn btn-default" name="_eventId_customerInfoCollected"/>
<button name="_eventId_cancel" class="btn btn-default">Cancel</button>

</form:form>
</div>
</div>

