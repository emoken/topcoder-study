package TopCoder.SRM212_DIV2;

public class LargestCircle {

  public int radius(String[] grid){
  
    int N = grid.length;
    int M = N+1;
    
    boolean[][] square = new boolean[N][N];

    int[][] checkMap = new int[M][M];

    // parse
    for(int i=0;i<N;i++){
      String row = grid[i];
      
      char[] cells = row.toCharArray();
      for(int j=0;j<N;j++){
        if(cells[j] == '#'){
          square[i][j] = false;
        }else{
          square[i][j] = true;
        }
      }
    }


    // main

    for(int i=0;i<M;i++){
      for(int j=0;j<M;j++){
        
      }
    }

    
    return 0;
  }
  
  
  public static void main(String[] a) {
    
    LargestCircle myObject = new LargestCircle();
    System.out.println(myObject.radius(new String[]{
        "####",
        "#..#",
        "#..#",
        "####" }
        ));
    
    System.out.println(myObject.radius(new String[]{ 
        "############",
        "###......###",
        "##.######.##",
        "#.########.#",
        "#.##..####.#",
        "#.##..####.#",
        "#.########.#",
        "#.########.#",
        "#.########.#",
        "##.######.##",
        "###......###",
        "############" }
    ));

    System.out.println(myObject.radius(new String[]{ 
        "#######",
        "#######",
        "#######",
        "#######",
        "#######" }
    ));
    
    
    System.out.println(myObject.radius(new String[]
        { "#####.......",
          "#####.......",
          "#####.......",
          "............",
          "............",
          "............",
          "............",
          "............",
          "............",
          "............" }
    ));

  }

}
