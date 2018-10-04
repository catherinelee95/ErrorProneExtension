package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.jpacman.framework.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test the Board.withinBorders method through the one-by-one domain testing
 * strategy.
 * 
 */
@RunWith(Parameterized.class)
public class BoardWithinBordersTest {
	
	private final int xcoord, ycoord;
	private final boolean expected;
	private final Board board;
	
	private static final int WIDTH = 10;
	private static final int HEIGHT = 20;
	
	/**
	 * Create a new test case by setting the point (x, y).
	 * The result should be the expected bool. 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param bool the expected result
	 */
	public BoardWithinBordersTest(int x, int y, boolean bool) {
		xcoord = x;
		ycoord = y;
		expected = bool;
		board = new Board(WIDTH, HEIGHT);
	}
	
	
	/** 
	 * The actual withinBorders test case.
	 */
	@Test
	public void testWithinBorders() {
		assertEquals(board.withinBorders(xcoord, ycoord), expected);
	}
	
	
	/**
	 * List of (x,y) data points with the expected boolean result.
	 * @return Test data to be fed to constructor.
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] values = new Object[][] {
			    { 0, 15, true },
			    { -1, 17, false },
			    { 10, 11, false },
			    { 9, 10, true },
			    { 3, 0, true },
			    { 4, -1, false },
			    { 7, 20, false },
			    { 8, 19, true } };
		return Arrays.asList(values);
	}
	
}
