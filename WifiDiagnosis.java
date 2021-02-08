/*
 * Class: CMSC203 
 * Instructor: Grigoriy A. Grinberg
 * Description: A program that diagnosis and attempts to resolve a WiFi issue
 * Due: 2/09/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Angela Minardi
*/


import java.util.Scanner;

public class WifiDiagnosis 
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in); //Declares keyboard for user input
		
		String fixedYN; //Initializes variable for user input on whether the problem is fixed
		final String YN_ERROR_MESSAGE = "\n\nPlease follow the instructions and enter yes or no."; //Constant string that holds an error message if the user does not enter yes or no when asked
				
		
		System.out.println("If you are having problems with internet connectivity, this WiFi Diagnosis might help."); //Introduces what the program does to the user		
		
		
		do 
		{ //Runs first step
			System.out.println("\nFirst step: reboot your computer"); //Gives instruction to user
			System.out.println("Are you able to connect with the internet? (yes or no)"); //Prompts user for input
			fixedYN = keyboard.nextLine(); //Assigns user input to fixedYN
			
			if(!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no"))) //Runs if the user did not enter valid input
			{
				System.out.println(YN_ERROR_MESSAGE); //Asks the user to follow directions
			}
		} while(!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no"))); //If the user did not enter yes or no, it asks the question again
		
		if(fixedYN.equalsIgnoreCase("yes")) //Runs if the WiFi issue is resolved
		{
			System.out.println("Rebooting your computer seemed to work. Glad this helped!"); //End of program if the WiFi issue is resolved
		}
		else if (fixedYN.equalsIgnoreCase("no")) //Runs step 2 if the WiFi issue is not resolved
		{
			do //Runs second step
			{
				System.out.println("\nSecond step: reboot your router"); //Gives instruction to the user
				System.out.println("Are you able to connect with the internet? (yes or no)"); //Prompts the user for input
				fixedYN = keyboard.nextLine(); //Assigns user input to fixedYN
				
				
				if(!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no")))
				{ //Runs if the user did not enter valid input
					System.out.println(YN_ERROR_MESSAGE); //Asks user to follow instructions
				}
			} while(!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no"))); //Repeats if the user did not enter yes or no
			
			if(fixedYN.equalsIgnoreCase("yes")) //Runs if the WiFi issue is resolved
			{
				System.out.println("Rebooting your router seemed to work. Glad this helped!"); //End of program if the WiFi issue is resolved
			}
			else if (fixedYN.equalsIgnoreCase("no")) //Begin of step 3 if issue is not resolved
			{
				do 
				{ //Runs third step
					System.out.println("\nThird step: make sure the cables to your router are plugged in firmly and your router is getting power"); //Gives instruction to the user
					System.out.println("Now are you able to connect with the internet?"); //Prompts the user for input
					fixedYN = keyboard.nextLine(); //Assigns user input to fixedYN
					
					if(!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no"))) { //Runs if the user did not enter yes or no
						System.out.println(YN_ERROR_MESSAGE); //Asks user to follow instructions
					}
				} while(!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no")));
				
				if(fixedYN.equalsIgnoreCase("yes"))//Runs if the WiFi issue is resolved
				{
					System.out.println("Checking the cables seemed to work. Glad this helped!"); //End of program if the WiFi issue is resolved
				}
				else if(fixedYN.equalsIgnoreCase("no")) //Begin of step 4 if issue is not resolved
				{
					do //Runs fourth step
					{
						System.out.println("\nFourth step: move your computer closer to the router"); //Gives user instructions
						System.out.println("Now are you able to connect with the internet?"); //Prompts the user for input
						fixedYN = keyboard.nextLine(); //Assigns user input to fixedYN
						
						if(!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no"))) //Runs if the user did not enter yes or no
						{
							System.out.println(YN_ERROR_MESSAGE); //Asks user to follow instructions
						}
						
					} while (!(fixedYN.equalsIgnoreCase("yes") || fixedYN.equalsIgnoreCase("no"))); //Repeats if the user did not enter yes or no
					
					if(fixedYN.equals("yes"))
					{
						System.out.println("Moving your computer seemed to work. Glad this helped!"); //End of program if the WiFi issue is resolved
					}
					else if (fixedYN.equalsIgnoreCase("no"))
					{
						//Runs fifth (final) step
						System.out.println("\nFifth step: contact your ISP");
						System.out.println("Make sure your ISP is hooked up to your router.");
						System.out.println("End of program."); //End of program if WiFi issue was not resolved
					}
				
				}
			}
		}
		
	}
}
