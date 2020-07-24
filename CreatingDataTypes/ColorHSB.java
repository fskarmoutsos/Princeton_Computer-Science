public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
        this.hue = h;
        this.saturation = s;
        this.brightness = b;


    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";

    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (saturation == 0 || brightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("the argument must not be null");
        int dHue = this.hue - that.hue;
        int absdHue = Math.abs(dHue);
        int dSat = this.saturation - that.saturation;
        int dBri = this.brightness - that.brightness;

        return Math.min(dHue * dHue, (360 - absdHue) * (360 - absdHue)) + dSat * dSat + dBri * dBri;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        ColorHSB col = new ColorHSB(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                                    Integer.parseInt(args[2]));
        int retHue = 0;
        int retSat = 0;
        int retBri = 0;
        int minDist = Integer.MAX_VALUE;
        String minColour = "";
        while (!StdIn.isEmpty()) {

            String fileCol = StdIn.readString();
            int fhue = StdIn.readInt();
            int fsat = StdIn.readInt();
            int fbri = StdIn.readInt();
            ColorHSB fcol = new ColorHSB(fhue, fsat, fbri);
            int dist = col.distanceSquaredTo(fcol);
            if (dist < minDist) {
                minDist = dist;
                minColour = fileCol;
                retHue = fhue;
                retSat = fsat;
                retBri = fbri;

            }

        }
        ColorHSB retCol = new ColorHSB(retHue, retSat, retBri);
        StdOut.println(minColour + " " + retCol);
    }
}
