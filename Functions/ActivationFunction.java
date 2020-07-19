public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double h = 0;
        if (Double.isNaN(x)) return Double.NaN;
        if (x < 0) h = 0;
        if (x == 0) h = 0.5;
        if (x > 0) h = 1;
        return h;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double s = 1 / (1 + Math.exp(-x));
        return s;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x >= 20) return 1.0;
        if (x <= -20) return -1.0;
        double expx = Math.exp(x);
        double expnx = Math.exp(-x);
        double t = (expx - expnx) / (expx + expnx);
        return t;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == Double.POSITIVE_INFINITY) return 1;
        if (x == Double.NEGATIVE_INFINITY) return -1;
        double s = x / (1 + Math.abs(x));
        return s;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double s = 1;
        if (x >= 0 && x < 2) s = x - x * x / 4;
        if (x > -2 && x < 0) s = x + x * x / 4;
        if (x <= -2) s = -1;
        return s;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double point = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + point + ") = " + heaviside(point));
        System.out.println("  sigmoid(" + point + ") = " + sigmoid(point));
        System.out.println("     tanh(" + point + ") = " + tanh(point));
        System.out.println(" softsign(" + point + ") = " + softsign(point));
        System.out.println("     sqnl(" + point + ") = " + sqnl(point));
    }
}
