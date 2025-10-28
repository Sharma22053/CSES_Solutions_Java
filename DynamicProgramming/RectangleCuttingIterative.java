import java.util.Scanner;

public class RectangleCuttingIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int breadth = sc.nextInt();
        int length = sc.nextInt();
        int[][] dp = new int[length + 1][breadth + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= breadth; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }

                int hori = Integer.MAX_VALUE, vert = Integer.MAX_VALUE;
                for (int k = 1; k < j; k++) { 
                    hori = Math.min(1 + dp[i][k] + dp[i][j - k], hori);
                }
                for (int l = 1; l < i; l++) { 
                    vert = Math.min(vert, 1 + dp[l][j] + dp[i-l][j]);
                }
                dp[i][j] = Math.min(vert, hori);
            }
        }
        System.out.println(dp[length][breadth]);
        sc.close();

    }
}
