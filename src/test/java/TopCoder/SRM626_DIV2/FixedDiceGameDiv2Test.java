package TopCoder.SRM626_DIV2;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FixedDiceGameDiv2Test {

	private FixedDiceGameDiv2 _target = new FixedDiceGameDiv2();
	private static final double DELTA = 1e-9;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void test1() throws IOException {
		int[] intArray = {2,2};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		double answerVal = Double.parseDouble(outContent.toString());
		double expetedVal = 2;
		assertEquals(expetedVal, answerVal, DELTA);		
	}

	@Test
	public void test2() throws IOException {
		int[] intArray = {4,2};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		double answerVal = Double.parseDouble(outContent.toString());
		double expetedVal = 3.2;
		assertEquals(expetedVal, answerVal, DELTA);		
	}

	@Test
	public void test3() throws IOException {
		int[] intArray = {3,3};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		double answerVal = Double.parseDouble(outContent.toString());
		double expetedVal = 2.6666666666666665;
		assertEquals(expetedVal, answerVal, DELTA);		
	}

	@Test
	public void test4() throws IOException {
		int[] intArray = {11,13};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		double answerVal = Double.parseDouble(outContent.toString());
		double expetedVal = 7.999999999999999;
		assertEquals(expetedVal, answerVal, DELTA);		
	}

}