var cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl",function($scope,$http){
	
	window.$scope = $scope;
	
	//var cart = [];
	
	$scope.addTocart = function(productID){
		$http.put("/eMusicStore/rest/customer/cart/add/"+productID).success(function(){
		      alert("product Successfully added to the cart");
		});
		
	};
	
	$scope.initCart = function(cartId){
		   alert("Inside Init function");
		     $scope.cartId = cartId;
			 $scope.refreshCart();
	};
	
	$scope.refreshCart = function(){
		$http.get("/eMusicStore/rest/customer/cart/"+$scope.cartId).success(function(data){		
//			alert("Inside refresh function");
//			for(var i = 0 ; i< data.length; i++){
//    		   cart.push(data[i]);
//			}
			$scope.cart = data;
			console.log("cartItem =" +JSON.stringify($scope.cart));	
			
		});
		};	
	
	
	$scope.clearCart = function(){
		$http['delete']("/eMusicStore/rest/customer/cart/"+$scope.cartId).success($scope.refreshCart());
	};
	

	
	$scope.removeFromCart = function(productId,cartId){
		$http.put("/eMusicStore/rest/customer/cart/remove/"+productId+"/"+cartId).success(function(){
			$scope.refreshCart();  
			alert("Item removed from cart");
		});
	};
	
	$scope.calGrandTotal = function(){
		
		var grandTotal = 0;
		
		for(var i = 0 ; i < $scope.cart.listCartItems.length ; i++){
			grandTotal+=$scope.cart.listCartItems[i].totalPrice;
		}
		alert("grand total is "+ grandTotal);
		return grandTotal;
	};
	
	
	
});


