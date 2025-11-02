import java.util.*;

public class CountingTilings {
    static final int MOD = 1000000007;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        m = sc.nextInt(); 
        sc.close();

        
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }

        int maxMask = 1 << n;
        long[][] dp = new long[m + 1][maxMask];
        dp[0][0] = 1;

        for (int col = 0; col < m; col++) {
            for (int mask = 0; mask < maxMask; mask++) {
                if (dp[col][mask] == 0) continue;
                fillNext(dp, col, mask, 0, 0);
            }
        }

        System.out.println(dp[m][0]);
    }

    static void fillNext(long[][] dp, int col, int curMask, int row, int nextMask) {
        if (row == n) {
            dp[col + 1][nextMask] = (dp[col + 1][nextMask] + dp[col][curMask]) % MOD;
            return;
        }

        if (((curMask >> row) & 1) != 0) {
            
            fillNext(dp, col, curMask, row + 1, nextMask);
        } else {
            
            fillNext(dp, col, curMask, row + 1, nextMask | (1 << row));

           
            if (row + 1 < n && ((curMask >> (row + 1)) & 1) == 0)
                fillNext(dp, col, curMask, row + 2, nextMask);
        }
    }
}
