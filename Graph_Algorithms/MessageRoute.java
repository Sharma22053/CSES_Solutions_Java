import java.io.*;
import java.util.*;

public class MessageRoute {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] parent = new int[n + 1];
        boolean[] vis = new boolean[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[1] = true;
        parent[1] = -1;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == n) break;
            for (int nbr : adj.get(node)) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    parent[nbr] = node;
                    q.add(nbr);
                }
            }
        }

        if (!vis[n]) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int cur = n; cur != -1; cur = parent[cur]) path.add(cur);
        Collections.reverse(path);

        System.out.println(path.size());
        for (int x : path) System.out.print(x + " ");
    }

    /** FAST SCANNER **/
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}
