import java.util.Scanner;

public class ArrayDescriptionIterative {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        int[][] dp = new int[n][m + 1];
        if (values[0] != 0) {
            dp[0][values[0]] = 1;
        } else {
            for (int i = 1; i <= m; i++) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (values[i] == 0) {
                for (int j = 1; j <= m; j++) {
                    if (j - 1 >= 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                    }
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                    if (j + 1 <= m) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                    }
                }
            } else {
                int j = values[i];
                if (j - 1 >= 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                if (values[i] + 1 <= m) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        long totalNumberOfWays = 0;
        for (int i = 1; i <= m; i++) {
            totalNumberOfWays = (totalNumberOfWays + dp[n - 1][i]) % mod;
        }
        System.out.println(totalNumberOfWays);

        sc.close();

    }
}
