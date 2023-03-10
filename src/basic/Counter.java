package basic;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * The {@code Counter} class is a mutable data type to encapsulate a counter.
 */
public class Counter {
    private final String name; // counter name
    private int count;         // current value

    /**
     * Initializes a new counter starting at 0, with the given id.
     *
     * @param id the name of the counter
     */
    public Counter(String id) {
        name = id;
    }

    /**
     * Increments the counter by 1.
     */
    public void increment() {
        count++;
    }

    /**
     * Returns the current value of this counter.
     *
     * @return the current value of this counter
     */
    public int tally() {
        return count;
    }

    /**
     * Returns a string representation of this counter.
     *
     * @return a string representation of this counter
     */
    public String toString() {
        return count + " " + name;
    }

    /**
     * Compares this counter to the specified counter.
     *
     * @param  that the other counter
     * @return {@code 0} if the value of this counter equals the value of that counter;
     *         a negative integer if the value of this counter is less than the value of that counter;
     *         and a positive integer if the value of this counter is greater than the value of that counter
     */
    public int compareTo(Counter that) {
        return Integer.compare(this.count, that.count);
    }

    /**
     * Reads two command-line integers n and trials; creates n counters;
     * increments trials counters at random; and prints results.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++)
            hits[i] = new Counter("counter" + i);

        for (int t= 0; t < trials; t++)
            hits[StdRandom.uniformInt(n)].increment();

        for (Counter counter : hits)
            StdOut.println(counter);
    }
}
