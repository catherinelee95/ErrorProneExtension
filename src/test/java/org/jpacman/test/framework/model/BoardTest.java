package org.jpacman.test.framework.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
	public void testInitial() {
		//TODO: Do we need this ?
		Board b = new Board(10, 20);
		assertThat(b.getWidth(), equalTo(10));
		assertThat(b.getHeight(), equalTo(20));
	}
	
	
	/**
	 * Test the put method that put a sprite at a given position.
	 */
	@Test
	public void testPut() {
		//TODO: Implement me.
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
