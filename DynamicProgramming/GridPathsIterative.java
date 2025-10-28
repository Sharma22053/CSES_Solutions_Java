import java.util.Scanner;

public class GridPathsIterative {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] nums = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                nums[i][j] = line.charAt(j);
            }
        }
        int[][] dp = new int[n][n];
        if (nums[n - 1][n - 1] == '.')
            dp[n - 1][n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i][j] == '*')
                    continue;
                if (i + 1 < n && nums[i + 1][j] == '.')
                    dp[i][j] = (dp[i][j] + dp[i + 1][j])%mod;

                if (j + 1 < n && nums[i][j + 1] == '.')
                    dp[i][j] = (dp[i][j] + dp[i][j + 1])%mod;
            }
        }
        System.out.println(dp[0][0]);
        sc.close();
    }
}
