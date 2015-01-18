package g02_TemperatureConverter;

import java.util.Scanner;

/**
 * Created by sanic on 18/01/2015.
 */
public class Main
{
	public static void main( String[] args )
	{
		//TODO scanner breaks after second loop, look into later.
		System.out.println( "Convert to [c] or [f]? - [Exit] to quit" );
		Scanner s = new Scanner( System.in );
		String input = "";
		while( !( input = s.nextLine().toLowerCase() ).equals( "exit" ) )
		{
			System.out.println( "Please enter the number you would like to convert." );
			double convert = s.nextDouble();
			double converted = 0;
			if( input.startsWith( "c" ) )
			{
				converted = convert / 9 * 5 - 32;
			}
			else if( input.startsWith( "f" ) )
			{
				converted = convert * 9 / 5 + 32;
			}
			System.out.println( convert + " -> " + converted );
		}
	}
}
