public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] mines = new String[m + 2][n + 2];
        int f = 0;
        while (f < k) {
            int r = (int) (Math.random() * m + 1);
            int q = (int) (Math.random() * n + 1);
            if (mines[r][q] == "*") continue;
            mines[r][q] = "*";
            f++;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (mines[i][j] != "*") {
                    int mines_num = 0;
                    if (mines[i - 1][j - 1] == "*") mines_num++;
                    if (mines[i][j - 1] == "*") mines_num++;
                    if (mines[i + 1][j - 1] == "*") mines_num++;
                    if (mines[i - 1][j] == "*") mines_num++;
                    if (mines[i + 1][j] == "*") mines_num++;
                    if (mines[i - 1][j + 1] == "*") mines_num++;
                    if (mines[i][j + 1] == "*") mines_num++;
                    if (mines[i + 1][j + 1] == "*") mines_num++;
                    mines[i][j] = Integer.toString(mines_num);
                }
            }

        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(mines[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
