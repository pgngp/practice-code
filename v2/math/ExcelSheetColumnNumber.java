/**
 * Excel sheet column number (123):
 * Given a column title as appear in an Excel sheet, return its corresponding column number. For example:
 * A -> 1
 * B -> 2
 * C -> 3
 *  …
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * …
 * AAA -> 703
 * http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-number-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int pos = 0, sum = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, pos);
            ++pos;
        }

        return sum;       
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        int result = e.titleToNumber(args[0]);
        System.out.println("result: " + result);
    }
}

