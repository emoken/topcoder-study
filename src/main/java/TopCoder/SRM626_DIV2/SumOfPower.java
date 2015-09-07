package TopCoder.SRM626_DIV2;

public class SumOfPower {

	public int findSum(int[] array){

		int resultValue = 0;
		int arraySize = array.length ;
		int numOfElements=1;

		for(int i=0;i<arraySize;i++){
			for(int j=0;j<arraySize;j++){

				if( j+numOfElements > arraySize) break;
				
				for(int k=0;k < numOfElements;k++){
					resultValue = resultValue + array[j + k];
				}
			}
			numOfElements++;
		}
		return resultValue;
	}

	
	public static void main(String[] args) {
		
		int[] intArray = new int[args.length];
		int index=0;
		for(String s:args){
			intArray[index++] = Integer.parseInt(s);
		}
		SumOfPower main = new SumOfPower();
		System.out.print(main.findSum(intArray));
	}
}


//
//Problem Statement
//You are given a int[] array. At any moment, you may choose a nonempty contiguous subsequence of array. 
//Whenever you do so, you will gain power equal to the sum of all elements in the chosen subsequence.
//You chose each possible contiguous subsequence exactly once, each time gaining some power. 
//Compute and return the total amount of power you gained.
//
//Definition
//Class:
//SumOfPower
//Method:
//findSum
//Parameters:
//int[]
//Returns:
//int
//Method signature:
//int findSum(int[] array)
//(be sure your method is public)
//Limits
//
//Time limit (s):
//2.000
//Memory limit (MB):
//256
//Constraints
//-
//array will contain between 1 and 50 elements, inclusive.
//-
//Each element in array will be between 1 and 100, inclusive.
//Examples
//0)
//
//
//{1,2}
//Returns: 6
//We have the following three contiguous subsequences:
//{1} => 1
//{2} => 2
//{1,2} => 3
//Thus, the sum of all possible powers is 1+2+3=6.
//1)
//
//
//{1,1,1}
//Returns: 10
//A 3-element sequence has 6 possible nonempty contiguous subsequences. 
//For the sequence {1,1,1} these are the subsequences: {1}, {1}, {1}, {1,1}, {1,1}, and {1,1,1}. 
//Their sums are 1, 1, 1, 2, 2, and 3. If you choose each of them once, the total power you'll gain is 1+1+1+2+2+3 = 10.
//2)
//
//
//{3,14,15,92,65}
//Returns: 1323
//
//3)
//
//
//{1,2,3,4,5,6,7,8,9,10}
//Returns: 1210
//
//This problem statement is the exclusive and proprietary property of TopCoder, Inc. 
//Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. 
//(c)2003, TopCoder, Inc. All rights reserved.
