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

public class ExcelColumnTitle {
    public static String getColName(int colNum) {
        String colName = "";
        char[] arr = {'-', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        while (colNum > 0) {
            int remainder = colNum % 26;
            if (remainder == 0) {
                remainder = 26;
                colNum = (colNum / 26) - 1;
            } else {
                colNum /= 26;
            }
            colName = arr[remainder] + colName;
        }

        return colName;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <arg>");
            System.exit(1);
        }

        String colName = getColName(Integer.parseInt(args[0]));
        System.out.println(String.format("%s -> %s", args[0], colName));
    }
}

