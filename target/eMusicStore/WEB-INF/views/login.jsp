<%@include file="/WEB-INF/views/templates/header.jsp" %>
   <div class="container-wrapper">
    <div class="container">
     <div id="login">
     <br/><br/>
     <h3>Login with Username and Password</h3>
     
     <c:if test="${not empty msg}">
     <div id="msg">${msg}</div>
     </c:if>
     
      <form name="loginform" action="<c:url value="/j_spring_security_check"/>" method="post">
        <div class="form-group">
        <c:if test="${not empty error}">
        <div id="error" style="color:red;">${error}</div>
        </c:if>
           <label for="username">Username: </label>
           <input type="text" id="username" name="username" class="form-control"/>
        </div>
        <div class="form-group">
           <label for="password">Password: </label>
           <input type="text" id="password" name="password" class="form-control"/>
        </div>
           <input type="submit" value="Submit" class="btn btn-default"/>
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     </form>
    </div>
   </div>
   </div>


<%@include file="/WEB-INF/views/templates/footer.jsp" %>