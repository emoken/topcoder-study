package TopCoder.SRM222_DIV1;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import util.TestUtil;

public class WalkingHomeTest{

  private final String TEST_NAME = "SRM222_DIV1";
  private final String PROBLEM_NAME = "500";
  private final String METHOD_NAME = "fewestCrossings";
  
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
    List<String> list = new ArrayList<>();
    
    while(sc.hasNext()){
    	list.add(sc.nextLine());
    }
    
    String[] map = list.stream().toArray(String[]::new);
    
    int answerVal = 0;

    try {
    	WalkingHome target = new WalkingHome();
      Class myClass = target.getClass();
      Method[] methods = myClass.getMethods();
      
      for(Method m: methods){
        if(Modifier.PUBLIC == m.getModifiers() && m.getName().equals(METHOD_NAME)){

          // FIXME 2. method signature.
          answerVal = ((Integer) m.invoke(target, new Object[]{map})).intValue();

        }
      }
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      e.printStackTrace();
    }finally{
      fileInputStream.close();
      sc.close();
    }

    // FIXME 3. assertion check data type.
    int expetedVal = new Integer(TestUtil.dos2unix(TestUtil.readFile(String.format("src\\test\\java\\TopCoder\\%s\\%s-%s-case%d.answer.txt", TEST_NAME, TEST_NAME, PROBLEM_NAME, testNo),StandardCharsets.UTF_8).replace("\n", "").replace("\r", ""))).intValue();
    assertEquals(expetedVal, answerVal);

  };
}

