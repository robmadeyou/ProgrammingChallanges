package g00_NameGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by sanic on 17/01/2015.
 */
public class LetterLikelihood
{
	private LetterObject[] letters = {
		new LetterObject( 'a', 0 ),
		new LetterObject( 'b', 0 ),
		new LetterObject( 'c', 0 ),
		new LetterObject( 'd', 0 ),
		new LetterObject( 'e', 0 ),
		new LetterObject( 'f', 0 ),
		new LetterObject( 'g', 0 ),
		new LetterObject( 'h', 0 ),
		new LetterObject( 'i', 0 ),
		new LetterObject( 'j', 0 ),
		new LetterObject( 'k', 0 ),
		new LetterObject( 'l', 0 ),
		new LetterObject( 'm', 0 ),
		new LetterObject( 'n', 0 ),
		new LetterObject( 'o', 0 ),
		new LetterObject( 'p', 0 ),
		new LetterObject( 'q', 0 ),
		new LetterObject( 'r', 0 ),
		new LetterObject( 's', 0 ),
		new LetterObject( 't', 0 ),
		new LetterObject( 'u', 0 ),
		new LetterObject( 'v', 0 ),
		new LetterObject( 'w', 0 ),
		new LetterObject( 'x', 0 ),
		new LetterObject( 'y', 0 ),
		new LetterObject( 'z', 0 ),
	};

	private int total;

	private char letter;

	public LetterLikelihood( char letter )
	{
		this.letter = letter;
	}

	public char getLetter()
	{
		return letter;
	}

	public void updateStats( char letter )
	{
		for( int i = 0; i < letters.length; i++ )
		{
			if( letters[ i ].getLetter()  ==  letter )
			{
				letters[ i ].increaseCount();
				this.total++;
				return;
			}
		}
	}

	public char getApropriateLetter()
	{
		double random = Math.random();
		Object character = null;
		Object[][] lettersBig = new Object[ total ][ 2 ];
		ArrayList<LetterObject> lettersLocal = sortInOrderOfRarity();

		int index = 0;
		for( LetterObject obj : lettersLocal )
		{
			for( int i = 0; i < (Integer)obj.getSize(); i++)
			{
				lettersBig[ index ][ 0 ] = obj.getLetter();
				lettersBig[ index ][ 1 ] = obj.getSize();
				index++;
			}
		}

		Random rand = new Random( );

		return lettersLocal.get( rand.nextInt( lettersLocal.size() )).getLetter();
	}

	/**
	 * Sorts all of the letters and their numbers in order of rareness.
	 * Rarest being on top
	 */
	public ArrayList<LetterObject> sortInOrderOfRarity()
	{
		ArrayList<LetterObject> tmp = new ArrayList<LetterObject>( );
		for( LetterObject obj : letters )
		{
			tmp.add( obj );
		}
		return tmp;
	}

	public class LetterObject implements Comparable
	{

		private char letter;
		private int size;
		public LetterObject( char letter, int size )
		{
			this.letter = letter;
			this.size = size;
		}

		public int getSize()
		{
			return size;
		}

		public char getLetter()
		{
			return letter;
		}

		public void increaseCount()
		{
			this.size++;
		}

		@Override
		public int compareTo( Object o )
		{
			return ( ( LetterObject ) o ).getSize() - getSize();
		}
	}
}
