public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] thue = new int[n];
        thue[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                thue[i] = thue[i / 2];
            } else {
                thue[i] = (1 - thue[i - 1]);
            }
        }
//        for (int k = 0; k < n; k++) {
//            System.out.print(thue[k]);
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String pre = " ";
                pre = (j == 0) ? "" : " ";
                if (thue[i] != thue[j]) {
                    System.out.print(pre + "- ");
                } else {
                    System.out.print(pre + "+ ");
                }
            }
            System.out.println();
        }
    }
}

