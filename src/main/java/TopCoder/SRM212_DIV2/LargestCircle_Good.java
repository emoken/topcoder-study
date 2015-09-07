package TopCoder.SRM212_DIV2;

import java.awt.Point;
import java.util.Vector;
 
public class LargestCircle {
 
    public int radius(String[] grid) {
        Vector pats = new Vector();
        for (int i = 1; i <= 25; ++i) {
            Point[] cache = new Point[50];
            int c = 0;
            for (double y = 0.01; y < i; y += 0.01) {
                double x = Math.sqrt(i * i - y * y);
                Point p = new Point((int) x, (int) y);
                //System.out.println(p);
                if (c == 0 || !cache[c - 1].equals(p)) {
                    cache[c++] = p;
                }
            }
            Point[] patterns = new Point[c * 4];
            for (int j = 0; j < c; ++j) {
                patterns[j * 4] = cache[j];
                patterns[j * 4 + 1] = new Point(cache[j]);
                patterns[j * 4 + 1].x = -patterns[j * 4 + 1].x - 1;
 
                patterns[j * 4 + 2] = new Point(cache[j]);
                patterns[j * 4 + 2].y = -patterns[j * 4 + 2].y - 1;
 
                patterns[j * 4 + 3] = new Point(cache[j]);
                patterns[j * 4 + 3].x = -patterns[j * 4 + 3].x - 1;
                patterns[j * 4 + 3].y = -patterns[j * 4 + 3].y - 1;
            }
 
            for (int k = 0; k < patterns.length; ++k) {
                //System.out.println(patterns[k]);
            }
            //System.out.println("bbbb");
 
            pats.add(patterns);
        }
 
        System.out.println("start searching...");
 
        int max = Math.min(grid[0].length() / 2, grid.length / 2);
        for (int i = max; i >= 1; --i) {
            System.out.println(i);
            for (int x = i; x <= grid[0].length() - i; ++x) {
                for (int y = i; y <= grid.length - i; ++y) {
                    Point[] po = (Point[]) pats.get(i - 1);
                    boolean ok = true;
                    for (int j = 0; j < po.length; ++j) {
                        int a = po[j].x + x;
                        int b = po[j].y + y;
                        if (a >= grid[0].length() || b >= grid.length) {
                            ok=false;
                            break;
                        }
                        char c = grid[b].charAt(a);
                        if (c == '#') {
                            ok = false;
                            break;
                        }
                    }
 
                    if (ok) {
                        return i;
                    }
                }
 
            }
        }
        return 0;
 
    }
 
    public static void main(String[] args) {
        LargestCircle ll = new LargestCircle();
        int f=ll.radius(new String[] { "#####.......",
                "#####.......",
                "#####.......",
                "............",
                "............",
                "............",
                "............",
                "............",
                "............",
                "............" });
        System.out.println("result: "+f);
    }
}
