package TopCoder.SRM222_DIV1;

import java.util.ArrayList;

/**
 * @author kenjiro.emoto
 *
 */
public class WalkingHome {

  int h;       // h  : Height
  int w;       // w  : Width
  int nd;      // nd : Number of Doors
  char[][] m;  // m  : Map
  boolean[][] v; // v : visited flag.
  PQ q;
  
  public int fewestCrossings(String[] map){

  // ---------------------------
  // initialization
  // ---------------------------
    h = map.length;
    w = map[0].length();
    m = new char[h][];

    // Each element of map will contain only the characters '.', '-', '|', '*', 'F', 'S', 'H'.
    int sx = -1, sy = -1, ex = -1, ey = -1;
    for (int i = 0; i < h; i++)
      m[i] = map[i].toCharArray();
    for (int i = 0; i < h; i++)
      for (int j = 0; j < w; j++)
        if (m[i][j] == 'S') {
          sx = j;
          sy = i;
        } else if (m[i][j] == 'H') {
          ex = j;
          ey = i;
//        } else if (m[i][j] == '*') {
        	// '*', 'F' are both impassable, so unify the string
//        	m[i][j]='F';
        }
    
  // ---------------------------
  // main
  // ---------------------------
    v = new boolean[h][w];
    q = new PQ();
  
  q.add(0, sx, sy);
  while (!q.isEmpty()) {
    Entry e = (Entry) q.popEntry();
    if (v[e.y][e.x]) continue;
    v[e.y][e.x] = true;
    if (ey == e.y && e.x == ex) {
  	  return e.key;
    }
    add(e, 1, 0);
    add(e, 0, 1);
    add(e, -1, 0);
    add(e, 0, -1);
  }

    return -1;
  }


  void add(Entry e, int dx, int dy) {

    // Each element of map will contain only the characters '.', '-', '|', '*', 'F', 'S', 'H'.
	int x = e.x + dx;
    int y = e.y + dy;
    
    // [check]
    // obvious impassable cells
    if (x < 0 || y < 0 || x >= w || y >= h || m[y][x] == '*' || m[y][x] == 'F' ) return;
    // conditional impassable cells
    if ( (dx != 0 && m[y][x] == '-') || (dy != 0 && m[y][x] == '|') ) return;

    int k = e.key;
    
    if( (m[y][x] == '|') || (m[y][x] == '-') ){

        if( (m[e.y][e.x] == '|' && m[y][x] == '|') || 
        		(m[e.y][e.x] == '-' && m[y][x] == '-') ){
        	// does nothing.
        }else{
        	k++;
        }
    }
    q.add(k, x, y);
  }

  static class Entry {
	    public int key;
	    public int x, y;
	    public Entry(int key, int a, int b) {
	      this.key = key;
	      x = a;
	      y = b;
	    }
	    
		@Override
		public String toString() {
			return String.format("key=[%d],x=[%d],y=[%d]:",key,x,y);
		}
	  }

	  static class PQ {
	    ArrayList q = new ArrayList();
	  
	    public boolean isEmpty() {
	      return q.isEmpty();
	    }
	  
	    int parent(int i) {
	      return (i+1)/2-1;
	    }
	    int left(int i) {
	      return (i+1)*2-1;
	    }
	    int right(int i) {
	      return (i+1)*2;
	    }
	    
	    // NOTE:
	    // below add() and popEntry() are manipulation methods to build a "binary heap"..
	    // https://en.wikipedia.org/wiki/Binary_heap#Heap_implementation
	    public void add(int key, int x, int y) {
	      q.add(null);
	      int i = q.size() - 1;
	      while (i > 0 && ((Entry) q.get(parent(i))).key > key) {
	        q.set(i, q.get(parent(i)));
	        i = parent(i);
	      }
	      q.set(i, new Entry(key, x, y));
	    }
	    public Entry popEntry() {
	      Entry e = (Entry) q.get(0);
	      q.set(0, q.get(q.size() - 1));
	      q.remove(q.size() - 1);
	    
	      int i = 0;
	      boolean done = false;
	      while (!done) {
	        int l = left(i), r = right(i);
	        int min = i;
	        if (l < q.size() && ((Entry) q.get(l)).key < ((Entry) q.get(min)).key) {
	          min = l;
	        }
	        if (r < q.size() && ((Entry) q.get(r)).key < ((Entry) q.get(min)).key) {
	          min = r;
	        }
	        if (min != i) {
	          Object temp = q.get(min);
	          q.set(min, q.get(i));
	          q.set(i, temp);
	          i = min;
	        } else {
	          done = true;
	        }
	      }
	      return e;
	    }

		@Override
		public String toString() {
			return q.toString();
		}
	  }

}
