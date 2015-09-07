package TopCoder.SRM197_DIV1;

import java.util.*;
class Pair implements Comparable{
  int x, y;
  Pair(int xx, int yy){x = xx; y = yy;}
  public int hashCode(){
    return x*17+y;
  }
  public boolean equals(Object o){
    Pair p = (Pair)o;
    return p.x == x && p.y == y;
  }
  
  public int compareTo(Object o){
    Pair p = (Pair)o;
    if(p.x != x) return x - p.x;
    return y - p.y;
  }
}
 
public class GeneralChessGood {
  public String[] attackPositions(String[] pieces) {
    int[] dx = {2,2,1,1,-2,-2,-1,-1};
    int[] dy = {1,-1,2,-2,1,-1,2,-2};
    HashSet hsf = null;
    for(int i = 0; i < pieces.length; i++){
      HashSet hs = new HashSet();
      String[] ss = pieces[i].split(",");
      int x = Integer.parseInt(ss[0]);
      int y = Integer.parseInt(ss[1]);
      for(int j = 0; j < dx.length; j++){
        hs.add(new Pair(x+dx[j],y+dy[j]));
      }
      if(hsf==null) hsf = hs;
      else hsf.retainAll(hs);
    }
    Pair[] pairs = (Pair[])hsf.toArray(new Pair[0]);
    Arrays.sort(pairs);
    String[] ret = new String[pairs.length];
    for(int i = 0; i < pairs.length; i++){
      ret[i] = pairs[i].x+","+pairs[i].y;
    }
    return ret;
  }
 
 
// ##################### NO POINT LOOKING BELOW, TESTCODE ONLY ####################
 
 
/** begin cut - don't modify this line*/
  public static void main(String[] a) {
    new GeneralChessGood().runTestCase(0);
    new GeneralChessGood().runTestCase(1);
    new GeneralChessGood().runTestCase(2);
    new GeneralChessGood().runTestCase(3);
  }
 
  public void runTestCase(int nbr) {
    switch(nbr) {
      case 0 : {
        checkOutput(attackPositions(new String[] {"0,0"}), new String[] { "-2,-1",  "-2,1",  "-1,-2",  "-1,2",  "1,-2",  "1,2",  "2,-1",  "2,1" }, 0); break;
      }
      case 1 : {
        checkOutput(attackPositions(new String[] {"2,1", "-1,-2"}), new String[] { "0,0",  "1,-1" }, 1); break;
      }
      case 2 : {
        checkOutput(attackPositions(new String[] {"0,0", "2,1"}), new String[] { }, 2); break;
      }
      case 3 : {
        checkOutput(attackPositions(new String[] {"-1000,1000", "-999,999", "-999,997"}), new String[] { "-1001,998" }, 3); break;
      }
    }
  }
  final void checkOutput(int mine, int them, int nbr) {
    boolean success = (mine==them);
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append(mine);
      out.append(", Expected: ");
      out.append(them);
    }
    System.out.println(out);
  }
  final void checkOutput(long mine, long them, int nbr) {
    boolean success = (mine==them);
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append(mine);
      out.append(", Expected: ");
      out.append(them);
    }
    System.out.println(out);
  }
  final void checkOutput(double mine, double them, int nbr) {
    boolean success = doubleCompare(mine, them);
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append(mine);
      out.append(", Expected: ");
      out.append(them);
    }
    System.out.println(out);
  }
  private static boolean doubleCompare(double expected, double result){
    double MAX_DOUBLE_ERROR = 1E-9;
    if(Double.isNaN(expected)){
      return Double.isNaN(result);
    }else if(Double.isInfinite(expected)){
      if(expected > 0){
        return result > 0 && Double.isInfinite(result);
      }else{
        return result < 0 && Double.isInfinite(result);
      }
    }else if(Double.isNaN(result) || Double.isInfinite(result)){
      return false;
    }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){
      return true;
    }else{
      double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR),
        expected * (1.0 + MAX_DOUBLE_ERROR));
      double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR),
          expected * (1.0 + MAX_DOUBLE_ERROR));
      return result > min && result < max;
    }
  }
  final void checkOutput(char mine, char them, int nbr) {
    boolean success = (mine==them);
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append("'");
      out.append(mine);
      out.append("'");
      out.append(", Expected: ");
      out.append("'");
      out.append(them);
      out.append("'");
    }
    System.out.println(out);
  }
  final void checkOutput(String mine, String them, int nbr) {
    boolean success = (mine.equals(them));
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append("\"");
      out.append(mine);
      out.append("\"");
      out.append(", Expected: ");
      out.append("\"");
      out.append(them);
      out.append("\"");
    }
    System.out.println(out);
  }
  final void checkOutput(long[] mine, long[] them, int nbr) {
    boolean success = (Arrays.equals(mine, them));
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append("{");
      for(int x=0;x<mine.length;x++) {
        out.append(mine[x]);
        if(x<mine.length-1) out.append(", ");
      }
      out.append("}");
      out.append(", Expected: ");
      out.append("{");
      for(int x=0;x<them.length;x++) {
        out.append(them[x]);
        if(x<them.length-1) out.append(", ");
      }
      out.append("}");
    }
    System.out.println(out);
  }
  final void checkOutput(char[] mine, char[] them, int nbr) {
    boolean success = (Arrays.equals(mine, them));
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append("{");
      for(int x=0;x<mine.length;x++) {
        out.append(mine[x]);
        if(x<mine.length-1) out.append(", ");
      }
      out.append("}");
      out.append(", Expected: ");
      out.append("{");
      for(int x=0;x<them.length;x++) {
        out.append(them[x]);
        if(x<them.length-1) out.append(", ");
      }
      out.append("}");
    }
    System.out.println(out);
  }
  final void checkOutput(double[] mine, double[] them, int nbr) {
    boolean success = (Arrays.equals(mine, them));
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append("{");
      for(int x=0;x<mine.length;x++) {
        out.append(mine[x]);
        if(x<mine.length-1) out.append(", ");
      }
      out.append("}");
      out.append(", Expected: ");
      out.append("{");
      for(int x=0;x<them.length;x++) {
        out.append(them[x]);
        if(x<them.length-1) out.append(", ");
      }
      out.append("}");
    }
    System.out.println(out);
  }
  final void checkOutput(int[] mine, int[] them, int nbr) {
    boolean success = (Arrays.equals(mine, them));
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append("{");
      for(int x=0;x<mine.length;x++) {
        out.append(mine[x]);
        if(x<mine.length-1) out.append(", ");
      }
      out.append("}");
      out.append(", Expected: ");
      out.append("{");
      for(int x=0;x<them.length;x++) {
        out.append(them[x]);
        if(x<them.length-1) out.append(", ");
      }
      out.append("}");
    }
    System.out.println(out);
  }
  final void checkOutput(String[] mine, String[] them, int nbr) {
    boolean success = (Arrays.equals(mine, them));
    StringBuffer out = new StringBuffer();
    out.append("Example ");
    out.append((nbr+1));
    out.append(" - ");
    out.append(success ? "success" : "failure   ");
    if(!success) {
      out.append("Got: ");
      out.append("{");
      for(int x=0;x<mine.length;x++) {
        out.append(mine[x]);
        if(x<mine.length-1) out.append(", ");
      }
      out.append("}");
      out.append(", Expected: ");
      out.append("{");
      for(int x=0;x<them.length;x++) {
        out.append(them[x]);
        if(x<them.length-1) out.append(", ");
      }
      out.append("}");
    }
    System.out.println(out);
  }
 
/** end cut - don't modify this line*/
}
 
// Powered by PopsEdit
// Powered by CodeProcessor
