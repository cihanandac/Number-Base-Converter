import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    boolean firstStage = true;
    while (firstStage) {
      boolean secondStage = true;
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
      String source = sc.next();

      // This section checks if the user type /exit
      if (source.equals("/exit")) {
        firstStage = false;
        break;
      }

      // source and target base numbers are taken and converted to BigInteger
      BigInteger sourceBig = new BigInteger(source);
      String target = sc.next();
      BigInteger targetBig = new BigInteger(target);

      // for making the program remember the user choice of base and target there are
      // two stages of the loop
      while (secondStage) {
        String ask = String.format("Enter number in base %s to convert to base %s " +
            "(To go back type /back)", source, target);
        System.out.println(ask);

        String num = sc.next();

        // This section checks if the user type /exit
        if (num.equals("/back")) {
          secondStage = false;
          break;
        }

        // If the source is 10, then we can skip converting to decimal.
        if (Integer.parseInt(source) != 10) {
          BigInteger decNum = convertToDec(num, sourceBig);
          String newNum = convertFromDec(decNum, targetBig);
          System.out.println(newNum);
        } else {
          BigInteger numBig = new BigInteger(num);
          String newNum = convertFromDec(numBig, targetBig);
          System.out.println(newNum);
        }
      }

    }

  }

  public static String convertFromDec(BigInteger number, BigInteger base) {
    String remainder;
    String newNum = "";

    String[] hexConv = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
        "t", "u", "v",
        "w", "x", "y", "z" };

    boolean dividing = true;
    while (dividing) {
      remainder = String.valueOf(number.remainder(base));
      number = number.divide(base);
      if (base.intValue() > 9 && Integer.parseInt(remainder) > 9) {
        remainder = hexConv[Integer.parseInt(remainder) - 10];
      }

      newNum = remainder + newNum;

      if (number.compareTo(base) < 0 && !Objects.equals(number.toString(), "0")) {
        if (base.intValue() > 9 && number.intValue() > 9) {
          remainder = hexConv[number.intValue() - 10];
          newNum = remainder + newNum;
          dividing = false;
        } else {
          newNum = number + newNum;
          dividing = false;
        }

      }
      if (number.intValue() == 0) {
        dividing = false;
      }
    }
    return "Conversion result:" + newNum;
  }

  public static BigInteger convertToDec(String number, BigInteger base) {
    int size = number.length();
    BigInteger newNum = BigInteger.valueOf(0);
    int value = 0;
    BigInteger valBig;

    for (int i = 0; i < size; i++) {
      boolean flag = Character.isDigit(number.charAt(i));
      if (base.intValue() > 0 && !flag) {
        switch (number.charAt(i)) {
          case 'a': {
            value = 10;
            break;
          }
          case 'b': {
            value = 11;
            break;
          }
          case 'c': {
            value = 12;
            break;
          }
          case 'd': {
            value = 13;
            break;
          }
          case 'e': {
            value = 14;
            break;
          }
          case 'f': {
            value = 15;
            break;
          }
          case 'g': {
            value = 16;
            break;
          }
          case 'h': {
            value = 17;
            break;
          }
          case 'i': {
            value = 18;
            break;
          }
          case 'j': {
            value = 19;
            break;
          }
          case 'k': {
            value = 20;
            break;
          }
          case 'l': {
            value = 21;
            break;
          }
          case 'm': {
            value = 22;
            break;
          }
          case 'n': {
            value = 23;
            break;
          }
          case 'o': {
            value = 24;
            break;
          }
          case 'p': {
            value = 25;
            break;
          }
          case 'q': {
            value = 26;
            break;
          }
          case 'r': {
            value = 27;
            break;
          }
          case 's': {
            value = 28;
            break;
          }
          case 't': {
            value = 29;
            break;
          }
          case 'u': {
            value = 30;
            break;
          }
          case 'v': {
            value = 31;
            break;
          }
          case 'w': {
            value = 32;
            break;
          }
          case 'x': {
            value = 33;
            break;
          }
          case 'y': {
            value = 34;
            break;
          }
          case 'z': {
            value = 35;
            break;
          }
        }
      } else {
        value = Character.getNumericValue(number.charAt(i));
      }

      valBig = BigInteger.valueOf(value);
      BigInteger res = base.pow(size - i - 1);
      newNum = newNum.add(valBig.multiply(res));

    }
    return newNum;
  }

}
