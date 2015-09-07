package TopCoder.SRM626_DIV2;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.TestUtil;

public class NegativeGraphDiv2Test {

	private NegativeGraphDiv2 _target = new NegativeGraphDiv2();
	
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
		InputStream fileInputStream = new FileInputStream ("test\\TopCoder\\SRM626_DIV2\\case1.txt");
		_target.setSystemIn(fileInputStream);

		_target.main(new String[]{});
		fileInputStream.close();
		
		int answerVal = new Integer(TestUtil.dos2unix(outContent.toString())).intValue();
		int expetedVal = new Integer(TestUtil.dos2unix(TestUtil.readFile("test\\TopCoder\\SRM626_DIV2\\case1.answer.txt",StandardCharsets.UTF_8))).intValue();
		assertEquals(expetedVal, answerVal);
	}

//	@Test
//	public void test2() throws IOException {
//		int[] intArray = {4,2};
//		String strIntArray = Arrays.toString(intArray);
//		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
//		_target.main(strArray);
//		double answerVal = Double.parseDouble(outContent.toString());
//		double expetedVal = 3.2;
//		assertEquals(expetedVal, answerVal, DELTA);		
//	}
//
//	@Test
//	public void test3() throws IOException {
//		int[] intArray = {3,3};
//		String strIntArray = Arrays.toString(intArray);
//		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
//		_target.main(strArray);
//		double answerVal = Double.parseDouble(outContent.toString());
//		double expetedVal = 2.6666666666666665;
//		assertEquals(expetedVal, answerVal, DELTA);		
//	}
//
//	@Test
//	public void test4() throws IOException {
//		int[] intArray = {11,13};
//		String strIntArray = Arrays.toString(intArray);
//		String[] strArray = strIntArray.substring(1, strIntArray.length() - 1).split(", ");
//		_target.main(strArray);
//		double answerVal = Double.parseDouble(outContent.toString());
//		double expetedVal = 7.999999999999999;
//		assertEquals(expetedVal, answerVal, DELTA);		
//	}

}