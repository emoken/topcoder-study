package TopCoder.SRM645_DIV2;

import java.util.HashMap;
import java.util.Map;

public class JanuszInTheCasino {

	long people;	// n : n will be between 1 and 10^12, inclusive.
	int fields;		// m : m and k will be between 1 and 50, inclusive.
	int games;		// k : m and k will be between 1 and 50, inclusive.
	
	long keyValueBase = 10000000000000L; // 10^13
	
	Map<Long, Double> cache = new HashMap<Long, Double>();
	
	public double findProbability(long n, int m, int k){
		people=n;
		fields=m;
		games=k;
		
		return calcProbability(0, people);
	}

	private double calcProbability(int numOfRounds, long currentPeople) {
		
		if(currentPeople==0){
			return 0;
		}

		if(numOfRounds==games){
			// when games are played as the number of rounds given, 
			// and there are people remaining, then the game is won.
			return 1;
		}

		long key = (keyValueBase * numOfRounds) + currentPeople;
		
		if(cache.containsKey(key)){
			return cache.get(key);
		}
		
		long remainingPeople = currentPeople%fields;
		long lowNumPerlField = currentPeople/fields;
		long highNumPerField = lowNumPerlField+1;
		
		double probability=0;
		
		probability += ((double)(fields-remainingPeople)/fields) * calcProbability(numOfRounds+1, currentPeople-lowNumPerlField);
		probability += ((double)remainingPeople/fields) * calcProbability(numOfRounds+1, currentPeople-highNumPerField);
		
		cache.put(key, probability);
		
		return probability;
	}


}
