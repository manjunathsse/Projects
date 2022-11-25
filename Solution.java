import java.util.*;

enum Month{
	JAN,FEB,MAR,APR,MAY,JUNE,JULY,AUG,SEPT,OCT,NOV,DEC
}

enum Crypto{
	BTC,DOGE,ETH,XRP,TRX;
	//to create parameterized constructor we should create BTC();
	private int x=0;
	Crypto(){
		//System.out.println("CRYPTO is created");
	}
	public int getRupees() {
		return x;

	}
	public void setRupees(int x) {
		this.x=x;
	}
}

public class Solution {

	public static void main(String[] args) {
		/*Month x=Month.APR;
		System.out.println(x);
		Month[] values = Month.values();// stores the enum values in array
		for(Month month:values) {
			System.out.println(month);
		}
		
		System.out.println(x.ordinal());// gives the index of the month in enum
		*/
		Crypto x=Crypto.BTC;
		Crypto y=Crypto.DOGE;
		y.setRupees(100);
		System.out.println(y.getRupees());
	}
}

/* properties of the enum:
 * when enum is created a class is created with the given name and its extends enum and the class becomes final
 * the variables in the enum with objects of the class.
 * 1. Enum can implement one or more interface
 * 2. It cant extends another class
 * 3. Enums are absract class
 * 4. All variables defined in enum are public static and final
 * 5. toString() meathod is overridden in enums.
 */
