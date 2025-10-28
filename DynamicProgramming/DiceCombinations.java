import java.util.Scanner;

public class DiceCombinations {
    static final int mod = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<=target;i++){
            for(int j=1;j<=6;j++){
                if(i-j >= 0) dp[i] = (dp[i] + dp[i-j])%mod;
            }
        }
        System.out.println(dp[target]);
        sc.close();
    }
}
