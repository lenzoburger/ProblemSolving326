package poker;

//Lencho Burka
import java.util.*;

public class Poker {
    private static String[] cards = new String[52];
    private static String[] lineArray = new String[5];
    private static String[] tempArray = new String[5];
    private static int count = 0;

    public static void main(String[] args) {
        String line;
        String hand;
        String temp;
        String output;
        Scanner input = new Scanner(System.in);
        int index;
        while (input.hasNextLine()) {
            index = 0;
            line = input.nextLine();
            hand = line;
            output = "";
            line = separator(line);
            if (!(line.equals("Invalid: "))) {
                for (String each : lineArray) {
                    line = validator(each, each.charAt(each.length() - 1));
                    if (line.equals("Invalid: ")) {
                        // System.out.println("checkpoint 1: "+ each);
                        output = "";
                        break;
                    }
                    temp = output(each, each.charAt(each.length() - 1));
                    if (dup(temp, cards) || dup(temp, tempArray)) {
                        // System.out.println(each + " checkpoint 2: " + temp);
                        output = "";
                        break;
                    }
                    tempArray[index] = temp;
                    index++;
                    output += temp;
                }
            }
            if (output.equals("")) {
                System.out.println("Invalid: " + hand);
            } else {
                temp = "";
                for (int i = 0; i < 4; i++) {
                    temp += tempArray[i] + " ";
                    cards[count] = tempArray[i];
                    count++;
                }
                cards[count] = tempArray[4];
                count++;
                System.out.println(temp + tempArray[4]);
                // System.out.println();
            }
        }
        input.close();
    }

    public static String validator(String card, char type) {
        char num = card.charAt(0);
        if (!(type == 'c' || type == 'C')) {
            if (!(type == 'h' || type == 'H')) {
                if (!(type == 'd' || type == 'D')) {
                    if (!(type == 's' || type == 'S')) {
                        return "Invalid: ";
                    }
                }
            }
        }

        if (card.length() == 3) {
            if (!(num == '1')) {
                return "Invalid: ";
            }
            num = card.charAt(1);
            if (!(num >= '0' && num <= '3')) {
                return "Invalid: ";
            }
        }

        if (card.length() == 2) {
            if (!(num >= '1' && num <= '9')) {
                if (!(num == 'a' || num == 'A')) {
                    if (!(num == 't' || num == 'T')) {
                        if (!(num == 'j' || num == 'J')) {
                            if (!(num == 'q' || num == 'Q')) {
                                if (!(num == 'k' || num == 'K')) {
                                    return "Invalid: ";
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!(card.length() >= 2 && card.length() <= 3)) {
            // System.out.println(card.length() + " Invalid type: " + card);
            return "Invalid: ";
        }

        return "";
    }

    public static String separator(String line) {
        String separator = "";
        int i = 0;
        String temp = "";
        line = line + " ";
        for (char each : line.toCharArray()) {
            if (each == ('-') || each == (' ')) {
                if ((temp.length() == 2 || temp.length() == 3) && i < 5) {
                    lineArray[i] = temp;
                    i++;
                    temp = "";
                    separator += each;
                } else {
                    return "Invalid: ";
                }
            } else if (each == ('/')) {
                if ((temp.length() == 2 || temp.length() == 3) && i < 5) {
                    lineArray[i] = temp;
                    i++;
                    temp = "";
                    separator += each;
                } else {
                    return "Invalid: ";
                }
            } else if (each <= 'z' && each >= 'a') {
                temp += each;
            } else if (each <= 'Z' && each >= 'A') {
                temp += each;
            } else if (each >= '0' && each <= '9') {
                if (temp.equals("") || temp.length() < 3) {
                    if (temp.length() == 2) {
                        if (each >= '0' && each <= '3') {
                            temp += each;
                        } else {
                            return "Invalid: ";
                        }
                    } else {
                        temp += each;
                    }
                } else {
                    return "Invalid: ";
                }
            } else {
                return "Invalid: ";
            }
        }

        if (i == 5) {
            if (!(separator.equals("---- "))) {
                if (!(separator.equals("//// "))) {
                    if (!(separator.equals("     "))) {
                        return "Invalid: ";
                    }
                }
            }
        } else {
            return "Invalid: ";
        }
        return "";
    }

    public static String output(String card, char type) {
        String output = "";
        String suit = Character.toString(type);
        suit = suit.toUpperCase();
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                if (card.charAt(i) == '1') {
                    if (card.charAt(i + 1) == '0') {
                        output = "10";
                        break;
                    } else if (card.charAt(i + 1) == '1') {
                        output = "J";
                        break;
                    } else if (card.charAt(i + 1) == '2') {
                        output = "Q";
                        break;
                    } else if (card.charAt(i + 1) == '3') {
                        output = "K";
                        break;
                    } else {
                        output = "A";
                        break;
                    }
                } else if (card.charAt(i) == 't' || card.charAt(i) == 'T') {
                    output = "10";
                } else if (card.charAt(i) >= 'a' && card.charAt(i) <= 'z') {
                    output = card.substring(i, i + 1);
                    output = output.toUpperCase();
                    break;
                } else {
                    output += card.substring(i, i + 1);
                    break;
                }
            }
        }
        output += suit;
        return output;
    }

    public static boolean dup(String card, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (card.equals(array[i])) {
                return true;
            }
        }
        return false;
    }
}