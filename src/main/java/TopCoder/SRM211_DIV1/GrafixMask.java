package TopCoder.SRM211_DIV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GrafixMask {

  public int Y_MAX = 400;
  public int X_MAX = 600;

  boolean area[][] = null;

  public int[] sortedAreas(String[] rectangles) {

    area = new boolean[Y_MAX][X_MAX];
    int y = 0;
    int x = 0;

    // ---------
    // parsing
    // ---------
    for (String str : rectangles) {
      String[] strs = str.split(" ");

      int[] index = Arrays.asList(strs).stream().mapToInt(Integer::parseInt).toArray();
      for (y = index[0]; y <= index[2]; y++) {
        for (x = index[1]; x <= index[3]; x++) {
          area[y][x] = true;
        }
      }
    }

    // ---------
    // main
    // ---------
    List<Integer> result = new ArrayList<Integer>();

    for (y = 0; y < Y_MAX; y++) {
      for (x = 0; x < X_MAX; x++) {

        // if found a hall.
        if (!area[y][x]) {
          result.add(calcHoleArea(y, x));
        }
      }
    }

    Collections.sort(result);

    int[] finalResult = new int[result.size()];
    for (int i = 0; i < finalResult.length; i++) {
      finalResult[i] = result.get(i);
    }

    return finalResult;
  }

  Queue<CoordinatePair> q = new LinkedList<CoordinatePair>();

  private int calcHoleArea(int startY, int startX) {

    int y = startY;
    int x = startX;

    int cntArea = 0;
    q.add(new CoordinatePair(y, x));

    while (!q.isEmpty()) {

      CoordinatePair c = q.poll();
      y = c.y;
      x = c.x;
      
      if(area[y][x]) continue;

      area[y][x] = true;

      cntArea++;

      if ((x + 1) < X_MAX && !area[y][x + 1]) {
        q.add(new CoordinatePair(y, x + 1));
      }

      if ((x - 1) >= 0 && !area[y][x - 1]) {
        q.add(new CoordinatePair(y, x - 1));
      }

      if ((y + 1) < Y_MAX && !area[y + 1][x]) {
        q.add(new CoordinatePair(y + 1, x));
      }

      if ((y - 1) >= 0 && !area[y - 1][x]) {
        q.add(new CoordinatePair(y - 1, x));
      }

    }

    return cntArea;

  };

  class CoordinatePair {

    int x;
    int y;

    public CoordinatePair(int y, int x) {
      super();
      this.y = y;
      this.x = x;
    }
  }

  // Unit Testing.
  public static void main(String[] args) {

    GrafixMask thisObj = new GrafixMask();

    System.out.println(Arrays.toString(thisObj.sortedAreas(new String[] { "0 292 399 307" })));

    System.out.println(Arrays.toString(thisObj.sortedAreas(new String[]{"48 192 351 207", "48 392 351 407",
        "120 52 135 547", "260 52 275 547"})));

    System.out.println(Arrays.toString(thisObj.sortedAreas(new String[]{"0 192 399 207", "0 392 399 407",
     "120 0 135 599", "260 0 275 599"})));

    System.out.println(Arrays.toString(thisObj.sortedAreas(new String[]{"50 300 199 300", "201 300 350 300",
     "200 50 200 299", "200 301 200 550"})));

    System.out.println(Arrays.toString(thisObj.sortedAreas(new String[]{"0 20 399 20", "0 44 399 44", "0 68 399 68",
     "0 92 399 92",
     "0 116 399 116", "0 140 399 140", "0 164 399 164", "0 188 399 188",
     "0 212 399 212", "0 236 399 236", "0 260 399 260", "0 284 399 284",
     "0 308 399 308", "0 332 399 332", "0 356 399 356", "0 380 399 380",
     "0 404 399 404", "0 428 399 428", "0 452 399 452", "0 476 399 476",
     "0 500 399 500", "0 524 399 524", "0 548 399 548", "0 572 399 572",
     "0 596 399 596", "5 0 5 599", "21 0 21 599", "37 0 37 599",
     "53 0 53 599", "69 0 69 599", "85 0 85 599", "101 0 101 599",
     "117 0 117 599", "133 0 133 599", "149 0 149 599", "165 0 165 599",
     "181 0 181 599", "197 0 197 599", "213 0 213 599", "229 0 229 599",
     "245 0 245 599", "261 0 261 599", "277 0 277 599", "293 0 293 599",
     "309 0 309 599", "325 0 325 599", "341 0 341 599", "357 0 357 599",
     "373 0 373 599", "389 0 389 599"})));

  }


}
