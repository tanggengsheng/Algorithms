package basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class Cat {
    private Cat() {}

    /**
     * Reads in a sequence of text files specified as the first command-line arguments,
     * concatenates them, and writes the result to the file specified as the last
     * command-line argument.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }
}
