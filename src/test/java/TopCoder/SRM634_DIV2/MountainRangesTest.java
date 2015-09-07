package TopCoder.SRM634_DIV2;

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


public class MountainRangesTest{


	private MountainRanges _target = new MountainRanges();
	
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
		int[] intArray = {5, 6, 2, 4};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 2;
		assertEquals(expetedVal, answerVal);
	}

	@Test
	public void test2() throws IOException {
		int[] intArray = {1, 1, 1, 1, 1, 1, 1};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 0;
		assertEquals(expetedVal, answerVal);
	}

	@Test
	public void test3() throws IOException {
		int[] intArray = {2, 1};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 1;
		assertEquals(expetedVal, answerVal);
	}

	@Test
	public void test4() throws IOException {
		int[] intArray = {2,5,3,7,2,8,1,3,1};
		String strIntArray = Arrays.toString(intArray);
		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
		_target.main(strArray);
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 4;
		assertEquals(expetedVal, answerVal);
	}
}

