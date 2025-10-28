import java.util.Scanner;

public class CountingTowers {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        int[] heights = new int[t];
        int maxN = 0;

        
        for (int i = 0; i < t; i++) {
            heights[i] = sc.nextInt();
            maxN = Math.max(maxN, heights[i]);
        }

        
        long[][] dp = new long[maxN][8];
        dp[0][0] = 1;
        dp[0][6] = 1;

        for (int i = 1; i < maxN; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0 || j == 2 || j == 3 || j == 4 || j == 5) {
                    dp[i][j] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4] + dp[i-1][5]) % mod;
                } else {
                    dp[i][j] = (dp[i-1][2] + dp[i-1][6] + dp[i-1][7]) % mod;
                }
            }
        }

        
        for (int i = 0; i < t; i++) {
            int n = heights[i];
            if (n == 1) {
                System.out.println(2);
                continue;
            }
            long total = 0;
            for (int j = 0; j < 8; j++) total = (total + dp[n-1][j]) % mod;
            System.out.println(total);
        }

        sc.close();
    }
}
