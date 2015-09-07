package TopCoder.SRM648_DIV2;

public class Fragile2 {

	public int countPairs(String[] graph){
		int numOfLeaves = numOfLeafs(graph);
		return (graph.length - numOfLeaves) * (graph.length -1) / 2;
	}
	private int numOfLeafs(String[] graph) {
		int ret=0;
		for(String e:graph){
			int c = 0;
			for(int i=e.length(); i-->0;){
				if(e.charAt(i) == 'Y'){
					++c;
				}
			}
			
			if(c<2){
				++ret;
			}
		}
		return ret;
	}
}
