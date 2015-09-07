package TopCoder.SRM219_DIV1;

// copied from this.
//(c++)
// http://community.topcoder.com/stat?c=problem_solution&rd=5865&pm=3117&cr=269554
//
// Other Solution to this problem
// http://topcoder.g.hatena.ne.jp/n4_t/20090517


public class TurnTableServiceRecursive {

  int[][] memo = new int[32768][16];
  int[] entree = new int[15];
  int n;

  private int go(int done, int pos) {
    if (done == (1 << n) - 1)
      return 0;

    int best = memo[done][pos];
    if (best >= 0)
      return best;
    best = 999999999;

    for (int rot = 0; rot < n; rot++) {

      int rtime = 0;

      if (rot > 0) {
        rtime = 1 + Math.min(rot, (n - rot));
      }

      int npos = (pos + rot) % n;

      int d = done;
      for (int i = 0; i < n; i++) {

        int dish = (npos + i) % n;
        if (((1 << dish) & entree[i]) == 0) {
          d |= (1 << i);
        }

      }

      if (d != done) {
        int t = go(d, (pos + rot) % n) + rtime + 15;
        if (t < best)
          best = t;
      }
    }

    return best;
  }

  public int calculateTime(String[] favorites) {

    n = favorites.length;

    for (int i = 0; i < n; i++) {

      int m = 0, j;
      String[] dishes = favorites[i].split(" ");

      for (String dish : dishes) {
        j = Integer.valueOf(dish);
        m |= (1 << j);
      }
      entree[i] = m;
    }
    return go(0, 0);

  }

}

// View TurntableService Problem Statement
// #include <iostream>
// #include <cstdio>
// #include <string>
// #include <vector>
// #include <algorithm>
// #include <map>
// #include <set>
// #include <sstream>
// #include <cmath>
//
// using namespace std;
//
//
// int memo[32768][16];
//
// class TurntableService {
// public:
//
// int entree[15],n;
//
// int go(int done, int pos)
// {
// if (done==(1<<n)-1) return 0;
//
// int &best=memo[done][pos];
// if (best>=0) return best;
// best=999999999;
//
// https://gcc.gnu.org/onlinedocs/gcc-3.4.6/gcc/Min-and-Max.html#Min-and-Max
//
// for(int rot=0;rot<n;rot++) {
// int rtime=0;
// if (rot>0) rtime=1+(rot<?(n-rot));
// int npos=(pos+rot)%n;
//
// int d=done;
// for(int i=0;i<n;i++) {
// int dish=(npos+i)%n;
// if ((1<<dish)&entree[i])
// d|=(1<<i);
// }
// if (d!=done) {
// int t=go(d,(pos+rot)%n)+rtime+15;
// if (t<best) best=t;
// }
// }
//
// return best;
// }
//
// int calculateTime(vector <string> favorites) {
// n=favorites.size();
// for(int i=0;i<n;i++) {
// int m=0,j;
// istringstream ss(favorites[i]);
// while (ss >> j) m |= (1<<j);
// entree[i]=m;
// }
// memset(memo,-1,sizeof(memo));
// return go(0,0);
// }
// };
//
//
// // Powered by FileEdit
