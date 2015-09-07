package TopCoder.SRM207_DIV2;

import java.util.LinkedList;
import java.util.Queue;

public class CaptureThemAll {

	// status.
	int[][] counter;
	boolean[][] rookCaptured;
	boolean[][] queenCaptured;

	// square positions.
	Integer[] knight;
	Integer[] rook;
	Integer[] queen;
	Queue<Integer[]> Q;
	
	private Integer[] convertSquare(String s){
		char[] c = s.toCharArray();
		int column = c[0] - 'a';
		int row = Character.getNumericValue(c[1]) - 1;
		return new Integer[] {column,row};
	}

	public int fastKnight(String knight, String rook, String queen){

		counter = new int[8][8];
		rookCaptured = new boolean[8][8];
		queenCaptured = new boolean[8][8];
		
		Q = new LinkedList<Integer[]>();

		this.knight = convertSquare(knight);
		this.rook = convertSquare(rook);
		this.queen = convertSquare(queen);

		System.out.println("-----------------------------------------------------");
		System.out.println(String.format("start :knight[%d][%d]", this.knight[0],this.knight[1]));
		System.out.println(String.format("target:queen [%d][%d]", this.queen[0],this.queen[1]));
		System.out.println(String.format("target:rook  [%d][%d]", this.rook[0],this.rook[1]));
		System.out.println("-----------------------------------------------------");

		// first case.
		Integer[] startSquare = this.knight;
		
		if(this.queen[0] == startSquare[0] && this.queen[1] == startSquare[1]) queenCaptured[startSquare[0]][startSquare[1]] = true;
		if(this.rook[0] == startSquare[0] && this.rook[1] == startSquare[1]) rookCaptured[startSquare[0]][startSquare[1]] = true;

		if( queenCaptured[startSquare[0]][startSquare[1]] && rookCaptured[startSquare[0]][startSquare[1]]){
			return 0;
		}
		
		// main
		Q.add(startSquare);
		
		int whileCounter=0;
		while(!Q.isEmpty()){
			whileCounter++;
			Integer[] now = Q.poll();

			int nowCount = counter[now[0]][now[1]];

			System.out.println(String.format("DEBUG:loop[%d]:now[%d][%d], count=[%d], queenCaptured=[%s],rookCaptured=[%s]", 
					whileCounter, now[0], now[1], nowCount, queenCaptured[now[0]][now[1]], rookCaptured[now[0]][now[1]]));

			if(findNextSquare(now[0] - 2, now[1] - 1, nowCount, now[0], now[1]) > -1) return ++nowCount;
			if(findNextSquare(now[0] - 2, now[1] + 1, nowCount, now[0], now[1]) > -1) return ++nowCount;	
			if(findNextSquare(now[0] + 2, now[1] - 1, nowCount, now[0], now[1]) > -1) return ++nowCount;
			if(findNextSquare(now[0] + 2, now[1] + 1, nowCount, now[0], now[1]) > -1) return ++nowCount;
			if(findNextSquare(now[0] - 1, now[1] - 2, nowCount, now[0], now[1]) > -1) return ++nowCount;
			if(findNextSquare(now[0] + 1, now[1] - 2, nowCount, now[0], now[1]) > -1) return ++nowCount;
			if(findNextSquare(now[0] - 1, now[1] + 2, nowCount, now[0], now[1]) > -1) return ++nowCount;
			if(findNextSquare(now[0] + 1, now[1] + 2, nowCount, now[0], now[1]) > -1) return ++nowCount;
		}
		
		return -1;
	}
	
    private int findNextSquare(int nextY, int nextX, int nowCount, int nowY, int nowX) {
    	
		if( 0 <= nextY && nextY < 8 && 0 <= nextX && nextX < 8 ){

			// carry out the "now" status.
			counter[nextY][nextX] = ++nowCount;
			
			boolean queenCapturedThisTime=false;
			if((this.queen[0] == nextY && this.queen[1] == nextX) || queenCaptured[nowY][nowX]){
				queenCaptured[nextY][nextX] = true;
				queenCapturedThisTime=true;
			}
			
			boolean rookCapturedThisTime=false;
			if((this.rook[0] == nextY && this.rook[1] == nextX) || rookCaptured[nowY][nowX]){
				rookCaptured[nextY][nextX] = true;
				rookCapturedThisTime=true;
			}
		
			if( queenCapturedThisTime && rookCapturedThisTime){
				return nowCount;
			}
			
			Q.add(new Integer[]{nextY,nextX}); 

		}
		
		return -1;
    }

	public static void main(String[] args) {
        new CaptureThemAll().execute();
    }
 
    private void execute() {
    	// corner case
//        System.out.println(fastKnight("a1","a1","a1"));

        // sample problems.
        System.out.println(String.format("ANSWER=[%d]",fastKnight("a1","b3","c5")));
        System.out.println(String.format("ANSWER=[%d]",fastKnight("b1","c3","a3")));
        System.out.println(String.format("ANSWER=[%d]",fastKnight("a1","a2","b2")));
        System.out.println(String.format("ANSWER=[%d]",fastKnight("a5","b7","e4")));
        System.out.println(String.format("ANSWER=[%d]",fastKnight("h8","e2","d2")));
    }
}
