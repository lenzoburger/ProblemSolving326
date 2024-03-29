package carpets;

import java.util.*;

public class MakeCarpet {
  public static void main(String[] args) {
    ArrayList<String> pieces = new ArrayList<String>();

    int n = 0;
    Scanner in = null;
    try {
      n = Integer.parseInt(args[0]);
      in = new Scanner(System.in);
    } catch (Exception ex) {
      System.err.println("\nUsage: java carpets.MakeCarpet [carpetSize] [MatchType] < [inputFile]\n");
      throw ex;
    }

    while (in.hasNextLine()) {
      String strip = in.nextLine();
      if (!(pieces.isEmpty())) {
        if (strip.length() != pieces.get(0).length()) {
          System.out.println("All carpet strips must be of the same size");
        } else {
          reverseIt(strip, pieces);
        }
      } else {
        reverseIt(strip, pieces);
      }
      // pieces.add();
    }

    in.close();

    if (args[1].equals("-n")) {
      makeNoMatchCarpet(n, pieces);
    } else if (args[1].equals("-m")) {
      makeMaxMatchCarpet(n, pieces);
    } else if (args[1].equals("-b")) {
      makeBalancedCarpet(n, pieces);
    } else {
      throw new IllegalArgumentException("Bad argument");
    }
  }

  public static void makeMaxMatchCarpet(int n, ArrayList<String> pieces) {
    if (n <= pieces.size()) {
      MaxMatchGraph g = new MaxMatchGraph(pieces.size());
      g.printErr += "Max Matches: \n\n";
      Collections.sort(pieces);
      // System.out.println(pieces + " length: " + pieces.size());
      for (int i = 0; i < pieces.size(); i++) {
        g.addPiece(pieces.get(i).toString(), i);
      }
      for (Piece each : g.pieceList) {
        g.printErr += each + " ";
      }
      g.printErr += "\n\n";
      g.relationShips();
      // g.displayAdjMat();
      ArrayList<Integer> list = new ArrayList<Integer>();
      list = g.maxMatch(n);

      System.out.println("\nMax Matches for carpet length " + list.size() + " = " + g.calculateListMatches(list));
      System.out.println();
      ArrayList<String> strList = new ArrayList<String>();
      strList = g.fixMe(list);
      for (String each : strList) {
        System.out.println(each);
      }
    } else {
      System.out.println("Carpet size specified is greater than avialable stock");
    }
  }

  public static void makeNoMatchCarpet(int n, ArrayList<String> pieces) {
    if (n <= pieces.size()) {
      System.out.println("\nMake Non Matching Carpet of Size " + n + "....\n");
      NoMatchGraph g = new NoMatchGraph(pieces.size());
      g.printErr += "No Matches: \n\n";
      Collections.sort(pieces);
      // System.out.println(pieces + " length: " + pieces.size());
      for (int i = 0; i < pieces.size(); i++) {
        g.addPiece(pieces.get(i).toString(), i);
      }
      for (Piece each : g.pieceList) {
        g.printErr += each + " ";
      }

      g.printErr += "\n\n";
      g.relationShips();
      // g.displayAdjMat();
      ArrayList<Integer> list = new ArrayList<Integer>();
      list = g.nonMatches(n);
      // System.out.println(list);
      if (list.size() == n) {
        ArrayList<String> strList = new ArrayList<String>();
        strList = g.fixMe(list);
        for (String each : strList) {
          System.out.println(each);
        }
      } else {
        list = g.balancedMatches(0, n);
        // System.out.println(balList);
        if (!(list.isEmpty())) {
          ArrayList<String> strList = new ArrayList<String>();
          strList = g.fixMe(list);
          for (String each : strList) {
            System.out.println(each);
          }
        } else {
          System.out.println("Non Matching Carpet of Size " + n + " is not possible");
        }
      }
      System.out.println();
    } else {
      System.out.println("Carpet size specified is greater than avialable stock");
    }
  }

  public static void makeBalancedCarpet(int n, ArrayList<String> pieces) {
    if (n <= pieces.size()) {
      System.out.println("\nMake a Balanced Carpet....\n");
      BalMatchGraph g = new BalMatchGraph(pieces.size());
      g.printErr += "Max Matches: \n\n";
      Collections.sort(pieces);

      for (int i = 0; i < pieces.size(); i++) {
        g.addPiece(pieces.get(i).toString(), i);
      }
      for (Piece each : g.pieceList) {
        g.printErr += each + " ";
      }
      g.printErr += "\n\n";
      g.relationShips();
      ArrayList<String> list = new ArrayList<String>();
      list = g.findBalance(n);
      System.out.println();
      System.out.println();
      if (list.size() == n) {
        System.out.println("Carpet size: " + n + "\nBalance: " + g.calculateBal(list) + "\n");
        for (String each : list) {
          System.out.println(each);
        }
      } else {
        System.out.println("Balance not possible: " + list);
      }
    } else {
      System.out.println("Carpet size specified is greater than avialable stock");
    }
  }

  private static ArrayList<String> reverseIt(String strip, ArrayList<String> list) {
    String reverse = new StringBuilder(strip).reverse().toString();
    if (list.isEmpty()) {
      list.add(strip);
    } else if (list.contains(reverse)) {
      list.add(reverse);
    } else {
      list.add(strip);
    }
    return list;
  }

}