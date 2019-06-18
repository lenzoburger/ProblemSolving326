package pentonimoes;

import java.util.*;

/**
 * Created by lburka on 5/8/15.
 */
public class PentominoesSolve {
    private static Shapes[] O;
    private static Shapes[] P;
    private static Shapes[] Q;
    private static Shapes[] R;
    private static Shapes[] S;
    private static Shapes[] T;
    private static Shapes[] U;
    private static Shapes[] V;
    private static Shapes[] W;
    private static Shapes[] X;
    private static Shapes[] Y;
    private static Shapes[] Z;
    private static char [][] matrix;
    private static int len=0;
    private static ArrayList<char []> mat= new ArrayList<char[]>();
    private static ArrayList<Shapes[]> criteria= new ArrayList<Shapes[]>();

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String crit= input.nextLine();
        while(input.hasNextLine()){
            String line = input.nextLine();
            if(line.equals("")){
                createShapes();
                criteria=critList(crit);
                runSearch(criteria);
                mat.clear();
                criteria.clear();
                matrix=null;
                crit= input.nextLine();
            }else {
                len = line.length();
                char[] store = new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    store[i] = line.charAt(i);
                }
                mat.add(store);
            }
        }
        input.close();
        createShapes();
        criteria=critList(crit);
        runSearch(criteria);
        mat.clear();
        criteria.clear();
        matrix=null;
    }

    private static void runSearch(ArrayList<Shapes[]> list){
        int nFactorial=100;
        int tries=0;

        while(tries<nFactorial) {
            for (Shapes piece : list.get(0)) {
                ArrayList<Shapes[]> q= new ArrayList<Shapes[]>();
                q=copyAL(list,q);
                ArrayList<Shapes> tried = new ArrayList<Shapes>();
                char[][] m = new char[matrix.length][matrix[0].length];
                m = copyArray(matrix, m);                                          //System.arraycopy( source, sourceStart, destination, destStart, length );
                m = dfs(m,q, tried, piece,0);
                if (m.length > 0) {
                    printMat(m);
                    System.out.println();
                    return;
                }
            }
            tries++;
            System.out.println("Tries "+ tries + " of : " + nFactorial);
            Collections.shuffle(list);
        }

    }

    public static char[][] copyArray(char[][] src, char[][] dst){
        for(int i=0;i<src.length;i++){
            System.arraycopy( src[i],0,dst[i],0,src[i].length);  //System.arraycopy( source, sourceStart, destination, destStart, length );
        }
        return dst;
    }

    public static char[][] dfs(char[][] curMat,ArrayList<Shapes[]>list, ArrayList<Shapes>triedList, Shapes me, int next){
        //System.out.println("size: "+ triedList.size() + " next: " + next + " me: " + me);
        //printMat(curMat);
        char[][] empty= new char[0][0];
        Shapes[] nextLetter= null;
        ArrayList<Shapes[]> queue= new ArrayList<Shapes[]>();
        queue=copyAL(list,queue);
        boolean noHoles= false;
        //System.out.println(me);
        if(queue.size()==1){
            //printMat(curMat);
        }
        if(!queue.isEmpty()){
            char [][] m= new char[curMat.length][curMat[0].length];
            m= copyArray(curMat,m);
            //System.out.println("_________ "+me);
            //printMat(m);     //System.arraycopy( source, sourceStart, destination, destStart, length );
            int[] hole= findHoles(m);
            m=me.draw(m);
            if(hole.length>0){
                if(m.length>0){
                    if(m[hole[0]][hole[1]]!='.'){
                        noHoles=true;
                    }
                }
            }else{
                noHoles=true;
            }
            if(m.length>0&&noHoles){
                //printMat(m);
                triedList.add(me);
                queue.remove(next);
                if(queue.isEmpty()) {
                    //System.out.println("Tried: "+ triedList.size() + " crit: "+ critList.size());
                    //printMat(m);
                    if(triedList.size()==criteria.size()){
                        return m;
                    }else {
                        return empty;
                    }

                }
                int r;
                ArrayList<Integer> tryMe= new ArrayList<Integer>();
                for(Shapes[] letter: queue) {
                    r= random(0, queue.size() - 1);
                    while(tryMe.contains(r)){
                        r= random(0,queue.size()-1);
                    }
                    tryMe.add(r);
                    nextLetter =queue.get(r);
                    for (Shapes each : nextLetter) {
                        //System.out.println("next-> "+each);
                        char[][] e = new char[matrix.length][matrix[0].length];
                        char[][] n = new char[matrix.length][matrix[0].length];
                        n = copyArray(m, n);
                        ArrayList<Shapes[]> q = new ArrayList<Shapes[]>();
                        q = copyAL(queue, q);
                        ArrayList<Shapes> tried = (ArrayList<Shapes>) triedList.clone();
                        e = dfs(n, q, tried, each, r);
                        if (e.length > 0) {
                            return e;
                        }

                    }
                }
            }
        }
        return empty;
    }

    private static int[] findHoles(char[][] board){
        int[] hole= new int[2];
        int[] empty=new int[0];
        for (int i=0;i<board.length;i++){
            for(int j=0; j<board[i].length;j++){
                if(board[i][j]=='.'){
                    hole[0]=i;
                    hole[1]=j;
                    return hole;
                }
            }
        }
        return empty;
    }

    private static void createShapes(){
        matrix= new char[mat.size()][len];
        int p=0;
        for(char[] each: mat){
            for(int j=0;j<each.length;j++){
                //System.out.print(each[j]);
            }
            //System.out.println();
            matrix[p]= each;
            p++;
        }
        ArrayList<Shapes[]> shapes= new ArrayList<Shapes[]>();
        Shapes.in init = new Shapes.in();
        shapes=init.init();
        O= shapes.get(0);
        P= shapes.get(1);
        Q= shapes.get(2);
        R= shapes.get(3);
        S= shapes.get(4);
        T= shapes.get(5);
        U= shapes.get(6);
        V= shapes.get(7);
        W= shapes.get(8);
        X= shapes.get(9);
        Y= shapes.get(10);
        Z= shapes.get(11);
    }

    private static ArrayList<Shapes[]> copyAL(ArrayList<Shapes[]> org, ArrayList<Shapes[]>copy){
        for(Shapes[] each : org){
            Shapes[] c= new Shapes[each.length];
            System.arraycopy(each,0,c,0,each.length);  //System.arraycopy( source, sourceStart, destination, destStart, length );
            copy.add(c);
        }
        return copy;
    }

    private static ArrayList<Shapes[]> critList (String crit){
        ArrayList<Shapes[]> theList= new ArrayList<Shapes[]>();
        for(int i=0;i<crit.length();i++){
            char each= crit.charAt(i);
            switch (each){
                case 'O':
                    theList.add(O);
                    break;
                case 'P':
                    theList.add(P);
                    break;
                case 'Q':
                    theList.add(Q);
                    break;
                case 'R':
                    theList.add(R);
                    break;
                case 'S':
                    theList.add(S);
                    break;
                case 'T':
                    //System.out.println("T");
                    theList.add(T);
                    break;
                case 'U':
                    theList.add(U);
                    break;
                case 'V':
                    theList.add(V);
                    break;
                case 'W':
                    theList.add(W);
                    break;
                case 'X':
                    theList.add(X);
                    break;
                case 'Y':
                    theList.add(Y);
                    break;
                case 'Z':
                    theList.add(Z);
                    break;
            }
        }
        return theList;
    }

    private static void printMat(char[][] piece){
        for(int row=0;row<piece.length;row++){
            for(int col=0;col<piece[row].length;col++){
                System.out.print(piece[row][col]);
            }
            System.out.println();
        }
    }

    public static int random(int min, int max){
        Random generator= new Random();
        return generator.nextInt(max-min+1)+min;
    }

}
