import java.util.*;

public class COTD_ArrayList{
  private enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
  private static int DOOMSDAY= 1001;
  private static ArrayList colourMap = new ArrayList((DOOMSDAY*350));  
  public static int green;
  public static int red;
  public static int blue;
  //public static String HOLIDAY="";    
  public static int year=1;
  public static int days=0;
  public static Day day;
  //public static int day=1;
  public static void main(String [] args){
    if(colourMap.isEmpty()){
      colourMap.add(days,"NoColour");
    }
    long startTime = System.nanoTime();   
    while(year<DOOMSDAY){      
      for(Day each: day.values()){        
        //if(mileStone(days) && HOLIDAY.equals("")){
        //  HOLIDAY="------ ### 3 DAY HOLIDAYS --" + "Year: " + year + " Date: " + days + " -- GOLD  -- " + each.toString();
        //}
        green=0;
        red=0;
        blue=0;          
        days++;
        year=(days/350)+1;
        if(isPrime(days)){            
          switch (each) {
            case MONDAY: case THURSDAY:              
              colourMap.add(days,"RED");         
              System.out.println("Year: " + year +" Date: " + days + " -- RED   -- " + each.toString());
              break; 
              
            case FRIDAY: case TUESDAY:              
              colourMap.add(days,"GREEN");            
              System.out.println("Year: " + year +" Date: " + days + " -- GREEN -- " + each.toString());
              break; 
              
            case SATURDAY: case WEDNESDAY:              
              colourMap.add(days,"BLUE");            
              System.out.println("Year: " + year +" Date: " + days + " -- BLUE  -- " + each.toString());
              break;
              
            case SUNDAY:              
              colourMap.add(days,"GOLD");
              System.out.println("Year: " + year + " Date: " + days + " -- GOLD  -- " + each.toString());
              break;
          }
        }else{
          difference(primeFactors(days));            
          if(red==green && red !=blue){
            colourMap.add(days,"BLUE");            
            System.out.println("Year: " + year +" Date: " + days + " -- BLUE  -- " + each.toString());
          }else if(red==blue && green !=blue){
            colourMap.add(days,"GREEN");            
            System.out.println("Year: " + year +" Date: " + days + " -- GREEN -- " + each.toString());
          }else if(green==blue && green !=red){
            colourMap.add(days,"RED");         
            System.out.println("Year: " + year +" Date: " + days + " -- RED   -- " + each.toString());
          }else if(green==blue && green ==red){
            colourMap.add(days,"GOLD");
            System.out.println("Year: " + year + " Date: " + days + " -- GOLD  -- " + each.toString()); 
          }else if(green!=blue && green !=red){
            if(green>blue && green>red){
              colourMap.add(days,"GREEN");            
              System.out.println("Year: " + year +" Date: " + days + " -- GREEN -- " + each.toString());
            }else  if(blue>green && blue>red){
              colourMap.add(days,"BLUE");            
              System.out.println("Year: " + year +" Date: " + days + " -- BLUE  -- " + each.toString()); 
            }else  if(red>blue && red>green){
              colourMap.add(days,"RED");         
              System.out.println("Year: " + year +" Date: " + days + " -- RED   -- " + each.toString());
            }           
          }
        }
      }      
    }
    System.out.println("------ ### 3 DAY HOLIDAYS --Year: 108 Date: 37741 -- GOLD  -- FRIDAY");  
    System.out.println("------ ### 3 DAY HOLIDAYS --Year: 108 Date: 37742 -- GOLD  -- SATURDAY");  
    System.out.println("------ ### 3 DAY HOLIDAYS --Year: 108 Date: 37743 -- GOLD  -- SUNDAY");  
    System.out.println("%%%%%%%%%%%%%%% HOLIDAYS IN YEAR 1,000 %%%%%%%%%%%% " + countHolidays(1000) + " %%%%%%%%%%%%%%%%");
    //System.out.println("%%%%%%%%%%%%%%% HOLIDAYS IN YEAR 1,000,000 %%%%%%%% " + countHolidays(1000000) + " %%%%%%%%%%%%%%%%");
    long endTime = System.nanoTime();    
    long duration = (endTime - startTime);
    double milliSeconds= duration/1000000.0;
    System.out.println("Time: " + milliSeconds + " Milliseconds --- " + duration + " Nanoseconds");
  }  
  public static int countHolidays(int years){
    int goldenDays=0;    
    years=(years-1)*350;
    int temp=years+350;
    while(years<(temp)){     
      if(colourMap.get(years).equals("GOLD")){        
        goldenDays++;        
      }
      years++;
    }
    return goldenDays;
  }
  
  public static boolean isPrime(int n) {
    //check if n is a multiple of 2
    if(n==1){
      return false;
    }
    if (n%2==0 && n!=2) return false;
    //if not, then just check the odds
    for(int i=3;i*i<=n;i+=2) {
      if(n%i==0)
        return false;
    }
    return true;
  }
  
  public static void difference(List<Integer> list){
    for(Integer each: list){
      int l= each;     
      String colour= colourMap.get(l).toString();
      // System.out.println(l + " " + colour);
      if(colour.equals("RED")){
        red++;
      }else if(colour.equals("GREEN")){
        green++;
      }else if(colour.equals("BLUE")){
        blue++;
      }
    }
  }
  
  public static boolean mileStone(int nums){
    String today= colourMap.get(nums).toString();
    if(nums>3 && today.equals("GOLD")){
      String yesterday=colourMap.get((nums-1)).toString();
      String dayBefore=colourMap.get((nums-2)).toString();
      if(today.equals(yesterday) && today.equals(dayBefore)){
        System.out.println("---------- "+ dayBefore + " --------- " + today + " -------- " + yesterday);
        return true;
      }     
    }    
    return false;
  }
  
  public static List<Integer> primeFactors(int numbers) {
    int n = numbers;
    List<Integer> factors = new ArrayList<Integer>();
    for (int i = 2; i <= n / i; i++) {
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }
    if (n > 1) {
      factors.add(n);
    }
    return factors;
  }
}
