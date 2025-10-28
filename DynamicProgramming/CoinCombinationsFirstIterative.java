import java.util.Scanner;

public class CoinCombinationsFirstIterative {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            for (int coin : nums) {
                if (t >= coin) {
                    dp[t] = (dp[t] + dp[t - coin]) % mod;
                }
            }
        }
        System.out.println(dp[target]);
        sc.close();

    }
}
