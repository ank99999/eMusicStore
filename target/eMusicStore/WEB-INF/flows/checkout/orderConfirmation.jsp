<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h3>Order</h3>
<p class="lead">Order Details</p>
</div>
</div>
</div>
<div class="container-wrapper">
<div class="container">
<div class="row">

<form:form class="form-horizontal" commandName="order">

<div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
 <div class="text-center">
 <h1>Receipt</h1>
 </div>
 <div class="row">
    <div class="col-xs-6 col-sm-6 col-md-6">
    <address>
         <strong>Shipping Address</strong><br>
         ${order.cart.customer.shippingAddress.getStreetName()}<br>
         ${order.cart.customer.shippingAddress.getCity()},${order.cart.customer.shippingAddress.getState()}<br>
         ${order.cart.customer.shippingAddress.getCountry()}
    </address>     
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6 text-right">
      <p>Shipping Date:<fmt:formatDate value="${now}"/></p>
    </div>
 </div>
 <div class="row">
    <div class="col-xs-6 col-sm-6 col-md-6">
    <address>
         <strong>Billing Address</strong><br>
         ${order.cart.customer.billingAddress.getStreetName()}<br>
         ${order.cart.customer.billingAddress.getCity()},${order.cart.customer.billingAddress.getState()}<br>
         ${order.cart.customer.billingAddress.getCountry()}
    </address>     
    </div>
 </div>
 
  <div class="row">
    <table class="table table-hover">
    <thead>
    <tr>
    <th>Product</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Total</th>
    </tr>
    </thead> 
    <tbody>
    <c:forEach var="cartItem" items="${order.cart.getListCartItems()}">
    <tr>
    <td class="col-md-9"><em>${cartItem.product.getProductName()}</em></td>
    <td class="col-md-1"><em>${cartItem.getQuantity()}</em></td>
    <td class="col-md-1"><em>${cartItem.product.getProductPrice()}</em></td>
    <td class="col-md-1"><em>${cartItem.getTotalPrice()}</em></td>
    </tr>
    </c:forEach>
    <tr>
    <td></td>
    <td></td>
    <td class="text-right">
    <h4><strong>Grand Total</strong></h4>
    </td>
    <td class="text-center">
    <h4><strong>${order.cart.getGrandTotal()}</strong></h4>
    </td>
    </tr>
    
    </tbody>
   </table>
   </div>

 
 

<input type="hidden" name="_flowExecutionKey"/>

<button name="_eventId_backToCollectShippingDetails" class="btn btn-default">Back</button>
<input type=submit value ="Submit Order" class="btn btn-default" name="_eventId_orderConfirmed"/>
<button name="_eventId_cancel" class="btn btn-default">Cancel</button>
</div>
</form:form>
</div>
</div>
</div>