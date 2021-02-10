import java.io.*;
import java.util.Scanner;

/**
	This program 
*/

public class MovieDriver {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);		
		
		Movie movie = new Movie();
		
		String title; //Holds movie title
		String rating; //Holds movie rating
		int ticketsSold; //Holds tickets sold for movie
		String exit; //Holds "y" or "n" to exit the program
		
		do 
		{
			System.out.println("Enter the name of a movie"); //Prompt user for title of movie
			title = keyboard.nextLine(); //Assign user input to variable title		
			movie.setTitle(title);
			
			System.out.println("Enter the rating of the movie"); //Prompt user for rating of movie
			rating = keyboard.nextLine(); //Assigns user input to variable rating
			movie.setRating(rating);
			
			System.out.println("Enter the number of tickets sold for this movie"); //Prompt user for tickets sold for movie
			ticketsSold = keyboard.nextInt();
			movie.setSoldTickets(ticketsSold);
			
			System.out.println(movie.toString());
			
			System.out.println("Would you like to enter another movie? (y or n)");
			keyboard.nextLine();
			exit = keyboard.nextLine();
					
		} while (exit.equalsIgnoreCase("y") == true);
		System.out.println("Goodbye");
		
		
	}

}
