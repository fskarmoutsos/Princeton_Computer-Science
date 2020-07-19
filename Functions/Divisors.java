public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) return 0;
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        return a;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 && b == 0) return 0;
        // return (1 / gcd(a, b)) * Math.abs(a) * Math.abs(b);
        return Math.abs(a) / gcd(a, b) * Math.abs(b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return (gcd(a, b) == 1);
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(i, n)) counter++;
        }
        return counter;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int int1 = Integer.parseInt(args[0]);
        int int2 = Integer.parseInt(args[1]);
        System.out.println("gcd(" + int1 + ", " + int2 + ") = " + gcd(int1, int2));
        System.out.println("lcm(" + int1 + ", " + int2 + ") = " + lcm(int1, int2));
        System.out.println("areRelativelyPrime(" + int1 + ", " + int2 + ") = "
                                   + areRelativelyPrime(int1, int2));
        System.out.println("totient(" + int1 + ") = " + totient(int1));
        System.out.println("totient(" + int2 + ") = " + totient(int2));
    }
}
