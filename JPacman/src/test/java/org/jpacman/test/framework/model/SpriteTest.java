package org.jpacman.test.framework.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import org.jpacman.framework.model.Sprite;
import org.jpacman.framework.model.Tile;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class addressing how sprites occupy or deoccupy tiles.
 * 
 * @author Arie van Deursen, TU Delft, Dec 24, 2011
 */
public class SpriteTest {

	private final Sprite john = new Sprite() { };
	private final Tile center = new Tile(0, 0);

	/**
	 * Initial situation: Sprite John is in the middle.
	 */
	@Before
	public void setUp() {
		john.occupy(center);
	}
	
/*	@Test
	public void testEmptyTile() {
		Sprite bob = new Sprite() { };
		assertEquals(bob.getTile(), null);
	}*/

/*	*//**
	 * Confirm that an assertion error should be thrown when
	 * we try to occupy a null tile.
	 * 
	 *//*
	@Test (expected = AssertionError.class)
	public void testOccupyNull() throws AssertionError {
		john.occupy(null);
	}
	*/
/*	*//**
	 * Confirm that an assertion error should be thrown when
	 * we try to occupy twice.
	 *//*
	@Test (expected = AssertionError.class)
	public void testOccupyTwice() throws AssertionError {
		john.occupy(center);
	}*/
	
/*	*//**
	 * Confirm that an assertion error should be thrown when
	 * we try to deoccupy an empty tile.
	 *//*
	@Test
	public void testDeocupiedEmptyTile() {
		try {
			john.deoccupy();
			john.deoccupy();
			fail("Deoccupy an empty tile should be invalid");
		
		} catch (AssertionError e) {
			String message = "PRE: Must occupy a cell already.";
			assertEquals(message, e.getMessage());
		}
	}*/
	
	/**
	 * Test the initial situation.
	 */
	@Test
	public void testOccupy() {
		assertTrue(center.containsSprite(john));
		assertThat(center.topSprite(), equalTo(john));
		assertThat(john.getTile(), equalTo(center));
	}

	/**
	 * Test what happens if we relocate a sprite.
	 */
	@Test
	public void relocateSprite() {
		john.deoccupy();
		Tile north = new Tile(0, 1);
		john.occupy(north);

		// john now lives at north
		assertThat(north.topSprite(), equalTo(john));

		// but john doesn't live in the center anymore.
		assertFalse(center.containsSprite(john));
	}
	
	/**
	 * Test what happens if there are multiple sprites on one tile.
	 */
	@Test
	public void multipleSprites() {
		Sprite david = new Sprite() {
		};
		david.occupy(center);

		// now David is the top most sprite.
		assertThat(center.topSprite(), equalTo(david));

		// but john is still there too.
		assertTrue(center.containsSprite(john));
		assertThat(john.getTile(), equalTo(center));
	}

	/**
	 * Testing moves, now with custom made matcher.
	 */
	@Test
	public void testMoveWithMatchers() {
		Tile north = new Tile(0, 1);
		john.deoccupy();
		john.occupy(north);
		assertThat(john, occupies(north));
		assertThat(john, not(occupies(center)));
	}

	/**
	 * Test that a sprite can leave its current tile.
	 */
	@Test
	public void testDeoccupy() {
		john.deoccupy();
		assertNull(john.getTile());
	}
	
	/**
	 * Confirm that we could get the 'OTHER' sprite type.
	 */
	@Test
	public void testGetSpriteType() {
		assertEquals(SpriteType.OTHER ,john.getSpriteType());
	}
	
	/**
	 * Confirm that we could display information about which Tile is
	 * being occupied by the Sprite.
	 */
	@Test
	public void testToString() {
		assertEquals("OTHER occupying [0,0]", john.toString());
	}
	
	/**
	 * @param expected
	 *            The tile the sprite should be on.
	 * @return A hamcrest matcher telling whether a sprite is the topmost one on
	 *         a given tile.
	 */
	private static Matcher<Sprite> occupies(final Tile expected) {
		return new BaseMatcher<Sprite>() {
			private Tile theTile = expected;

			@Override public boolean matches(Object o) {
				if (!(o instanceof Sprite)) {
					return false;
				}
				Sprite theSprite = (Sprite) o;
				return theSprite.getTile().equals(theTile)
						&& theTile.topSprite().equals(theSprite);
			}

			@Override public void describeTo(Description d) {
				d.appendText("sprite occupying tile ");
				d.appendValue(theTile);
			}
		};
	}
}
