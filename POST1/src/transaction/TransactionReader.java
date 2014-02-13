/**
 * author: Ye Cheng
 */
package transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;

import payment.CashPayment;
import payment.CheckPayment;
import payment.CreditPayment;
import payment.Payment;

public class TransactionReader {
	private BufferedReader source;
	private String nextLine;
	private ArrayList<Transaction> transactions;
	
	public TransactionReader( String transactionFile)throws IOException{
    	//System.out.println("Transaction file: "+ transactionFile);
    	//System.out.println("user.dir: " + System.getProperty("user.dir"));
        source = new BufferedReader(new FileReader(transactionFile));
        this.transactions = new ArrayList<Transaction>();
	}
    void close() {
        try {
            source.close();
        } catch (Exception e) {}
    }
	boolean hasMoreTransaction(){
		try{
			nextLine = source.readLine();	
				//System.out.println(nextLine!=null);
				//System.out.println(nextLine.length()== 0);
			//System.out.println(nextLine);
		}
	    catch (IOException e) {
		    System.err.println("Error: " + e);
		}
		return nextLine!=null;
	}
	
	public ArrayList<Transaction> getNextTransaction() throws IOException{
		while (hasMoreTransaction()) {
			while(nextLine.length()== 0){
				nextLine = source.readLine();
			}
			StringTokenizer st = new StringTokenizer(nextLine,"	",false);
			
			String nextToken = st.nextToken();
			
			//add transaction header
			Date d = new Date(System.currentTimeMillis());
			TransactionHeader header = new TransactionHeader(nextToken,d);
			Transaction transaction = new Transaction(header);
			transaction.setHeader(header);
			nextLine = source.readLine();
			//System.out.println(nextLine);
			
			//add transaction items
			while (!nextLine.startsWith("<")){
				st = new StringTokenizer(nextLine,"	",false);
				TransactionItem transItem = new TransactionItem(Integer.parseInt(st.nextToken()),1);
				if (st.hasMoreTokens()){
					transItem.setNumItem(Integer.parseInt(st.nextToken()));
				}
				transaction.addItem(transItem);
				nextLine = source.readLine();
				//System.out.println(nextLine);
			}
			
			//add payment
			st = new StringTokenizer(nextLine,"<>$	",false);
			String paymentMethod = st.nextToken();
			Payment payment= null;
			switch (paymentMethod){
			case "CASH":
				payment = new CashPayment(Double.parseDouble(st.nextToken()));
				break;
			case "CHECK":
				payment = new CheckPayment(Double.parseDouble(st.nextToken()));
				break;
			case "Credit":
				payment = new CreditPayment(Double.parseDouble(st.nextToken()));
				break;
			}
			transaction.addPayment(payment);
			this.transactions.add(transaction);
		}
		return transactions;
	}
	/*public static void main (String args[]) throws IOException{
		TransactionReader s = new TransactionReader("transaction.txt");
		s.getNextTransaction();
		System.out.println(s.transactions.size());
		
	}*/
}
