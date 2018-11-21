package org.jpacman.test.framework.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Sprite;
import org.jpacman.framework.model.Tile;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for the board class
 *
 */
public class BoardTest {
	
	private Board board;
	private Sprite sprite;
	

	/**
	 * Initialize a board and sprite.
	 */
	@Before 
	public void setUp() {
		sprite = new Sprite() {};
		board = new Board(10, 10);
	}

	
	//////////////Board Construction Tests//////////////////
	/**
	 * Create a board constructor with a positive width and height.
	 */
	@Test
	public void testInit() {
		Board b = new Board(250, 120);
		assertThat(b.getWidth(), equalTo(250));
		assertThat(b.getHeight(), equalTo(120));
	}
/*	*//**
	 * Check if we can construct a board with an invalid width.
	 *//*
	@Test
	public void testInitInvalidWidth() {
		try {
			new Board(-1, 5);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE1: width should be >= 0 but is -1";
			assertEquals(message, e.getMessage());
		}
	}*/
	
/*	*//**
	 * Check if we can construct a board with an invalid height.
	 *//*
	@Test
	public void testInitInvalidHeight() {
		try {
			new Board(100, -5);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE2: height should be >= 0 but is -5";
			assertEquals(message, e.getMessage());
		}
	}*/
	
	
/*	*//**
	 * Check if we can construct a board if both the width and height are invalid.
	 *//*
	@Test
	public void testInitInvalidWidthHeight() {
		try {
			new Board(-1, -500);
			fail("Board should not be successfully created.");
		} catch (AssertionError e) {
			String message = "PRE1: width should be >= 0 but is -1";
			assertEquals(message, e.getMessage());
		}
	}*/
	
	
	/**
	 * Create a board with 0 width and height
	 */
	@Test
	public void testInitZeroSizeBoard() {
		Board b = new Board(0, 0);
		assertThat(b.getWidth(), equalTo(0));
		assertThat(b.getHeight(), equalTo(0));
	}
	
	
	
	//////////////Test board and sprite interactions//////////////////
	/**
	 * Place a sprite on an existing tile
	 */
	@Test
	public void testPutSprite() {
		board.put(sprite, 5, 5);
		assertEquals(board.spriteAt(5, 5), sprite);
	}
	
/*	*//**
	 * Test if we can place a null sprite on the board
	 *//*
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
	}*/
	
/*	*//**
	 * Test if we can place a sprite outside the board boundaries
	 *//*
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
	}*/
	
/*	*//**
	 * Test if we can place a sprite already on a tile on a new tile.
	 *//*
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
	}*/
	
	/**
	 * Test if we correctly get the correct type of sprite back after putting it on the board.
	 */
	@Test
	public void testPutSpriteType() {
		board.put(sprite, 5, 5);
		assertEquals(board.spriteTypeAt(5, 5), sprite.getSpriteType());
	}
	
	
/*	*//**
	 * Test if we can get a sprite type on an invalid (out of bounds) tile on the board
	 *//*
	@Test
	public void testInvalidSpriteAtType() {
		try {
			board.spriteTypeAt(10, 5);
			fail("Invalid position should fail");
		
		} catch (AssertionError e) {
			String message = "PRE: (10, 5)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}

	}*/
	
	
	
/*	*//**
	 * Test if we can get a sprite type on an invalid (out of bounds) tile on the board
	 *//*
	@Test
	public void testInvalidSpriteAtType2() {
		try {
			board.spriteTypeAt(5, 10);
			fail("Invalid position should fail");
		
		} catch (AssertionError e) {
			String message = "PRE: (5, 10)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}

	}*/
	
	/**
	 * Confirm we can get the type of a sprite correctly
	 */
	@Test
	public void testSpriteAt() {
		board.put(sprite, 5, 6);
		Sprite fetchedSprite = board.spriteAt(5, 6);
		assertEquals(sprite, fetchedSprite);
	}
	
	/**
	 * Test if we can get the sprite type on an empty tile
	 */
	@Test
	public void testMissingSpriteAtType() {
		SpriteType spriteType = board.spriteTypeAt(5,  5);
		assertEquals(spriteType, SpriteType.EMPTY);
	}
	
