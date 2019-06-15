import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lburka on 5/17/15.
 */
public class Epidemic {

    public static void main(String[] args) {
        ArrayList<ArrayList<Cell>> states= new ArrayList<ArrayList<Cell>>();
        Scanner input= new Scanner(System.in);

        while (input.hasNextLine()){
            String line= input.nextLine();

            if(line.equals("")){

                findNeighbours(states);
                update(states);
                printCells(states);
                System.out.println();
                states.clear();

            }else{

                ArrayList<Cell> ln= new ArrayList<Cell>();

                for(int i=0; i< line.length();i++){
                    ln.add(new Cell(line.charAt(i)));
                }

                states.add(ln);

            }
        }

        findNeighbours(states);
        update(states);
        printCells(states);
    }

    public static void update(ArrayList<ArrayList<Cell>> pop){
        boolean updated=true;

        while(updated) {

            updated=false;

            for (ArrayList<Cell> row : pop) {

                for (Cell each : row) {

                    boolean u=each.update();

                    if(u){

                        updated=true;

                    }

                }
            }
        }
    }

    public static void findNeighbours(ArrayList<ArrayList<Cell>> pop){
        for(int row=0;row<pop.size();row++){

            for (int col=0;col<pop.get(row).size();col++){

                Cell top;
                Cell bot;
                Cell left;
                Cell right;

                if(row<pop.size()-1){
                    bot=pop.get(row+1).get(col);

                }else{
                    bot=null;
                }

                if(row>0){
                    top=pop.get(row-1).get(col);

                }else{
                    top=null;
                }

                if(col<pop.get(row).size()-1){
                    right=pop.get(row).get(col+1);

                }else{
                    right=null;
                }

                if(col>0){
                    left=pop.get(row).get(col-1);

                }else{
                    left=null;
                }
                //System.out.println("t: "+ top + " b: "+ bot + " l: "+left+ " r: "+ right);
                pop.get(row).get(col).neighbours(top,bot,left,right);
            }
        }
    }

    public static void printCells(ArrayList<ArrayList<Cell>> grid){
        for(ArrayList<Cell> each: grid){

            for (Cell x: each) {
                System.out.print(x);
            }

            System.out.println();
        }
    }

    private static class Cell{
        public ArrayList<Cell> n= new ArrayList<Cell>();
        public char state;
        public boolean sick;
        public boolean immune;

        public Cell(char state){
            this.state= state;

            if(state==('S')){
                sick=true;
                immune=false;

            }else if(state=='I'){
                immune=true;
                sick=false;

            }else{
                immune=false;
                sick=false;
            }
        }

        public boolean update(){
            int sickCount=0;

            if(!this.immune && !this.sick) {

                for (Cell each : n) {

                    if (each.sick) {
                        sickCount++;
                    }
                }

                if (sickCount >= 2) {
                    this.sick = true;
                    this.state = 'S';
                    return true;
                }
            }
            return false;
        }

        public void neighbours(Cell top,Cell bot, Cell left, Cell right){

            if(top!=null){
                n.add(top);
            }

            if(bot!=null){
                n.add(bot);
            }

            if(left!=null){
                n.add(left);
            }

            if(right!=null){
                n.add(right);
            }
        }
        
        public String toString(){
            return ""+state;
        }
    }
}
