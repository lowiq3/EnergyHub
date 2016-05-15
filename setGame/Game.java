
package setGame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaming Qiu
 * This class represents a Set Game
 * 
 * numOfDimensions: the dimension of properties, e.g.
 * color, shape, shading, etc
 * numOfChoices: the possible choices per dimension
 * cardinalityOfSet: cardinality of the result set
 * cards: the cards that being played in this game
 * 
 */
public class Game {
	private int numOfDimensions;
	private int numOfChoices;
	private int cardinalityOfSet;
	private Card[] cards;

	public Game(int numOfDimensions, int numOfChoices, int cardinalityOfSet) {
		this.numOfDimensions = numOfDimensions;
		this.numOfChoices = numOfChoices;
		this.cardinalityOfSet = cardinalityOfSet;
	}
	
	public Game() {
		this(4,3,3);
	}
	
	/**
	 * use random generator to generate cards
	 * @see Card
	 */
	public void generateCards(int numOfCards) {
		cards = new Card[numOfCards];
		for (int i = 0; i < numOfCards; ++i) {
			cards[i] = new Card(numOfDimensions, numOfChoices);
		}
	}
	
	/**
	 * This overloaded method is for specifying a given
	 * set of cards, used for testing here
	 * @param testData an M*N array, 
	 * M is the number of cards
	 * N is the dimension of properties 
	 */
	public void generateCards(int[][] testData) {
		assert testData.length >=  cardinalityOfSet;
		assert testData[0].length == numOfDimensions;
		cards = new Card[testData.length];
		for (int i = 0; i < testData.length; ++i) {
			cards[i] = new Card(numOfDimensions, numOfChoices);
			cards[i].setProperties(testData[i]);
		}
	}
	
	public void printCards() {
		for (Card card : cards) {
			card.print();
		}
	}
	
	/**
	 * Check if the next card could be a valid add 
	 * with existing cards in the set.
	 * 
	 * This method can be further optimized to cut the
	 * inner loop by carrying a set of candidate numbers
	 * that the i-th property of the next card can choose of
	 * thus, instead of looping through cardsInSet, we only
	 * need to do an amortized O(1) check, but it requires
	 * O(numOfDimension * numOfChoices) space to maintain 
	 * the candidate set.
	 * 
	 * For the time being, I didn't implement the better 
	 * version, just keep a side note here.
	 */
	private boolean isValid(List<Integer> cardsInSet, int nextCardIndex) {
		if (cardsInSet.size() < 2) return true;
		
		int[] firstCardProperties = cards[cardsInSet.get(0)].getProperties();
		int[] secondCardProperties = cards[cardsInSet.get(1)].getProperties();
		int[] nextCardProperties = cards[nextCardIndex].getProperties();
		
		for (int i = 0; i < numOfDimensions; ++i) {
			if (firstCardProperties[i] == secondCardProperties[i]) {
				if (nextCardProperties[i] != firstCardProperties[i]) {
					return false;
				}
			} else {
				for (int j = 0; j < cardsInSet.size(); ++j) {
					if (nextCardProperties[i] == 
							cards[cardsInSet.get(j)].getProperties()[i]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * helper function to be called recursively
	 * @param res the container that carries results
	 * @param cardsInSet the list of cards that are already in the set
	 * @param nextCardIndex the next card being considered
	 */
	private void solveUtil(List<List<Integer>> res, 
			List<Integer> cardsInSet, int nextCardIndex) {
		if ((cards.length - nextCardIndex) < 
				(cardinalityOfSet - cardsInSet.size())) {
			return;
		}
		if (isValid(cardsInSet, nextCardIndex)) {
			cardsInSet.add(nextCardIndex);
			if (cardsInSet.size() == cardinalityOfSet) {
				res.add(new ArrayList<Integer>(cardsInSet));
			} else {
				for (int i = nextCardIndex+1; i < cards.length; ++i) {
					solveUtil(res, cardsInSet, i);
				}
			}
			cardsInSet.remove(cardsInSet.size()-1);
		}
	}
	
	public List<List<Integer>> solve() {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < cards.length; ++i) {
			solveUtil(res, new ArrayList<Integer>(), i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.generateCards(15);
		game.printCards();
		System.out.println(game.solve());
	}

}
