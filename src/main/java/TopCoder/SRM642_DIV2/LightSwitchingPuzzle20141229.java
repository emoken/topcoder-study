package TopCoder.SRM642_DIV2;

public class LightSwitchingPuzzle20141229 {

	private int arraySize;

	public int minFlips(String state){
		
		arraySize = state.length();
		int[] stateArray = new int[arraySize];
		char[] stateChars = state.toCharArray();
		for(int i=0;i<arraySize;i++){
			stateArray[i] = stateChars[i] == 'Y' ? 1 : -1;
		}

		//------------
		// Check irregular cases: all are N or Y
		//------------
		int checkResult = checkAllIsSame(stateArray);
		if( checkResult == 1 ){
			// all is N
			return 0;
		}
		if( checkResult == 2 ){
			// all is Y
			return 1;
		}

		//------------
		// Main
		//------------
		int switchCounter=0;
		
		int[] switchArray = new int[arraySize];
		for(int i=0;i<arraySize;i++){
			switchArray[i]=1;
		}

		while(true){
			
			// determining switch logic.
			// here
			
			// executing switch logic.
			// here			
			
			checkResult = checkAllIsSame(stateArray);
			if( checkResult == 1 ){
				// all is N
				return switchCounter;
			}
			if( checkResult == 2 ){
				// all is Y
				return switchCounter + 1;
			}
			
			if(switchCounter == (arraySize-1)){
				return -1;
			}
		}
		
	}

	private int checkAllIsSame(int[] stateArray){
		int count = 0;
		for(int intVal : stateArray){
			count = count + intVal;
		}
		
		if(arraySize == count){
			return 2;
		}else if( arraySize == Math.abs(count) ){
			return 1;
		}

		return -1;
	}

}
