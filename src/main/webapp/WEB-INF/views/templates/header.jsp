<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html data-ng-App="cartApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!--  <link rel="shortcut icon" href="#"> -->

    <title></title>
    
    <!-- Angular JS-->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    
    <!-- Controller JS -->
    <script type="text/javaScript" src="<c:url value="/resources/js/controller.js"/>"></script>
    
    <!-- Jquery -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    
    <!-- Data table plugin -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    
    <!-- Carousel CSS -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
    
    <!-- Style CSS -->
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    
    <link href="<c:url value="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">
   <nav class="navbar navbar-light navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#" style="color:#423b31 ; font-size:24px">AP's Music Store</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a class="nav-link" href="<c:url value="/" />" style="color:#423b31; font-size:18px">Home</a></li>
                <li><a class="nav-link" href="<c:url value="/product/productList/All" />" style="color:#423b31; font-size:18px">Products</a></li>
                <li><a class="nav-link" href="<c:url value="/about" />" style="color:#423b31 ;font-size:18px">About US</a></li>
              </ul>
              <ul class="nav navbar-nav pull-right">
                 <c:if test="${pageContext.request.userPrincipal.name!= null}">
                    <li><a style="color:#423b31;font-size:18px">Welcome ${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout"/>" style="color:#423b31 ; font-size:18px">Logout</a></li>
                 </c:if>
                 <c:if test="${pageContext.request.userPrincipal.name != 'admin' && pageContext.request.userPrincipal.name != null}">
                    <li><a href="<c:url value="/customer/cart" />" style="color:#423b31 ; font-size:18px">Cart</a></li>
                 </c:if>
                 <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                   <li><a href="<c:url value="/admin/productInventory"/>" style="color:#423b31 ; font-size:18px">Inventory</a></li>
                 </c:if>
                 <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a href="<c:url value="/login" />" style="color:#423b31 ; font-size:18px">Login</a></li>
                    <li><a href="<c:url value="/register" />" style="color:#423b31 ; font-size:18px">Register</a></li>
                 </c:if>
                 
                 
               </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>
    
      <br/><br/>  