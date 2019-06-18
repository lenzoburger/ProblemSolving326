package telephoneNumbers;

//Lencho Burka
import java.util.*;
import java.io.Console;
import java.math.*;

public class TeleNumberApp {
  private static String[] nums = new String[100];
  private static int counter = 0;

  public static void main(String[] args) {
    String check = "";
    String line;
    System.out.println("Enter Telephone Number(s) for validation: \n");
    Scanner input = new Scanner(System.in);
    while (input.hasNextLine()) {
      line = input.nextLine();
      check = sort(line);
      if (check.equals("INVALID")) {
        System.out.println(line + " INV\n");
      }

      if (!(check.equals("INVALID")) && counter < 100) {
        for (int i = 0; i < counter; i++) {
          if (nums[i].equals(check)) {
            line = " DUP";
            break;
          }
        }

        if (line.equals(" DUP")) {
          System.out.println(check + line + "\n");
        } else {
          nums[counter] = check;
          counter++;
          System.out.println(check + "\n");
        }
      }
    }
    input.close();
  }

  public static String sort(String numbers) {
    int prefix;
    int letters = 0;
    char character = ' ';
    int paranthases = 0;
    int ascii = (int) character;
    int count = 9;
    String nums = "";
    if (numbers.length() >= count && numbers.length() < 16) {
      for (int i = 0; i < numbers.length(); i++) {
        character = numbers.charAt(i);
        ascii = (int) character;
        if ((ascii >= 48 && ascii <= 57) || (character == '-' && i > 4)) {
          nums += numbers.substring(i, i + 1);
          if (nums.length() == 3) {
            if (nums.substring(0, 3).equals("025")) {
              nums = "0274";
            }
          }
        } else if (character == '(' && i == 0) {
          paranthases++;
        } else if (character == ')' && paranthases == 1) {
          prefix = Integer.parseInt(nums);
          if (prefix >= 21 && prefix <= 27 && i == 4) {
            paranthases++;
          } else if (prefix >= 2 && prefix <= 9 && i == 3) {
            paranthases++;
          } else if (prefix >= 508 && prefix <= 900 && i == 5) {
            paranthases++;
          } else {
            return "INVALID";
          }
        } else if (character == ' ') {
          //count = count;
        } else if (ascii >= 65 && ascii <= 90 && nums.length() >= 4) {
          prefix = Integer.parseInt(nums.substring(0, 4));
          if (prefix >= 508 && prefix <= 900 && nums.length() <= 14) {
            nums += numbers.substring(i, i + 1);
            letters++;
          } else {
            return "INVALID";
          }
        } else {
          return "INVALID";
        }
      }
      if (paranthases == 1) {
        return "INVALID";
      }
      return type(numbers, nums, letters);
    } else {
      return "INVALID";
    }
  }

  public static String type(String numbers, String nums, int letters) {
    if (nums.substring(0, 3).equals("021") || nums.substring(0, 3).equals("027")
        || nums.substring(0, 3).equals("022")) {
      return mobileCodes(numbers, nums, nums.substring(0, 3));
    } else if (nums.substring(0, 4).equals("0508") || nums.substring(0, 4).equals("0800")
        || nums.substring(0, 4).equals("0900")) {
      if (letters > 0) {
        return letters(numbers, nums, nums.substring(0, 4), letters);
      } else {
        return initialCodes(numbers, nums, nums.substring(0, 4));
      }
    } else if (nums.substring(0, 5).equals("02409") || nums.substring(0, 2).equals("03")
        || nums.substring(0, 2).equals("04") || nums.substring(0, 2).equals("06") || nums.substring(0, 2).equals("07")
        || nums.substring(0, 2).equals("09")) {
      return areaCodes(numbers, nums, nums.substring(0, 2));
    }
    return "INVALID";
  }

