<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<br/>
<div class="container-wrapper">
<div class="container">
<section>
<div class="jumbotron">
<div class="container">
<h1>Cart</h1>
<p>All the selected products in your cart</p>
</div>
</div>
</section>

<section>
<div class="container" data-ng-controller="cartCtrl" data-ng-app="cartApp">
<div data-ng-init="initCart('${cartId}')">
<div>
<a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyhicon glyhicon-remove-sign"></span>Clear Cart</a>
<a href = "<spring:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Checkout</a>
</div>

<table  class="table table-hover">
<tr>
<th>Product</th>
<th>Unit Price</th>
<th>Quantity</th>
<th>Price</th>
<th>Action</th>
</tr>
<tbody>
<tr ng-repeat="item in cart.listCartItems">
<td>{{item.product.productName}}</td>
<td>{{item.product.productPrice}}</td>
<td>{{item.quantity}}</td>
<td>{{item.totalPrice}}</td>
<td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productID,cart.cartId)">
<span class="glyphicon glyphicon-remove"></span>remove</a></td>
</tr>

<tr>
<th></th>
<th></th>
<th>Grand Total</th>
<th>{{calGrandTotal()}}</th>
<th></th> 
</tr> 
</tbody>
</table>

<a class="btn btn-warning" href="<c:url value='/product/productList/All'/>">Continue Shopping</a>
</div>
</div>
</section>
</div>
</div>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>