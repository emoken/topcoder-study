package TopCoder.SRM634_DIV2;

// 2014.10.3(Fri): submission result:75.04 points.
// 2014.10.4(sAT): submission result:75.00 points.
public class MountainRanges{

	public int countPeaks(int[] heights){
		
		int peakCounter=0;
		
		for(int i=0;i<heights.length;i++){

			int previousElement = (0<=i-1)? heights[i-1]:-1;
			int nextElement = (i+1 < heights.length)? heights[i+1]:-1;

			// determine the current is a peak.
			if(previousElement < heights[i] && nextElement < heights[i]){
				peakCounter++;
			}
		}
		
		return peakCounter;
	}
	
	public static void main(String[] args) {
		int[] intArray = new int[args.length];
		int index=0;
		for(String s:args){
			intArray[index++] = Integer.parseInt(s);
		}
		System.out.print(new MountainRanges().countPeaks(intArray));
	}
}

// Problem Statement

// Tom is in charge of a tourist agency.
//  He has a lovely picture of the local mountain range.
//  He would like to sell it to the tourists but first he needs to know how many peaks are visible in the picture.

// The mountain range in the picture can be seen as a sequence of heights.
//  You are given these heights as a int[] height.
//  An element of height is called a peak if its value is strictly greater than each of the values of adjacent elements.
//  Compute and return the number of peaks in the given mountain range.

// Definition

// Class:
// MountainRanges
// Method:
// countPeaks
// Parameters:
// int[]
// Returns:
// int
// Method signature:
// int countPeaks(int[] heights)
// (be sure your method is public)
// Limits

// Time limit (s):
// 2.000
// Memory limit (MB):
// 256
// Constraints
// -
// heights will contain between 1 and 50 elements, inclusive.
// -
// Each element of heights will be between 1 and 100, inclusive.
// Examples
// 0)


// {5, 6, 2, 4}
// Returns: 2
// Element 1 (0-based index) is a peak. Its height is 6, which is strictly greater than each of its neighbors' heights (5 and 2). Element 3 is also a peak since its height is 4 and that is strictly greater than its neighbor's height (which is 2).
// 1)


// {1, 1, 1, 1, 1, 1, 1}
// Returns: 0
// This is a very flat mountain with no peaks.
// 2)


// {2, 1}
// Returns: 1
// Element 0 is a peak.
// 3)


// {2,5,3,7,2,8,1,3,1}
// Returns: 4
// The peaks here are the elements with 0-based indices 1, 3, 5, and 7. Their heights are 5, 7, 8, and 3, respectively.
// 4)


// {1}
// Returns: 1
// Element 0 is a peak. Even though it has no neighbors, the condition from the problem statement is still satisfied.
// 5)


// {1,2,3,4,4,3,2,1}
// Returns: 0
// According to our definition there is no peak in this mountain range.

