public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int len = args.length;
        double[] S = new double[len];
        S[0] = 0;
        for (int i = 1; i < len; i++) {
            S[i] = S[i - 1] + Integer.parseInt(args[i]);
            // System.out.println(S[i]);
        }
        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * S[len - 1]);
            for (int i = 1; i < len; i++) {
                if ((S[i - 1] <= r) && (S[i] > r)) {
                    System.out.print(i + " ");
                    break;
                }
            }
            if ((j > 1) && ((j + 1) % 25 == 0)) System.out.println();

        }
    }
}
