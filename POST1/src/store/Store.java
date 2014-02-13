/**
 * author: Ye Cheng
 */
package store;
import java.io.IOException;
import java.util.ArrayList;

import product.ProductCatalog;
import transaction.Transaction;
import transaction.TransactionItem;
import transaction.TransactionReader;

public class Store {
	private String storeName;
	private String transactionFile;
	private String productFile;
	private ProductCatalog productCatalog;
	private TransactionReader transactionReader;
	private ArrayList<Transaction> transactions;
	
	public Store(String storeName,String transactionFile,String productFile){
		this.storeName = storeName;
		this.transactionFile = transactionFile;
		this.productFile = productFile;
	}
	public void getProductCatalog () throws IOException{
		//make product catalog
		productCatalog = new ProductCatalog(productFile);
		productCatalog.makeCatalog();
	}
	public void getTransaction() throws IOException{
		transactionReader = new TransactionReader(transactionFile);
		this.transactions = transactionReader.getNextTransaction();
	}
	public void printInvoice() throws IOException{
		System.out.println("STORE NAME" +"	"+storeName);
		getProductCatalog ();
		getTransaction();
		for (int i = 0; i< transactions.size();i++){
			System.out.println("CUSTOMER NAME"+ "	"+ transactions.get(i).getCustomerName());
			for (int j = 0; j<transactions.get(i).getNumTrans();j++){
				System.out.print("Item:	");
				TransactionItem transItem = transactions.get(i).getItem(j);
				int productUpc = transItem.getUpc();
				int productQuantity = transItem.getNumItem();
				double unitPrice = this.productCatalog.getProduct(productUpc).getPrice();
				String productText = this.productCatalog.getProduct(productUpc).getDescription();
				System.out.print(productText + "	");
				System.out.print(productQuantity + "	");
				System.out.print("@ ");
				System.out.printf("%1$.2f", unitPrice);
				System.out.print("	");
				System.out.printf("%1$.2f", productQuantity*unitPrice);
				System.out.println("");
				System.out.print("transaction end");
			}
		}
	}
	public static void main (String args[]) throws IOException{
		Store s = new Store("Ye","transaction.txt","products.txt");
		s.printInvoice();
	}
}
