/**
 * Fraction to recurring decimal (70):
 * Given two integers representing the numerator and denominator of fraction fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * http://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
 */

/**
 * time: O(n) where n is number of digits in fraction
 * space: O(n) where n is number of digits in fraction
 */

public class Fraction {
    public static String convertIntToString(int num) {
        String str = "";
        while (num > 0) {
            int remainder = num % 10;
            str = remainder + str;
            num /= 10;
        }

        return str.isEmpty() ? "0" : str;
    }

    public static String convertDoubleToString(double fraction) {
        System.out.println("fraction: " + fraction);
        String decimalStr = (fraction < 0) ? "-" : "";
        fraction = Math.abs(fraction);
        int decimal = (int) fraction;
        decimalStr += convertIntToString(decimal);
        String fractionStr = "";
        fraction -= decimal;
        int prev = 0;
        while (fraction != 0) {
            fraction *= 10;
            decimal = (int) (fraction % 10);
            if (decimal == prev) {
                fractionStr += "(" + prev + ")";
                return decimalStr + "." + fractionStr;
            } else if (prev != 0) {
                fractionStr += prev;
                prev = decimal;
            } else {
                prev = decimal;
            }

            fraction -= decimal;
        }

        if (fractionStr.isEmpty() && prev == 0) {
            return decimalStr;
        } else if (fractionStr.isEmpty()) {
            return decimalStr + "." + prev;
        } else if (prev == 0) {
            return decimalStr + "." + fractionStr;
        } else {
            return decimalStr + "." + fractionStr + prev;
        }
    }

    public static String getFraction(int numerator, int denominator) {
        return convertDoubleToString((double) numerator / denominator);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java <prog> <numerator> <denominator>");
            System.exit(1);
        }

        int numerator = Integer.parseInt(args[0]);
        int denominator = Integer.parseInt(args[1]);
        System.out.println(String.format(
                    "Fraction string of numerator %d and denominator %d is %s",
                    numerator,
                    denominator,
                    getFraction(numerator, denominator)
        ));
    }
}

