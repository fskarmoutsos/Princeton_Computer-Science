public class ShannonEntropy {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] freq = new int[m];
        double SH = 0;
        double sumOfN = 0;
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            freq[n - 1]++;
            sumOfN++;
        }
        for (int i = 0; i < m; i++) {
            double pi = freq[i] / sumOfN;
            double logpi = Math.log(pi) / Math.log(2);
            if (pi != 0) {
                SH += -pi * logpi;
            }
        }
        StdOut.printf("%.4f\n", SH);

    }
}

