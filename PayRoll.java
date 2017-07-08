class PayRoll{
	
	
	public static void main(String[] args)throws Exception{

		int salary = Integer.parseInt(System.console().readLine() );
		char grade =(char) System.in.read();
		
		float DA = Dearness_Allowence(salary);
		int hra = house_rent_allowance(grade);
		float pf = provided_fund(salary);
						
		//Gross Salary
		float gross_sal = (DA+hra+pf);
		System.out.println("Gross Salary "+gross_sal);
		
		//Net Salary
		float net_sal = gross_sal - pf;
		System.out.println("NET Salary "+net_sal);

		
	}
	
	// Dearness Allowence (DA)
	public static float Dearness_Allowence(int salary){
			float result =  (float)(salary/0.12) ;
			System.out.println("Dearness Allowence "+result);
			return (float)(salary/0.12);
	}
	
	
	// House Rent Allowence (HRA)
	public static int house_rent_allowance(char c){
		int n1 =0;
		switch(c){
			
			case 'A':
				n1 = 3000;
				System.out.println("HRA : "+n1);
				break;
			case 'B':
				n1 = 2000;
				System.out.println("HRA : "+n1);
				break;
			default:
				n1 = 1000;
				System.out.println("HRA : "+n1);
				break;

		}
		return n1;
		
	}
	
	
	// Provided Fund
	public static float provided_fund(int salary){
				float result =  (float)(salary/0.083) ;
				System.out.println("Provided Fund "+result);
				return 0;
	}
	
	
	
}