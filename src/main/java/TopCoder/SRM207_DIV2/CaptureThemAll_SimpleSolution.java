package TopCoder.SRM207_DIV2;

import java.util.ArrayList;

public class CaptureThemAll_SimpleSolution {
	
	private int[] convertSquare(String s){
		char[] c = s.toCharArray();
		int column = c[0] - 'a';
		int row = Character.getNumericValue(c[1]) - 1;
		return new int[] {column,row};
	}

	public int fastKnight(String knight, String rook, String queen){

		// square positions.
		int[] knightXY = convertSquare(knight);
		int[] rookXY = convertSquare(rook);
		int[] queenXY = convertSquare(queen);

		int knightToRook = calcMimDistance(knightXY, rookXY);
		int knightToQueen = calcMimDistance(knightXY, queenXY);
		int queenToRook = calcMimDistance(queenXY, rookXY);
		
		return Math.min(knightToQueen + queenToRook, knightToRook + queenToRook);
	}

	private int calcMimDistance(int[] startXY, int[] endXY) {

		if(startXY[0] == endXY[0] && startXY[1] == endXY[1]){
			// reached the "endXY"
			return 0;
		}
		
		int[][] distances = new int[8][8];
	    int[][] queue = new int[64][2];
	    queue[0][0] = startXY[0];
	    queue[0][1] = startXY[1];

	    for (int i = 0; i<8; i++){
	        for (int j = 0; j<8; j++){
	            distances[i][j] = -1;//Using -1 for infinity
	        }
	    }
	    
	    distances[startXY[0]][startXY[1]] = 0;
	    int head = 0;
	    int tail = 1;

	    while(tail > head){
	        int x = queue[head][0];
	        int y = queue[head][1];
	        head++;

	        for(int[] nextXY: getReachableXY(x, y)){
	        	if(distances[nextXY[0]][nextXY[1]] == -1){
	        		
	        		if(nextXY[0] == endXY[0] && nextXY[1] == endXY[1]){
	        			// reached the "endXY"
	        			return distances[x][y] + 1;
	        		}

	        		distances[nextXY[0]][nextXY[1]] = distances[x][y] + 1;
	        		queue[tail][0] = nextXY[0];
	        		queue[tail][1] = nextXY[1];
	        		tail++;
	            }
	        }
	    }
	    
	    return -1;
	}

	private ArrayList<int[]> getReachableXY(int nowX, int nowY) {
		int nextX=0;
		int nextY=0;
		ArrayList<int[]> tmp = new ArrayList<int[]>();
		nextX = nowX - 2; nextY = nowY - 1; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		nextX = nowX - 2; nextY = nowY + 1; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		nextX = nowX + 2; nextY = nowY - 1; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		nextX = nowX + 2; nextY = nowY + 1; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		nextX = nowX - 1; nextY = nowY - 2; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		nextX = nowX + 1; nextY = nowY - 2; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		nextX = nowX - 1; nextY = nowY + 2; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		nextX = nowX + 1; nextY = nowY + 2; if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){ tmp.add(new int[]{nextX,nextY});};
		return tmp;
	}

	public static void main(String[] args) {
        new CaptureThemAll_SimpleSolution().execute();
    }
 
    private void execute() {
    	// corner case
        System.out.println(fastKnight("a1","a1","a1"));

        // sample problems.
//        System.out.println(String.format("ANSWER=[%d]",fastKnight("a1","b3","c5")));
//        System.out.println(String.format("ANSWER=[%d]",fastKnight("b1","c3","a3")));
//        System.out.println(String.format("ANSWER=[%d]",fastKnight("a1","a2","b2")));
//        System.out.println(String.format("ANSWER=[%d]",fastKnight("a5","b7","e4")));
//        System.out.println(String.format("ANSWER=[%d]",fastKnight("h8","e2","d2")));
    }
}
