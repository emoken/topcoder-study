package TopCoder.SRM635_DIV2;

import java.io.InputStream;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LonglongestPathTree {

  private Node[] _nodes=null;
  private int _numEdges;
  private int _numNodes;
  private int _maxNode;
  private long _maxLength;
  private Deque<Integer> _lifoStack = new LinkedList<>();

  public long getLength(int[] A, int[] B, int[] L){

    // ------------------------
    //  init
    // ------------------------
    _numEdges = A.length;
    _numNodes = A.length + 1;
    setupNodeArray(A,B,L);
    
    // ------------------------
    //  MAIN
    // ------------------------
    long finalMax=0;
    Edge tempEdgeFrom, tempEdgeTo;
    long maxLengthA,maxLengthB;
    
    for(int i=0;i<_numEdges;i++){
      
      tempEdgeFrom = _nodes[A[i]].getEdge(_nodes[B[i]]);
      tempEdgeTo = _nodes[B[i]].getEdge(_nodes[A[i]]);
      _nodes[A[i]].removeEdge(_nodes[B[i]]);
      _nodes[B[i]].removeEdge(_nodes[A[i]]);

      // (1) get a max length of a graph including A[i] node.
      maxLengthA = getMaxLength(A[i]);
      // (2) get a max length of a graph including B[i] node.
      maxLengthB = getMaxLength(B[i]);

      // update "finalMax" with a new max.
      if((maxLengthA + maxLengthB + L[i]) > finalMax) {
        finalMax = maxLengthA + maxLengthB + L[i];
      }

      _nodes[A[i]].addEdge(tempEdgeFrom);
      _nodes[B[i]].addEdge(tempEdgeTo);
    }

    return finalMax;
  }

  private long getMaxLength(int startingNodeId){
    doDFS(startingNodeId);
    doDFS(_maxNode);
    return _maxLength;
  }

  private void doDFS(int startingNodeId){
    
    try{
      
    // ------------------------
    //  init
    // ------------------------
    for(int j=0;j<_numNodes;j++){
      _nodes[j].unmarkVisited();
      _nodes[j].init();
    }

    _maxLength=0;
    _maxNode = startingNodeId;
    int curLength=0;
    Node node=null;
    Node previousNode=null;


    // ------------------------
    //  MAIN
    // ------------------------
    _lifoStack.push(startingNodeId);
    while(!_lifoStack.isEmpty()){

      node = _nodes[_lifoStack.pop()];

      if(node.isVisited()){
        Edge previousEdge = node.getEdge(previousNode);
        curLength -= previousEdge.getLength();
      }else{
        // mark 'visited', it means, the first time arriving at this node.
        node.markVisited();
      }
  
      while(true){
        Edge e = node.nextNonVisitedEdge();
        previousNode = node;
  
        if(e!=null){
          _lifoStack.push(node.getId());
          node = _nodes[e.getNodeId()];
          node.markVisited();
          curLength += e.getLength();
          
          if(curLength>_maxLength){
            _maxLength=curLength;
            _maxNode=node.getId();
          }
        }else{
          break;
        }
      }
    }
    
    }catch(Exception e){
      e.getStackTrace();
    }

  };


  private void setupNodeArray(int[] A, int[] B, int[] L) {
    int numEdges = A.length;
    _nodes = new Node[numEdges+1];

    for(int i=0;i<numEdges;i++){
      Node fromNode = _nodes[A[i]];
      if(fromNode == null){
        fromNode = new Node(A[i]);
        _nodes[A[i]] = fromNode;
      }

      Node toNode = _nodes[B[i]];
      if(toNode == null){
        toNode = new Node(B[i]);
        _nodes[B[i]] = toNode;
      }

      fromNode.addEdge(new Edge(B[i], L[i]));
      toNode.addEdge(new Edge(A[i], L[i]));
    }
  }

  private class Node{
    private int id;
    private Map<Integer, Edge> edges = new HashMap<>();
    private Queue<Edge> edgeQueue = new LinkedList<>();
    private boolean visited = false;
    
    public Node(int id){this.id = id;}
    public void init() {
      Iterator<Integer> i = edges.keySet().iterator();
      while(i.hasNext()){
        Edge e = edges.get(i.next());
        edgeQueue.add(e);
      }
    }
    public void addEdge(Edge e){ edges.put(e.getNodeId(),e);};
    public void markVisited(){
      visited = true;
    }
    public void unmarkVisited(){
      visited = false;
    }
    public boolean isVisited(){
      return visited;
    }
    public int getId() {
      return id;
    }
    public void removeEdge(Node node){
        edges.remove(node.getId());
    }
    public Edge getEdge(Node node){
      return edges.get(node.getId());
    }
    public Edge nextNonVisitedEdge(){
      
      Edge e = null;
      
      while(true){
        e = edgeQueue.poll();
      
        if(e==null) break;

        if(_nodes[e.getNodeId()].isVisited()){
          continue;
        }else{
          break;
        }
      }
      return e;
//      Iterator<Integer> i = edges.keySet().iterator();
//      while(i.hasNext()){
//        Edge e = edges.get(i.next());
//        if(!_nodes[e.getNodeId()].isVisited()){
//          return e;
//        }
//      }
//      return null;
    }
    
    @Override
    public String toString() {
      return String.format("Node id[%s]:visited?[%s]", this.id,this.visited);
    }
  }

  private class Edge{
    private int nodeId;
    private int length;
    public Edge(int n, int l){this.nodeId = n; this.length = l;};
    public int getNodeId(){
      return nodeId;
    }
    public int getLength(){
      return length;
    }
    @Override
    public String toString() {
      return String.format("Edge: node=[%s], length=[%s]", this.nodeId, this.length);
    }
  }
  

// -----------------------------------------------------------
// TODO These are for UT. 
// If this can be removed in any way, I'd be very good!!!
//-----------------------------------------------------------
  private static InputStream SYSTEM_IN = System.in;
  public static void setSystemIn(InputStream systemIn) {
    SYSTEM_IN = systemIn;
  }

  private static int[] toIntArray(String[] strArray){
    int[] intArray = new int[strArray.length];
    for(int i=0;i<strArray.length;i++){
      intArray[i] = Integer.parseInt(strArray[i]);
    }
    return intArray;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(SYSTEM_IN);
    int[] a = toIntArray(sc.next().replace(" ", "").split(","));
    int[] b = toIntArray(sc.next().replace(" ", "").split(","));
    int[] l = toIntArray(sc.next().replace(" ", "").split(","));
    sc.close();
    LonglongestPathTree target = new LonglongestPathTree();
    System.out.print(target.getLength(a,b,l));
  }
}

