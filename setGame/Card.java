
package setGame;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Jiaming Qiu
 * This class represents a Card in Set Game
 * 
 * dimension: the dimension of properties, e.g.
 * color, shape, shading, etc
 * choice: the possible choices per dimension
 * properties: an int array that carries the value of each
 * dimension of this card
 * 
 * For the classic game of 4 dimensions (color, number
 * shape, shading) with 3 values per dimension,
 * an example card could have properties: [0,2,1,0],
 * which means color  : 0, red
 *             number : 2, three symbols
 *             shape  : 1, round shape
 *             shading: 0, no shade
 * 
 * Here I use a random number generator to 
 * randomly generate card properties; we can 
 * also set properties for testing purpose
 */
public class Card {
	private static Random rand = new Random();
	private int dimension;
	private int choice;
	private int[] properties; 
	
	private void generate() {
		properties = new int[dimension];
		for (int i = 0; i < dimension; ++i) {
			properties[i] = rand.nextInt(choice);
		}
	}
	
	public Card(int dimension, int choice) {
		this.dimension = dimension;
		this.choice = choice;
		generate();
	}
	
	public Card() {
		this(4,3); 	// default to be dimension:4, choice:3
	}
	
	public void print() {
		System.out.println(Arrays.toString(properties));
	}
	
	public int[] getProperties() {
		return properties;
	}
	
	public void setProperties(int[] properties) {
		this.properties = properties;
	}
	
	public static void main(String[] args) {
		Card c = new Card();
		c.print();
	}

}
