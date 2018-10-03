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
	private final Sprite adam = new Sprite() { };
	
	/**
	 * Create a Board, and give it initial height and width.
	 */
	@Before public void setUp() {
		//TODO: Do we need this ?
		board = new Board(10, 10);
	}

	
	/**
	 * Test the Board constructor.
	 */
	@Test
	public void testInvalidInitialization() {
		try {
			Board b = new Board(-1, 5);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE1: width should be >= 0 but is -1";
			assertEquals(message, e.getMessage());
		}
		
		try {
			Board b = new Board(100, -5);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE: current should be < max but is -5";
			assertEquals(message, e.getMessage());
		}
		
		try {
			Board b = new Board(-1, -500);
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
	
	
	/**
	 * Test the put method that put a sprite at a given position.
	 */
	@Test
	public void testInvalidPut() {
		//test off the board 
		try {
			board.put(adam, 11, 10);
			fail("Sprite should not be succesfully put");
		} catch (AssertionError e) {
			String message = "PRE1: ";
			assertEquals(message, e.getMessage());
		}
		//test null sprite 
		try {
			board.put(null, 11, 10);
			assert(false);
		} catch (AssertionError e) {
			
		}
		//test occupied sprite
		try {
			Sprite ben = new Sprite() { };
			board.put(null, 11, 10);
		
		} catch (AssertionError e) {
			
		}
		
		
		board.put(adam, 2, 3);
		assertTrue(board.tileAt(2, 3).containsSprite(adam));
	}
	
	
	/**
	 * Test spriteAt
	 */
	@Test
	public void testSpriteAt() {
		//TODO: Implement me.
		board.put(adam, 2, 3);
		assertEquals(adam, board.spriteAt(2, 3));
	}
	
	
	/**
	 * Test spriteTypeAt
	 */
	@Test
	public void testSpriteTypeAt() {
	 //TODO: Implement me.
		//
		board.put(adam, 2, 3);
		assertEquals(SpriteType.OTHER, board.spriteTypeAt(2, 3));
		assertEquals( SpriteType.EMPTY, board.spriteTypeAt(1, 1));
	}
	
	
	/**
	 * Test tileAtOffset
	 */
	@Test
	public void testTileAtOffset() {
	 //TODO: Implement me.
		Tile tile = new Tile(2,3);
		Tile result = board.tileAtOffset(tile, 4, 5);
		assertEquals(result.getX(), 6);
		assertEquals(result.getY(), 8);
	}
	
		
	/**
	 * Test tileAtDirection
	 */
	@Test
	public void testTileAtDirection() {
	 //TODO: Implement me.
		Tile tile = new Tile(2,3);
		Tile result = board.tileAtDirection(tile, Direction.RIGHT);
		assertEquals(result.getX(), 3);
		assertEquals(result.getY(), 3);
	}
		
}
