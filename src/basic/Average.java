package basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Average {
    private Average() {}

    /**
     * Reads in a sequence of real numbers from standard input and prints
     * out their average to standard output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int count = 0;
        double sum = 0.0;

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            count++;
        }

        double average = sum / count;
        StdOut.println("Average is: " + average);
    }
}
