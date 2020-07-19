public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int cumulative = 0;
        int[] count = new int[n + 2];
        for (int i = 0; i < trials; i++) {
            int people = 0;
            boolean[] hasBirthday = new boolean[n];
            while (true) {
                people++;                               // one more person enters the room
                int d = (int) (n * Math.random());   // integer between 0 and days-1
                if (hasBirthday[d]) {
                    count[people]++;
                    break;              // found two people with the same birthday
                }
                hasBirthday[d] = true; // update array
            }
        }
        for (int i = 1; i <= n + 1; i++) {
            cumulative += count[i];
            double average = (double) cumulative / trials;
            System.out.println(i + "\t" + count[i] + "\t" + average);
            if (average >= 0.5) break;
        }
    }
}
