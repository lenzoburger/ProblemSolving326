package pentonimoes;

import java.util.ArrayList;

/**
 * Created by lburka on 5/9/15.
 */
public abstract class Shapes{
    public char[][] draw(char[][] mat) {
        return mat;
    }

    public  static class in{
        public ArrayList<Shapes[]> init(){
            ArrayList<Shapes[]> initial= new ArrayList<Shapes[]>();
            Shapes[] O= {new O1(),new O2()};
            Shapes[] P= {new P1(),new P2(),new P3(),new P4(),new P5(),new P6(),new P7(),new P8()};
            Shapes[] Q= {new Q1(),new Q2(),new Q3(),new Q4(),new Q5(),new Q6(),new Q7(),new Q8()};
            Shapes[] R= {new R1(),new R2(),new R3(),new R4(),new R5(),new R6(),new R7(),new R8()};
            Shapes[] S= {new S1(),new S2(),new S3(),new S4(),new S5(),new S6(),new S7(),new S8()};
            Shapes[] T= {new T1(),new T2(),new T3(),new T4()};
            Shapes[] U= {new U1(),new U2(),new U3(),new U4()};
            Shapes[] V= {new V1(),new V2(),new V3(),new V4()};
            Shapes[] W= {new W1(),new W2(),new W3(),new W4()};
            Shapes[] X= {new X1()};
            Shapes[] Y= {new Y1(),new Y2(),new Y3(),new Y4(),new Y5(),new Y6(),new Y7(),new Y8()};
            Shapes[] Z= {new Z1(),new Z2(),new Z3(),new Z4()};
            initial.add(O);
            initial.add(P);
            initial.add(Q);
            initial.add(R);
            initial.add(S);
            initial.add(T);
            initial.add(U);
            initial.add(V);
            initial.add(W);
            initial.add(X);
            initial.add(Y);
            initial.add(Z);
            return initial;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class O1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 1 && i <  mat.length - 2) {
                            char top = mat[i - 1][j];
                            char down = mat[i + 1][j];
                            char top2 = mat[i - 2][j];
                            char down2 = mat[i + 2][j];
                            if (top == '.' && down == '.' && top2 == '.' && down2 == '.') {
                                mat[i + 1][j] = 'O';
                                mat[i + 2][j] = 'O';
                                mat[i][j] = 'O';
                                mat[i - 1][j] = 'O';
                                mat[i - 2][j] = 'O';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class O2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (j > 1 && j < mat[i].length - 2) {
                            char top = mat[i][j - 1];
                            char down = mat[i][j + 1];
                            char top2 = mat[i][j - 2];
                            char down2 = mat[i][j + 2];
                            if (top == '.' && down == '.' && top2 == '.'&& down2 == '.') {
                                mat[i][j + 1] = 'O';
                                mat[i][j + 2] = 'O';
                                mat[i][j] = 'O';
                                mat[i][j - 1] = 'O';
                                mat[i][j - 2] = 'O';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1)  && j < mat[i].length - 1) {
                            char top = mat[i - 1][j];
                            char down = mat[i + 1][j];
                            char left = mat[i][j + 1];
                            char right = mat[i - 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'P';
                                mat[i - 1][j] = 'P';
                                mat[i + 1][j] = 'P';
                                mat[i][j + 1] = 'P';
                                mat[i - 1][j + 1] = 'P';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 1  && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 1][j + 1];
                            char left = mat[i][j - 1];
                            char right = mat[i][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'P';
                                mat[i + 1][j] = 'P';
                                mat[i + 1][j + 1] = 'P';
                                mat[i][j - 1] = 'P';
                                mat[i][j + 1] = 'P';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && j > 0) {
                            char top = mat[i - 1][j];
                            char down = mat[i + 1][j];
                            char left = mat[i][j - 1];
                            char right = mat[i + 1][j - 1];
                            if (top == '.' && left == '.' && right == '.'&& down == '.') {
                                mat[i][j] = 'P';
                                mat[i - 1][j] = 'P';
                                mat[i + 1][j] = 'P';
                                mat[i][j - 1] = 'P';
                                mat[i + 1][j - 1] = 'P';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i][j + 1];
                            char down = mat[i - 1][j];
                            char left = mat[i - 1][j - 1];
                            char right = mat[i][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'P';
                                mat[i][j + 1] = 'P';
                                mat[i - 1][j] = 'P';
                                mat[i - 1][j - 1] = 'P';
                                mat[i][j - 1] = 'P';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P5 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length-1 && j< mat[i].length - 2) {
                            char top = mat[i][j+1];
                            char down = mat[i][j+2];
                            char left = mat[i+1][j];
                            char right = mat[i+1][j+1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'P';
                                mat[i][j+1] = 'P';
                                mat[i][j+2] = 'P';
                                mat[i+1][j] = 'P';
                                mat[i+1][j+1] ='P';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P6 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && j > 0) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i - 1][j - 1];
                            char right = mat[i][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'P';
                                mat[i + 1][j] = 'P';
                                mat[i - 1][j] = 'P';
                                mat[i][j - 1] = 'P';
                                mat[i - 1][j - 1] = 'P';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P7 extends Shapes {
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && (j > 0 && j < mat[i].length -1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j + 1];
                            char right = mat[i - 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'P';
                                mat[i - 1][j] = 'P';
                                mat[i][j - 1] = 'P';
                                mat[i][j + 1] = 'P';
                                mat[i - 1][j + 1] = 'P';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class P8 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && j < mat[i].length - 1) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i][j + 1];
                            char right = mat[i + 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'P';
                                mat[i + 1][j] = 'P';
                                mat[i - 1][j] = 'P';
                                mat[i][j + 1] = 'P';
                                mat[i + 1][j + 1] = 'P';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 1 && (j > 0 && j > 2)) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j - 2];
                            char right = mat[i][j - 3];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i + 1][j] = 'Q';
                                mat[i][j - 1] = 'Q';
                                mat[i][j - 2] = 'Q';
                                mat[i][j - 3] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i>2 && j > 0) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i - 2][j];
                            char right = mat[i - 3][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i][j - 1] = 'Q';
                                mat[i - 1][j] = 'Q';
                                mat[i - 2][j] = 'Q';
                                mat[i - 3][j] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && j < mat[i].length - 3) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j + 1];
                            char left = mat[i][j + 2];
                            char right = mat[i][j + 3];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i - 1][j] = 'Q';
                                mat[i][j + 1] = 'Q';
                                mat[i][j + 2] = 'Q';
                                mat[i][j + 3] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 3 && j < mat[i].length - 1){
                            char top = mat[i + 1][j];
                            char down = mat[i + 2][j];
                            char left = mat[i + 3][j];
                            char right = mat[i][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i + 1][j] = 'Q';
                                mat[i + 2][j] = 'Q';
                                mat[i + 3][j] = 'Q';
                                mat[i][j + 1] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q5 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 2 && j < mat[i].length - 1) {
                            char top = mat[i - 1][j];
                            char down = mat[i - 2][j];
                            char left = mat[i - 3][j];
                            char right = mat[i][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i - 1][j] = 'Q';
                                mat[i - 2][j] = 'Q';
                                mat[i - 3][j] = 'Q';
                                mat[i][j + 1] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q6 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 1 && j < mat[i].length - 3) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j + 1];
                            char left = mat[i][j + 2];
                            char right = mat[i][j + 3];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i + 1][j] = 'Q';
                                mat[i][j + 1] = 'Q';
                                mat[i][j + 2] = 'Q';
                                mat[i][j + 3] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q7 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 3 && j > 0) {
                            char top = mat[i][j - 1];
                            char down = mat[i + 1][j];
                            char left = mat[i + 2][j];
                            char right = mat[i + 3][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i][j - 1] = 'Q';
                                mat[i + 1][j] = 'Q';
                                mat[i + 2][j] = 'Q';
                                mat[i + 3][j] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Q8 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && j > 2) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j - 2];
                            char right = mat[i][j - 3];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Q';
                                mat[i - 1][j] = 'Q';
                                mat[i][j - 1] = 'Q';
                                mat[i][j - 2] = 'Q';
                                mat[i][j - 3] = 'Q';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i - 1][j + 1];
                            char left = mat[i][j - 1];
                            char right = mat[i + 1][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i - 1][j] = 'R';
                                mat[i - 1][j + 1] = 'R';
                                mat[i][j - 1] = 'R';
                                mat[i + 1][j] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i][j + 1];
                            char down = mat[i][j - 1];
                            char left = mat[i - 1][j];
                            char right = mat[i + 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i][j + 1] = 'R';
                                mat[i + 1][j + 1] = 'R';
                                mat[i][j - 1] = 'R';
                                mat[i - 1][j] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i][j + 1];
                            char right = mat[i + 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i + 1][j] = 'R';
                                mat[i - 1][j] = 'R';
                                mat[i][j + 1] = 'R';
                                mat[i + 1][j - 1] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j + 1];
                            char right = mat[i - 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i + 1][j] = 'R';
                                mat[i][j - 1] = 'R';
                                mat[i][j + 1] = 'R';
                                mat[i - 1][j - 1] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R5 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j + 1];
                            char right = mat[i + 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i - 1][j] = 'R';
                                mat[i][j - 1] = 'R';
                                mat[i][j + 1] = 'R';
                                mat[i + 1][j - 1] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R6 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j + 1];
                            char left = mat[i - 1][j - 1];
                            char right = mat[i - 1][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i + 1][j] = 'R';
                                mat[i][j + 1] = 'R';
                                mat[i - 1][j] = 'R';
                                mat[i - 1][j - 1] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R7 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j + 1];
                            char left = mat[i][j - 1];
                            char right = mat[i - 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i + 1][j] = 'R';
                                mat[i][j + 1] = 'R';
                                mat[i][j - 1] = 'R';
                                mat[i - 1][j + 1] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class R8 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i][j - 1];
                            char right = mat[i + 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'R';
                                mat[i + 1][j] = 'R';
                                mat[i - 1][j] = 'R';
                                mat[i][j - 1] = 'R';
                                mat[i + 1][j + 1] = 'R';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 1 && i< mat.length - 1) && j < mat[i].length- 1) {
                            char top = mat[i][j + 1];
                            char down = mat[i + 1][j + 1];
                            char left = mat[i - 1][j];
                            char right = mat[i - 2][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i][j + 1] = 'S';
                                mat[i + 1][j + 1] = 'S';
                                mat[i - 1][j] = 'S';
                                mat[i - 2][j] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 1 && (j > 0 && j < mat[i].length - 2)) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 1][j - 1];
                            char left = mat[i][j + 1];
                            char right = mat[i][j + 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i + 1][j] = 'S';
                                mat[i + 1][j - 1] = 'S';
                                mat[i][j + 1] = 'S';
                                mat[i][j + 2] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 2) && j>0 ) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 2][j];
                            char left = mat[i][j - 1];
                            char right = mat[i - 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i + 1][j] = 'S';
                                mat[i + 2][j] = 'S';
                                mat[i][j - 1] = 'S';
                                mat[i - 1][j - 1] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && (j > 1 && j < mat[i].length - 1)) {
                            char top = mat[i][j - 1];
                            char down = mat[i][j - 2];
                            char left = mat[i - 1][j];
                            char right = mat[i - 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i][j - 1] = 'S';
                                mat[i][j - 2] = 'S';
                                mat[i - 1][j] = 'S';
                                mat[i - 1][j + 1] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S5 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length -1 && (j > 1 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 1][j + 1];
                            char left = mat[i][j - 1];
                            char right = mat[i][j - 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i + 1][j] = 'S';
                                mat[i + 1][j + 1] = 'S';
                                mat[i][j - 1] = 'S';
                                mat[i][j - 2] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S6 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 1 && i < mat.length - 1) && j > 0) {
                            char top = mat[i][j - 1];
                            char down = mat[i + 1][j - 1];
                            char left = mat[i - 1][j];
                            char right = mat[i - 2][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i][j - 1] = 'S';
                                mat[i + 1][j - 1] = 'S';
                                mat[i - 1][j] = 'S';
                                mat[i - 2][j] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S7 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && (j > 0 && j < mat[i].length - 2)) {
                            char top = mat[i][j + 1];
                            char down = mat[i][j + 2];
                            char left = mat[i -1][j];
                            char right = mat[i - 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i][j+1] = 'S';
                                mat[i][j+2] = 'S';
                                mat[i-1][j] = 'S';
                                mat[i-1][j-1] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class S8 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 2) && j < mat[i].length - 1) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 2][j];
                            char left = mat[i - 1][j + 1];
                            char right = mat[i][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'S';
                                mat[i + 1][j] = 'S';
                                mat[i + 2][j] = 'S';
                                mat[i - 1][j + 1] = 'S';
                                mat[i][j + 1] = 'S';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class T1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 2 && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 2][j];
                            char left = mat[i][j + 1];
                            char right = mat[i][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'T';
                                mat[i][j + 1] = 'T';
                                mat[i][j - 1] = 'T';
                                mat[i + 1][j] = 'T';
                                mat[i + 2][j] = 'T';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class T2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && j < mat[i].length - 2) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i][j + 1];
                            char right = mat[i][j + 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'T';
                                mat[i][j + 1] = 'T';
                                mat[i][j + 2] = 'T';
                                mat[i + 1][j] = 'T';
                                mat[i - 1][j] = 'T';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class T3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 1 && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i - 2][j];
                            char left = mat[i][j + 1];
                            char right = mat[i][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'T';
                                mat[i][j + 1] = 'T';
                                mat[i][j - 1] = 'T';
                                mat[i - 1][j] = 'T';
                                mat[i - 2][j] = 'T';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class T4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (( i > 0 && i < mat.length - 1) && j > 1){
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i][j - 1];
                            char right = mat[i][j - 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'T';
                                mat[i + 1][j] = 'T';
                                mat[i - 1][j] = 'T';
                                mat[i][j - 1] = 'T';
                                mat[i][j - 2] = 'T';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class U1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j - 1];
                            char down = mat[i - 1][j + 1];
                            char left = mat[i][j + 1];
                            char right = mat[i][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'U';
                                mat[i - 1][j - 1] = 'U';
                                mat[i - 1][j + 1] = 'U';
                                mat[i][j + 1] = 'U';
                                mat[i][j - 1] = 'U';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class U2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1)  && j < mat[i].length - 1) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i + 1][j + 1];
                            char right = mat[i - 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'U';
                                mat[i + 1][j] = 'U';
                                mat[i - 1][j] = 'U';
                                mat[i + 1][j + 1] = 'U';
                                mat[i - 1][j + 1] = 'U';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class U3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 1 && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j - 1];
                            char down = mat[i + 1][j + 1];
                            char left = mat[i][j + 1];
                            char right = mat[i][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'U';
                                mat[i + 1][j - 1] = 'U';
                                mat[i + 1][j + 1] = 'U';
                                mat[i][j + 1] = 'U';
                                mat[i][j - 1] = 'U';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class U4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && j > 0) {
                            char top = mat[i - 1][j - 1];
                            char down = mat[i + 1][j - 1];
                            char left = mat[i + 1][j];
                            char right = mat[i - 1][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'U';
                                mat[i - 1][j - 1] = 'U';
                                mat[i + 1][j - 1] = 'U';
                                mat[i + 1][j] = 'U';
                                mat[i - 1][j] = 'U';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class V1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 1 && j < mat[i].length - 2) {
                            char top = mat[i - 1][j];
                            char down = mat[i - 2][j];
                            char left = mat[i][j + 1];
                            char right = mat[i][j + 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i - 1][j] = 'V';
                                mat[i - 2][j] = 'V';
                                mat[i][j] = 'V';
                                mat[i][j + 1] = 'V';
                                mat[i][j + 2] = 'V';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class V2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 2 && j < mat[i].length - 2) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 2][j];
                            char left = mat[i][j + 1];
                            char right = mat[i][j + 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i + 1][j] = 'V';
                                mat[i + 2][j] = 'V';
                                mat[i][j] = 'V';
                                mat[i][j + 1] = 'V';
                                mat[i][j + 2] = 'V';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class V3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 2 && j > 1) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 2][j];
                            char left = mat[i][j - 1];
                            char right = mat[i][j - 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i + 1][j] = 'V';
                                mat[i + 2][j] = 'V';
                                mat[i][j] = 'V';
                                mat[i][j - 1] = 'V';
                                mat[i][j - 2] = 'V';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class V4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 1 && j > 1) {
                            char top = mat[i - 1][j];
                            char down = mat[i - 2][j];
                            char left = mat[i][j - 1];
                            char right = mat[i][j - 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i - 1][j] = 'V';
                                mat[i - 2][j] = 'V';
                                mat[i][j] = 'V';
                                mat[i][j - 1] = 'V';
                                mat[i][j - 2] = 'V';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    private static class W1 extends Shapes {
        public char[][] draw(char[][] mat) {
            char[][] empty = new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i - 1][j - 1];
                            char right = mat[i + 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'W';
                                mat[i + 1][j] = 'W';
                                mat[i][j - 1] = 'W';
                                mat[i - 1][j - 1] = 'W';
                                mat[i + 1][j + 1] = 'W';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    private static class W2 extends Shapes {
        public char[][] draw(char[][] mat) {
            char[][] empty = new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i + 1][j - 1];
                            char right = mat[i - 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'W';
                                mat[i - 1][j] = 'W';
                                mat[i][j - 1] = 'W';
                                mat[i + 1][j - 1] = 'W';
                                mat[i - 1][j + 1] = 'W';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    private static class W3 extends Shapes {
        public char[][] draw(char[][] mat) {
            char[][] empty = new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j + 1];
                            char left = mat[i - 1][j - 1];
                            char right = mat[i + 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'W';
                                mat[i - 1][j] = 'W';
                                mat[i][j + 1] = 'W';
                                mat[i - 1][j - 1] = 'W';
                                mat[i + 1][j + 1] = 'W';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    private static class W4 extends Shapes {
        public char[][] draw(char[][] mat) {
            char[][] empty = new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i + 1][j - 1];
                            char left = mat[i][j + 1];
                            char right = mat[i - 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'W';
                                mat[i + 1][j] = 'W';
                                mat[i + 1][j - 1] = 'W';
                                mat[i][j + 1] = 'W';
                                mat[i - 1][j + 1] = 'W';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    private static class X1 extends Shapes{
        public char[][] draw(char [][] mat){
            char[][] empty= new char[0][0];
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[i].length;j++){
                    if(mat[i][j]=='.'){
                        if((i>0&&i<mat.length-1)&&(j>0&&j<mat[i].length-1)){
                            char top= mat[i-1][j];
                            char down= mat[i+1][j];
                            char left= mat[i][j-1];
                            char right= mat[i][j+1];
                            //System.out.println("HERE");
                            if(top=='.'&& left =='.'&& right=='.'&&down=='.'){
                                mat[i-1][j]='X';
                                mat[i+1][j]='X';
                                mat[i][j-1]='X';
                                mat[i][j+1]='X';
                                mat[i][j]='X';
                                return mat;
                                //System.out.println("THERE");
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 1 && (j > 0 && j < mat[i].length - 2)) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j + 1];
                            char right = mat[i][j + 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Y';
                                mat[i + 1][j] = 'Y';
                                mat[i][j - 1] = 'Y';
                                mat[i][j + 1] = 'Y';
                                mat[i][j + 2] = 'Y';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 2) && j > 0) {
                            char top = mat[i][j - 1];
                            char down = mat[i - 1][j];
                            char left = mat[i + 1][j];
                            char right = mat[i + 2][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Y';
                                mat[i + 1][j] = 'Y';
                                mat[i + 2][j] = 'Y';
                                mat[i][j - 1] = 'Y';
                                mat[i - 1][j] = 'Y';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && (j > 0 && j < mat[i].length - 2)) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j + 1];
                            char right = mat[i][j + 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Y';
                                mat[i - 1][j] = 'Y';
                                mat[i][j - 1] = 'Y';
                                mat[i][j + 1] = 'Y';
                                mat[i][j + 2] = 'Y';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 2) && j < mat[i].length - 1) {
                            char top = mat[i - 1][j];
                            char down = mat[i + 1][j];
                            char left = mat[i][j + 1];
                            char right = mat[i + 2][j];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Y';
                                mat[i - 1][j] = 'Y';
                                mat[i + 1][j] = 'Y';
                                mat[i][j + 1] = 'Y';
                                mat[i + 2][j] = 'Y';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y5 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i > 0 && (j > 1 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i][j + 1];
                            char left = mat[i][j - 1];
                            char right = mat[i][j - 2];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i - 1][j] = 'Y';
                                mat[i][j + 1] = 'Y';
                                mat[i][j - 1] = 'Y';
                                mat[i][j - 2] = 'Y';
                                mat[i][j] = 'Y';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y6 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 1 && i < mat.length - 1) && j < mat[i].length - 1) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i - 2][j];
                            char right = mat[i][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i + 1][j] = 'Y';
                                mat[i - 1][j] = 'Y';
                                mat[i - 2][j] = 'Y';
                                mat[i][j + 1] = 'Y';
                                mat[i][j] = 'Y';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y7 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 1 && i < mat.length - 1) && j > 0) {
                            char top = mat[i + 1][j];
                            char down = mat[i - 1][j];
                            char left = mat[i - 2][j];
                            char right = mat[i][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Y';
                                mat[i + 1][j] = 'Y';
                                mat[i - 1][j] = 'Y';
                                mat[i - 2][j] = 'Y';
                                mat[i][j - 1] = 'Y';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Y8 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if (i < mat.length - 1 && (j > 1 && j < mat[i].length - 1)) {
                            char top = mat[i + 1][j];
                            char down = mat[i][j - 1];
                            char left = mat[i][j - 2];
                            char right = mat[i][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j] = 'Y';
                                mat[i][j + 1] = 'Y';
                                mat[i][j - 1] = 'Y';
                                mat[i][j - 2] = 'Y';
                                mat[i + 1][j] = 'Y';
                                return mat;
                            }
                        }
                    }

                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Z1 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i + 1][j];
                            char left = mat[i - 1][j - 1];
                            char right = mat[i + 1][j + 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i - 1][j] = 'Z';
                                mat[i + 1][j] = 'Z';
                                mat[i][j] = 'Z';
                                mat[i - 1][j - 1] = 'Z';
                                mat[i + 1][j + 1] = 'Z';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Z2 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i][j + 1];
                            char down = mat[i][j - 1];
                            char left = mat[i - 1][j + 1];
                            char right = mat[i + 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j + 1] = 'Z';
                                mat[i][j - 1] = 'Z';
                                mat[i][j] = 'Z';
                                mat[i - 1][j + 1] = 'Z';
                                mat[i + 1][j - 1] = 'Z';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Z3 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i - 1][j];
                            char down = mat[i + 1][j];
                            char left = mat[i - 1][j + 1];
                            char right = mat[i + 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i - 1][j] = 'Z';
                                mat[i + 1][j] = 'Z';
                                mat[i][j] = 'Z';
                                mat[i - 1][j + 1] = 'Z';
                                mat[i + 1][j - 1] = 'Z';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }

    /**
     * Created by lburka on 5/9/15.
     */
    private static class Z4 extends Shapes{
        public char[][] draw(char[][] mat) {
            char[][] empty= new char[0][0];
            for (int i = 0;i < mat.length; i++) {
                for (int j = 0;j < mat[i].length; j++) {
                    if (mat[i][j] == '.') {
                        if ((i > 0 && i < mat.length - 1) && (j > 0 && j < mat[i].length - 1)) {
                            char top = mat[i][j - 1];
                            char down = mat[i][j + 1];
                            char left = mat[i + 1][j + 1];
                            char right = mat[i - 1][j - 1];
                            if (top == '.' && left == '.' && right == '.' && down == '.') {
                                mat[i][j - 1] = 'Z';
                                mat[i][j + 1] = 'Z';
                                mat[i][j] = 'Z';
                                mat[i - 1][j - 1] = 'Z';
                                mat[i + 1][j + 1] = 'Z';
                                return mat;
                            }
                        }
                    }
                }
            }
            return empty;
        }

        public String toString(){
            String className = this.getClass().getName();
            return className;
        }
    }
}
