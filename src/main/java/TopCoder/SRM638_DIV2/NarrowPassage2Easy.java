package TopCoder.SRM638_DIV2;

import java.util.HashSet;
import java.util.Set;

public class NarrowPassage2Easy {

  int[] _indices;
  int[] _size;
  int N;
  int _maxSizeSum;
  Set<String> _wolves = new HashSet<String>();
  
  public int count(int[] size, int maxSizeSum){
    
    // preparation.
    N = size.length;
    _maxSizeSum = maxSizeSum;
    _indices = new int[N];
    _size = size;
    for(int i=0;i<N;i++){
      _indices[i]=i+1;
    }

    // corner case..
    if(N==1) return 1;

    // MAIN
    search(0);
    return _wolves.size();
  }
  
  
  private void search(int index){
    
    String key="";
    for(int i=0;i<N;i++){
      key = key +_indices[i];
    }
    
    System.out.println(String.format("DEBUG:index[%d],key[%s]",index,key));

    if(!_wolves.contains(key)){
      _wolves.add(key);
      System.out.println(String.format("DEBUG:added!!! ===> index[%d],key[%s]",index,key));
    }

//    if(index == N) return;
    if(!swappable(index)) return;
    

    for(int i=0;i<N-1;i++){
      swap(i);
      search(index+1);
    }
  }
  
  private void swap(int index1){
    int index2=index1+1;
    
    if(!swappable(index1)) return;

    int tmp = _size[index1];
    _size[index1] = _size[index2];
    _size[index2] = tmp;
    
    tmp = _indices[index1];
    _indices[index1] = _indices[index2];
    _indices[index2] = tmp;
  }
  
  private boolean swappable(int index){
    return (_size[index] + _size[index+1]) <= _maxSizeSum;
  }

}
