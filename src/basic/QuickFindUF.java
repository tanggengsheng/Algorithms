package basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private final int[] id;
    private int count;

    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    private void validate(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (id.length - 1));
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pId = id[p], qId = id[q];

        for (int i = 0; i < id.length; i++)
            if (id[i] == pId)
                id[i] = qId;
        --count;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q))
                continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
