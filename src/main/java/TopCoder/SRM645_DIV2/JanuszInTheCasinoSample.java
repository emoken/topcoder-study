package TopCoder.SRM645_DIV2;

import java.util.HashMap;

public class JanuszInTheCasinoSample {
	int fields,games;
	long MAX =100000000000000L;
	HashMap<Long, Double> map = new HashMap<>();


	private double rec(int t, long people_rest) {
		
		long key = t*MAX + people_rest;
		
		if(map.containsKey(key)) return map.get(key);
		if(people_rest==0) return 0;
		if(t==games) return 1;
		
		int x = (int) (people_rest % fields);
		double res = 0;
		long a = (people_rest / fields), b = a+1;
		res += ((fields-x) / (double)fields) * rec(t + 1, people_rest - a);
		res += (x / (double)fields) * rec(t + 1, people_rest - b);

		map.put(key, res);
		return res;
	}
	
	public double findProbability(long n, int m, int k){
		this.fields=m;
		this.games=k;
		
		return rec(0, n);
	}


}
