/**
 * author: Ye Cheng
 */
package transaction;

public class TransactionItem {
	private int upc;
	private int numItem;
	
	public TransactionItem(int upc, int numItem){
		this.upc = upc;
		this.numItem = numItem;
	}
	public void setNumItem(int numItem){
		this.numItem = numItem;
	}
	public int getUpc(){
		return this.upc;
	}
	public int getNumItem(){
		return this.numItem;
	}
}
