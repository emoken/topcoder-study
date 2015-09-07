package TopCoder.SRM635_DIV2;

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

public class LonglongestPathTreeTest{

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
  public void test1() throws IOException {doTest(1);}
  @Test
  public void test2() throws IOException {doTest(2);}
  @Test
  public void test3() throws IOException {doTest(3);}
  @Test
  public void test4() throws IOException {doTest(4);}
  @Test
  public void test5() throws IOException {doTest(5);}

  private void doTest(int testNo) throws IOException {
    InputStream fileInputStream = new FileInputStream ("test\\TopCoder\\SRM635_DIV2\\case"+testNo+".txt");
    LonglongestPathTree.setSystemIn(fileInputStream);
    LonglongestPathTree.main(new String[]{});
    fileInputStream.close();

    long answerVal = new Long(TestUtil.dos2unix(outContent.toString())).longValue();
    long expetedVal = new Long(TestUtil.dos2unix(TestUtil.readFile("test\\TopCoder\\SRM635_DIV2\\case"+testNo+".answer.txt",StandardCharsets.UTF_8).replace("\n", ""))).longValue();
    assertEquals(expetedVal, answerVal);
  };
}

