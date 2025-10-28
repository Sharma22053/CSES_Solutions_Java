import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigitsIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] dp = new int[target + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=target;i++){
            String temp = Integer.toString(i);
            for(char ch : temp.toCharArray()){
                int digit = ch - '0';
                if(digit == 0) continue;
                dp[i] = Math.min(dp[i], 1+dp[i-digit]);
            }

        }
        System.out.println(dp[target]);
        sc.close();
    }
}
