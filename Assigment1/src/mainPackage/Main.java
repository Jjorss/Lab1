package mainPackage;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Main {

	public static void main(String[] args) {
		//creates an instance of a scanner and a decimal formatter.
		Scanner sc = new Scanner(System.in);
		DecimalFormat decF = new DecimalFormat("#0.00");
		
		//Sets the user input to the annual_rate1 variable.
		System.out.print("What is your anual rate(\"Please enter a percent\"): ");
		// annual_rate1 = Annual Return
		double annual_rate1 = sc.nextDouble();
		
		//Sets the user's input to the years_retired variable.
		System.out.print("Years retired: ");
		// years_retired = How many years are you going to be retired for
		double years_retired = sc.nextDouble();
		
		//Sets the user's input to the requiredIn variable.
		System.out.print("Required income: ");
		//requiredIn = Required Income
		double requiredIn = sc.nextDouble();
		
		//Sets the user's input to the monthly_SSI variable
		System.out.print("Monthly SSI: ");
		// monthly_SSI = Monthly SSI
		double monthly_SSI = sc.nextDouble();
	
		//Prints out the total you need to save: PV
		double need_to_save = -1  * needToSave(annual_rate1, years_retired, requiredIn, monthly_SSI);
		System.out.println("You need to save a total of $" + decF.format(need_to_save)); 
		
		//Sets the user's input to the annual_rate2 variable.
		System.out.print("What is your anual rate(\"Please enter a percent\"): ");
		//annual_rate2 = Annual return for PMT
		double annual_rate2 = sc.nextDouble();
		
		//Sets the user's input to the yearsToWork variable.
		System.out.print("How many years are you going to work: ");
		//yearsToWork = How many years are you going to work for
		double yearsToWork = sc.nextDouble();
		
		//Prints out how much you need to save each month: PMT
		double save_monthly = -1 * saveMonthly(annual_rate2, yearsToWork, need_to_save);
		System.out.println("Inorder to save a total of $" + decF.format(need_to_save) +
				" ,you must save $" + decF.format(save_monthly) + " monthly." );
	}
	
	//Calculates the PV
	//Uses external jar FinanceLib
	//Inputs a double, double, double, double
	//Returns a double.
	public static double needToSave(double anual_rate, double yearsR, double rIncome, double monthlySSI) {
		return FinanceLib.pv((anual_rate / 12) / 100, yearsR * 12, rIncome - monthlySSI, 0, false);
		
	}
	
	
	//Calculates the PMT
	//Uses external jar FinanceLib
	//Inputs a double, double, double
	//Returns a double
	public static double saveMonthly(double anual_rate, double years, double need_to_save) {
		return FinanceLib.pmt((anual_rate / 12) / 100, years * 12, 0, need_to_save, false);
	}
}
