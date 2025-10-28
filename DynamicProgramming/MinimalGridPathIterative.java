import java.util.*;

public class MinimalGridPathIterative {
    static final int INF = (int) 1e9 + 7;

    static void stableCountingSort(List<int[]> v, int k) {
        if (v.isEmpty()) return;

        int lo = v.get(0)[k], hi = v.get(0)[k];
        for (int i = 1; i < v.size(); i++) {
            lo = Math.min(lo, v.get(i)[k]);
            hi = Math.max(hi, v.get(i)[k]);
        }

        int R = hi - lo + 1;
        int[] cnt = new int[R + 1];
        for (int[] x : v) cnt[x[k] - lo + 1]++;
        for (int i = 1; i <= R; i++) cnt[i] += cnt[i - 1];

        List<int[]> out = new ArrayList<>(Collections.nCopies(v.size(), null));
        for (int[] x : v) {
            int pos = cnt[x[k] - lo]++;
            out.set(pos, x);
        }

        for (int i = 0; i < v.size(); i++) {
            v.set(i, out.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] g = new String[n];
        for (int i = 0; i < n; i++) {
            g[i] = sc.next();
        }
        int m = g[0].length();

        int[][] rk = new int[n][m];
        for (int[] row : rk) Arrays.fill(row, INF);

        for (int d = n + m - 2; d >= 0; d--) {
            List<int[]> v = new ArrayList<>();
            int imin = Math.max(0, d - (m - 1));
            int imax = Math.min(n - 1, d);
            for (int i = imin; i <= imax; i++) {
                int j = d - i;
                int r1 = (i + 1 < n) ? rk[i + 1][j] : INF;
                int r2 = (j + 1 < m) ? rk[i][j + 1] : INF;
                int best = Math.min(r1, r2);
                if (i == n - 1 && j == m - 1) best = -1;
                v.add(new int[]{g[i].charAt(j), best, i, j});
            }
            stableCountingSort(v, 1);
            stableCountingSort(v, 0);

            int id = -1;
            for (int k = 0; k < v.size(); k++) {
                if (k == 0 || v.get(k)[0] != v.get(k - 1)[0] || v.get(k)[1] != v.get(k - 1)[1]) id++;
                rk[v.get(k)[2]][v.get(k)[3]] = id;
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        ans.append(g[i].charAt(j));
        while (i != n - 1 || j != m - 1) {
            char cmin = 127;
            int rmin = Integer.MAX_VALUE, ni = i, nj = j;
            if (i + 1 < n && (g[i + 1].charAt(j) < cmin || (g[i + 1].charAt(j) == cmin && rk[i + 1][j] < rmin))) {
                cmin = g[i + 1].charAt(j);
                rmin = rk[i + 1][j];
                ni = i + 1;
                nj = j;
            }
            if (j + 1 < m && (g[i].charAt(j + 1) < cmin || (g[i].charAt(j + 1) == cmin && rk[i][j + 1] < rmin))) {
                cmin = g[i].charAt(j + 1);
                rmin = rk[i][j + 1];
                ni = i;
                nj = j + 1;
            }
            i = ni;
            j = nj;
            ans.append(g[i].charAt(j));
        }

        System.out.println(ans.toString());
        sc.close();
    }
}
