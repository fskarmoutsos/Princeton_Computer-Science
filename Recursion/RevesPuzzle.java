public class RevesPuzzle {
    private static void reves(int n, String from, String temp1, String temp2, String to) {
        if (n == 0) return;
        if (n == 1) {
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            return;

        }
        reves(n - 2, from, temp2, to, temp1);
        StdOut.println("Move disc " + (n - 1) + " from " + from + " to " + temp2);
        StdOut.println("Move disc " + (n) + " from " + from + " to " + to);
        StdOut.println("Move disc " + (n - 1) + " from " + temp2 + " to " + to);
        reves(n - 2, temp1, from, temp2, to);
    }

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == k) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        reves(k, "A", "B", "D", "C");
        hanoi(n, k, "A", "B", "D");
        reves(k, "C", "A", "C", "D");

    }
}
