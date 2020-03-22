/**
 * Fraction to recurring decimal (70):
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * http://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
 */

/*
 * time: O(1)
 * space: O(1)
 */

import java.util.*;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        int flag = 1;
        long n = (long) numerator;
        if (numerator < 0) {
            flag = -flag;
            n = -n;
        }
        long d = (long) denominator;
        if (denominator < 0) {
            flag = -flag;
            d = -d;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(n / d);
        long rem = n % d; 
        int pos = 0;
        boolean hasDecimalPoint = false;
        Map<Long, Integer> posMap = new HashMap<>();
        Map<Long, Long> dividendMap = new HashMap<>();
        while (rem > 0) {
            long dividend = rem * 10;
            long quot = dividend / d;
            rem = dividend % d;
            if (hasDecimalPoint) {
                ++pos;
                if (!posMap.containsKey(rem) || dividendMap.get(rem) != dividend) {
                    posMap.put(rem, pos);
                    dividendMap.put(rem, dividend);
                    sb.append(quot);
                } else {
                    int offset = pos - posMap.get(rem);
                    sb.insert(sb.length() - offset, "(");
                    sb.append(")");
                    break;
                }
            } else {
                sb.append(".");
                sb.append(quot);
                hasDecimalPoint = true;
                posMap.put(rem, pos);
                dividendMap.put(rem, dividend);
            }
        }

        if (flag < 0) {
            sb.insert(0, "-");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal f = new FractionToRecurringDecimal();
        String result = f.fractionToDecimal(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("result: " + result);
    }
}
