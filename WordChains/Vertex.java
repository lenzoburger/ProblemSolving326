package wordChains;
public class Vertex {
  public String label;        // label (e.g. 'A')
  public state state_1;
  public int position;
  public int ancestor;
  public int dfs_distance;
  public int bfs_distance;
  public int ending;  
  public int count;
  
  public Vertex(String lab, int p){
    label = lab;
    position=p;    
  }
  
  public String toString(){
    return label;
  }
  
}  // end class Vertex
