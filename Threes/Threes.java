/** Author: Lencho Burka **/
package threes;

public class Threes{
  public static int count=0;
  public static int count2=0;
  
  public static void main(String [] args){    
    int x=3;
    int z=2;
    while(count<70){
      increasingX(x);
      x++;
    }
    System.out.println();
    while(count2<70){
      increasingZ(z);
      z++;
    }
    
  }
  
  
  public static void increasingX(int x){
    long  ySqr = 1;
    long  xSqr = x*x;
    long  z = 1;
    //long  lB = ((z*z*z*z) + 1) / 2;   
    
    while (z < x) {
      //lB = ((z*z*z*z) + 1) / 2;
      ySqr = (((z*z*z*z) + 1) - xSqr);
      if ((xSqr < ySqr) && pSqr(ySqr)) {      
        ySqr = (long)Math.sqrt(ySqr);
        if(noFactors(xSqr,ySqr,(int)z)){
          if(count<70){
            System.out.println((count+1) + " " + x + " " + ySqr +" " + z);
            count++;
          }
          //return;
        }
      }
      z++;
    }
  }
  
  public static void increasingZ(int z){    
    long x= z+1;
    long y=x+1;
    long xSqr=(long)Math.pow(x,2);;
    long ySqr=y*y;
    long result=(long)(Math.pow(z,4))+1;
    //System.out.println(count2 + " x = " + x + " y =" + y +" z =" + z);
    while(x<y && x>z){
      //System.out.println(" Two " +count2 + " x = " + x + " y =" + y +" z =" + z);
      xSqr=(long)Math.pow(x,2);
      ySqr=result-(xSqr);
      y=(long)Math.sqrt(ySqr);
      if(((xSqr) < (ySqr)) && pSqr(ySqr)){
        result=(long)(Math.pow(z,4))+1;
        if(noFactors(x,y,z)&&result==(xSqr+ySqr)){
          //System.out.println(result + " = " + ((x*x)+ySqr));
          if(count2<70){                       
            System.out.println((count2+1) + " " + x + " " + y +" " + z);
            count2++;
          }
        }
      }
      x++;         
    }
    return;
  }
  
  
  public static boolean pSqr(long ySqr){
    long square = (long)Math.sqrt(ySqr);
    if (square * square == ySqr) {
      return true;
    } else {
      return false;
    }
  }
  
  
  
  public static boolean noFactors(long x, long y, int z){
    return gCD(x,y)==1 && gCD(x,z)==1 && gCD(y,z)==1;
  }
  
  
  private static long gCD(long a, long b) {    
    while(a!=0 && b!=0){ // until either one of them is 0
      
      long c = b;
      b = a%b;
      a = c;
    }
    return a+b; // either one is 0, so return the non-zero value
  }
  
}