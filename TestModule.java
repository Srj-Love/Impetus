import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;import org.omg.CORBA.TRANSACTION_MODE;
import org.w3c.dom.stylesheets.MediaList;

public class TestModule {

	static ArrayList<Module> mList = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static int opening_balance = 10000;
	static int closing_balance = opening_balance;

	static int srNo = 1;
	private static Date mDate;

	
	
	public static void main(String[] args) {
		mDate = new Date();		
		BigOne();
		
		
	}
	
	
	
	private static int please_enter_amount() {

		System.out.print("Please enter Amount -> ");
		int amount = sc.nextInt();
		System.out.println(amount);
		return amount;
	}



	private static void closingBalance(int amount) {


		System.out.println( "Opening Balance = "+ opening_balance);
		closing_balance+=amount;
		System.out.println( "Closing Balance = "+ closing_balance);
		
	}


	static void  FullDetails(int bal,char tran_type ){
		mList.add(new Module(srNo, bal, mDate, tran_type)); 
		srNo++;		
		
	}
		
	public static int BigOne(){
		
			Module m = new Module();
			System.out.println("Please enter transactions type \n D-deposit, W-withdraw -> ");
			char tran_type = sc.next().charAt(0);
			
			System.out.print("Please enter Amount -> ");
			int amount = sc.nextInt();
			FullDetails(amount, tran_type);


			System.out.println("Do you want Next Transaction");
			char next_trans = sc.next().charAt(0);
			
			
			switch(tran_type){
				case 'd':
					if(next_trans == 'y'){
						closing_balance+=amount;
						BigOne();
					}else if(next_trans == 'n'){
						switch (next_trans) {
						case 'y':
							System.out.println(" Next Transaction");
							opening_balance+= amount;
							System.out.println("Amount -> "+m.getAmount());
							break;
						case 'n':
							closingBalance(amount);
							Iterator<Module> it = mList.iterator();
							while(it.hasNext()){
								System.out.println(it.next().toString());	
							}
							break;
						default:
							System.out.println("wrong char ):");
							break;
						}
					}
					break;
				case 'w':
					closing_balance-=amount;
					System.out.println( "Closing Balance = "+ closing_balance);
					break;
			
			
			
		}
		
		
		
		return 0;
		
	}

}


//

 class Module {
	
	private int srNo,amount;
	private Date mDate;
	private char type;
	
	
	
	public Module(int srNo, int amount, Date mDate, char type) {
		super();
		this.srNo = srNo;
		this.amount = amount;
		this.mDate = mDate;
		this.type = type;
	}
	
	public Module() {
		// TODO Auto-generated constructor stub
	}

	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
		
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return " srNo=" + srNo + "  amount=" + amount + "  mDate=" + mDate+ "  type=" + type;
	}
	
	

}
