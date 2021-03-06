import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // StdAudio.loop("soundtrackA.wav");
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In in = new In(filename);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        in.readLine();

        BarChart chart = new BarChart(title, xAxis, source);
        while (in.hasNextLine()) {
            int numOfRecords = Integer.parseInt(in.readLine());

            Bar[] bars = new Bar[numOfRecords];
            String caption = "";

            for (int i = 0; i < numOfRecords; i++) {
                String temp = in.readLine();
                String[] a = temp.split(",");
                caption = a[0];
                bars[i] = new Bar(a[1], Integer.parseInt(a[3]), a[4]);
            }
            Arrays.sort(bars);

            chart.setCaption(caption);
            for (int i = bars.length - 1; i > bars.length - 1 - k; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(1);
            chart.reset();

            in.readLine();
        }
        chart.reset();
    }
}
