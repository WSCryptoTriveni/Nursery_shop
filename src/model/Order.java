package model;

public class Order {
	private int orderId;
	private int productId;
	private String product_name;
	private int product_price;
	private int cust_id;
	private String cust_name;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	
	public Order(int orderId,int productId, String product_name, int product_price, int cust_id, String cust_name
			) {
		super();
		this.productId = productId;
		this.product_name = product_name;
		this.product_price = product_price;
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", cust_id=" + cust_id + ", cust_name=" + cust_name
				+ "]";
	}
	
	
	

	

}
