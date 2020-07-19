public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        // StdDraw.setPenRadius(0.005);
        // StdDraw.setPenColor(Color.BLACK);
        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int vertNum = StdIn.readInt();
            double[] x = new double[vertNum];
            double[] y = new double[vertNum];
            for (int i = 0; i < vertNum; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
            // StdDraw.show();
        }
    }
}
