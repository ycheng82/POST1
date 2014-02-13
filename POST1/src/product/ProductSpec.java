/**
 * author: Ye Cheng
 */
package product;

public class ProductSpec {
	private Integer upc;	
	private String description;	
	private double price;

	public ProductSpec(String[] productInfor) {
		// TODO Auto-generated constructor stub
		//System.out.println("get infor");
		this.upc = Integer.valueOf(productInfor[0]);
		this.description = productInfor[1];
		this.price = Float.valueOf(productInfor[2]);
	}

	public Integer getUpc() {
		return this.upc;
	}

	public String getDescription() {
		return this.description;
	}
	public double getPrice(){
		return this.price;
	}

}
