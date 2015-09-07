package TopCoder.SRM637_DIV2;

import java.io.InputStream;
import java.util.Scanner;

public class Problem1000 {

//-----------------------------------------------------------
//TODO These are for UT. 
//If this can be removed in any way, I'd be very good!!!
//-----------------------------------------------------------
 private static InputStream SYSTEM_IN = System.in;
 public static void setSystemIn(InputStream systemIn) {
   SYSTEM_IN = systemIn;
 }

 public static void main(String[] args) {
   Scanner sc = new Scanner(SYSTEM_IN);
   int value = sc.nextInt();
   sc.close();
   System.out.print(value);
 }
}
