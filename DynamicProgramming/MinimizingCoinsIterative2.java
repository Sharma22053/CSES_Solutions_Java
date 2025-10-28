import java.util.*;

public class MinimizingCoinsIterative2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : nums) {
            for (int t = coin; t <= target; t++) {
                if (dp[t - coin] != Integer.MAX_VALUE) {
                    dp[t] = Math.min(dp[t], 1 + dp[t - coin]);
                }
            }
        }
        System.out.println(dp[target] == Integer.MAX_VALUE ? -1 : dp[target]);
        sc.close();
    }
}
