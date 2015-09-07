package TopCoder.SRM637_DIV2;

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

public class Problem500Test{

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  private final String TEST_NAME = "SRM637_DIV2";
  private final String PROBLEM_NAME = "500";
  
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
  public void test1() throws IOException {doTest(1);}
  @Test
  public void test2() throws IOException {doTest(2);}
  @Test
  public void test3() throws IOException {doTest(3);}
//  @Test
//  public void test4() throws IOException {doTest(4);}
//  @Test
//  public void test5() throws IOException {doTest(5);}

  private void doTest(int testNo) throws IOException {
    InputStream fileInputStream = new FileInputStream (String.format("test\\TopCoder\\%s\\%s-%s-case%d.txt", TEST_NAME, TEST_NAME, PROBLEM_NAME, testNo));
    Problem500.setSystemIn(fileInputStream);
    Problem500.main(new String[]{});
    fileInputStream.close();

    String answerVal = outContent.toString();
    String expetedVal = TestUtil.dos2unix(TestUtil.readFile(String.format("test\\TopCoder\\%s\\%s-%s-case%d.answer.txt", TEST_NAME, TEST_NAME, PROBLEM_NAME, testNo),StandardCharsets.UTF_8).replace("\n", "").replace("\r", ""));
    assertEquals(expetedVal, answerVal);

  };
}

