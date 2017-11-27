// Filename: MyLoan.java
// Author: Faizan Ahmed
// CSC 300 - Homework #3

import java.util.Scanner;

public class MyLoan {
	
	//private variables
	private double amountBorrowed;
	private double yearlyRate;
	private int years;
	
	//constructors
	public MyLoan(){
		this.amountBorrowed = 0.0;
		this.yearlyRate = 0.0;
		this.years = 0;
	}
	
	public MyLoan(double amt, double rt, int yrs){
		this.amountBorrowed = amt;
		this.yearlyRate = rt;
		this.years = yrs;
	}
	
	//instance methods
	public double getAmountBorrowed(){ return this.amountBorrowed; }
	public double getYearlyRate(){ return this.yearlyRate; }
	public int getYears(){ return this.years; }
	
	public double monthlyPayment(){
		double i = (getYearlyRate()/100)/12; 
		double n = getYears() * 12;
    	double monthpay = getAmountBorrowed()*(i *(Math.pow(1 + i,n)))/(Math.pow(1 + i, n) -1);
		return monthpay;
	} 
	
	public double totalPayment(){
		double totalpay = monthlyPayment() * (getYears() * 12);
		return totalpay;
	}
	
	public String toString(){
		String ret = "";
		ret = "Loan: $" +getAmountBorrowed()+" at " +getYearlyRate()+"% for " +getYears()+ " years";
		return ret;
	}
	
	//***** main method *****
	public static void main(String[] args){
		
		System.out.println("***** Welcome to the Loan Analyzer! *****");
		Scanner in = new Scanner(System.in);
		String ans;

		do {
			System.out.print("\nEnter the principle amount to borrow: ");
			int p = in.nextInt();
			
			//hard-coded rates,years 
			final double RATE15 = 5.75;
			final double RATE30 = 6.25;
			
			MyLoan data1 = new MyLoan(p, RATE15, 15);
			MyLoan data2 = new MyLoan(p, RATE30, 30);
			
			//myloan - data1
			System.out.println("\n============ ANALYSES ============");
			String a = data1.toString();
			System.out.println(a);	
			System.out.printf("Monthly payment = $%.2f", data1.monthlyPayment());
			System.out.printf("\nTotal payment = $%.2f", data1.totalPayment());
			
			System.out.println("\n");
			//myloan - data2
			String b = data2.toString();
			System.out.println(b);
			System.out.printf("Monthly payment = $%.2f", data2.monthlyPayment());
			System.out.printf("\nTotal payment = $%.2f", data2.totalPayment());
			System.out.println("\n==================================");			
			
			//end of program
			System.out.print("\n ** Do you want to continue (y/n)? ");
			ans = in.next();
		}while (ans.equals("Y")||ans.equals("y"));
			if (ans.equals("N")||ans.equals("n")){
				System.out.println("\n***** Thank You! Good Bye. *****");
			}
	}
}
