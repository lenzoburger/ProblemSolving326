package repeatedDigits;

import java.util.ArrayList;

/**
 * Created by lburka on 5/17/15
 */
public class findblock {
    private static ArrayList<Digit> numberSystem= new ArrayList<Digit>();

    public static void main(String[] args) {
        int b= Integer.parseInt(args[0]);
        int n= Integer.parseInt(args[1]);
        for(int i=0; i<b;i++){
            numberSystem.add(new Digit(i));
        }

        count(b,n,numberSystem);
    }

    public static void count(int b, int n, ArrayList<Digit> nS) {
        ArrayList[] values = new ArrayList[n];
        int i = 0;
        boolean repeat= false;
        int count= 0;
        int bestCount=0;
        int begin= 0;
        int bestBegin=0;
        while (i < n) {
            int mod = i;
            ArrayList<Digit> num = new ArrayList<Digit>();
            while (mod >= b) {
                Digit digit = nS.get(mod % b);
                num.add(0, digit);
                mod = mod / b;
            }
            num.add(0,nS.get(mod));
            if(hasRepeat(num)) {
                if(repeat==false){
                    repeat=true;
                    begin= i;
                    count=1;
                }else{
                    count++;
                }
                if(count>bestCount){
                    bestCount=count;
                    bestBegin=begin;
                }
            }else{
                repeat=false;
                count=0;
            }
            values[i] = num;
            i++;
        }
        System.out.println(bestBegin +" "+ bestCount);
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
