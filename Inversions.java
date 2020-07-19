public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long invNum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) invNum++;
            }
        }
        // System.out.println(invNum);
        return invNum;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] arr = new int[n];
        int inv = 0, i = 0;
        if (n == 0 && k == 0) return arr;
        if (k == 0) {
            for (int j = 0; j < n; j++) {
                arr[j] = j;
            }
        }
        else if (k < n) {
            for (int j = 0; j < n - k - 1; j++) arr[j] = j;
            arr[n - (int) k - 1] = n - 1;
            for (int j = n - (int) k; j < n; j++) arr[j] = j - 1;
        }
        else {
            while (k - inv > n - i - 1) {
                arr[i] = n - 1 - i;
                inv += n - i - 1;
                i++;
            }
            int knew = ((int) k - inv);
            for (int j = i; j < n - knew - 1; j++) arr[j] = j - i;
            arr[n - knew - 1] = n - i - 1;
            for (int j = n - knew; j < n; j++) arr[j] = j - 1 - i;


        }
        return arr;
    }


    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        // int[] b = { 8, 7, 0, 1, 2, 6, 5, 4, 3 };
        // int[] a = { 0, 4, 1, 2, 5, 3, 6 };

        // count(generate(7, 8));
        int[] a; //= new int[n];
        a = generate(n, k);
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");

        // System.out.println("count  :" + count(a));
    }
}
