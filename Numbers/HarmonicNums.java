public class HarmonicNums{

    public static void main(String args[]) {
        float singleResult = calcHarmSingle(10000);
        double doubleResult = calcHarmDouble(10000);
        float singleReverse = calcHarmSingleRev(10000);
        double doubleReverse = calcHarmDoubleRev(10000);
        
        System.out.println("single result " + singleResult);
        
        System.out.println("single reverse " + singleReverse);
        

        System.out.println("partial harmonic sum for n = 4 25.0 / 12.0: " +
                           25.0 / 12.0);
    }
    
    public static float calcHarmSingle(int n) {
        float result = 0;
        for (int i = 1; i <= n; i++) {
            result += (1f / i);
        }
        return result;
    }

    public static float calcHarmSingleRev(int n) {
        float result = 0;
        for (int i = n; i > 0; i--) {
            result += (1f / i);
        }
        return result;
    }
    
    public static double calcHarmDouble(int n) {
        double loss = 0.0;
        double result = 0.0;
        double lastResult = 0.0;
        for (int i = 1; i <= n; i++) {
            lastResult = result;
            result += (1.0d / i);
            double difference = result - lastResult;
            loss += Math.abs((1.0d / i) - difference);
        }
        System.out.println("double result " + result);
        System.out.println("loss: " + loss);
        return result;
    }

    public static double calcHarmDoubleRev(int n) {
        double loss = 0.0;
        double result = 0.0;
        double lastResult = 0.0;
        for (int i = n; i > 0; i--) {
            lastResult = result;
            result += (1.0d / i);
            double difference = result - lastResult;
            loss += Math.abs((1.0d / i) - difference);
        }
        System.out.println("double reverse " + result);
        System.out.println("loss: " + loss);
        return result;
    } 
}
