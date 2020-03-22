/**
 * Excel sheet column title (112):
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet. For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * …
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 26;
            rem = rem == 0 ? 26 : rem;
            sb.append((char) ('A' + rem - 1));
            n /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        String result = e.convertToTitle(Integer.parseInt(args[0]));
        System.out.println("result: " + result);    
    }
}
