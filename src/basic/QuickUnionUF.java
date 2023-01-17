package basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private final int[] root;
    private int count;

    public QuickUnionUF(int n) {
        count = n;
        root = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        while (p != root[p])
            p = root[p];
        return p;
    }

    private void validate(int p) {
        if (p < 0 || p >= root.length)
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (root.length - 1));
    }

    public void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        root[pRoot] = qRoot;
        --count;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
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
