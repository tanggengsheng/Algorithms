package basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Knuth {
    private Knuth() {}

    /**
     * Rearranges an array of objects in uniformly random order (under the assumption that
     * {@code Math.random()} generates independent and uniformly distributed numbers between 0 and 1).
     *
     * @param a the array to be shuffled
     */
    public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            // choose index uniformly in [0, i]
            int l = (int)(Math.random() * (i + 1));
            Object swap = a[l];
            a[l] = a[i];
            a[i] = swap;
        }
    }

    /**
     * Rearranges an array of objects in uniformly random order (under the assumption that
     * {@code Math.random()} generates independent and uniformly distributed numbers between 0 and 1).
     *
     * @param a the array to be shuffled
     */
    public static void shuffleAlternate(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int r = i + (int)(Math.random() * (n - i));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    /**
     * Reads in a sequence of strings from standard input, shuffles them, and prints out the results.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();

        Knuth.shuffle(a);

        for (String s : a)
            StdOut.println(s);
    }
}
