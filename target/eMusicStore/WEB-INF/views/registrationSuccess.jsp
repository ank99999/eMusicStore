<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      <div class="container">
        <div class="container-wrapper">
            <div class="jumbotron">
             <h2>Customer Registered Successfully!!</h2>
            </div>
            <section>
            <a href="<c:url value="/product/productList/All" />" class="btn btn-warning">Let's Start Shopping!!</a>
            </section>
            </div>
            </div>
      
     

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>