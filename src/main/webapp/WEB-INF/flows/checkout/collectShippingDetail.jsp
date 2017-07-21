<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h2>Customer Details</h2>
</div>
</div>
</div>
<div class="container-wrapper">
<div class="container">

<form:form class="form-horizontal" commandName="order">

<h4>Shipping Information</h4>

<div class="form-group">
<label for="shippingStreet">Street</label>
<form:input path="cart.customer.shippingAddress.StreetName" id="shippingStreet" class="form-control"/>
</div>

<div class="form-group">
<label for="shippingCity">City</label>
<form:input path="cart.customer.shippingAddress.City" id="shippingCity" class="form-control"/>
</div>

<div class="form-group">
<label for="shippingState">State</label>
<form:input path="cart.customer.shippingAddress.State" id="shippingState" class="form-control"/>
</div>

<div class="form-group">
<label for="shippingCountry">Country</label>
<form:input path="cart.customer.shippingAddress.Country" id="shippingCountry" class="form-control"/>
</div>

<input type="hidden" name="_flowExecutionKey"/>

<button name="_eventId_backToCollectCustomerInfo" class="btn btn-default">Back</button>
<input type=submit value ="Next" class="btn btn-default" name="_eventId_shippingDetailCollected"/>
<button name="_eventId_cancel" class="btn btn-default">Cancel</button>

</form:form>
</div>
</div>