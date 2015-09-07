package TopCoder.SRM146_DIV2;

public class BridgeCrossing {

  private int[] side;
  private int[] time;
  private int best = Integer.MAX_VALUE, n;

  public int minTime(int[] times) {

    // preparation.
    this.n = times.length;
    this.time = times;
    this.side = new int[this.n];
    
    // main.
    if(n==1) return times[0];
    
    go(0, n);

    return best;
  }

  private void go(int tm, int left) {
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++)
        if (side[i] == 0 && side[j] == 0) {
          // i and j will cross
          side[i] = side[j] = 1;
          int new_tm = tm + Math.max(time[i], time[j]);
          if (left == 2) {
            if (new_tm < best) best = new_tm;
          } else {
            for (int k = 0; k < n; k++)
              // k will go back
              if (side[k] == 1) {
                side[k] = 0;
                go(new_tm + time[k], left - 1);
                side[k] = 1;
              }
          }
          side[i] = side[j] = 0;
        }
  }
}
