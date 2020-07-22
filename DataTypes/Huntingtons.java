public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < dna.length() - 2; i++) {
            String codon = dna.substring(i, i + 3);

            if (!codon.equals("CAG")) {
                count = 0;
            }
            else {
                count++;
                i += 2;
                max = Math.max(count, max);
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String nowhites = s.replace(" ", "");
        nowhites = nowhites.replace("\n", "");
        nowhites = nowhites.replace("\t", "");

        return nowhites;
    }


    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9) return "not human";
        else if (maxRepeats >= 10 && maxRepeats <= 35) return "normal";
        else if (maxRepeats >= 36 && maxRepeats <= 39) return "high risk";
        else if (maxRepeats >= 40 && maxRepeats <= 180) return "Huntington's";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);      // input file
        String s = in.readAll();
        // StdOut.print(s);

        String whitefree = removeWhitespace(s);
        // StdOut.print(whitefree);
        int a = maxRepeats(whitefree);
        StdOut.println("max repeats = " + a);
        StdOut.println(diagnose(a));
    }
}
