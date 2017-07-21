package com.musicstore.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.Customer;
import com.musicstore.model.Product;
import com.musicstore.service.customerService;
import com.musicstore.service.productService;
import com.musicstore.service.cartItemService;
import com.musicstore.service.cartService;

@Controller
@RequestMapping("/rest/customer/cart")
public class CartResources {
	@Autowired
	private customerService customerservice;
	
	@Autowired
	private productService productService;
	
	@Autowired
	private cartItemService cartItemService;
	
	@Autowired
	private cartService cartService;
	
	@RequestMapping(value = "/{cartId}" , method=RequestMethod.GET)
	public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") Long cartId){
		Cart cart = cartService.getCartById(cartId);
//		System.out.println("-----------------------------------------------");
//	    for(CartItem cartItem :cart.getListCartItems()){
//	    	System.out.println(cartItem.toString());
//	    }
//	    List<CartItem> cartItems = cart.getListCartItems();
	    return cart;
		
	}
	
	@RequestMapping(value = "/add/{productID}" , method=RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCartItem(@PathVariable(value = "productID") Long productID, @AuthenticationPrincipal User activeuser){
		Customer customer = customerservice.getCustomerByUserName(activeuser.getUsername());
		Product product = productService.getproductById(productID);
		Cart cart = customer.getCart();
    	List<CartItem> listCartItems = cart.getListCartItems();	
		
		for(int i = 0 ; i < listCartItems.size(); i++){
			if(listCartItems.get(i).getProduct().getProductID()== productID){
				CartItem cartItem = listCartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(cartItem.getQuantity()*product.getProductPrice());
				//cartService.addCart(cart);
				cartItemService.addCartItem(cartItem);
				return;
			}
			
		}
		
	
	 
				CartItem Item = new CartItem();
				Item.setQuantity(1);
				Item.setTotalPrice(product.getProductPrice());
				Item.setProduct(product);
				Item.setCart(cart);
				//cart.getListCartItems().add(Item);
				//cartService.addCart(cart);
				cartItemService.addCartItem(Item);
				
				
				
		}
	
	@RequestMapping(value = "/remove/{productID}/{cartId}", method=RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable("productID")Long productID , @PathVariable("cartId")Long cartId){
		CartItem cartItem = cartItemService.getCartItemByProductId(productID , cartId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping("/{cartId}")
	public void clearCart(@PathVariable Long cartId){
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
		
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Illegal request, please verify your payload")
	public void handleClientErrors(Exception e){}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal server error")
	public void handleServerErrors(Exception e){}
		
	}


