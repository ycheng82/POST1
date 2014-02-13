/**
 * author: Ye Cheng
 */
package transaction;

import java.sql.Date;

public class TransactionHeader {
	private String customeName;
	private Date date;
	public TransactionHeader(String customerName, Date date){
		this.customeName = customerName;
		this.date = date;
	}
	public String getName(){
		return this.customeName;
	}
	public Date getDate(){
		return this.date;
	}
}
