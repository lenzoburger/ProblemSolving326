package smokersProblem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lburka on 5/8/15.
 */
public class SProblem {
    private static int rows;
    private static int cols;
    public static Grid g;

    public static void main(String [] args){
        ArrayList<int[]> nonSmokers= new ArrayList<int[]>();
        Scanner input= new Scanner(System.in);
        Scanner s= new Scanner(input.nextLine());
        rows = s.nextInt();
        cols = s.nextInt();
        while(input.hasNextLine()) {
            String line=input.nextLine();

            if(line.equals("")){
                g= new Grid(rows,cols,nonSmokers);
                g.findTotal();
                //g.printGrid(g.vertexList);
                g=null;
                nonSmokers.clear();
                Scanner l= new Scanner(input.nextLine());
                rows = l.nextInt();
                cols = l.nextInt();

            }else{
                int[] coord= new int[3];
                Scanner l= new Scanner(line);
                coord[0]=l.nextInt();
                coord[1]=l.nextInt();
                nonSmokers.add(coord);
            }
        }

        g= new Grid(rows,cols,nonSmokers);
        g.findTotal();
        //g.printGrid(g.vertexList);
    }
}
