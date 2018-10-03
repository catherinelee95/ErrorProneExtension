package org.jpacman.test.framework.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Sprite;
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
		board = new Board(10, 10);
	}

	
	/**
	 * Test the Board constructor.
	 */
	@Test
	public void testInitial() {
		Board b = new Board(10, 20);
		assertThat(b.getWidth(), equalTo(10));
		assertThat(b.getHeight(), equalTo(20));
	}
	
	
	/**
	 * Test the put method that put a sprite at a given position.
	 */
	@Test
	public void testPut() {
		board.put(adam, 2, 3);
		assertTrue(board.tileAt(2, 3).containsSprite(adam));
	}
	
	
	/**
	 * Test spriteAt
	 */
	@Test
	public void testSpriteAt() {
	 //TODO: Implement me.
	}
	
	
	/**
	 * Test spriteTypeAt
	 */
	@Test
	public void testSpriteTypeAt() {
	 //TODO: Implement me.
	}
	
	
	/**
	 * Test tileAtOffset
	 */
	@Test
	public void testTileAtOffset() {
	 //TODO: Implement me.
	}
	
	
	/**
	 * Test tunnelledCoordinate
	 */
	@Test
	public void testTunnelledCoordinate() {
	 //TODO: Implement me.
	}
	
	
	/**
	 * Test onBoardMessage
	 */
	@Test
	public void tesOnBoardMessage() {
	 //TODO: Implement me.
	}
	
	
}
