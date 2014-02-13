/**
 * author: Ye Cheng
 */
package transaction;

import java.util.ArrayList;

import payment.Payment;

public class Transaction {
	private TransactionHeader header;
	private ArrayList<TransactionItem> transItems;
	private Payment payment;
	
	public Transaction (TransactionHeader header){
		this.transItems = new ArrayList<TransactionItem> ();
	}
	public Transaction (TransactionHeader header,ArrayList<TransactionItem> transItems,Payment payment){
		this.header = header;
		this.transItems = transItems;
		this.payment = payment;
	}
	public void setHeader (TransactionHeader header){
		this.header = header;
	}
	public String getCustomerName(){
		return this.header.getName();
	}
	public void addItem(TransactionItem transItem){
		this.transItems.add(transItem);
	}
	public void addPayment(Payment payment){
		this.payment = payment;
	}
	public int getNumTrans(){
		return this.transItems.size();
	}
	public TransactionItem getItem(int i){
		return this.transItems.get(i);
	}
	public Payment getPayment(){
		return this.payment;
	}
}
