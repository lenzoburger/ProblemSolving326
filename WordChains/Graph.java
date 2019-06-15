package wordChains;
import java.util.*;

public class Graph {
  private final int MAX_VERTS;
  public Vertex vertexList[]; // list of vertices
  public boolean adjMat[][];      // adjacency matrix
  public int nVerts;          // current number of vertices
  public int words=0;
  private Queue<Integer> stackQ = new LinkedList<Integer>();
  
  public Graph(int size){               // constructor
    MAX_VERTS= size;
    vertexList = new Vertex[MAX_VERTS];
    // adjacency matrix
    adjMat = new boolean[MAX_VERTS][MAX_VERTS];
    nVerts = 0;
    for(int y=0; y<MAX_VERTS; y++)      // set adjacency
      for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
      adjMat[x][y] = false;        
  }  // end constructor
  
  
  public void addVertex(String lab, int p){
    vertexList[p] = new Vertex(lab,p);
    vertexList[p].state_1= state.UNVISITED;  
    vertexList[p].dfs_distance=0;
    vertexList[p].bfs_distance=-1;
    vertexList[p].ending=0;
    vertexList[p].ancestor=-1;
    vertexList[p].count=0;
    nVerts++;
    //System.out.println(nVerts);
  }
  
  
  public void addEdge(int start, int end){
    adjMat[start][end] = true;
    adjMat[end][start] = true;
  } 
  
  public void relationShips (){
    //System.out.println(g.nVerts);
    for(int i=0;i<nVerts;i++){
      ///System.out.println("am here");
      for(int j=0; j<nVerts; j++){
        if(matching(vertexList[j].label,vertexList[i].label)){
          //System.out.println(g.vertexList[i].label + " " + g.vertexList[j].label);
          addEdge(i,j);
        }
      }
    }
    
  }
  
  public void bfs(int start){
    int temp;
    vertexList[start].state_1 = state.VISITED_SELF;
    vertexList[start].bfs_distance = 0;
    stackQ.add(start); 
    while(stackQ.size() > 0){
      temp = stackQ.remove();
      for (int i = 0; i < nVerts; i++) {
        if (adjMat[temp][i] && vertexList[i].state_1 == state.UNVISITED) {
          vertexList[i].state_1 = state.VISITED_SELF;
          vertexList[i].bfs_distance = 1 + vertexList[temp].bfs_distance;
          vertexList[i].ancestor = temp;
          stackQ.add(i);
        }
      }
    }  
  }
  
  public void dfs(){
    for(int i = 0; i < nVerts; i++){
      if(vertexList[i].state_1 == state.UNVISITED){
        visit(vertexList[i]);
      }
    }
  }
  
  public void visit(Vertex v){
    Vertex w;  
    v.state_1 = state.VISITED_SELF;
    this.words++;
    v.dfs_distance = words;
    for(int i = 0; i < nVerts; i++){
      if(adjMat[v.position][i]){    
        w = vertexList[i];
        if(w.state_1 == state.UNVISITED){
          w.ancestor = v.position;
          visit(w);
        }
      }
    }
    this.words++;
    v.state_1 = state.VISITED_DESCENDANTS;
    v.ending = words;
  }
  
  public boolean matching (String s1, String s2){
    int l= s1.length();
    int matches=0;
    for(int i=0;i<l;i++){
      if(s1.charAt(i)==s2.charAt(i)){
        matches++;
      }
    }
    
    if(matches==l-1){
      return true;
    }
    return false;
  }
  
  public void displayRelationships() {
    for(int r=0;r<nVerts;r++){
      System.out.print(vertexList[r].label + ": ");
      for(int c=0;c<nVerts;c++){
        if(adjMat[r][c]==true){
          System.out.print(vertexList[c].label + ", ");
        }
      }
      System.out.println();
    }
  }
  
  public void displayResult(String start,int end,String last){
    String result="";
    Vertex stop = vertexList[end];
    while(!(stop.label).equals(start) && stop.ancestor >= 0){
      String reverse= new StringBuilder(result).reverse().toString();
      String rev= new StringBuilder(stop.toString()).reverse().toString();
      result+=rev + " ";
      stop = vertexList[stop.ancestor];
    }
    String reverse= new StringBuilder(result).reverse().toString();
    result +=stop;    
    if(result.equals(last)||result.equals("")){
       System.out.println("Not Possible");
    }else{      
      System.out.println(start + reverse);
    }
  }
  
  public void displayVertex(int v) {
    System.out.println(vertexList[v].label);
  }
  
  public void displayAdjMat() {
    for(int j=0;j<nVerts;j++){            
      System.out.print("    "+ vertexList[j].label);           
    }
    System.out.println();
    int i = 0;
    for(boolean[] row: adjMat){
      System.out.print(vertexList[i].label+ "  ");
      for(boolean col:row){
        System.out.print(col+"      ");
      }
      System.out.println();
      if(i<nVerts-1){
        i++;
      }
    }  
  }
  
  public ArrayList<Integer> myChildren(int index){
    ArrayList<Integer> children= new ArrayList<Integer> ();
    //System.out.println("here " + index);
    for(int i=0;i<adjMat[index].length;i++){
      boolean each= adjMat[index][i];
      if(each){
        children.add(i);
        //System.out.println(vertexList[i] + " is a child of: " + vertexList[index]);
      }
    }
    return children;
  }
  
  public ArrayList<Integer> findEnd(int start, int end, ArrayList<Integer> wordChain, int length) {
    //System.out.println("here " + start);
    ArrayList<Integer> children= myChildren(start);
    ArrayList<Integer> bogus= new ArrayList<Integer>();
    if(!(children.isEmpty())||start==end){       
      if(wordChain.size()==length){       
        if(start==end){          
          return wordChain;
        }else{
          return bogus;
        }
      }  
      
      for(int each: children){
        if(!(wordChain.contains(each))){
          ArrayList<Integer> chain = (ArrayList<Integer>) wordChain.clone();
          chain.add(each);
          bogus=findEnd(each,end,chain,length);
          if(!(bogus.isEmpty())){
            return bogus;
          }               
          //if((wordChain.contains(each))){
          //return bogus;
          // }
        }
      }       
    }
    return bogus;
  }
}