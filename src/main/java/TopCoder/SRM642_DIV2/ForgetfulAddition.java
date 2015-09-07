package TopCoder.SRM642_DIV2;

public class ForgetfulAddition {

	public int minNumber(String expression){
		
		int min=Integer.MAX_VALUE;
		
		for(int i = 1;i<expression.length();i++){
			int right = Integer.valueOf(expression.substring(0,i)).intValue();
			int left = Integer.valueOf(expression.substring(i)).intValue();
			
			if(min > (right + left) ){
				min = right + left;
			}
		}
		return min;
	}
}
