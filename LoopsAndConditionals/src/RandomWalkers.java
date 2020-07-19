public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double steps = 0;
        for (int l = 1; l <= trials; l++) {
            int i = 0;
            int j = 0;
            while ((Math.abs(i) + Math.abs(j)) < r) {
                steps++;
                double k = Math.random();
                if (k >= 0.75) {
                    j += 1;
                } else if (k > 0.5) {
                    i += 1;
                } else if (k > 0.25) {
                    i -= 1;
                } else {
                    j -= 1;
                }
                //System.out.println("(" + i + ", " + j + ")");

            }

        }
        System.out.println("average number of steps = " + steps / (double) trials);
    }
}
