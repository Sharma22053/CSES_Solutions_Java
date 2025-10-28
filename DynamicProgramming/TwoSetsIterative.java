import java.util.Scanner;

public class TwoSetsIterative {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        dp[n][target] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = target; j >= 0; j--) {
                int leave = dp[i + 1][j];
                int take = 0;
                if (j + nums[i] <= target) {
                    take = dp[i + 1][j + nums[i]];
                }
                dp[i][j] = (take + leave) % mod;
            }
        }
        long inverseOf2 = (mod + 1) / 2;
        System.out.println((dp[0][0] * inverseOf2) % mod);
        sc.close();
       

    }
}
