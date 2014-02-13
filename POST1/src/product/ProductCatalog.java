/**
 * author: Ye Cheng
 */
package product;

import java.io.IOException;
import java.util.HashMap;

public class ProductCatalog {
	private ProductReader productReader;
	private HashMap<Integer, ProductSpec> productCatalog;
	
	public ProductCatalog(String productFile) throws IOException{
		productReader = new ProductReader(productFile);
		productCatalog = new HashMap<Integer, ProductSpec>();
	}
	
	public HashMap<Integer, ProductSpec> makeCatalog(){
        while (productReader.hasMoreProduct()) {
        	//System.out.println(productReader.getNextProduce().getUpc());
        	productCatalog.put(productReader.getNextProduce().getUpc(), productReader.getNextProduce());
        }
		return productCatalog;
	}
	
	public int getProductCatalogSize (){
		return productCatalog.size();
	}
	public void addProduct (ProductSpec productItem){
		productCatalog.put(productItem.getUpc(), productItem);
	}
	
	public ProductSpec getProduct(int upc){
		return productCatalog.get(upc);
	}
	public void sortProduct (){
		
	}
	public void printCatalog(){
		
	}
	/*public static void main (String[] args) throws IOException{
		ProductCatalog p = null;
		p = new ProductCatalog("products.txt");
		p.makeCatalog();		
		System.out.println(p.getProduct(1000).getDescription());
				
	}*/
}
