package TopCoder.SRM648_DIV2;

public class KitayutaMart2 {

	public int numBought(int initialPrice, int total){
		
		int counter=1;
		
		return calc(initialPrice,total,initialPrice,counter);
	}

	private int calc(int initialPrice, int total, int calculatedTotal, int counter) {

		int base = (int) (counter==1? 0: Math.pow(2,(counter-1)));
		calculatedTotal = (int) (calculatedTotal + ( base * initialPrice));

		if(total==calculatedTotal){
			return counter;
		}
		
		System.out.println(String.format("DEBUG:counter[%s],calculatedTotal[%s]",counter,calculatedTotal));
		return calc(initialPrice, total, calculatedTotal, ++counter);
	}

}
