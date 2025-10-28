import java.util.Scanner;

public class RemovalGameIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long[][] dp = new long[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (i > j) {
                    dp[i][j] = 0;
                } else if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    long pickFirst = nums[i] + Math.min(
                            (i + 2 <= j ? dp[i + 2][j] : 0),
                            (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0));

                    long pickLast = nums[j] + Math.min(
                            (i <= j - 2 ? dp[i][j - 2] : 0),
                            (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0));

                    dp[i][j] = Math.max(pickFirst, pickLast);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
        sc.close();
    }
}
