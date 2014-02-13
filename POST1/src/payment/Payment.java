/**
 * author: Ye Cheng
 */
package payment;

public abstract class Payment {
	double amountDue;
	abstract void makePayment(double amountPaid);
	double amountPaid;
	
	public Payment (double amountPaid){
		this.amountPaid = amountPaid;
	}

}
