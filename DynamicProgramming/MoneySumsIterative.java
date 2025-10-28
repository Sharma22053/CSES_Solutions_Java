import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoneySumsIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int totalSum = Arrays.stream(nums).sum();
        boolean[] dp = new boolean[totalSum + 1];
        
        dp[0] = true;
        for (int i : nums) {
            for (int sum = totalSum; sum >= i; sum--) {
                if (dp[sum - i]) {
                    dp[sum] = true;
                    
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= totalSum; i++) {
            if (dp[i])
                result.add(i);
        }
        
        System.out.println(result.size());
        for (int i : result) {
            System.out.print(i + " ");
        }

        sc.close();

    }
}
