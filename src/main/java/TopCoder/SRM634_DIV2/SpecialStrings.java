package TopCoder.SRM634_DIV2;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SpecialStrings{

	public String findNext(String current){

    // ------------------------
	  //  Preparation
    // ------------------------
	  int N = current.length();
	  char[] tgtStrChars = new char[N];
	  Arrays.fill(tgtStrChars, '1');

	  // ------------------------
	  //  Main
    // ------------------------
    char[] prevSpecialStr = "".toCharArray();
    
	  for(int tgtIdx=0;tgtIdx<N;tgtIdx++){

	    if( ! checkLargeness(tgtStrChars, tgtIdx, current)){
	      break;
	    }
	    
	    // when tgtIdx = '0' case.
	    tgtStrChars[tgtIdx]='0';
      String tgtStr = new String(tgtStrChars);
      if(isSpecialString(tgtStr) && tgtStr.compareTo(current) > 0){
        prevSpecialStr=Arrays.copyOf(tgtStrChars, tgtStrChars.length);
        continue;
      }

      // when tgtIdx = '1' case.
      tgtStrChars[tgtIdx]='1';

      for(int movingIdx=tgtIdx+1;movingIdx<N;movingIdx++){
        tgtStrChars[movingIdx]='0';
        if(isSpecialString(tgtStr) && tgtStr.compareTo(current) > 0){
          prevSpecialStr=tgtStrChars;
        }
        tgtStrChars[movingIdx]='1';
      }

      // set '0' for a next iteration.
      tgtStrChars[tgtIdx]='0';
	  };
	  
		return new String(prevSpecialStr);
	}
	
	
	private boolean checkLargeness(char[] tgtStrChars, int tgtIdx, String current) {

	  boolean zeroCaseLargeness, oneCaseLargeness;
	  tgtStrChars[tgtIdx]='0';
	  zeroCaseLargeness = new String(tgtStrChars).compareTo(current) > 0 ? true:false;

	  tgtStrChars[tgtIdx]='1';
	  oneCaseLargeness = new String(tgtStrChars).compareTo(current) > 0 ? true:false;

	  if(zeroCaseLargeness == false && oneCaseLargeness == false){
	    return false;
	  }else{
	    return true;
	  }
  }


  public boolean isSpecialString(String specialStr){

	  int N = specialStr.length();
	  if(N == 1){
	    return true;
	  }

	  char[] chars = specialStr.toCharArray();
	  int srcIdx,tgtIdx;
	  
    for(int numTries=1;numTries<N;numTries++){
      
      // loop for # of 'specialStr' digits - 1. 
      // (i.e.) if it's 5 digits long, loop 4 times.
  	  for(int movingIdx=0;movingIdx<N-1;movingIdx++){
  	    
  	    srcIdx = movingIdx;
  	    tgtIdx = numTries + movingIdx;
  	    
  	    if(srcIdx >= N || tgtIdx >= N){
  	      return false;
  	    }
  	    
  	    if(movingIdx<numTries){
          if(chars[srcIdx] < chars[tgtIdx]){
            break;
//            return true;
          }else if(chars[srcIdx] > chars[tgtIdx]){
            return false;
          }else if(chars[srcIdx] == chars[tgtIdx])
            if(tgtIdx == N-1){
              return false;
            }else{
              continue;
            }
  	    }else{
  	      if(chars[tgtIdx] == '1'){
//  	        return true;
  	        break;
  	      }
  	    }
  	  }
    }	  
	  return true;
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
   System.out.print(new SpecialStrings().findNext(sc.next()));
   sc.close();
 }
}
