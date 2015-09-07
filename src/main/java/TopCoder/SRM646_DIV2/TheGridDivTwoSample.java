package TopCoder.SRM646_DIV2;

import java.util.LinkedList;

public class TheGridDivTwoSample {

	static class State{
		int x;
		int y;
		int k;
		
		public State(int x,int y,int k){
			this.x=x;
			this.y=y;
			this.k=k;
		}
	}
	
	public int find(int[] x, int[] y, int k){
		
		boolean[][] visited = new boolean[4002][4002];
		
		for(int i=0;i<y.length;i++){
			visited[y[i]+2000][x[i]+2000] = true;
		}
		
		LinkedList<State> q = new LinkedList<State>();
		q.add(new State(0,0,0));
		
		int maxX=0;
		
		while(!q.isEmpty()){
			State s = q.poll();
			
			if(!visited[s.y+2000][s.x+2000]){
				maxX = Math.max(s.x, maxX);
				visited[s.y+2000][s.x+2000]=true;
				if(s.k != k){
					q.add(new State(s.x+1,s.y,s.k+1));
					q.add(new State(s.x-1,s.y,s.k+1));
					q.add(new State(s.x,s.y+1,s.k+1));
					q.add(new State(s.x,s.y-1,s.k+1));
				}
			}
		}
		
		return maxX;
	}
}
