<%@include file="/WEB-INF/views/templates/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br/>
<div class="container-wrapper">
 <div class="container">
 <div class="page-header">
<h3>Product Detail</h3>
<p class="lead">Here is the detail information of the product</p>
</div>

<div class="container" data-ng-app="cartApp"> 
<div class="row">
  <div class="col-md-6">
    <img src="<c:url value="/resources/images/${product.productID}.png"/>" alt="product image" style="width:40%; height:200px;"/>
  </div>
  <div class="col-md-6">
    <h2>${product.productName}</h2>
    <p>${product.productDescription}</p>
    <p>Category: ${product.productCategory}</p>
    <p>Condition: ${product.productCondition}</p>
    <p>Price: ${product.productPrice} $</p>
 </div>
</div>
<br/>
<c:set var="role" scope="page" value="${param.role}"/>
<c:set var="url" scope="page" value="/product/productList/All"/>
 <c:if test="${role == 'admin'}">
   <c:set var="url" scope="page" value="/admin/product/productInventory"/> 
 </c:if>
 <div data-ng-controller="cartCtrl">
 <p>
   <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
   <a href="#" class="btn btn-warning" ng-click="addTocart('${product.productID}')"><span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
   <a class="btn btn-default" href="<spring:url value="/customer/cart"/>">View cart</a>
 </p>
 </div>
</div>
</div>
</div>
<!--  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>-->
<script src ="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %> 