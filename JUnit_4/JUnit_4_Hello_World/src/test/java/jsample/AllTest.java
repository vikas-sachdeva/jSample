package jsample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.JUnit4TestAdapter;

/**
 * Create a Suite for running all test classes
 */
@RunWith(Suite.class)
/**
 * Add all the test classes as value in Suite.SuiteClasses annotation.
 */
@Suite.SuiteClasses(value = { AppTest.class, HelloWordTest.class })
public class AllTest {

	/**
	 * This class can be empty if test cases are getting run in Eclipse.
	 * 
	 * Otherwise, add following methods for running test suite from command
	 * line.
	 * 
	 * By this way, all test cases can be run as Java application also.
	 * 
	 * In the output, A dot is printed before each test is started. The total
	 * time for all the test case execution is also output. Final, the last line
	 * is a summary of the test results.
	 */

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(AllTest.class);
	}
}