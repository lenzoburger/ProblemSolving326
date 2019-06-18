package colourOfTheDay;

import java.util.*;

public class GenerateCOTDAlt {
  private enum Day {
    TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, MONDAY
  };

  private static Day day;
  private static int DOOMSDAY = 1000 * 350;
  private static String[] colourMap = new String[(DOOMSDAY + 7)];
  public static List<Integer> factors = new ArrayList<Integer>();
  public static int green;
  public static int red;
  public static int blue;
  public static String HOLIDAY = "";
  public static boolean print = false;
  public static int printOnly = 1000000;

  // public static int day=1;
  public static void main(String[] args) {
    int year = 1;
    int days = 1;
    long startTime = System.nanoTime();

    while (days < DOOMSDAY) {
      for (Day each : day.values()) {
        if (mileStone(days) && HOLIDAY.equals("")) {
          HOLIDAY = "------ ### 3 DAY HOLIDAYS --" + "Year: " + year + " Date: " + days + " -- GOLD  -- "
              + each.toString();
        }
        green = 0;
        red = 0;
        blue = 0;
        year = (days / 350) + 1;
        if (days % 350 == 0) {
          if (days % (DOOMSDAY / 100) == 0) {
            double percentage = ((double) days / (double) DOOMSDAY) * 100;
            // System.out.println("-----------------------------------At Year " + days/350
            // +" -------------------------- " + (int)percentage + "% COMPLETE
            // -------------------------------------");
          }
        }
        days++;
        if (isPrime(days)) {
          primeColour(year, days, each);
        } else {
          primeFactors(days);
          // difference(primeFactors(days));
          nonPrimeColour(year, days, each);
        }
      }
    }
    // System.out.println("FIRST 3-DAY HOLIDAY: " + HOLIDAY);
    // System.out.println("%%%%%%%%%%%%%%% HOLIDAYS IN YEAR 50 %%%%%%%%%%%% " +
    // countHolidays(50) + " %%%%%%%%%%%%%%%%");
    // System.out.println("%%%%%%%%%%%%%%% HOLIDAYS IN YEAR 1,000 %%%%%%%%%%%% " +
    // countHolidays(1000) + " %%%%%%%%%%%%%%%%");
    // System.out.println("%%%%%%%%%%%%%%% HOLIDAYS IN YEAR 1,000,000 %%%%%%%% " +
    // countHolidays(1000000) + " %%%%%%%%%%%%%%%%");
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    double milliSeconds = duration / 1000000.0;
    // System.out.println("Time: " + milliSeconds + " Milliseconds --- " + duration
    // + " Nanoseconds");
    for (int i = 2; i <= 1000; i++) {
      System.out.println(i + " " + colourMap[i]);
    }
  }

  public static void printMe(int d, int y, Day dotw, String col) {
    if (print && printOnly == 0) {
      System.out.println("Year: " + y + " Date: " + d + " -- " + col + "  -- " + dotw.toString());
    } else if (printOnly > 0 && printOnly == y) {
      System.out.println("Year: " + y + " Date: " + d + " -- " + col + "  -- " + dotw.toString());
    }
  }

  public static int countHolidays(int years) {
    int goldenDays = 0;
    years = (years - 1) * 350;
    int temp = years + 350;
    while (years < (temp)) {
      if (colourMap[years].equals("GOLD")) {
        goldenDays++;
      }
      years++;
    }
    return goldenDays;
  }

  public static void primeColour(int y, int d, Day dotw) {
    switch (dotw) {
    case MONDAY:
    case THURSDAY:
      colourMap[d] = "RED";
      printMe(d, y, dotw, colourMap[d]);
      break;

    case FRIDAY:
    case TUESDAY:
      colourMap[d] = "GREEN";
      printMe(d, y, dotw, colourMap[d]);
      break;

    case SATURDAY:
    case WEDNESDAY:
      colourMap[d] = "BLUE";
      printMe(d, y, dotw, colourMap[d]);
      break;

    case SUNDAY:
      colourMap[d] = "GOLD";
      printMe(d, y, dotw, colourMap[d]);
      break;
    }
  }

  public static void nonPrimeColour(int y, int d, Day dotw) {
    if (red == green && red != blue) {
      colourMap[d] = "BLUE";
      printMe(d, y, dotw, colourMap[d]);
    } else if (red == blue && green != blue) {
      colourMap[d] = "GREEN";
      printMe(d, y, dotw, colourMap[d]);
    } else if (green == blue && green != red) {
      colourMap[d] = "RED";
      printMe(d, y, dotw, colourMap[d]);
    } else if (green == blue && green == red) {
      colourMap[d] = "GOLD";
      printMe(d, y, dotw, colourMap[d]);
    } else if (green != blue && green != red) {
      if (green > blue && green > red) {
        colourMap[d] = "GREEN";
        printMe(d, y, dotw, colourMap[d]);
      } else if (blue > green && blue > red) {
        colourMap[d] = "BLUE";
        printMe(d, y, dotw, colourMap[d]);
      } else if (red > blue && red > green) {
        colourMap[d] = "RED";
        printMe(d, y, dotw, colourMap[d]);
      }
    }
  }

  public static boolean isPrime(int n) {
    // check if n is a multiple of 2
    if (n == 1) {
      return false;
    }
    if (n % 2 == 0 && n != 2)
      return false;
    // if not, then just check the odds
    for (int i = 3; i * i <= n; i += 2) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  public static void colCount(int number) {
    String colour = colourMap[number];
    // System.out.println(l + " " + colour);
    if (colour.equals("RED")) {
      red++;
    } else if (colour.equals("GREEN")) {
      green++;
    } else if (colour.equals("BLUE")) {
      blue++;
    }
  }

  public static boolean mileStone(int nums) {
    String today = colourMap[nums];
    if (nums > 3 && today.equals("GOLD")) {
      String yesterday = colourMap[(nums - 1)];
      String dayBefore = colourMap[(nums - 2)];
      if (today.equals(yesterday) && today.equals(dayBefore)) {
        System.out.println("---------- day " + nums + ": " + dayBefore + " --------- day " + (nums - 1) + ": " + today
            + " -------- day " + (nums - 2) + ": " + yesterday);
        return true;
      }
    }
    return false;
  }

  public static void primeFactors(int numbers) {
    String realFactors = numbers + "th Day: ";
    String divFactor = numbers + "th Day: ";
    int n = numbers;
    // List<Integer> factors = new ArrayList<Integer>();
    for (int i = 2; i <= n / i; i++) {
      while (n % i == 0) {
        // factors.add(i);
        int prevFactors = n / i;
        int devider = numbers - prevFactors;
        if (prevFactors > 1 && prevFactors != numbers) {
          colCount(devider);
          realFactors += prevFactors + ", ";
          divFactor += devider + ", ";
        }
        n /= i;
      }
    }
    if (n > 1) {
      // factors.add(n);
      int prevFactors2 = numbers / n;
      int devider2 = numbers - prevFactors2;
      if (prevFactors2 > 1 && prevFactors2 != numbers) {
        colCount(devider2);
        realFactors += prevFactors2 + ", ";
        divFactor += devider2 + ", ";
      }
    }
  }
}
