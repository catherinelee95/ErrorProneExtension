package org.jpacman.test.framework.factory;

import static org.junit.Assert.assertEquals;

import org.jpacman.framework.factory.FactoryException;

import org.junit.Test;

/**
 * Test the Factory Exception class.
 * 
 */
public class FactoryExceptionTest {
	
	/**
	 * Test that the Factory Exception inherits Exception with a message parameter. 
	 * @throws FactoryException 
	 */
	@Test
	public void testFactoryExceptionContructor() {
		String message = "Exception Message";
		FactoryException exception = new FactoryException(message);
		assertEquals(message, exception.getMessage());
	}
	
	
	/**
	 * Test that the Factory Exception with the message 
	 * constructor inherits Exception throwable behaviour. 
	 * @throws FactoryException 
	 */
	@Test(expected = Exception.class)
	public void testFactoryExceptionThrow() throws Exception {
		throw new FactoryException("Exception Message");
	}
	
	
	/**
	 * Test that the Factory Exception inherits Exception with  
	 * message and throwable parameters.
	 * @throws FactoryException 
	 */
	@Test
	public void testFactoryExceptionWithCause() {
		String message = "Exception Message";
		Throwable cause = new Throwable();
		FactoryException exception = new FactoryException(message, cause);
		assertEquals(message, exception.getMessage());
		assertEquals(cause, exception.getCause());
	}
	
	
	/**
	 * Test that the Factory Exception with the message and throwable 
	 * parameters inherits Exception throwable behaviour. 
	 * @throws FactoryException 
	 */
	@Test(expected = Exception.class)
	public void testFactoryExceptionWithCauseThrow() throws Exception {
		throw new FactoryException("Exception Message", new Throwable());
	}
}
