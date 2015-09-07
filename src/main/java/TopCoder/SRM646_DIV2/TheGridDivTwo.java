package TopCoder.SRM646_DIV2;

import java.util.HashMap;
import java.util.Map;

public class TheGridDivTwo {

	int max_x=0;
	int MOD_GRID=1000;
	boolean[][] _blocks = new boolean[2002][2002];
	
	Map<Long,Integer> cache = new HashMap<Long,Integer>();
	
	public int find(int[] x, int[] y, int k){
		
		// k will be between 1 and 1,000, inclusive
		// x will contain between 0 and 47 elements, inclusive.
		// x and y will contain the same number of elements.
		// Each element of x will be between -1,000 and 1,000, inclusive.
		// Each element of y will be between -1,000 and 1,000, inclusive.
		
		// corner case.
		if(x.length==0){
			return k;
		}
		
		// main
		for(int i=0;i<x.length;i++){
			_blocks[x[i]+MOD_GRID][y[i]+MOD_GRID]=true;
		}
		recursive(new int[]{1000,1000},k);
		
		return max_x;
	}

	private int recursive(int[] coordinates, int remaining) {
//		System.out.println(
//				String.format("x[%d]y[%d], remaining=[%d]", coordinates[0] - MOD_GRID,coordinates[1] - MOD_GRID,remaining));
		
		long key = (coordinates[0] * 10000000000L) + (coordinates[1] * 10000) + remaining;
		
		if(cache.containsKey(key)){
			return cache.get(key);
		}
		
		if(_blocks[coordinates[0] + 1][coordinates[1]] && 
				_blocks[coordinates[0] - 1][coordinates[1]] &&
				_blocks[coordinates[0]][coordinates[1] + 1] &&
				_blocks[coordinates[0]][coordinates[1] - 1] ){
			return Math.max((coordinates[0]-MOD_GRID), max_x);
		}
		
		if(remaining==0){
			max_x = Math.max((coordinates[0]-MOD_GRID), max_x);
//			System.out.println("MAX="+max_x);
			return max_x;
		}
		
		int maxVal=0;
		
		// right(east)
		if(!_blocks[coordinates[0] + 1][coordinates[1]]) {
			maxVal = Math.max(recursive(new int[]{coordinates[0] + 1,coordinates[1]}, remaining-1),maxVal);
		}

		// left(west)
		if(!_blocks[coordinates[0] - 1][coordinates[1]]) {
			maxVal = Math.max(recursive(new int[]{coordinates[0] - 1,coordinates[1]}, remaining-1),maxVal);
		}

		// up(north)
		if(!_blocks[coordinates[0]][coordinates[1] + 1]) {
			maxVal = Math.max(recursive(new int[]{coordinates[0],coordinates[1] + 1}, remaining-1),maxVal);
		}
		
		// down(south)
		if(!_blocks[coordinates[0]][coordinates[1] - 1]) {
			maxVal = Math.max(recursive(new int[]{coordinates[0],coordinates[1] - 1}, remaining-1),maxVal);
		}

		cache.put(key,maxVal);

		return maxVal;
	}

}
