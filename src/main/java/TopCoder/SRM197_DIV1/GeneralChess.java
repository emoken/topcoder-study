package TopCoder.SRM197_DIV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralChess {

    public String[] attackPositions(String[] pieces){
	
	// for each [pieces], store all ["8"] [y][x] coordinates.
	int[][][] bitmap = new int[pieces.length][8][2];

	for(int i=0;i<pieces.length;i++){

	    String[] s= pieces[i].split(",");
	    int y=Integer.valueOf(s[0]);
	    int x=Integer.valueOf(s[1]);
	    
	    bitmap[i][0][0] = y+2;
	    bitmap[i][0][1] = x+1;
	    bitmap[i][1][0] = y+2;
	    bitmap[i][1][1] = x-1;

	    bitmap[i][2][0] = y+1;
	    bitmap[i][2][1] = x+2;
	    bitmap[i][3][0] = y+1;
	    bitmap[i][3][1] = x-2;

	    bitmap[i][4][0] = y-1;
	    bitmap[i][4][1] = x-2;
	    bitmap[i][5][0] = y-1;
	    bitmap[i][5][1] = x+2;

	    bitmap[i][6][0] = y-2;
	    bitmap[i][6][1] = x-1;
	    bitmap[i][7][0] = y-2;
	    bitmap[i][7][1] = x+1;
	    
	}
	
	Map<String,String> finalResult = new HashMap<>();

	for(int j=0;j<8;j++){
	    finalResult.put(String.format("%d,%d", bitmap[0][j][0], bitmap[0][j][1]),"");
	}

	// corner case
	if(pieces.length==1){
		return finalResult.keySet().stream().toArray(String[]::new);
	}

	// main
	// find matches.
	for(int i=1;i<pieces.length;i++){
	    
	    Map<String,String> tmpResult = new HashMap<>();
	    for(int j=0;j<8;j++){
		    tmpResult.put(String.format("%d,%d", bitmap[i][j][0], bitmap[i][j][1]),"");
	    }
	    
	    List<String> t = new ArrayList<>(tmpResult.keySet());
	    for(String key:t){
		if( ! finalResult.containsKey(key)){
		    tmpResult.remove(key);
		}
	    }

	    if(tmpResult.isEmpty()) return new String[]{};
	    
	    finalResult = tmpResult;
	}

	return finalResult.keySet().stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
	
	GeneralChess myObject = new GeneralChess();
	System.out.println(Arrays.toString(myObject.attackPositions(new String[]{"0,0"})));
	System.out.println(Arrays.toString(myObject.attackPositions(new String[]{"2,1", "-1,-2"})));
	System.out.println(Arrays.toString(myObject.attackPositions(new String[]{"0,0", "2,1"})));
	System.out.println(Arrays.toString(myObject.attackPositions(new String[]{"-1000,1000", "-999,999", "-999,997"})));

    }

}
