package g00_NameGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by sanic on 17/01/2015.
 */
public class Main
{

	public static  LetterLikelihood[] letters = {
			new LetterLikelihood( 'a' ),
			new LetterLikelihood( 'b' ),
			new LetterLikelihood( 'c' ),
			new LetterLikelihood( 'd' ),
			new LetterLikelihood( 'e' ),
			new LetterLikelihood( 'f' ),
			new LetterLikelihood( 'g' ),
			new LetterLikelihood( 'h' ),
			new LetterLikelihood( 'i' ),
			new LetterLikelihood( 'j' ),
			new LetterLikelihood( 'k' ),
			new LetterLikelihood( 'l' ),
			new LetterLikelihood( 'm' ),
			new LetterLikelihood( 'n' ),
			new LetterLikelihood( 'o' ),
			new LetterLikelihood( 'p' ),
			new LetterLikelihood( 'q' ),
			new LetterLikelihood( 'r' ),
			new LetterLikelihood( 's' ),
			new LetterLikelihood( 't' ),
			new LetterLikelihood( 'u' ),
			new LetterLikelihood( 'v' ),
			new LetterLikelihood( 'w' ),
			new LetterLikelihood( 'x' ),
			new LetterLikelihood( 'y' ),
			new LetterLikelihood( 'z' ),
	};

	public static void main( String[] args )
	{
		try
		{
			BufferedReader reader = Files.newBufferedReader( Paths.get( "res/names.txt" ) );
			String line = null;
			while( ( line = reader.readLine() ) != null )
			{
				String startsWith = "";
				if( line.startsWith( "MO " ) )
				{
					startsWith = "MO ";
				}
				else if( line.startsWith( "FO" ) )
				{
					startsWith = "FO ";
				}
				else
				{
					startsWith = "MF ";
				}
				line = line.replace( startsWith, "" );
				line = line.replaceFirst( "((LN) |(LY) )", "" );

				char[] charArray = line.toLowerCase().toCharArray();
				for( int i = 0; i < charArray.length; i++ )
				{
					if( i != 0 )
					{
						getRepresentingObject( charArray[ i ] ).updateStats( charArray[ i - 1 ] );
						getRepresentingObject( charArray[ i - 1 ] ).updateStats( charArray[ i ] );
					}
				}
			}
		}
		catch( IOException ex )
		{
			ex.printStackTrace();
		}

		System.out.println( "Read all the names, now it's time to generate some fun!" );



		System.out.println( "Alright, generating your name now! " );
		while( true )
		{
			System.out.println( generateName( letters[ ( int ) ( Math.random() * 5 ) + 4  ].getLetter(), (int ) ( Math.random() * 5 ) + 4 ) );
		}
	}

	public static LetterLikelihood getRepresentingObject( char c )
	{
		for( LetterLikelihood letter : letters )
		{
			if( letter.getLetter() == c )
			{
				return letter;
			}
		}
		return null;
	}

	public static String generateName( char startsWith, int lenght )
	{
		String name = "" + startsWith;
		char lastChar = startsWith;
		while( name.length() != lenght )
		{
			lastChar = getRepresentingObject( lastChar ).getApropriateLetter();
			name += lastChar;
		}
		return name;
	}
}
