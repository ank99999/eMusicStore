<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br/>

<script>
$(document).ready(function(){
	$('.table').DataTable({
		'lengthMenu' : [[1,2,5,10,-1],[1,2,5,10,"All"]]
	});
});

</script>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h3>Product Inventory</h3>
<p class="lead">Check our Product Inventory</p>
</div>
</div>
</div>

<div class="container-wrapper">
<div class="container">
 <table class="table table-striped table table-bordered table table-hover">
 <thead>
      <tr>
      <th>Photo</th>
      <th>Name</th>
      <th>Category</th>
      <th>Condition</th>
      <th>Price</th>
      <th></th>
      </tr>
  </thead>
  <tbody>
     <c:forEach items="${listOfProducts}" var="product">
      <tr>
      <td><img src="<c:url value="/resources/images/${product.productID}.png"/>" style="width:100%;height:150px"/></td>
      <td>${product.productName}</td>
      <td>${product.productCategory}</td>
      <td>${product.productCondition}</td>
      <td>${product.productPrice}$</td>
      <td><a href="<spring:url value="/product/viewProduct/${product.productID}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
      <a href="<spring:url value="/admin/product/deleteProduct/${product.productID}" />"><span class="glyphicon glyphicon-remove"></span></a>
      <a href="<spring:url value="/admin/product/updateProduct/${product.productID}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
      </td>
      </tr>
      </c:forEach>
   </tbody>
      </table>
      
 <a href="<c:url value="/admin/product/addProduct"/>" class="btn btn-primary">Add Product</a>
 </div>
 </div>
 
 <%@include file="/WEB-INF/views/templates/footer.jsp" %>  
 

