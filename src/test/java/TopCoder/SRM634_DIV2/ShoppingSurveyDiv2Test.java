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


public class ShoppingSurveyDiv2Test{


	private ShoppingSurveyDiv2 _target = new ShoppingSurveyDiv2();
	
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
		int intVal = 5;
		int[] intArray = {3,3};
		String strIntArray = Arrays.toString(intArray);

		_target.main(new String[]{Integer.toString(intVal), strIntArray});
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 1;
		assertEquals(expetedVal, answerVal);
	}

	@Test
	public void test2() throws IOException {
		int intVal = 100;
		int[] intArray = {97};
		String strIntArray = Arrays.toString(intArray);

		_target.main(new String[]{Integer.toString(intVal), strIntArray});
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 97;
		assertEquals(expetedVal, answerVal);
	}

	@Test
	public void test3() throws IOException {
		int intVal = 10;
		int[] intArray = {9,9,9,9,9};
		String strIntArray = Arrays.toString(intArray);

		_target.main(new String[]{Integer.toString(intVal), strIntArray});
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 5;
		assertEquals(expetedVal, answerVal);
	}

	@Test
	public void test4() throws IOException {
		int intVal = 7;
		int[] intArray = {1,2,3};
		String strIntArray = Arrays.toString(intArray);

		_target.main(new String[]{Integer.toString(intVal), strIntArray});
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 0;
		assertEquals(expetedVal, answerVal);
	}

	@Test
	public void test5() throws IOException {
		int intVal = 5;
		int[] intArray = {3,3,3};
		String strIntArray = Arrays.toString(intArray);

		_target.main(new String[]{Integer.toString(intVal), strIntArray});
		int answerVal = Integer.parseInt(outContent.toString());
		int expetedVal = 0;
		assertEquals(expetedVal, answerVal);
	}
}

