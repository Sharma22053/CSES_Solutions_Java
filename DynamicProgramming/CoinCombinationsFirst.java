import java.util.*;

public class CoinCombinationsFirst {
    static final int mod = 1000000007;
    static int[] dp;
    public static void main(String[] args) {

        int[] nums = { 2, 3, 5 };
        dp = new int[10];
        Arrays.fill(dp,-1);
        System.out.println(helper(nums, 9));

    }

    static int helper(int[] nums, int target) {
        if (target == 0)
            return 1;
        if (target < 0 )
            return 0;
        if(dp[target] != -1) return dp[target];

        int ways = 0;
        for(int coin : nums){
            ways = (ways + helper(nums,target-coin))%mod;
        }
        return dp[target] = ways;
    }
}
