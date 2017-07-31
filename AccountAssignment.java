class  Contact 
{
		
		
		private static String address,email;
		static int mobile;
		
		
		//Setter
		public static void setAddress(String a){address = a;}
		public static void setMobile(int m){mobile = m;}
		public static void setEmail(String e){email = e;}
		
		//getter
		public static String getAddress(){return address;}
		public static int getMobile(){return mobile;}
		public  static String getEmail(){return email;}
}


// Main Class
class AccountAssignment {
	Contact mContact = new Contact();
		static long acNo;
		static int balance=20000;
		static String name;
		static char accountType;
		
		
		//Display Acc Details
		public static void displayDetails(long a,String n, char aT){
			acNo = a;
			name = n;
			accountType = aT; 
			System.out.println("Name :"+name);
			System.out.println("Account No :"+acNo);
			System.out.println("Account Type :"+accountType);
			System.out.println("ABalance  :"+balance);
		}
		
		// Display Contact Details
		public static void displayContactDetails(){
	
			System.out.println("  Address -> " + Contact.getAddress());
			System.out.println("  Mobile  -> " + Contact.getMobile());
			System.out.println("Email -> " + Contact.getEmail()); 
			
		}
		
		// Saving  Account
		static class SavingAccount{
			static int minimumBalance = 0,starting_cheque_number = 123,ending_cheque_number = 456;
			
			static void crAmount(int bal){
				AccountAssignment.balance  += bal;
				System.out.print("your account has been successfully credited with : "+bal+" \n Toal  Balance ->  " + AccountAssignment.balance);
			}
			
			static void  drAmount(int withd){
				AccountAssignment.balance -=withd;
				System.out.print("Toal  Balance -> " + AccountAssignment.balance);
			}
			static void validateChequeNumber(int sChq,int eChq){
				if((sChq == starting_cheque_number) && (eChq == ending_cheque_number)){
					System.out.println("Cheque No. is Rigth");
				}else{
					System.out.println("Cheque Bo. is Not  Rigth");
				}
			}
			
			void displayBalance(){
				System.out.print("Toal  Balance -> " + AccountAssignment.balance);
			}
		}
		
		// Deposit Amount
		static class DepositAccount{
			
			static int principalAmount,numberOfMonths,rateOfInterest;
			static int total_interest_calculated;
			
			
			DepositAccount(int principalAmount,int numberOfMonths,int rateOfInterest){
				this.principalAmount = principalAmount;
				this.numberOfMonths = numberOfMonths;
				this.rateOfInterest = rateOfInterest;
			}
			
			static void calculateInterest(){
				total_interest_calculated = ((principalAmount*numberOfMonths*rateOfInterest)/100);
				int maturityAccount = principalAmount + total_interest_calculated;
				System.out.println(" Total Interest -> " + total_interest_calculated);
				System.out.print(" Maturity Amount " + maturityAccount);

			}
			
		}
		
		
		// psvm
		public static void main(String ar[])throws Exception{
			Contact c = new Contact();
			AccountAssignment aa = new AccountAssignment();
			
			System.out.print("Account Number -> ");
			long accNo = Long.parseLong(System.console().readLine());
			
			System.out.print("Account Holder Name -> ");
			String accName = System.console().readLine();
			
			System.out.print("Amount for Deposit or WithDraw-> ");
			int accBal = Integer.parseInt(System.console().readLine());
			
			System.out.println("Contact Details -> ");
			
			System.out.print("Mobile Number -> ");
			c.setMobile((int)Integer.parseInt(System.console().readLine()));
			
			System.out.print("Email Address -> ");
			c.setEmail(System.console().readLine());
			
			System.out.print("Address -> ");
			c.setAddress(System.console().readLine());
			
			System.out.print("\t PLEASE ENTER ACCOUNT TYPE SAVING s , DEPOSIT d  -> ");
			char saving_or_deposit = (char)System.in.read();
			
			if(saving_or_deposit ==('s'))
			{
				
					System.out.print("\t Starting chq no.-> ");
					int stating_chq = Integer.parseInt(System.console().readLine());
			
					System.out.print("\t Ending chq no.-> ");
					int ending_chq = Integer.parseInt(System.console().readLine());
					
					System.out.print(" \t Minimum Balance -> ");
					int minBal = Integer.parseInt(System.console().readLine());
					
					SavingAccount.minimumBalance = minBal;
					SavingAccount.validateChequeNumber(stating_chq,ending_chq);
					
					System.out.println("");
				
					System.out.print("DO yOU WANT ANY TRANSACTION ->");
					char yesORno = System.console().readLine().charAt(0);
						if(yesORno == ('y'))
						{
							System.out.print("Transaction Type D- Deposit, W-Withdraw, A-Amount  -> ");
							char TranType = System.console().readLine().charAt(0);
							switch(TranType)
							{
								case 'd': // if deposit
									SavingAccount.crAmount(accBal);
									break;
								case 'w': // if withdrow
									if(balance <= SavingAccount.minimumBalance)
									{
										System.out.println(" Minimum Balance Should be > 1000");
										System.out.println(" Your Amount is -> "+ balance);
									}else
									{
										SavingAccount.drAmount(accBal);
									}
									System.out.print("THank You");
									break;
								case 'a':
									displayDetails(accNo,accName,saving_or_deposit);
									AccountAssignment.displayContactDetails();
									break;
							
							}//switch
						}else if(yesORno == ('n'))
						{
							System.out.print(" THANK YOOU " );
						}
			}// saving_or_deposit = saving
			 else if (saving_or_deposit == ('d'))
			{
				System.out.print(" Do you want to Calculate interest  -> ");
				char cINt = System.console().readLine().charAt(0);
				if(cINt == 'y')
				{
					System.out.print(" Principal Amount ->  ");
					int princAmt = Integer.parseInt(System.console().readLine());
					System.out.print("No. in Months -> ");
					int nom = Integer.parseInt(System.console().readLine());
					System.out.print("Rate of Interest -> ");
					int roi = Integer.parseInt(System.console().readLine());
					new DepositAccount(princAmt,nom,roi);
					DepositAccount.calculateInterest();
				}else if(cINt == 'n')
				{
					System.out.print(" THANK YOOU " );
				}				
			}// saving_or_deposit = Deposit 
			 
		}//main
	}

