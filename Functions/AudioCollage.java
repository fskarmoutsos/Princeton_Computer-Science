public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        // double maximum = a[0];
        // int index = 1;
        double[] aa = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            // if (maximum < a[i]) {
            //     maximum = a[i];
            //     index = i;
            // }
            // double check = a[i] * alpha;
            // if (check < -1) {
            //     a[i] = -1;
            // }
            // else if (check > 1) {
            //     a[i] = 1;
            // }
            // else {
            aa[i] = a[i] * alpha;
            // }

        }
        // for (int i = 0; i < a.length; i++) {
        //     a[i] = a[i] / a[index];
        // }
        return aa;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int len = a.length;
        double[] aa = new double[a.length];
        for (int i = 0; i < len / 2; i++) {
            double mezz = a[i];
            aa[i] = a[len - 1 - i];
            aa[len - 1 - i] = mezz;
        }
        return aa;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int len = a.length + b.length;
        double[] m = new double[len];
        for (int i = 0; i < a.length; i++) m[i] = a[i];
        for (int i = a.length; i < len; i++) m[i] = b[i - a.length];
        return m;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int len = Math.max(a.length, b.length);
        double[] s = new double[len];
        if (a.length <= b.length) {
            for (int i = 0; i < a.length; i++) {
                s[i] = a[i] + b[i];
            }
            for (int i = a.length; i < b.length; i++) {
                s[i] = b[i];
            }
        }
        if (a.length > b.length) {
            for (int i = 0; i < b.length; i++) {
                s[i] = a[i] + b[i];
            }
            for (int i = b.length; i < a.length; i++) {
                s[i] = a[i];
            }
        }
        // double maximum = s[0];
        // int index = 1;
        // for (int i = 0; i < len; i++) {
        //     if (maximum < s[i]) {
        //         maximum = s[i];
        //         index = i;
        //     }
        // }
        // for (int i = 0; i < len; i++) {
        //     s[i] = s[i] / a[index];
        //
        // }
        return s;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double len = a.length / alpha;
        int leni = (int) Math.round(len);
        double[] s = new double[leni];
        for (int i = 0; i < leni; i++) {
            int index = Math.max((int) Math.round(i * alpha) - 1, 0);
            s[i] = a[index];
        }
        return s;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        // double[] a = StdAudio.read("beatbox.wav");
        // StdAudio.play(amplify(a, 2));
        // double[] b = StdAudio.read("buzzer.wav");
        // StdAudio.play(reverse(b));
        // double[] c = StdAudio.read("cow.wav");
        // double[] d = StdAudio.read("dialup.wav");
        // StdAudio.play(merge(c, d));
        // double[] e = StdAudio.read("exposure.wav");
        // double[] f = StdAudio.read("harp.wav");
        // StdAudio.play(mix(e, f));


        double[] a = { -0.375, 0.125, -0.125, -0.375 };
        double[] f = changeSpeed(a, 1);
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i]);
        }


        // double[] g = StdAudio.read("singer.wav");
        // StdAudio.play(changeSpeed(g, 1.2));
    }
}
