// Using depth-first search
package wordChains; 

import java.util.*;

public class WordChainsApp {
  public static boolean further=false;
  public static int cLength=0;
  public static String start="";
  public static String end="";
  
  public static void main(String[] args) {
    int sIndex;
    int eIndex;
    
    comLine(args);
    
    Graph g;       
    ArrayList pieces = new ArrayList();
    boolean added= false;         
    int fileSize=0;    
    Scanner in = new Scanner(System.in); 
    
    while (in.hasNextLine()){
      String word = in.nextLine();           
      pieces.add(word);
      fileSize++;                         
    }
    
    if(!(pieces.contains(start))){
      pieces.add(start);
      fileSize++;
    }
     if(!(pieces.contains(end))){
      pieces.add(end);
      fileSize++;
    }
     
    g= new Graph(fileSize);    
    sIndex=pieces.indexOf(start);
    eIndex=pieces.indexOf(end);    
    for(int i=0;i<fileSize;i++){
      g.addVertex(pieces.get(i).toString(),i);
    }
    
    g.relationShips(); //determine relatioships
    
    if(!further){     
      g.bfs(sIndex);
      g.displayResult(start,eIndex,end); 
    }else{      
      ArrayList<Integer> wordChain= new ArrayList<Integer>();
      wordChain.add(sIndex);
      wordChain=g.findEnd(sIndex,eIndex,wordChain,cLength);
      if(wordChain.isEmpty()){
        System.out.println(start +" " + end +" "+ cLength +" not possible");
      } else{
        for(int each: wordChain){
        System.out.print(g.vertexList[each]+" ");
      }
      System.out.println();
      }
    }   
  }  // end main() 
  
  public static void comLine(String[] args){
    try {
      start = args[0];
      end = args[1];
      if(args.length == 3) {
        cLength = Integer.parseInt(args[2]);
        further = true;      
      }   
    } catch (Exception ex) {
      System.err.println("\nUsage: java WordChainsApp [firstWord] [lastWord] [OPTIONAL: chainLength] {wordsList[]}\n");
      throw ex;
    }
  }
}  // end class DFSApp