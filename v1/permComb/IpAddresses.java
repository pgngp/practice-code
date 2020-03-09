/**
 * Restore IP addresses (102):
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example: given "25525511135",return ["255.255.11.135", "255.255.111.35"].
 * http://www.programcreek.com/2014/06/leetcode-restore-ip-addresses-java/
 */

import java.util.ArrayList;
import java.util.List;

public class IpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        helper(result, s, 0, "", 0);

        return result;
    }

    private void helper(List<String> result, String digits, int index, String currStr, int numOctets) {
        if (index == digits.length() && numOctets == 4) {
            result.add(currStr);
            return;
        } else if (index == digits.length()) {
            return;
        } else if (numOctets == 4) {
            return;
        } else if (numOctets > 0) {
            currStr += ".";
        }

        String octet = "";
        for (int i = 0; i < 3; ++i) {
            if (index + i >= digits.length()) {
                return;
            } else if (i == 1 && digits.charAt(index) == '0') {
                return;
            }

            octet += digits.charAt(index + i);
            if (Integer.parseInt(octet) > 255) {
                return;
            }

            currStr += digits.charAt(index + i);
            helper(result, digits, index + i + 1, currStr, numOctets + 1);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java <prog> <digits>");
            System.exit(1);
        }   

        IpAddresses ia = new IpAddresses();
        List<String> result = ia.restoreIpAddresses(args[0]);
        System.out.println(result);
    }
}
