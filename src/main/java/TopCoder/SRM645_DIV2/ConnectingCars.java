package TopCoder.SRM645_DIV2;

import java.util.Map;
import java.util.TreeMap;

public class ConnectingCars {

	public long minimizeCost(int[] positions, int[] lengths){
		
		int N = positions.length;
		int M = N-1;
		int[] costs = new int[M];
		
		Map<Integer,Integer> startMap = new TreeMap<>();
		for(int i=0;i<N;i++){
			startMap.put(positions[i], lengths[i]);
		}
		
		Integer[] positionsInOrder = (Integer[])startMap.keySet().toArray(new Integer[startMap.size()]);
		
		for(int i=0;i<M;i++){
			costs[i] = positionsInOrder[i+1] - (positionsInOrder[i] + startMap.get(positionsInOrder[i]));
		}

		for(int i=0;i<M;i++){
			int fromLeft = i + 1;
			int fromRight = M-i;
			costs[i] = Math.min(fromLeft, fromRight) * costs[i];
		}
		
		long minTotalCost=0;
		for(int cost:costs){
			minTotalCost += cost;
		}
		
		return minTotalCost;
	}
}
