package TopCoder.SRM626_DIV2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class NegativeGraphDiv2 {

	private int Nmax = 50 + 2;
	private int Cmax = 1000 + 2;
	private int INF = Integer.MAX_VALUE;

    private Map <Integer,List<Pair>> G = new HashMap<Integer,List<Pair>>();
    private Queue <Pair> Q = new LinkedList<>();
    private long A[][] = new long[Nmax][Cmax];
    
    private class Pair{
    	int first;
    	int second;
    	public Pair(int first,int second){
    		this.first = first;
    		this.second = second;
    	}
		@Override
		public String toString() {
			return String.format("%d,%d", first,second);
		}
    }

	public long findMin(int N, int[] s, int[] t, int[] weight, int charges){
		
		int E = s.length;
		
        for ( int i = 0; i < E; ++i )
        {
        		if(G.get(s[i]) == null){
        			G.put(s[i], new ArrayList<Pair>());
        		}
                G.get(s[i]).add( new Pair( t[i], weight[i] ) );
        }

        for ( int i = 1; i <= N; ++i )
        {
            for ( int j = 0; j <= charges; ++j )
                    A[i][j] = INF;
        }
        
        A[1][charges] = 0;
        
        Q.add(new Pair(1,charges));

        while(Q.size()>0){
        	int nod = Q.peek().first;
        	int charge_nod = Q.peek().second;
        	Q.poll();
        	
            for ( int i = 0; i < G.get(nod).size(); ++i )
            {
                int vecin = G.get(nod).get(i).first;
                long cost = G.get(nod).get(i).second;

                if ( A[vecin][charge_nod] > A[nod][charge_nod] + cost )
                {
                    A[vecin][charge_nod] = A[nod][charge_nod] + cost;
                    Q.add( new Pair( vecin, charge_nod ) );
                }

                if ( charge_nod > 0 )
                {
                    if ( A[vecin][charge_nod - 1] > A[nod][charge_nod] - cost )
                    {
                        A[vecin][charge_nod - 1] = A[nod][charge_nod] - cost;
                        Q.add( new Pair( vecin, charge_nod - 1 ) );
                    }
                }
            }
        }
        
        long minim = INF;
        
        for ( int j = 0; j <= charges; ++j )
            minim = min( minim, A[N][j] );
        
		return minim;
	}
	
	private long min(long a, long b){
		if(a>b){
			return b;
		}else{
			return a;
		}
	}
	
	public static void main(String[] args) {
		NegativeGraphDiv2 main = new NegativeGraphDiv2();
		main.solution();
	}
	
	private void solution(){

//		Scanner scanner = new Scanner(SYSTEM_IN);
//		String n = scanner.nextLine();
//		String s = scanner.nextLine();
//		String t = scanner.nextLine();
//		String weight = scanner.nextLine();
//		String charges = scanner.nextLine();
//		scanner.close();

		long result1 = findMin(
				3, 
				new int[]{1, 1, 2, 2, 3, 3},
				new int[]{2, 3, 1, 3, 1, 2},
				new int[]{1, 5, 1, 10, 1, 1},
				1
				);
		System.out.println(result1);

		long result2 = findMin(
				1, 
				new int[]{1},
				new int[]{1},
				new int[]{100},
				1000
				);
		System.out.println(result2);

	};

	private InputStream SYSTEM_IN = System.in;
	public InputStream getSystemIn() {
		return SYSTEM_IN;
	}
	public void setSystemIn(InputStream systemIn) {
		SYSTEM_IN = systemIn;
	}
	private void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}
}


//
//Problem Statement
//    
//Nancy has a directed graph with N vertices and E edges.
// The vertices are numbered 1 through N.
// Each edge of the graph has a positive integer weight.
// This graph is described by three int[]s with E elements each: s, t, and weight.
// For each valid i, the graph contains an edge from s[i] to t[i], and its weight is weight[i].
// Note that Nancy's graph may contain multiple edges with the same start and end.
// It may also contain self-loops.
//
//Nancy is currently standing in the vertex 1.
// She can reach other vertices by moving along the edges.
// The cost of using an edge is equal to its weight.
// Nancy's goal is to reach the vertex N and to minimize the total cost of doing so.
//
//Nancy has a special power she can use to make her travels cheaper.
// Whenever she traverses an edge, she can use that special power to make the weight of that edge temporarily negative.
// You are given an int charges: the number of times Nancy can use her special power.
// Each use of the special power only works for one traversal of an edge.
// Nancy can traverse each edge arbitrarily many times.
// Each time she traverses an edge, she may use her special power, if she still has some charges left.
//
//Compute and return the minimal total cost of Nancy's journey.
//
//Definition
//    
//Class:
//NegativeGraphDiv2
//Method:
//findMin
//Parameters:
//int, int[], int[], int[], int
//Returns:
//long
//Method signature:
//long findMin(int N, int[] s, int[] t, int[] weight, int charges)
//(be sure your method is public)
//Limits
//    
//Time limit (s):
//2.000
//Memory limit (MB):
//256
//Constraints
//-
//N will be between 1 and 50, inclusive.
//-
//E will be between 1 and 2500, inclusive.
//-
//s, t, weight will each contain exactly E elements.
//-
//s and t will only contain numbers between 1 and N, inclusive.
//-
//There will be a path from node 1 to node N.
//-
//weight will contain numbers between 0 and 100,000, inclusive.
//-
//charges will be between 0 and 1,000, inclusive.
//Examples
//0)
//
//    
//3
//{1,1,2,2,3,3}
//{2,3,1,3,1,2}
//{1,5,1,10,1,1}
//1
//Returns: -9
//The optimal path for Nancy is 1->2->3, and using her single charge on the last edge.
//1)
//
//    
//1
//{1}
//{1}
//{100}
//1000
//Returns: -100000
//The graph may contain self-loops. Here, the optimal solution is that Nancy uses the self-loop 1,000 times, each time using her special power to change its cost from 100 to -100.
//2)
//
//    
//2
//{1,1,2}
//{2,2,1}
//{6,1,4}
//2
//Returns: -9
//There can be multiple edges between vertices.
//3)
//
//    
//2
//{1}
//{2}
//{98765}
//100
//Returns: -98765
//Nancy may not be able to use all her charges.
//This problem statement is the exclusive and proprietary property of TopCoder, Inc. 
//Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
//
