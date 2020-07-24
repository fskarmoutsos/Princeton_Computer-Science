public class Clock {
    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        this.hours = h;
        this.minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) throw new IllegalArgumentException("Valid format HH:MM");
        if (!s.contains(":"))
            throw new IllegalArgumentException("Valid format HH:MM");
        int h = Integer.parseInt(s.substring(0, 2));
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        int m = Integer.parseInt(s.substring(3));
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        this.hours = h;
        this.minutes = m;
    }


    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String HH;
        String MM;
        if (this.hours > 9) {
            HH = Integer.toString(this.hours);
        }
        else {
            HH = "0" + Integer.toString(this.hours);
        }
        if (this.minutes > 9) {
            MM = Integer.toString(this.minutes);
        }
        else {
            MM = "0" + Integer.toString(this.minutes);
        }
        return (HH + ":" + MM);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) {
            return true;
        }
        else if (this.hours == that.hours && this.minutes < that.minutes) {
            return true;
        }
        else {
            return false;
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.minutes < 59) {
            this.minutes += 1;
        }
        else {
            if (this.hours < 23) {
                this.hours += 1;
            }
            else if (this.hours == 23) {
                this.hours = 0;
            }
            this.minutes = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Delta must be between positive");
        int dh = this.hours + delta / 60;
        int dm = this.minutes + delta % 60;
        if (dm > 59) {
            dm -= 60;
            dh += 1;
        }
        if (dh > 23) {
            dh %= 24;
        }
        this.hours = dh;
        this.minutes = dm;
    }

    // Test client (see below).
    public static void main(String[] args) {
        // Clock cl1 = new Clock(-2147483648, -2147483648);
        Clock cl2 = new Clock("02:5");
        // StdOut.println(cl1);
        StdOut.println(cl2);
        // StdOut.println(cl1.isEarlierThan(cl2));
        // cl1.tic();
        // cl2.tic();
        // StdOut.println(cl1);
        // StdOut.println(cl2);
        // cl1.toc(30000);
        // StdOut.println(cl1);
        // cl2.toc(10);
        // StdOut.println(cl2);
        // cl1.toc(180);
        // StdOut.println(cl1);

    }
}
