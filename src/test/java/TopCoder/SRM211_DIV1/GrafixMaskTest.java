package TopCoder.SRM211_DIV1;

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

public class GrafixMaskTest{

  private final String TEST_NAME = "SRM211_DIV1";
  private final String PROBLEM_NAME = "500";
  private final String METHOD_NAME = "sortedAreas";
  
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

    InputStream fileInputStream = new FileInputStream (String.format("src\\test\\java\\TopCoder\\%s\\%s-%s-case%d.txt", TEST_NAME, TEST_NAME, PROBLEM_NAME, testNo));

    Scanner sc = new Scanner(fileInputStream);
    if(!sc.hasNext()){ sc.close(); return;}
    
    // FIXME 1. input data type.
    String inStr = sc.nextLine();
    Object[] answerVal = null;
    String[] stringArray = inStr.replace("{","").replace("}","").split(",");
    Object ans = null;
    try {
      GrafixMask target = new GrafixMask();
      Class myClass = target.getClass();
      Method[] methods = myClass.getMethods();
      
      for(Method m: methods){
        if(Modifier.PUBLIC == m.getModifiers() && m.getName().equals(METHOD_NAME)){

          // FIXME 2. method signature.
//          answerVal = (Object[])m.invoke(target, new Object[]{stringArray});

          ans = m.invoke(target, new Object[]{stringArray});

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }finally{
      fileInputStream.close();
      sc.close();
    }

    // FIXME 3. assertion check data type.
    int[] expetedVal = TestUtil.toIntArray(
        TestUtil.dos2unix(TestUtil.readFile(String.format("src\\test\\java\\TopCoder\\%s\\%s-%s-case%d.answer.txt", TEST_NAME, TEST_NAME, PROBLEM_NAME, testNo),StandardCharsets.UTF_8).replace("\n", "").replace("\r", "")).replace("{","").replace("}","").split(","));

    assertEquals(expetedVal.length, answerVal.length);
    for(int i=0;i<expetedVal.length;i++){
      assertEquals(expetedVal[i], ((Integer)answerVal[i]).intValue());
    }

  };
}