	/**
	 * Attempt to get a sprite from that doesn't exist in the board.
	 */
	@Test
	public void testEmptySpriteAt() {
		Sprite fetchedSprite = board.spriteAt(5, 5);
		assertEquals(fetchedSprite, null);
	}
	
/*	*//**
	 * Attempt the sprite at method in an invalid (out of bounds) tile on the board.
	 *//*
	@Test
	public void testInvalidSpriteAt() {
		try {
			board.spriteAt(10, 10);
			fail("Invalid position should fail");
		
		} catch (AssertionError e) {
			String message = "PRE: (10, 10)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}
	}*/
	
//////////////Within Borders test//////////////////
	/**
	 * Confirm that we are not within borders if we are outside boundaries
	 */
	@Test
	public void testInvalidWithinBorders() {
		boolean isWithinBorders = board.withinBorders(-1, -1);
		assertFalse(isWithinBorders);
	}
	
	/**
	 * Confirm that we are within boards if we select values within the expected boundaries
	 */
	@Test
	public void testWithinBorders() {
		boolean isWithinBorders = board.withinBorders(5, 5);
		assertTrue(isWithinBorders);
	}
	
	
	//////////////Test board tiles//////////////////
	
	/**
	 * Confirm that we can get an expected tile using the TileAt method
	 */
	@Test
	public void testTileAt() {
		Tile boardTile = board.tileAt(5, 6);
		assertEquals(boardTile.getX(), 5);
		assertEquals(boardTile.getY(), 6);
	}
	
/*	*//**
	 * Confirm that we cannot get a tile outside the boundaries of the board using the TileAt 
	 * method
	 *//*
	@Test
	public void testInvalidTileAt() {
		try {
			board.tileAt(10, 5);
			fail("Tile should be out of bounds");
		
		} catch (AssertionError e) {
			String message = "PRE: (10, 5)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}
	}*/
	
/*	*//**
	 * Confirm that we cannot get a tile at an offset if the base tile is null
	 *//*
	@Test
	public void testNullTileAtOffset() {
		try {
			board.tileAtOffset(null, 5, 5);
			fail("Null tile should not be valid.");
		
		} catch (AssertionError e) {
			String message = "PRE1: start tile should not be null.";
			assertEquals(message, e.getMessage());
		}
	}*/
	
/*	*//**
	 * Confirm that we cannot get a tile at an offset if the base tile is
	 * out of boundaries
	 *//*
	@Test
	public void testInvalidBaseTileAtOffset() {
		try {
			board.tileAtOffset(new Tile(10, 10), 0, 0);
			fail("Base tile should be invalid.");
		
		} catch (AssertionError e) {
			String message = "PRE2(10, 10)not on board of size 10 * 10";
			assertEquals(message, e.getMessage());
		}
	}*/

	
	/**
	 * Test various tiles we can get using an offset
	 */
	@Test
	public void testTileAtOffset() {
		int[][] values = data();
		for(int i = 0; i < values.length; i++) {
			int[] testInfo = values[i];
			
			Tile source = new Tile(testInfo[0], testInfo[1]);
			Tile target = board.tileAtOffset(source, testInfo[2], testInfo[3]);
			assertEquals(target.getX(), testInfo[4]);
			assertEquals(target.getY(), testInfo[5]);
		}
	}
	
	
	/**
	 * Data points to be fed to tileAtOffset test
	 * @return
	 */
	private int[][] data() {
		int[][] values = new int[][] {
			// x-axis and y axis of original tile, dx, dy, resulting x, resulting y
			{ 2, 2, 3, 5, 5, 7},
			{ 2, 2, -1, 3, 1, 5},
			{ 2, 2, -2, -1, 0, 1},
			{ 5, 5, 5, 5, 0, 0},
			//worm hole cases
			{ 2, 2, -3, -3, 9, 9},
			{ 2, 2, -4, 9, 8, 1},
			{ 2, 2, 9, 9, 1, 1},
			{ 2, 2, 9, -4, 1, 8}
			};
			return values;
	}
	
	/**
	 * Test to get a tile in a specified direction
	 */
	@Test
	public void testTileAtDirection() {
		Tile tileBelow = board.tileAtDirection(new Tile(2, 2), Direction.DOWN);
		assertEquals(tileBelow.getX(), 2);
		assertEquals(tileBelow.getY(), 3);
		
	}
	
}
