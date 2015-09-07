package TopCoder.SRM626_DIV2;

public class SumOfPower_Good {

	public int findSum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				for (int k = j; k < j + i + 1; k++) {
					sum += array[k];
				}
			}
		}
		return sum;
	}
}
