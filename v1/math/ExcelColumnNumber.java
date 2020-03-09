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

/**
 * time: O(n) where n is the length of the column name string
 * space: O(1)
 */

public class ExcelColumnNumber {
    public static int getColNum(String colName) {
        int index = 0;
        int colNum = 0;
        for (int i = colName.length() - 1; i >= 0; --i) {
            colNum += Math.pow(26, index) * (colName.charAt(i) - 'A' + 1);
            ++index;
        }

        return colNum;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <col>");
            System.exit(1);
        }

        int colNum = getColNum(args[0]);
        System.out.println(String.format("%s -> %d", args[0], colNum));
    }
}

