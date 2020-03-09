/**
 * Simplify path (58):
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/../", => "/"
 * path = "/home//foo/", => "/home/foo"
 * http://www.programcreek.com/2014/04/leetcode-simplify-path-java/
 */

/*
 * time: O(n), where n is the number of dirs
 * space: O(n)
 */

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] arr = path.split("/+");
        for (String s : arr) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                stack.pollFirst();
            } else {
                stack.addFirst(s);
            }
        }

        StringBuilder newPath = new StringBuilder();
        while (stack.peekLast() != null) {
            newPath.append("/").append(stack.removeLast());
        }

        return newPath.length() > 0 ? newPath.toString() : newPath.append("/").toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String result = sp.simplifyPath(args[0]);
        System.out.println("result: *" + result + "*");
    }
}
