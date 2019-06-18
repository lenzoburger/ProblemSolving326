package numbers;

public class Identity {

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        System.out.println("LHS: " + x);
        System.out.println("RHS: " + calcRHS(x,y));
    }

    public static double calcRHS(double x, double y) {
        return ((x / y) - x * y) * y + x * y * y;
    }
}
