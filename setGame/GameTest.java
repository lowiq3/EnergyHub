
package setGame;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author Jiaming Qiu
 */
public class GameTest {

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testClassicGame1() {
		Game game = new Game();
		int[][] testData = { 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(0, 1, 2));
		expected.add(Arrays.asList(0, 1, 3));
		expected.add(Arrays.asList(0, 2, 3));
		expected.add(Arrays.asList(1, 2, 3));
		assertTrue("Any three out of four cards works", 
				expected.equals(game.solve()));
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testClassicGame2() {
		Game game = new Game();
		int[][] testData = { 
			{ 1, 1, 1, 1 }, 
			{ 1, 2, 1, 0 }, 
			{ 1, 1, 0, 0 }, 
			{ 1, 0, 1, 0 }
		};
		game.generateCards(testData);
		assertTrue("No solution", game.solve().isEmpty());
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testClassicGame3() {
		Game game = new Game();
		int[][] testData = { 
			{ 1, 1, 2, 0 }, 
			{ 1, 2, 1, 2 }, 
			{ 1, 2, 0, 0 }, 
			{ 1, 0, 1, 0 }
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(0, 2, 3));
		assertTrue("One solution with equal and nonequal properties", 
				expected.equals(game.solve()));
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testClassicGame4() {
		Game game = new Game();
		int[][] testData = { 
			{ 1, 1, 2, 0 }, 
			{ 1, 2, 1, 2 }, 
			{ 0, 2, 0, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 2, 2, 1, 2 },
			{ 1, 2, 0, 0 }, 
			{ 1, 2, 1, 2 },
			{ 0, 2, 0, 0 }, 
			{ 1, 0, 1, 0 }, 
			{ 1, 2, 1, 2 }
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(0, 5, 8));
		expected.add(Arrays.asList(1, 6, 9));
		assertTrue("Classic game with 10 cards", 
				expected.equals(game.solve()));
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testClassicGame5() {
		Game game = new Game();
		int[][] testData = { 
			{ 1, 1, 2, 0 }, 
			{ 1, 2, 1, 2 }, 
			{ 0, 2, 0, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 2, 2, 1, 2 },
			{ 1, 2, 0, 0 },
			{ 1, 2, 1, 2 }, 
			{ 0, 2, 0, 0 }, 
			{ 1, 0, 1, 0 }, 
			{ 1, 2, 1, 2 }, 
			{ 0, 2, 0, 0 },
			{ 1, 1, 1, 2 },
			{ 0, 2, 0, 0 }, 
			{ 1, 0, 2, 0 }, 
			{ 1, 1, 1, 2 }
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(0, 5, 8));
		expected.add(Arrays.asList(1, 6, 9));
		expected.add(Arrays.asList(2, 7, 10));
		expected.add(Arrays.asList(2, 7, 12));
		expected.add(Arrays.asList(2, 10, 12));
		expected.add(Arrays.asList(3, 5, 13));
		expected.add(Arrays.asList(7, 10, 12));
		assertTrue("Classic game with 15 cards", 
				expected.equals(game.solve()));
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testClassicGame6() {
		Game game = new Game();
		int[][] testData = { 
			{ 1, 1, 1, 0 },
			{ 1, 1, 1, 0 },
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 },
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 },
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 },
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 1, 1, 0 }
		};
		game.generateCards(testData);
		assertEquals("size of 20 choose 3", 1140, game.solve().size());
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testWithMoreDimensions1() {
		Game game = new Game(7, 3, 3);
		int[][] testData = { 
			{ 1, 1, 1, 0, 2, 1, 2 },
			{ 1, 0, 1, 0, 2, 1, 2 }, 
			{ 1, 1, 1, 1, 2, 1, 2 },
			{ 0, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 2, 1, 2 },
			{ 2, 1, 1, 1, 1, 1, 1 }
		};
		game.generateCards(testData);
		assertTrue("No solution", game.solve().isEmpty());
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testWithMoreDimensions2() {
		Game game = new Game(7, 3, 3);
		int[][] testData = { 
			{ 1, 1, 1, 0, 2, 1, 2 }, 
			{ 1, 0, 1, 0, 2, 1, 2 }, 
			{ 1, 1, 1, 1, 2, 1, 2 },
			{ 0, 1, 1, 1, 0, 1, 1 }, 
			{ 1, 1, 1, 1, 2, 1, 2 }, 
			{ 2, 1, 1, 1, 1, 1, 0 }
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(2, 3, 5));
		expected.add(Arrays.asList(3, 4, 5));
		assertTrue("7 dimensions, 3 choices", 
				expected.equals(game.solve()));
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testWithMoreDimensionsMoreChoices() {
		Game game = new Game(5, 5, 3);
		int[][] testData = { 
			{ 3, 1, 2, 1, 1 },
			{ 1, 0, 2, 2, 3 },
			{ 4, 1, 4, 0, 3 }, 
			{ 2, 4, 0, 3, 2 },
			{ 4, 1, 3, 2, 3 }, 
			{ 1, 0, 0, 2, 0 }, 
			{ 3, 1, 2, 2, 2 }, 
			{ 0, 4, 0, 3, 2 }, 
			{ 4, 3, 0, 2, 0 },
			{ 0, 0, 2, 1, 4 }, 
			{ 0, 4, 1, 3, 1 }, 
			{ 1, 0, 3, 4, 1 }
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(0, 10, 11));
		expected.add(Arrays.asList(2, 3, 9));
		expected.add(Arrays.asList(2, 3, 11));
		expected.add(Arrays.asList(2, 5, 10));
		expected.add(Arrays.asList(2, 7, 11));
		expected.add(Arrays.asList(3, 4, 9));
		assertTrue("5 dimensions, 5 choices", 
				expected.equals(game.solve()));
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testWithMoreDimensionsMoreChoicesButBiggerSetSize1() {
		Game game = new Game(5, 5, 5);
		int[][] testData = { 
			{ 3, 1, 2, 1, 1 },
			{ 1, 0, 2, 2, 3 },
			{ 4, 1, 4, 0, 3 },
			{ 2, 4, 0, 3, 2 },
			{ 4, 1, 3, 2, 3 }, 
			{ 1, 0, 0, 2, 0 },
			{ 3, 1, 2, 2, 2 }, 
			{ 0, 4, 0, 3, 2 }, 
			{ 4, 3, 0, 2, 0 },
			{ 0, 0, 2, 1, 4 }, 
			{ 0, 4, 1, 3, 1 }, 
			{ 1, 0, 3, 4, 1 }
		};
		game.generateCards(testData);
		assertTrue("No Solution: 5 dimensions, 5 choices, " 
				+ "choose 5 cards to make a set", game.solve().isEmpty());
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testWithMoreDimensionsMoreChoicesButBiggerSetSize2() {
		Game game = new Game(5, 5, 5);
		int[][] testData = { 
			{ 3, 1, 2, 1, 1 }, 
			{ 1, 0, 2, 2, 3 },
			{ 4, 1, 4, 0, 3 }, 
			{ 2, 4, 0, 3, 2 },
			{ 4, 1, 3, 2, 3 },
			{ 1, 0, 0, 2, 0 },
			{ 3, 1, 2, 2, 2 }, 
			{ 0, 4, 0, 3, 2 }, 
			{ 2, 1, 0, 2, 2 },
			{ 0, 0, 2, 1, 4 },
			{ 0, 4, 1, 3, 1 },
			{ 1, 0, 3, 4, 1 }, 
			{ 3, 1, 2, 1, 1 },
			{ 1, 0, 2, 2, 3 },
			{ 4, 2, 4, 0, 3 },
			{ 2, 4, 0, 3, 2 }, 
			{ 4, 1, 3, 2, 3 }, 
			{ 1, 1, 1, 4, 0 }, 
			{ 3, 1, 2, 2, 2 },
			{ 0, 4, 0, 3, 2 },
			{ 4, 3, 0, 2, 0 }, 
			{ 0, 1, 3, 3, 4 }, 
			{ 0, 4, 1, 3, 1 }, 
			{ 1, 0, 3, 4, 1 } 
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(0, 2, 8, 17, 21));
		expected.add(Arrays.asList(2, 8, 12, 17, 21));
		assertTrue("5 dimensions, 5 choices, choose 5 cards to make a set", 
				expected.equals(game.solve()));
	}

	/**
	 * Test method for {@link test.Game#solve()}.
	 */
	@Test
	public final void testWithMoreDimensionsMoreChoicesButBiggerSetSize3() {
		Game game = new Game(6, 7, 4);
		int[][] testData = { 
			{ 4, 6, 2, 6, 3, 0 },
			{ 3, 5, 6, 0, 4, 0 }, 
			{ 0, 0, 4, 3, 0, 5 }, 
			{ 1, 0, 5, 2, 3, 4 },
			{ 0, 3, 3, 5, 3, 3 }, 
			{ 5, 3, 3, 5, 2, 1 }, 
			{ 0, 4, 0, 3, 1, 1 }, 
			{ 1, 0, 6, 3, 0, 5 },
			{ 6, 4, 5, 2, 1, 4 }, 
			{ 1, 2, 6, 1, 3, 5 }, 
			{ 3, 6, 4, 2, 3, 6 }, 
			{ 1, 0, 2, 1, 6, 3 },
			{ 3, 2, 2, 3, 4, 3 }, 
			{ 3, 2, 4, 5, 0, 6 }, 
			{ 3, 4, 4, 1, 6, 0 }
		};
		game.generateCards(testData);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(0, 2, 5, 8));
		expected.add(Arrays.asList(0, 5, 7, 8));
		expected.add(Arrays.asList(1, 2, 5, 8));
		expected.add(Arrays.asList(1, 5, 8, 11));
		assertTrue("6 dimensions, 7 choices, choose 4 cards to make a set",
				expected.equals(game.solve()));
	}

}
