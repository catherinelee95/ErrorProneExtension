package org.jpacman.test.framework.factory;

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
	@Test(expected = Exception.class)
	public void testFactoryException() throws Exception {
		throw new FactoryException("Exception Message");
	}
	
	/**
	 * Test that the Factory Exception inherits Exception with a 
	 * message and throwable parameter.
	 * @throws FactoryException 
	 */
	@Test(expected = Exception.class)
	public void testFactoryExceptionWithCause() throws Exception {
		throw new FactoryException("Exception Message", new Throwable());
	}
}
