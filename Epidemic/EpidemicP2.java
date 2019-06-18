package epidemic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lburka on 5/17/15.
 */
public class EpidemicP2 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Cell>> states= new ArrayList<ArrayList<Cell>>();
        Scanner input= null;
        try {
            input = new Scanner(System.in);
          } catch (Exception ex) {
            System.err.println("\nUsage: java epidemic.EpidemicP2 < [InputFile]\n");
            throw ex;
        }

        while (input.hasNextLine()){
            String line= input.nextLine();

            if(line.equals("")){
                findNeighbours(states);
                makeSick(states);
                cleanUP(states);
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

        input.close();

        findNeighbours(states);
        makeSick(states);
        cleanUP(states);
        printCells(states);        
    }

    public static void update(ArrayList<ArrayList<Cell>> pop){
        boolean updated=true;

        while(updated && pop.size() > 0) {
            updated=false;
            int a=0;
            while(a<Math.max(pop.size(),pop.get(0).size())){
                if (a<pop.get(0).size()){
                    for (int rows=0;rows<pop.size();rows++){
                        boolean u= pop.get(rows).get(a).update();
                        if(u){
                            updated=true;
                        }
                    }
                    //System.out.println("Done Rows");
                    //printCells(pop);
                }
                if (pop.size()-(a+1)>=0){
                    for (int col=0;col<pop.get(0).size();col++){
                        boolean u= pop.get(pop.size()-(a+1)).get(col).update();
                        if(u){
                            updated=true;
                        }
                    }
                }
                //System.out.println("Done Cols");
                //printCells(pop);
                a++;
            }
        }
    }

    public static boolean allSick(ArrayList<ArrayList<Cell>> pop){

        for (ArrayList<Cell> row : pop) {

            for (Cell each : row) {
                if(!each.sick && !each.immune){
                    return false;
                }
            }
        }
        return true;
    }

    public static void updateR(ArrayList<ArrayList<Cell>> pop){
        boolean updated=true;

        while(updated) {

            updated=false;

            for (ArrayList<Cell> row : pop) {

                for (Cell each : row) {

                    boolean u=each.updateR();

                    if(u){

                        updated=true;

                    }

                }
            }
        }
    }

    public static void makeSick(ArrayList<ArrayList<Cell>> pop){
        for (ArrayList<Cell> row : pop) {
            for (Cell each : row) {
                each.makeSick();
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
        String output="";
        int makeSick=0;
        for(ArrayList<Cell> each: grid){

            for (Cell x: each) {
                if(x.sick){
                    makeSick++;
                }
                output+=x;
            }
            output+="\n";
        }
        System.out.print(makeSick + "\n" + output);
    }

    public static void cleanUP(ArrayList<ArrayList<Cell>> pop){
        update(pop);
        ArrayList<int[]> madeSick= new ArrayList<int[]>();
        for(int i=0; i<pop.size();i++){
            for(int j=0;j<pop.get(i).size();j++){
                if(pop.get(i).get(j).sick){
                    int[] k= new int[2];
                    k[0]=i;
                    k[1]=j;
                    madeSick.add(k);
                }
            }
        }
        for(int[] each: madeSick){
            ArrayList<ArrayList<Cell>> copy= new ArrayList<ArrayList<Cell>>();
            copy=copyList(pop,copy);
            copy.get(each[0]).get(each[1]).sick=false;
            copy.get(each[0]).get(each[1]).state='.';
            updateR(copy);
            if(allSick(copy)){
                pop.get(each[0]).get(each[1]).sick=false;
                pop.get(each[0]).get(each[1]).state='.';
                //printCells(copy);
            }
        }
    }

    public static ArrayList<ArrayList<Cell>> copyList(ArrayList<ArrayList<Cell>> org, ArrayList<ArrayList<Cell>> copy){
        for(ArrayList<Cell> rows: org){
            ArrayList<Cell> row= new ArrayList<Cell>();
            for(Cell cell: rows){
                Cell c= new Cell(cell.state);
                row.add(c);
            }
            copy.add(row);
        }
        findNeighbours(copy);
        return copy;
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

        public void makeSick(){
            if(!this.immune){
                this.sick=true;
                this.state='S';
            }
        }

        public boolean update(){
            int sickCount=0;

            if(!this.immune && this.sick) {

                for (Cell each : n) {

                    if (each.sick) {
                        sickCount++;
                    }
                }

                if (sickCount >= 2) {
                    this.sick = false;
                    this.state = '.';
                    return true;
                }
            }
            return false;
        }

        public boolean updateR(){
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
            //System.out.println(n);
        }
        
        public String toString(){
            return ""+state;
        }
    }
}
