package org.jpacman.test.framework.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Sprite;
import org.jpacman.framework.model.Tile;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Board class.
 * 
 */
public class BoardTest {
	
	private Board board;
	private Sprite sprite;
	
	/**
	 * Create a Board, and give it initial height and width.
	 */
	@Before public void setUp() {
		//TODO: Do we need this ?
		sprite = new Sprite() {};
		board = new Board(10, 10);
	}

	
	//////////////Board Construction Tests//////////////////
	
	/**
	 * Test the Board constructor.
	 */
	@Test
	public void testInitInvalidWidth() {
		try {
			new Board(-1, 5);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE1: width should be >= 0 but is -1";
			assertEquals(message, e.getMessage());
		}
	}
	
	@Test
	public void testInitInvalidHeight() {
		try {
			new Board(100, -5);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE2: height should be >= 0 but is -5";
			assertEquals(message, e.getMessage());
		}
	}
	
	
	@Test
	public void testInitInvalidWidthHeight() {
		try {
			new Board(-1, -500);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE1: width should be >= 0 but is -1";
			assertEquals(message, e.getMessage());
		}
	}
	
	
	/**
	 * Test the Board constructor.
	 */
	@Test
	public void testInitZeroSizeBoard() {
		Board b = new Board(0, 0);
		assertThat(b.getWidth(), equalTo(0));
		assertThat(b.getHeight(), equalTo(0));
	}
	
	
	/**
	 * Test the Board constructor.
	 */
	@Test
	public void testInit() {
		Board b = new Board(250, 120);
		assertThat(b.getWidth(), equalTo(250));
		assertThat(b.getHeight(), equalTo(120));
	}
	
	
	//////////////Test board and sprite interactions//////////////////
	@Test
	public void testPutOffBoard() {
		try {
			board.put(sprite, 10, 10);
			fail("Sprite should not be succesfully put");
		} catch (AssertionError e) {
			String message = "PRE1: (10, 10)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}
		
		//Confirm that the sprite was not put on the board.
		assertEquals(sprite.getTile(), null);
	}
	
	@Test
	public void testPutNullSprite() {
		
		//test null sprite 
		try {
			board.put(null, 5, 5);
			fail("Sprite should not be successfully put.");
		} catch (AssertionError e) {
			String message = "PRE2: Sprite not null";
			assertEquals(message, e.getMessage());
		}
	}
	
	/**
	 * Test the put method that put a sprite at a given position.
	 */
	@Test
	public void testPutOccupiedSprite() {
		Tile tile = new Tile(1,1);

		//test occupied sprite
		try {
			sprite.occupy(tile);
			board.put(sprite, 5, 5);
			fail("Sprite should not be successfully put.");
			
		} catch (AssertionError e) {
			String message = "PRE3: Sprite should not occupy[1,1]";
			assertEquals(message, e.getMessage());
		}
		
		assertEquals(board.spriteAt(5, 5), null);
	}
	
	@Test
	public void testPutSprite() {
		board.put(sprite, 5, 5);
		assertEquals(board.spriteAt(5, 5), sprite);
	}
	
	
	@Test
	public void testPutSpriteType() {
		board.put(sprite, 5, 5);
		assertEquals(board.spriteTypeAt(5, 5), sprite.getSpriteType());
	}
	
	
	@Test
	public void testInvalidSpriteAtType() {
		try {
			board.spriteTypeAt(10, 5);
			fail("Invalid position should fail");
		
		} catch (AssertionError e) {
			String message = "PRE: (10, 5)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}

	}
	
	
	@Test
	public void invalidSpriteAt() {
		try {
			board.spriteAt(10, 10);
			fail("Invalid position should fail");
		
		} catch (AssertionError e) {
			String message = "PRE: (10, 10)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}
	}
	
	//////////////Test board tiles//////////////////
	
	@Test
	public void testTileAt() {
		Tile boardTile = board.tileAt(5, 6);
		assertEquals(boardTile.getX(), 5);
		assertEquals(boardTile.getY(), 6);
	}
	
	@Test
	public void testInvalidTileAt() {
		try {
			board.tileAt(10, 5);
			fail("Tile should be out of bounds");
		
		} catch (AssertionError e) {
			String message = "PRE: (10, 5)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}
	}
	
	@Test
	public void testNullTileAtOffset() {
		try {
			board.tileAtOffset(null, 5, 5);
			fail("Null tile should not be valid.");
		
		} catch (AssertionError e) {
			String message = "PRE1: start tile should not be null.";
			assertEquals(message, e.getMessage());
		}
	}
	
	@Test
	public void testInvalidBaseTileAtOffset() {
		try {
			board.tileAtOffset(new Tile(10, 10), 0, 0);
			fail("Base tile should be invalid.");
		
		} catch (AssertionError e) {
			String message = "PRE2(10, 10)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}
	}
	
	@Test
	public void testInvalidTileAtOffset() {
	}
}
