package TopCoder.SRM642_DIV2;

import java.util.ArrayList;

public class TallShoes {

	long INF = Long.MAX_VALUE;
	long[] minCost;
	ArrayList<Edge>[] g;

	public int maxHeight(int N, int[] X, int[] Y, int[] height, long B){

		// --------------------
		//  preparation.
		// --------------------
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

		// --------------------
		//  main.
		// --------------------
	    
	    
	    
		return 0;
	}

  class Edge {
	    int to;
	    int height;
	    
	    Edge(int to, int height){
	      this.to=to;
	      this.height=height;
	    }
	  }

}
