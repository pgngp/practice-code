/**
 * Rectangle area (104):
 * Find the total area covered by two rectilinear rectangles in a 2D plane. Each rectangle is defined by its bottom left corner and top right corner coordinates.
 * http://www.programcreek.com/2014/06/leetcode-rectangle-area-java/
 */

/*
 * time: O(1)
 * space: O(1)
 */

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1 = (C - A) * (D - B);
        int rect2 = ((G - E) * (H - F));
        int total = rect1 + rect2;

        // no overlap
        if (C <= E || G <= A || H <= B || D <= F) {
            return total;
        }

        // calculate overlapping x-axis
        int xOverlap = 0;
        if (A <= E && E < C && C <= G) {
            xOverlap = C - E;
        } else if (E <= A && A < G && G <= C) {
            xOverlap = G - A;
        } else if (A <= E && G <= C) {
            xOverlap = G - E;
        } else if (E <= A && C <= G) {
            xOverlap = C - A;
        }

        // calculate overlapping y-axis
        int yOverlap = 0;
        if (B <= F && F < D && D <= H) {
            yOverlap = D - F;
        } else if (F <= B && B < H && H <= D) {
            yOverlap = H - B;
        } else if (B <= F && H <= D) {
            yOverlap = H - F;
        } else if (F <= B && D <= H) {
            yOverlap = D - B;
        }

        return total - (xOverlap * yOverlap);
    }

    public static void main(String[] args) {
        RectangleArea ra = new RectangleArea();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);
        int f = Integer.parseInt(args[5]);
        int g = Integer.parseInt(args[6]);
        int h = Integer.parseInt(args[7]);
        int result = ra.computeArea(a, b, c, d, e, f, g, h);
        System.out.println("result: " + result);
    }
}
