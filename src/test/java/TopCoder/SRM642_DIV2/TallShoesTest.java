package TopCoder.SRM642_DIV2;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.Test;

import util.TestUtil;

public class TallShoesTest{

  private final String TEST_NAME = "SRM642_DIV2";
  private final String PROBLEM_NAME = "1000";
  private final String METHOD_NAME = "maxHeight";
  
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

    InputStream fileInputStream = new FileInputStream (String.format("test\\TopCoder\\%s\\%s-%s-case%d.txt", TEST_NAME, TEST_NAME, PROBLEM_NAME, testNo));
    Scanner sc = new Scanner(fileInputStream);
    if(!sc.hasNext()){ sc.close(); return;}
    
    int answerVal=0;
    int N=Integer.valueOf(sc.nextLine()).intValue();
    String inStrX = sc.nextLine();
    String inStrY = sc.nextLine();
    String inStrHeight = sc.nextLine();
    long B=Long.valueOf(sc.nextLine()).longValue();

    int[] inIntArrayX = TestUtil.toIntArray(inStrX.replace(" ", "").replace("{","").replace("}","").split(","));
    int[] inIntArrayY = TestUtil.toIntArray(inStrY.replace(" ", "").replace("{","").replace("}","").split(","));
    int[] inIntArrayHeight = TestUtil.toIntArray(inStrHeight.replace(" ", "").replace("{","").replace("}","").split(","));

    try {
      TallShoes target = new TallShoes();
      Class myClass = target.getClass();
      Method[] methods = myClass.getMethods();
      
      for(Method m: methods){
        if(Modifier.PUBLIC == m.getModifiers() && m.getName().equals(METHOD_NAME)){

          // FIXME 2. method signature.
          answerVal = ((Integer) m.invoke(target, N,inIntArrayX,inIntArrayY,inIntArrayHeight,B)).intValue();

        }
      }
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      e.printStackTrace();
    }finally{
      fileInputStream.close();
      sc.close();
    }

    // FIXME 3. assertion check data type.
    int expetedVal = new Integer(TestUtil.dos2unix(TestUtil.readFile(String.format("test\\TopCoder\\%s\\%s-%s-case%d.answer.txt", TEST_NAME, TEST_NAME, PROBLEM_NAME, testNo),StandardCharsets.UTF_8).replace("\n", "").replace("\r", ""))).intValue();
    assertEquals(expetedVal, answerVal);

  };
}

