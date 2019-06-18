package repeatedDigits;

import java.util.ArrayList;

/**
 * Created by lburka on 5/17/15
 */
public class findRepeat {
    private static ArrayList<Digit> numberSystem= new ArrayList<Digit>();
    private static ArrayList<Digit> numberSystemC= new ArrayList<Digit>();
    public static void main(String[] args) {
        int b= 0;
        int c= 0;

        try {
            b= Integer.parseInt(args[0]);
            c= Integer.parseInt(args[1]);
         } catch (Exception ex) {
             System.err.println("\nUsage: java repeatedDigits.findRepeat [base1 b] [base2 c]\n");
             throw ex;
         }


        for(int i=0; i<b;i++){
            numberSystem.add(new Digit(i));
        }
        for(int i=0; i<c;i++){
            numberSystemC.add(new Digit(i));
        }

        findrepeat(b, c, numberSystem, numberSystemC);
    }

    public static void findrepeat(int b, int c, ArrayList<Digit> nS,ArrayList<Digit> nSC) {
        int i = 0;
        while (i<Integer.MAX_VALUE) {
            int mod = i;
            int modC = i;
            ArrayList<Digit> num = new ArrayList<Digit>();
            ArrayList<Digit> numC = new ArrayList<Digit>();
            while (mod >= b) {
                Digit digit = nS.get(mod % b);
                num.add(0, digit);
                mod = mod / b;
            }
            while (modC >= c) {
                Digit digitC = nSC.get(modC % c);
                numC.add(0, digitC);
                modC = modC / c;
            }
            numC.add(0,nSC.get(modC));
            num.add(0,nS.get(mod));
            if(hasRepeat(num)&&hasRepeat(numC)){
                System.out.println("\nSmallest with integer repeating digits (n): "+i);
                return;
            }
            i++;
        }
        System.out.println("\nNot Possible");
    }

    public static boolean hasRepeat(ArrayList<Digit> number){
        for (Digit each: number){
            int me= number.indexOf(each);
            for(int i=0;i<number.size();i++){
                if(i!=me){
                    if(number.get(i)==each){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static class Digit{
        public String label="";
        public Digit(int n){
            label+=n;
        }
        public String toString(){
            return label;
        }
    }
}

