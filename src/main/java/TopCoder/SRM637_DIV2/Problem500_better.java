package TopCoder.SRM637_DIV2;

import java.io.InputStream;
import java.util.Scanner;

public class Problem500_better {

  private static final char BLACK = '#';
  private static final char WHITE = '.';
  
  public int calc(String[] board){
    int max = -1;
    
    if (board[0].charAt(0) == WHITE){
      max = Math.max(max, count(0,0,board));
    }
    if (board[1].charAt(0) == WHITE){
      max = Math.max(max, count(1,0,board));
    }

    return max;
  }


  private int count(int i, int j, String[] board) {
    int val = 0;
    
    while (j<board[0].length()){
      if(j == board[0].length() -1 || board[i].charAt(j+1) == WHITE){
        if(board[(i+1)%2].charAt(j) == WHITE){
          val++;
        }
        j++;
      }else{
        i = (i+1)%2;
        j++;
      }
    }
    return val;
  }

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
   String upperStr = sc.next();
   String lowerStr = sc.next();
   String[] board = new String[]{upperStr, lowerStr};
   sc.close();
   Problem500 target = new Problem500();
   
   System.out.print(target.calc(board));
 }
}
