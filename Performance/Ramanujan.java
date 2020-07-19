public class Ramanujan {
    public static boolean isRamanujan(long n) {
        int count = 0;

        long x = 1;
        long y = (int) Math.cbrt(n);

        while (x < y) {

            long sum = x * x * x + y * y * y;
            if (sum < n) {
                x = x + 1;
            }
            else if (sum > n) {
                y = y - 1;
            }
            else {
                count++;
                x = x + 1;
                y = y - 1;
            }

            if (count >= 2) {
                return true;
            }
        }

        return false;

    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        // double start = System.currentTimeMillis() / 1000.0;
        System.out.println(isRamanujan(n));
        // double now = System.currentTimeMillis() / 1000.0;
        // StdOut.printf(" (%.0f seconds)\n", now - start);
    }
}
