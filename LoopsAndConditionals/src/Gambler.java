public class Gambler {
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);
        int bet = Integer.parseInt(args[1]);
        int goal = Integer.parseInt(args[2]);
        int trials = Integer.parseInt(args[3]);

        int wins = 0;
        for (int i = 0; i < trials; i++) {
            int t = stake;
            while (t > 0 && t < goal) {
                if (Math.random() < 0.5) t += bet;
                else t -= bet;
            }
            if (t >= goal) wins++;
        }
        System.out.println(wins + " wins of " + trials);
    }
}


