public class MoneySums {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 5 };
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        boolean[] dp = new boolean[sum + 1];
        helper(nums, 0, 0, dp);
        int count = 0;
        for(boolean b : dp){
            if(b) count++;
        }
        System.out.println(count);

    }

    static void helper(int[] nums, int index, int currentSum, boolean[] dp) {
        if (index == nums.length) {
            if (currentSum > 0)
                dp[currentSum] = true;

            return;
        }
        helper(nums, index + 1, currentSum, dp);
        helper(nums, index + 1, currentSum + nums[index], dp);
    }
}
