package g01_HeadsOrTails;

import java.util.Scanner;

/**
 * Created by sanic on 18/01/2015.
 */
public class Main
{
	public static void main( String[] args )
	{
		System.out.println( "[Heads] or [tails]? - [Exit] to quit" );
		Scanner s = new Scanner( System.in );
		String input = "";
		int correct = 0;
		int total = 0;
		while( !( input = s.nextLine().toLowerCase() ).equals( "exit" ) )
		{
			boolean heads = Math.random() >= 0.5;
			total++;
			if( input.equals( "heads" ) || input.equals( "h" ) )
			{
				if( heads )
				{
					correct++;
					System.out.println( "You're right!" );
				}
				else
				{
					System.out.println( "Darn, better luck next time.");
				}
			}
			else if( input.equals( "tails" ) || input.equals( "t" ) )
			{
				if( !heads )
				{
					correct++;
					System.out.println( "You're right!" );
				}
				else
				{
					System.out.println( "Darn, better luck next time.");
				}
			}
		}
		System.out.println( "Your luck is there " + Math.round( ( ( double )correct / total ) * 100 ) + "% of the time.");
	}
}
