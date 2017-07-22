<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br/>
      <div class="container">
        <div class="container-wrapper">
            <div class="jumbotron">
             <h2 class="alert alert-danger">Checkout Cancelled!!</h2>
             <p>Your checkout has been cancelled.You may continue shopping.</p>
            </div>
            <section>
            <a href="<c:url value="/product/productList/All" />" class="btn btn-warning">Products</a>
            </section>
            </div>
            </div>
      
<%@include file="/WEB-INF/views/templates/footer.jsp" %>