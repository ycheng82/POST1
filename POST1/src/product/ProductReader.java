/**
 * author: Ye Cheng
 */
package product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class ProductReader {
	private BufferedReader source;
	private String nextLine;
	private String delimiter;
	
	public ProductReader(String productFile) throws IOException{
    	//System.out.println("Product file: "+ productFile);
    	//System.out.println("user.dir: " + System.getProperty("user.dir"));
        source = new BufferedReader(new FileReader(productFile));
	}
	
    void close() {
        try {
            source.close();
        } catch (Exception e) {}
    }
    
	protected boolean hasMoreProduct(){
		try{
			do{
				nextLine = source.readLine();	
				//System.out.println(nextLine!=null);
				//System.out.println(nextLine.length()== 0);
				if (nextLine==null){
					break;
				}
			}while(nextLine.length()== 0);
			//System.out.println(nextLine);
		}
	    catch (IOException e) {
		    System.err.println("Error: " + e);
		}
		return nextLine!=null;
	}
	
	protected ProductSpec getNextProduce(){
		delimiter = "	";
		StringTokenizer st = new StringTokenizer(nextLine,delimiter,false);
		int numberOfTokens = 0;
		String[] productInfor = new String[3];
		while (st.hasMoreTokens()) {
			productInfor[numberOfTokens] = st.nextToken();
			numberOfTokens++;
			//System.out.println(numberOfTokens);
			//System.out.println(productInfor);				
		}
		if (numberOfTokens!=3) {
			System.out.println("*****invalid record record******");
			System.exit(1); 
		}
		else {
			//System.out.println("record complete");
			return new ProductSpec(productInfor);
		}
		return new ProductSpec(productInfor);
	}
	
	/*public static void main(String args[]){
        ProductReader s = null;
        try {
            s = new ProductReader("products.txt");
            while (s.hasMoreProduct()) {
            	s.getNextProduce();
            }
        } catch (Exception e) {}

        if (s != null) {
            s.close();
        }
	}*/
	
}
