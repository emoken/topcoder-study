package TopCoder.SRM637_DIV2;

import java.io.InputStream;
import java.util.Scanner;

// emoken has submitted the 250-point problem for 213.33 points
public class Problem250 {

  
  public int calc(int[] snuke, int[] sothe){
    
    int points=0;
    for(int i=0;i<snuke.length;i++){
      if(snuke[i]>sothe[i]){
        points++;
      }
    }
    
    return points;
  }
  
//-----------------------------------------------------------
//TODO These are for UT. 
//If this can be removed in any way, I'd be very good!!!
//-----------------------------------------------------------
 private static InputStream SYSTEM_IN = System.in;
 public static void setSystemIn(InputStream systemIn) {
   SYSTEM_IN = systemIn;
 }

 private static int[] toIntArray(String[] strArray){
   int[] intArray = new int[strArray.length];
   for(int i=0;i<strArray.length;i++){
     intArray[i] = Integer.parseInt(strArray[i]);
   }
   return intArray;
 }

 public static void main(String[] args) {
   Scanner sc = new Scanner(SYSTEM_IN);
   int[] a = toIntArray(sc.next().replace(" ", "").split(","));
   int[] b = toIntArray(sc.next().replace(" ", "").split(","));
   sc.close();
   Problem250 target = new Problem250();
   System.out.print(target.calc(a, b));
 }

}
