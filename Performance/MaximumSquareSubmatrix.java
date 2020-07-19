public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int maxS = 0, i, j;
        int n = a.length;
        int s[][] = new int[n][n];
        /* Set first column of S[][]*/
        for (i = 0; i < n; i++)
            s[i][0] = a[i][0];

        /* Set first row of S[][]*/
        for (j = 0; j < n; j++)
            s[0][j] = a[0][j];

        /* Construct other entries of S[][]*/
        for (i = 1; i < n; i++) {
            for (j = 1; j < n; j++) {
                if (a[i][j] == 1) {
                    s[i][j] = Math.min(s[i][j - 1], Math.min(s[i - 1][j], s[i - 1][j - 1])) + 1;
                    if (maxS < s[i][j]) {
                        maxS = s[i][j];
                    }
                }
                else {
                    s[i][j] = 0;
                }
            }
        }
        return maxS;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
                // System.out.print(a[i][j]);
                // if (j == n - 1) System.out.println();
            }
        }
        System.out.println(size(a));

    }
}