  public static String letters(String original, String nums, String type, int letters) {
    nums = remove(nums, 7);
    String newNums = type;
    char charc = ' ';
    if (letters <= 9 && nums.length() <= 13) {
      for (int i = 4; i < nums.length(); i++) {
        charc = nums.charAt(i);
        if (charc >= 'A' && charc <= 'Z') {
          newNums += convert(charc);
        } else if (charc >= '0' && charc <= '9') {
          if (type.equals("0508") && i <= 9) {
            newNums += nums.substring(i, i + 1);
          } else if (type.equals("0800") && i <= 10) {
            newNums += nums.substring(i, i + 1);
          } else if (type.equals("0900") && i <= 8) {
            newNums += nums.substring(i, i + 1);
          } else {
            return "INVALID";
          }
        } else {
          return "INVALID";
        }
      }
    } else {
      return "INVALID";
    }
    return format(newNums, type);
  }

  public static String convert(char l) {
    if (l >= 'A' && l <= 'C') {
      return "2";
    } else if (l >= 'D' && l <= 'F') {
      return "3";
    } else if (l >= 'G' && l <= 'I') {
      return "4";
    } else if (l >= 'J' && l <= 'L') {
      return "5";
    } else if (l >= 'M' && l <= 'O') {
      return "6";
    } else if (l >= 'P' && l <= 'S') {
      return "7";
    } else if (l >= 'T' && l <= 'V') {
      return "8";
    } else if (l >= 'W' && l <= 'Z') {
      return "9";
    } else {
      return "0";
    }
  }

  public static String initialCodes(String original, String nums, String type) {
    if (!(type.equals("0900"))) {
      nums = remove(nums, 7);
    }
    if (nums.substring(0, 4).equals("0508") && nums.length() == 10) {
      return format(nums, type);
    } else if (nums.substring(0, 4).equals("0800") && (nums.length() == 10 || nums.length() == 11)) {
      return format(nums, type);
    } else if (nums.substring(0, 4).equals("0900") && nums.length() == 9) {
      return format(nums, type);
    } else {
      return "INVALID";
    }
  }

  public static String areaCodes(String original, String nums, String type) {
    nums = remove(nums, 5);
    String block1 = nums.substring(2, 5);
    if (nums.length() == 9) {
      if (nums.substring(0, 2).equals("02")) {
        return format(nums, type);
      } else if (!(nums.substring(0, 2).equals("02"))) {
        if (!(nums.charAt(2) == '1') && !(nums.charAt(2) == '0')) { // Digit must be between 2 to 9
          if (block1.equals("900") || block1.equals("911") || block1.equals("999")) {
            return "INVALID";
          }
          return format(nums, type);
        } else {
          return "INVALID";
        }
      }
    }
    return "INVALID";
  }

  public static String mobileCodes(String original, String nums, String type) {
    if (type.equals("021") && nums.length() == 12) {
      nums = remove(nums, 7);
    } else {
      nums = remove(nums, 6);
    }
    if (nums.substring(0, 3).equals("021") && (nums.length() >= 9 && nums.length() <= 11)) {
      return format(nums, type);
    } else if ((nums.substring(0, 3).equals("022") || nums.substring(0, 3).equals("027")) && nums.length() == 10) {
      return format(nums, type);
    } else {
      return "INVALID";
    }
  }

  public static String remove(String nums, int index) {
    String init_nums = "";
    for (int i = 0; i < nums.length(); i++) {
      if (nums.charAt(i) == '-' && i == index) {
        continue;
      } else if (nums.charAt(i) == '-' && i != index) {
        return "INVALID";
      } else {
        init_nums += nums.substring(i, i + 1);
      }
    }
    return init_nums;
  }

  public static String format(String phoneFmt, String type) {
    int block2 = 0;
    int chunk = phoneFmt.length() - type.length();
    String block = phoneFmt.substring(type.length());
    if (chunk == 6 || chunk == 7) {
      block2 = 3;
    } else if (chunk == 8 || chunk == 9) {
      block2 = 4;
    }
    if (chunk == 5) {
      java.text.MessageFormat phoneMsgFmt = new java.text.MessageFormat("{0} {1}");
      String[] phoneNumArr = { type, block.substring(0) };
      return phoneMsgFmt.format(phoneNumArr);
    } else {
      java.text.MessageFormat phoneMsgFmt = new java.text.MessageFormat("{0} {1} {2}");
      String[] phoneNumArr = { type, block.substring(0, block2), block.substring(block2) };
      return phoneMsgFmt.format(phoneNumArr);
    }
  }
}
