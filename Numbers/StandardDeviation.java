package numbers;

import java.util.*;
public class StandardDeviation{    

 public static void main(String[] args){
        int n = 10;
        //  if(args.length > 1) n = Integer.valueOf(args[1]);
        double[] test1 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0};
        double[] test = initArray(n);
        double[] t1 = initArray(n);

        System.out.print("\nArray: [");
        for(double i: test1){
            System.out.print(" " + i);
        }
        System.out.println(" ]");
        
       
        System.out.printf("Stdv Method 1: %s\n", method1(test1));
        System.out.printf("Stdv Method 2: %s\n", method2(test1));

        System.out.println("\n100 added to each element.");
        System.out.printf("Method 1: %s\n", method1(addValue(test1)));
        System.out.printf("Method 2: %s\n", method2(addValue(test1)));


        System.out.println("\nRandom array of length " + n);
         System.out.printf("Stdv Method 1: %s\n", method1(test));
        System.out.printf("Stdv Method 2: %s\n", method2(test));

        System.out.println("\n100 added to each element.");
        System.out.printf("Method 1: %s\n", method1(addValue(test)));
        System.out.printf("Method 2: %s\n", method2(addValue(test)));

    }

    public static double[] initArray(int n){
        Random r = new Random();
        double[] result = new double[n];
        for(int i = 0; i < n; i++){
            result[i] = r.nextInt(9) + 1;
        }
        return result;
    }

    public static double[] addValue(double[] setNums){
        double[] result = new double[setNums.length];
        for(int i = 0; i < setNums.length; i++){
            result[i] = setNums[i] + (double) 1000;
        }
        return result;
    }
    
 public static double method2(double[] setNums){
        double len = setNums.length;
        double cumulativeSum = 0;
        double variantSum = 0;
        double mean;
        double variance;
        for(double i: setNums){
            cumulativeSum += (double)i;
        }
        mean = cumulativeSum/len;
        for(double i: setNums){
            variantSum += Math.pow((double)i, 2);
        }
        variance = (double)((variantSum/len) - Math.pow(mean, 2));
        return (double)Math.sqrt(variance);
    }

    public static double method1(double setNums[]){
        double len = setNums.length;
        double cumulativeSum = 0;
        double variantSum = 0;
        double stdv;
        double mean;
        for(double i: setNums){
            cumulativeSum += (double)i;
        }
        mean = cumulativeSum/len;
        for(double i: setNums){
            variantSum += Math.pow((double)i - mean, 2);
        }
        stdv = Math.sqrt(variantSum/len);
        return stdv;
    }
}
