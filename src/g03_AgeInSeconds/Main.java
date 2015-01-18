package g03_AgeInSeconds;

import java.util.Scanner;

/**
 * Created by sanic on 18/01/2015.
 */
public class Main
{
	public static void main( String[] args )
	{
		System.out.println( "Enter your age in years" );
		Scanner scan = new Scanner( System.in );
		int ageInYears = scan.nextInt();
		System.out.println( "You are approximately " + ( ageInYears * 365 * 24 * 60 * 60 ) + " seconds old.");
	}
}
