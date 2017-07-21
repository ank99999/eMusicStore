<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br/>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h3>Update Product</h3>
<p class="lead">Please update the information as follows</p>
</div>
</div>
</div>


<div class="container-wrapper">
<div class="container">
<form:form action="${pageContext.request.contextPath}/admin/product/updateProduct" method="post" modelAttribute="product" enctype="multipart/form-data">
<div class="form-group">
<form:hidden path="productID" value="${product.productID}"/>
</div>
<div class="form-group">
<label for="name">Name</label><form:errors path="productName" style="color:red;"></form:errors>
<form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
</div>

<div class="form-group">
<label for="category">Category</label>
<label class="checkbox-inline"><form:radiobutton value="Instrument" path="productCategory"  id="category" class="form-control,form-check-input"/> Instrument</label>
<label class="checkbox-inline"><form:radiobutton value="Record" path="productCategory"  id="category" class="form-control,form-check-input"/> Record</label>
<label class="checkbox-inline"><form:radiobutton value="Accessory" path="productCategory"  id="category" class="form-control,form-check-input"/> Accessory</label>
</div>


<div class="form-group">
<label for="conditions">Condition</label>
<label class="checkbox-inline"><form:radiobutton value="new" path="productCondition"  id="conditions" class="form-control,form-check-input"/> New</label>
<label class="checkbox-inline"><form:radiobutton value="good" path="productCondition"  id="conditions" class="form-control,form-check-input"/> Good</label>
<label class="checkbox-inline"><form:radiobutton value="used" path="productCondition"  id="conditions" class="form-control,form-check-input"/> Used</label>
</div>


<div class="form-group">
<label for="description">Description</label>
<form:textarea path="productDescription" id="description" class="form-control" value="${product.productDescription}"/>
</div>

<div class="form-group">
<label for="price">Price</label><form:errors path="ProductPrice" style="color:red;"></form:errors>
<form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}"/>
</div>

<div class="form-group"><form:errors path="UnitsInStock" style="color:red;"></form:errors>
<label for="unitsInstock">Units In Stock</label>
<form:input path="UnitsInStock" id="unitsInstock" class="form-control" value="${product.unitsInStock}"/>
</div>

<div class="form-group">
<label for="productimage">Upload Image</label>
<form:input path="ProductImage" id="productimage" type="file" class="form:input-large"/>
</div>

<br>

<input type="submit" class="btn btn-primary" value="Update"/>

</form:form>



</div>
</div>


<%@include file="/WEB-INF/views/templates/footer.jsp" %>  