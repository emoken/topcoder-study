package TopCoder.SRM646_DIV2;

import java.util.Arrays;

public class TheConsecutiveIntegersDivTwo {

	public int find(int[] numbers, int k){

		// corner case.
		if(k==1){
			return 0;
		}

		// main
		int N = numbers.length;
		int minDistance=Integer.MAX_VALUE;
		Arrays.sort(numbers);
		
		for(int i=0;i<N-1;i++){
			minDistance = Math.min(minDistance, Math.abs(numbers[i]-numbers[i+1]));
		}
		
		return minDistance-1;
	}
}
