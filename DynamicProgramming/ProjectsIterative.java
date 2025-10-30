import java.io.*;
import java.util.*;

public class ProjectsIterative {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = fs.nextInt();
        long[] start = new long[n];
        long[] end = new long[n];
        long[] reward = new long[n];

        for (int i = 0; i < n; i++) {
            start[i] = fs.nextLong();
            end[i] = fs.nextLong();
            reward[i] = fs.nextLong();
        }

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = i;
        Arrays.sort(order, (a, b) -> {
            if (end[a] < end[b])
                return -1;
            if (end[a] > end[b])
                return 1;
            return 0;
        });

        long[] sortedEnd = new long[n];
        long[] sortedStart = new long[n];
        long[] sortedReward = new long[n];
        for (int i = 0; i < n; i++) {
            sortedEnd[i] = end[order[i]];
            sortedStart[i] = start[order[i]];
            sortedReward[i] = reward[order[i]];
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            long s = sortedStart[i - 1];
            long w = sortedReward[i - 1];

            int j = upperBound(sortedEnd, s - 1) - 1;
            long take = w + (j >= 0 ? dp[j + 1] : 0);
            long skip = dp[i - 1];
            dp[i] = Math.max(skip, take);
        }

        out.println(dp[n]);
        out.flush();
    }

    static int upperBound(long[] arr, long key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1)
                    throw new EOFException();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
