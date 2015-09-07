package TopCoder.SRM233_DIV1;

import java.util.Scanner;

public class SmartWordToy {

	public int minPresses(String start, String finish, String[] forbid){
		
		int m = forbid.length;
		boolean[][][] bad = new boolean[m][4][26];
		
		{
			int i=0;
			int j=0;
			String s="";
			try{
				for (i=0;i<m;i++){
					Scanner sc = new Scanner(forbid[i]);
					for(j=0;j<4;j++){
						if(sc.hasNext()){
							s = sc.next();
							for(char ch:s.toCharArray()){
								bad[i][j][ch-'a']=true;
							}
						}
					}
				}
			}catch(Exception e){
				System.err.println(String.format("bad[i][j][ch-'a']=bad[%d][%d][%s]",i,j,s));
				e.printStackTrace();
			}
		}
		
		
		boolean[][][][] w=new boolean[26][26][26][26];
		int[] q= new int[26*26*26*26*5];
		
		int head = 0;
		int tail = 0;
		for (int i=0;i<4;i++){
			q[tail++] = start.charAt(i) - 'a';
		}
		q[tail++] = 0;
		
		// register "$start" word 
		w[q[0]][q[1]][q[2]][q[3]]=true;
		
		// register "$finish" word 
		int[] f = new int[4];
		for (int i=0;i<4;i++){
			f[i] = finish.charAt(i)-'a';
		}
		
		outer:
		while(head<tail){
			int[] cur = new int[4];
			for (int i=0;i<4;i++){
				cur[i] = q[head++];
			}
			
			int cd = q[head++];
			
			for (int i=0;i<m;i++){
				boolean thisbad = true;
				for (int j=0;j<4;j++){
					thisbad &= bad[i][j][cur[j]];
				}
				if (thisbad){
					continue outer;
				}
			}
			
			boolean done = true;
			for (int i=0;i<4;i++){
				done &= f[i] == cur[i];
			}
			
			if(done){
				return cd;
			}
			
			for (int i=0;i<4;i++){
				for (int delta = -1; delta <= 1; delta++){
					if (delta == 0){
						continue;
					}
					int[] next = new int[4];
					for (int k=0;k<4;k++){
						next[k] = cur[k];
					}
					
					next[i] += delta;
					if(next[i]<0){
						next[i] += 26;
					}
					next[i] %= 26;
					if(!w[next[0]][next[1]][next[2]][next[3]]){
						w[next[0]][next[1]][next[2]][next[3]] = true;
						for(int j=0;j<4;j++){
							q[tail++]=next[j];
						}
						q[tail++]=cd+1;
					}
					
				}
			}
			
		}
		
		return -1;
	}
	
    public static void main(String[] args) {
        new SmartWordToy().execute();
    }
 
    private void execute() {
        System.out.println(minPresses("aaaa","bbbb", new String[]{"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"}));
    }
}
