package model;

public class Product {
	private int productId;
	private String product_name;
	private int product_price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String product_name, int product_price) {
		super();
		this.productId = productId;
		this.product_name = product_name;
		this.product_price = product_price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", product_name=" + product_name + ", product_price=" + product_price
				+ "]";
	}
	
	

}
