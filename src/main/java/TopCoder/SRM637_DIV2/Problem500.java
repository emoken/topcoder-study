package TopCoder.SRM637_DIV2;

import java.io.InputStream;
import java.util.Scanner;

public class Problem500 {

  char[] _upperRow;
  char[] _lowerRow;
  int[] _ij = {0,0};
  int _numBlacks=0;

  public int calc(String[] board){
    
    _upperRow = board[0].toCharArray();
    _lowerRow = board[1].toCharArray();

    // corner case.
    if(_upperRow.length==1){
      if(_upperRow[0] == '.' || _upperRow[0] == '.'){
        return 1;
      }else{
        return 0;
      }
    }

    // -----------------
    //  MAIN
    // -----------------

    // "ij" is currentPosition.
    if(_upperRow[0] != '.'){
      _ij[1] = 1;
    }

    while(true){

      turnBlackThenMove();

      if(_ij[0] == _upperRow.length-1){
        
        if(_ij[1] == 0){
          if(_lowerRow[_ij[0]] == '.'){
            _lowerRow[_ij[0]] = '#';
            _numBlacks++;
          };
        }else if(_ij[1] == 1){
          if(_upperRow[_ij[0]] == '.'){
            _upperRow[_ij[0]] = '#';
            _numBlacks++;
          };
        }

        break;
      }
    }
    return _numBlacks;
  }
  
  boolean moveVertically=false;
  
  private void turnBlackThenMove() {

    //    (1) move to right always.
    //    (2) check up/down and right. if both right and down/up are available, move right then turn down/up black.
    //    (3) if only either right or up/down is available, just move.
    //    (4) when reach to the right most, once again, look around and turn down/up black if possible.

    if(_ij[1] == 0){
      if(_upperRow[_ij[0]+1] == '.'){

        if(_lowerRow[_ij[0]] == '.' && _upperRow[_ij[0]+1] == '.' && moveVertically == false){
          _lowerRow[_ij[0]] = '#';
          _numBlacks++;
        };

        _ij[0]++;
        moveVertically=false;
      }else{
        _ij[1] = 1;
        moveVertically=true;
      }
    }else if(_ij[1] == 1){
      if(_lowerRow[_ij[0]+1] == '.'){

        if(_upperRow[_ij[0]] == '.' && _lowerRow[_ij[0]+1] == '.' && moveVertically == false){
          _upperRow[_ij[0]] = '#';
          _numBlacks++;
        };

        _ij[0]++;
        moveVertically=false;
      }else{
        _ij[1] = 0;
        moveVertically=true;
      }
    }
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
