package TopCoder.SRM219_DIV1;

public class TurnTableServiceDP {

  public int calculateTime(String[] favorites) {

    // initialization.
	int n = favorites.length;
    boolean[][] likes = new boolean[n][n];
    for (int i=0; i < n; ++i) {
      String[] tokens = favorites[i].split(" +");
      for (int j=0; j < tokens.length; ++j) {
        likes[i][Integer.parseInt(tokens[j])] = true;
      }
    }

    // main
    int[][] best = new int[1<<n][n];

    // a bitmask of who has been served food (2^15)
    for (int mask=1; mask < best.length; ++mask) {

      //  state space is current position (p = 0...14)
      for (int p=0; p < n; ++p) {
        best[mask][p] = INF;
        int mask2 = mask;

        // serve everybody with a favorite in front of him
        for (int i=0; i < n; ++i) {
          int dish = (i+p)%n;

          if ((mask & (1<<i)) != 0 && likes[i][dish]) {
        	 // true if ( "i" is not served ) && ("i" likes a dish in front of them)

        	 // ### BIT MANIPULATION ###
        	 // [ (mask & (1<<i)) != 0 ] checks if "i" th bit is ON(1) or OFF(0).

         	 // ### BIT MANIPULATION ###
        	 // [ mask2 -= 1<<i ] is to turn off "i" th bit
        	 mask2 -= 1<<i;
          }
        }

        if (mask2 != mask) {
          for (int pp=0; pp < n; ++pp) {
            if (p == pp) continue;
            int dist = Math.abs(p-pp);
            dist = Math.min(dist,n-dist);
            int t = (mask2 == 0 ? 0 : dist+1);
            best[mask][p] = Math.min(best[mask][p],15+t+best[mask2][pp]);
          }
        }
      }

    }

    // calculate answer.
    int r = best[(1<<n)-1][0];
    for (int p=1; p < n; ++p) {
      int dist = Math.min(p,n-p);
      r = Math.min(r,dist+1+best[(1<<n)-1][p]);
    }
    return r;
  }
    
  static final int INF = 1000000;
   
  // Powered by FileEdit
  // Powered by CodeProcessor
}
