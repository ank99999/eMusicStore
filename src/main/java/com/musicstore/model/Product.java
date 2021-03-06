package com.musicstore.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "product", schema = "heroku_2a9214216160cb1" )
public class Product implements Serializable{
  
	private static final long serialVersionUID = 1952045726114159867L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "productID")
	private long productID;
    
	@NotEmpty (message="The Product Name must not be empty")
	@Column(name = "productName")
	private String productName;
    
	@Column(name = "productCategory")
	private String productCategory;
    
	@Column(name = "productDescription")
	private String productDescription;
    
    @Min(value=0,message="Price must not be less than zero")
    @Column(name = "productPrice")
	private double productPrice;
    
    @Min(value=0,message="Product unit must not be less than zero")
    @Column(name = "UnitsInStock")
	private int UnitsInStock;
    
    @Column(name = "productCondition")
	private String productCondition;
    
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> listCartItems;
    
    @Transient
    private MultipartFile ProductImage;
  
	public long getProductID() {
		return productID;
	}
	
	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getUnitsInStock() {
		return UnitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		UnitsInStock = unitsInStock;
	}
	
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public List<CartItem> getListCartItems() {
		return listCartItems;
	}
	public void setListCartItems(List<CartItem> listCartItems) {
		this.listCartItems = listCartItems;
	}
	public MultipartFile getProductImage() {
		return ProductImage;
	}
	public void setProductImage(MultipartFile productImage) {
		ProductImage = productImage;
	}
}
