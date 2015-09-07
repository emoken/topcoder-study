package TopCoder.SRM642_DIV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TallShoes_sample {

  long INF = Long.MAX_VALUE;
  long[] minCost;
  ArrayList<Edge>[] g;
//  int N;
  
  class Edge {
    int to;
    int height;
    
    Edge(int to, int height){
      this.to=to;
      this.height=height;
    }
  }
  
  class State implements Comparable<State>{
    int n;
    State(int n){
      this.n=n;
    }
    @Override
    public int compareTo(State s) {
      if(minCost[n] > minCost[s.n]) return 1;
      else if(minCost[n] < minCost[s.n]) return -1;
      else return 0;
    }
  }
  
  long dijkstra(long h){
    int n = g.length;
    
    Arrays.fill(minCost, INF);
    minCost[0] = 0;
    
    PriorityQueue<State> pq= new PriorityQueue<TallShoes_sample.State>();
    pq.add(new State(0));
    
    while(!pq.isEmpty()){
      State next = pq.poll();
      
      for(Edge v : g[next.n]){
        if(minCost[next.n] + mult(Math.max(0, h - v.height)) < minCost[v.to]){
          minCost[v.to] = minCost[next.n] + mult(Math.max(0, h - v.height));
          pq.add(new State(v.to));
        }
      }
    }
    
    return minCost[n-1];
  }
  
  long mult(long a){
    return a*a;
  }
  
  public int maxHeight(int N, int[] X, int[] Y, int[] height, long B){
    int M = X.length;
    
    // init.
    g = new ArrayList[N];
    for(int i=0;i<N;i++)
      g[i] = new ArrayList<Edge>();
    minCost = new long[N];
    
    for(int i=0;i<M;i++){
      g[X[i]].add(new Edge(Y[i], height[i]));
      g[Y[i]].add(new Edge(X[i], height[i]));
    }

    // main
    int lo = 0, hi = 100010000;
    int debugCnt=0;
    while(lo < hi -1){
      debugCnt++;
      
      int mid = (lo + hi)/2;
      if(dijkstra(mid) <= B) lo = mid;
      else hi = mid;
      
      System.err.println(String.format("loop[%d]:lo=[%d],hi=[%d],mid=[%d]",debugCnt, lo,hi,mid));
    }
    return lo;
  }
}
