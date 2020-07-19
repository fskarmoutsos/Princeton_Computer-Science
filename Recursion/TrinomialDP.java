public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        long[][] cfArray = new long[n + 1][2 * n + 4];
        if (k < 0) k = -k;
        if (n == 0 && k == 0) {
            return 1;
        }
        else if (k < -n || k > n) {
            return 0;
        }
        else {
            cfArray[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= 2 * n; j++) {
                    cfArray[i][j] = cfArray[i - 1][h(j - 1)] + cfArray[i - 1][h(j)] + cfArray[i
                            - 1][h(j + 1)];
                    // cfArray[i][j] = cfArray[i - 1][j] + 2 * cfArray[i - 1][j
                    //         + 1];
                }
            }
            return cfArray[n][k];
        }
    }

    private static int h(int k1) {
        if (k1 < 0) {
            return -k1;
        }
        else {
            return k1;
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        // if (k < 0) k = -k;
        long result = trinomial(n, k);
        System.out.println(result);

    }

}





