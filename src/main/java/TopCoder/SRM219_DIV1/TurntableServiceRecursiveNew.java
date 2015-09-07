package TopCoder.SRM219_DIV1;

// copied from this.
// (java)
// http://community.topcoder.com/stat?c=problem_solution&rd=5865&pm=3117&cr=287266
//
// Other Solution to this problem
// http://topcoder.g.hatena.ne.jp/n4_t/20090517

import java.util.*;

public class TurntableServiceRecursiveNew {
  int[] f;
  int n;
  int[][] a;
  int INF = 1000000;

  int fun(int m, int p) {
    if (a[p][m] >= 0)
      return a[p][m];
    int r = INF;
    int q = m;
    for (int i = 0; i < n; i++)
      if ((1 << (i + p) % n & f[i]) != 0)
        q |= 1 << i;
    if (q == (1 << n) - 1)
      r = 15;
    else if (q != m) {
      for (int i = 0; i < n; i++)
        if (i != p) {
          int c = Math.min((i - p + n) % n, (p - i + n) % n) + 16 + fun(q, i);
          if (c < r)
            r = c;
        }
    }
    a[p][m] = r;
    return r;
  }

  public int calculateTime(String[] favorites) {
    n = favorites.length;
    f = new int[n];
    for (int i = 0; i < n; i++) {
      String[] s = favorites[i].split(" ");
      for (int j = 0; j < s.length; j++)
        f[i] |= 1 << Integer.parseInt(s[j]);
    }
    a = new int[n][1 << n];
    for (int i = 0; i < n; i++)
      Arrays.fill(a[i], -1);
    int m = fun(0, 0);
    for (int i = 1; i < n; i++)
      m = Math.min(m, Math.min(i, n - i) + 1 + fun(0, i));
    return m;
  }
}

// Powered by FileEdit
// Powered by CodeProcessor