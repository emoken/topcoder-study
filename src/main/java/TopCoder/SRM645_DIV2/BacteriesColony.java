package TopCoder.SRM645_DIV2;

public class BacteriesColony {

	public int[] performTheExperiment(int[] colonies){
		int N=colonies.length;
		
		while(true){
			
			int[] checkResult = new int[N];
			int count=0;
			
			for(int i=1;i<N-1;i++){
				if(colonies[i] > colonies[i-1] && colonies[i] > colonies[i+1]){
					checkResult[i]=-1;
					count++;
				}
				if(colonies[i] < colonies[i-1] && colonies[i] < colonies[i+1]){
					checkResult[i]=1;
					count++;
				}
			}

			for(int i=1;i<N-1;i++){
				colonies[i] += checkResult[i];
			}
			
			if(count==0){
				break;
			}
		}
		
		return colonies;
	}
	
}
