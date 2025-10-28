import java.util.*;

public class MinimizingCoinsIterative {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= target; i++) {
            dp[n][i] = Integer.MAX_VALUE;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int t = 1; t <= target; t++) {
                int leave = dp[i + 1][t];
                int take = Integer.MAX_VALUE;
                if (t >= nums[i]) {
                    int sub = dp[i][t - nums[i]];
                    if (sub != Integer.MAX_VALUE) {
                        take = 1 + sub;
                    }
                }
                dp[i][t] = Math.min(take, leave);
            }
        }
        int result = dp[0][target];
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

        sc.close();

    }

}
