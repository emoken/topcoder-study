package TopCoder.SRM223_DIV1;
import java.util.*;

/**
 * @author kenjiro.emoto
 *
 */
public class RevolvingDoors {

  int h;       // h  : Height
  int w;       // w  : Width
  int nd;      // nd : Number of Doors
  char[][] m;  // m  : Map
  boolean[][][] v;
  PQ q;
  static class Entry {
    public int key;
    public int x, y, d;
    public Entry(int key, int a, int b, int c) {
      this.key = key;
      x = a;
      y = b;
      d = c;
    }
    
	@Override
	public String toString() {
		return String.format("key=[%d],x=[%d],y=[%d],d=[%d]:",key,x,y,d);
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
    
    public void add(int key, int x, int y, int d) {
      q.add(null);
      int i = q.size() - 1;
      while (i > 0 && ((Entry) q.get(parent(i))).key > key) {
        q.set(i, q.get(parent(i)));
        i = parent(i);
      }
      q.set(i, new Entry(key, x, y, d));
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

  void add(Entry e, int dx, int dy) {

	// [bitwise XOR]
	// Basically, this is to "toggle" a door which is controlled as a binary representation.
	// To "toggle", bitwise XOR is used. 

	int x = e.x + dx;
    int y = e.y + dy;
    if (x < 0 || y < 0 || x >= w || y >= h || m[y][x] == '#') return;
    int k = e.key;
    int s = e.d;
    if (m[y][x] >= 150) {
      // h:at a cell located vertically(height) from the door.
      int d = m[y][x] - 150;
      if ((s & 1 << d) == 0) {
        if (dy == 0) return;
        k++;
        s = s ^ (1 << d); // bitwise XOR
      }
    } else if (m[y][x] >= 130) {
      // w:at a cell located horizontally(width) from the door.
      int d = m[y][x] - 130;
      if ((s & 1 << d) != 0) {
        if (dx == 0) return;
        k++;
        s = s ^ (1 << d); // bitwise XOR
      }
    }
    q.add(k, x, y, s);
  }

  public int turns(String[] map) {

    // initialization.
    h = map.length;
    w = map[0].length();
    m = new char[h][];
    
    // sd = "S"tart "D"oor
    int sx = -1, sy = -1, sd = 0, ex = -1, ey = -1;
    nd = 0;
    for (int i = 0; i < h; i++)
      m[i] = map[i].toCharArray();
    for (int i = 0; i < h; i++)
      for (int j = 0; j < w; j++)
        if (m[i][j] == 'S') {
          sx = j;
          sy = i;
        } else if (m[i][j] == 'E') {
          ex = j;
          ey = i;
        }

	// References:
	// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html
	// Signed left shift    = [ << ]
    // 
    // OR: https://en.wikipedia.org/wiki/Bitwise_operation#OR
    // Bitwise inclusive OR = [ |  ] : bitwise OR  : This technique is an efficient way to store a number of Boolean values using as little memory as possible.
	// Bitwise exclusive OR = [ ^  ] : bitwise XOR : This technique may be used to manipulate bit patterns representing sets of Boolean states.
    // 
    // TODO : cypher this code later, but it must do an initialization.
    for (int i = 0; i < h; i++)
      for (int j = 0; j < w; j++)
        if (m[i][j] == 'O') {
          if (m[i - 1][j] == '|') sd = sd | (1 << nd); // bitwise OR
          m[i - 1][j] = (char) (130 + nd); // 10000010
          m[i + 1][j] = (char) (130 + nd);
          m[i][j - 1] = (char) (150 + nd); // 10010110
          m[i][j + 1] = (char) (150 + nd);
          m[i][j] = '#';
          nd++;
        }

    v = new boolean[h][w][1 << nd];
    if (!safe(sx, sy, ex, ey)) return -1;
    q = new PQ();

//    printValues();
    
	// main
    q.add(0, sx, sy, sd);
    while (!q.isEmpty()) {
      Entry e = (Entry) q.popEntry();
      if (v[e.y][e.x][e.d]) continue;
      v[e.y][e.x][e.d] = true;
      if (ey == e.y && e.x == ex) {
    	  printValues();
    	  return e.key;
      }
      add(e, 1, 0);
      add(e, 0, 1);
      add(e, -1, 0);
      add(e, 0, -1);
    }
    return -1;
  }

  void add2(Entry e, int dx, int dy) {
    int x = e.x + dx;
    int y = e.y + dy;
    if (x < 0 || y < 0 || x >= w || y >= h || m[y][x] == '#') return;
    q.add(e.key, x, y, 0);
  }

  boolean safe(int sx, int sy, int ex, int ey) {
    q = new PQ();
    q.add(0, sx, sy, 0);
    boolean[][] v = new boolean[h][w];
    while (!q.isEmpty()) {
      Entry e = (Entry) q.popEntry();
      if (v[e.y][e.x]) continue;
      v[e.y][e.x] = true;
      if (ey == e.y && e.x == ex) return true;
      add2(e, 1, 0);
      add2(e, 0, 1);
      add2(e, -1, 0);
      add2(e, 0, -1);
    }
    return false;
  }

  private void printValues(){
	  if(DEBUG){
		  System.out.println("---- m ----");
		  for(char[] m_array:m){
			  System.out.println(String.format("DEBUG:%s",String.copyValueOf(m_array)));
		  }
		  System.out.println("---- v ----");
		  for(int i=0;i<v.length;i++){
			  boolean[][] v_array = v[i];
			  for(int j=0;j<v_array.length;j++){
				  boolean[] v_array2 = v[i][j];
				  System.out.println(String.format("DEBUG:[%d][%d]=%s", i, j, Arrays.toString(v_array2)));
			  }
		  }
	  }
  }

  private static final boolean DEBUG=true;
}
