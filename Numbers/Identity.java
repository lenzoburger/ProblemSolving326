import java.util.*;

public class Identity {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        System.out.println("LHS: " + x);
        System.out.println("RHS: " + calcRHS(x,y));
        
    }

    public static double calcRHS(double x, double y) {
        return ((x / y) - x * y) * y + x * y * y;
    }
}
