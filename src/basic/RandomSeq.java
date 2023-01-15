package basic;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSeq {
    private RandomSeq() {}

    /**
     * Reads in two command-line arguments lo and hi and prints n uniformly
     * random real numbers in [lo, hi) to standard output.
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws IllegalAccessException {
        // command-line arguments
        int n = Integer.parseInt(args[0]);

        // for backward compatibility with Intro to Programming in Java version of RandomSeq
        if (args.length == 1) {
            // generate and print n numbers between 0.0 and 1.0
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniformDouble(0.0, 1.0);
                StdOut.println(x);
            }
        } else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);
            // generate and print n numbers between lo and hi
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniformDouble(lo, hi);
                StdOut.printf("%.2f\n", x);
            }
        } else
            throw new IllegalAccessException("Invalid number of arguments");
    }
}
