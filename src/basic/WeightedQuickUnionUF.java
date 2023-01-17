package basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private final int[] parent;
    private final int[] size;
    private int count;

    public WeightedQuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // path compression by halving
            p = parent[p];
        }
        return p;
    }

    private void validate(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (parent.length - 1));
    }

    public void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        --count;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
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
