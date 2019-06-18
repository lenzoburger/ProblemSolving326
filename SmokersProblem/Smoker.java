package smokersProblem;

import java.util.ArrayList;

public class Smoker {
    public boolean start=false;
    public boolean end= false;
    public boolean exclude= false;
    public int myExclusionZone=0;
    public String label;
    public boolean smoker;
    public int x;        // label (e.g. 'A')
    public int y;
    ArrayList<Smoker> neighbours= new ArrayList<Smoker>();
    public Smoker left;
    public Smoker right;
    public Smoker up;
    public Smoker down;
    public Smoker nearest;
    public int nearestDist;
    public int dist;
    public Smoker parent= null;
    public Smoker(int x, int y, boolean smoker, int maxRows, int maxCols) {
        this.x=x;
        this.y=y;
        this.smoker=smoker;
        this.label="0  ";
        if(x==0&&y==0) {
            start = true;
        }else if(maxRows-1==y && maxCols-1 ==x){
            end=true;
        }
        dist=y+x;
    }

    public ArrayList<Smoker> getNeighbours(Smoker parent){
        ArrayList<Smoker> n= new ArrayList<Smoker>();
        for (Smoker each: neighbours){
            if(each!=null && each.exclude == false && each !=parent){
                n.add(each);
            }
        }
        return n;
    }

    public String toString() {
        return label;
    }
}
