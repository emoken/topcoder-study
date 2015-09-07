package TopCoder.SRM642_DIV2;

public class LightSwitchingPuzzle {

  private static char ON = 'Y';
  private static char OFF = 'N';

  private int _arraySize;
  private char[] _stateChars;
	
	public int minFlips(String state){
		
    _stateChars = state.toCharArray();
    _arraySize = _stateChars.length;
    
    // case:
    //  N = 1 
    if(_arraySize==1){
      if(_stateChars[0] == ON){
        return 1;
      }else{
        return 0;
      }
    }

//    // case: 
//    //  all chars are the same. either all are ON, or all are OFF.
//    boolean isAllSame = true;
//    for(char c:_stateChars){
//      if(c != _stateChars[0]) isAllSame = false;
//    }
//    if(isAllSame){
//      if(_stateChars[0] == ON){
//        return 1;
//      }else{
//        return 0;
//      }
//    }
    
    // main:
    int flipCnt=0;
    for(int i=1;i<_arraySize;i++){
      if(_stateChars[0] != _stateChars[i]){
        toggle(i);
        flipCnt++;
      }
    }
    
    if(_stateChars[0] == ON){
      return flipCnt+1;
    }else{
      return flipCnt;
    }
	}

  private void toggle(int startIdx) {
    // convert 0th index scale to a natural number scale.
    int position = startIdx + 1;
    
    for(int i=startIdx;i<_arraySize;i += position){
      _stateChars[i] = _stateChars[i] == ON ? OFF : ON;
    }
  }
}
