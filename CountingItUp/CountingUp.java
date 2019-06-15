import java.util.*;
public class CountingUp {
 public static void main(String[] args) {
   try{
    
    ArrayList<Long> upperElements = new ArrayList<>();
    ArrayList<Long> lowerElements = new ArrayList<>();
    ArrayList<Long> simplified = new ArrayList<>();

    long n = Long.parseLong(args[0]);
    long k = Long.parseLong(args[1]);

    long difference = n - k;

    if (n == k || k == 0) {
        System.out.println(1);
        return;
    }

    if ((n-k) < k) {
      difference = k;
      k = n - k;
    }

   // System.out.printf("\n");

    long combinatorial;

    long topResult = n;
    long underResult = k;
    long multiplier = n - 1;

    upperElements.add(n);
    lowerElements.add(k);

   // System.out.println(difference);
    while (multiplier > difference) {
    //  System.out.println(multiplier);
      topResult *= multiplier;
      upperElements.add(multiplier);   
      multiplier--;
    }

    multiplier = k - 1;
    while (multiplier > 0) {
     // System.out.println(multiplier);
      underResult *= multiplier;  
      lowerElements.add(multiplier);    
      multiplier--;
    }

    // for (Long uE : upperElements) {
    //   System.out.printf("upper: %s\n",uE);
    // }

    // for (Long lE : lowerElements ) {
    //   System.out.printf("lower: %s\n", lE);
    // }

     simplified = simplify(upperElements, lowerElements);

    // for (Long u : upperElements) {
    //   System.out.printf("upper: %s\n",u);
    // }

    // for (Long l : lowerElements ) {
    //   System.out.printf("lower: %s\n", l);
    // }

    // for (Long s : simplified ) {
    //   System.out.printf("simplified: %s\n", s);
    // }

    combinatorial = simplified.get(0);
    for (int i = 1; i < simplified.size(); i++ ) {
      combinatorial *= simplified.get(i);
    }



    //System.out.printf("\n    %s! \n-----------\n %s!(%s - %s)!\nresult: %s\n", n, k, n, k, topResult/underResult);

    //System.out.printf("\n    %s! \n-----------\n %s!(%s - %s)!\nresult: %s\n", n, k, n, k, combinatorial);
    
    System.out.println(combinatorial);

   } catch(Exception ex){
    System.err.println("Usage: java CountingUp n k");
   }
 }


  public static ArrayList<Long> simplify(ArrayList<Long> upperElements, ArrayList<Long> lowerElements){
    ArrayList<Long> result = new ArrayList<>();
    Long u, l, g;
    while(notAllOne(lowerElements)){
      for (int i = 0; i < lowerElements.size(); i++) {
        for (int j = 0; j < upperElements.size(); j++) {
          l = lowerElements.get(i);
          u = upperElements.get(j);
          if (u > 1) {
            if (u % l == 0) {
              //System.out.printf("%s is divisible by %s\n", u, l);
              lowerElements.set(i, l/l);
              upperElements.set(j, u/l);
              u = u/l;
              l = l/l;
            } else if ((g = gcd(u,l)) > 1) {
         //     System.out.printf("%s and %s have a common factor of %s\n", u, l, g);
              lowerElements.set(i, l/g);
              upperElements.set(j, u/g);
              u = u/g;
              l = l/g;
            }
          }
         // System.out.println(lowerElements);
       //   System.out.println(upperElements);
        }
      }
    //  System.out.println(lowerElements);
    //  System.out.println(upperElements);
    }
    result.addAll(upperElements);
    return result;
  }

  public static boolean notAllOne(ArrayList<Long> lowerElements){
    for (Long l : lowerElements) {
      if (l > 1) return true;
    }
    return false;
  }

   /*
      Return 1 if no common factors
     */
  public static long gcd(long a, long b){
        while(a!=0 && b!=0) // until either one of them is 0
            {
                long c = b;
                b = a%b;
                a = c;
            }
        return a+b; // either one is 0, so return the non-zero value
    }
}
