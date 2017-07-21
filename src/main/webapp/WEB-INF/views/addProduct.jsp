<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h3>Add Product</h3>
<p class="lead">Fill in the following info to add a product</p>
</div>
</div>
</div>


<div class="container-wrapper">
<div class="container">
<form:form action="${pageContext.request.contextPath}/admin/product/addProduct" method="post" commandName="product" enctype="multipart/form-data">

<div class="form-group">
<label for="name">Name</label><form:errors path="ProductName" style="color:red;"></form:errors>
<form:input path="ProductName" id="name" class="form-control"/>
</div>

<div class="form-group">
<label for="category">Category</label>
<label class="checkbox-inline"><form:radiobutton value="Instrument" path="ProductCategory"  id="category" class="form-control,form-check-input"/> Instrument</label>
<label class="checkbox-inline"><form:radiobutton value="Record" path="ProductCategory"  id="category" class="form-control,form-check-input"/> Record</label>
<label class="checkbox-inline"><form:radiobutton value="Accessory" path="ProductCategory"  id="category" class="form-control,form-check-input"/> Accessory</label>
</div>


<div class="form-group">
<label for="conditions">Condition</label>
<label class="checkbox-inline"><form:radiobutton value="new" path="productCondition"  id="conditions" class="form-control,form-check-input"/> New</label>
<label class="checkbox-inline"><form:radiobutton value="good" path="productCondition"  id="conditions" class="form-control,form-check-input"/> Good</label>
<label class="checkbox-inline"><form:radiobutton value="used" path="productCondition"  id="conditions" class="form-control,form-check-input"/> Used</label>
</div>


<div class="form-group">
<label for="description">Description</label>
<form:textarea path="productDescription" id="description" class="form-control"/>
</div>

<div class="form-group">
<label for="price">Price</label><form:errors path="productPrice" style="color:red;"></form:errors>
<form:input path="productPrice" id="price" class="form-control"/>
</div>

<div class="form-group">
<label for="unitsInstock">Units In Stock</label><form:errors path="UnitsInStock" style="color:red;"></form:errors>
<form:input path="UnitsInStock" id="unitsInstock" class="form-control"/>
</div>

<div class="form-group">
<label for="productimage">Upload Image</label>
<form:input path="ProductImage" id="productimage" type="file" class="form:input-large"/>
</div>

<br>

<input type="submit" class="btn btn-primary" value="submit"/>

</form:form>



</div>
</div>


<%@include file="/WEB-INF/views/templates/footer.jsp" %>  