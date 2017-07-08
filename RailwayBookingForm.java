class RailwayBookingForm{
	
	public static int basic_fare = 2000;
	
	public static void main(String args[])throws Exception {
		
		System.out.println(" ");
		System.out.println("  ****Railway Booking Form***** ");
		System.out.println("");
		
		//age
		System.out.println("Enter Youra Age");
		int age = Integer.parseInt(System.console().readLine() );
		System.out.println(" ");
	
		// mp,mla or employee
		System.out.println(" press P for \"MP\" \n  press M for \"MLA\" \n press E for \"Railway Employee\" ");
		char position =(char) System.in.read();
		float getAgeDiscounts = 0,getDiscount = 0;
		
		
		
				
		switch(position){
			
			case 'P':
				System.out.println(" MP Dsicounts (PLD) : 40% ");
				getDiscount =  getDiscount(40);
				getAgeDiscounts = getAgeDiscounts(age);
				System.out.println(" Your Total is : " + (getAgeDiscounts + getDiscount));
				break;
			case 'M':
				System.out.println(" MLA Dsicounts (PLD) : 30% ");
				getDiscount =  getDiscount(30);
				getAgeDiscounts = getAgeDiscounts(age);
				System.out.println(" Your Total is : " +(getAgeDiscounts + getDiscount));
				break;
			case 'E':
				System.out.println(" Railway Employee Dsicounts (RD) : 20% ");
				getDiscount =  getDiscount(20);
				getAgeDiscounts = getAgeDiscounts(age);
				System.out.println(" Your Total is : " + (getAgeDiscounts + getDiscount));
				break;
				
			/* case 'e':
			case 'm':
			case 'p':
				System.out.println(" You can choose one options at a time  "); */
				
			default:
				System.out.println("OOPss!, choose one Position at a Time");
				break;
		}
			
			System.out.println(" --------- Happy Journey ------- ");
		
	}
	
	
	// calculate Discounts
	public static float getDiscount(int percent){
		
		float per = (float)percent/100;
		float result = (2000*per);
		System.out.println("After Discounting : "+ result);
		return result;
		
	}
	
	// calulate Age Discounts
	public static float getAgeDiscounts(int age){
		float total =0;
		if(age >= 60){
			System.out.println(" You are comes Under Senier Citizen Discounts (SCD) : 10% ");
			 total = getDiscount(10);
			
		}else{
			System.out.println(" You Don't comes under (SCD) ");
		}
		return total;
	}
	
	
	
}