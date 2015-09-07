package TopCoder.SRM626_DIV2;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.TestUtil;

public class SumOfPowerTest {

	private SumOfPower _target = new SumOfPower();
	
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
		int[] intArray = {1,1,1};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 10;
		assertEquals(expetedVal, answerVal);		
	}

	@Test
	public void test2() throws IOException {
		int[] intArray = {3,14,15,92,65};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 1323;
		assertEquals(expetedVal, answerVal);		
	}

	@Test
	public void test3() throws IOException {
		int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 1210;
		assertEquals(expetedVal, answerVal);		
	}

	@Test
	public void test4() throws IOException {
		int[] intArray = {5, 52, 95, 88, 90, 77, 16, 58, 78, 59, 38, 73, 95, 5, 40, 51, 86, 93, 9, 58, 43, 18, 7, 12, 32};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 160318;
		assertEquals(expetedVal, answerVal);		
	}

}