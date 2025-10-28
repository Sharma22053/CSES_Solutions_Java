import java.util.Scanner;

public class EditDistanceRecursive {
    static int dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n1 = s1.length();
        int n2 = s2.length();
        dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(helper(s1, s2, s1.length() - 1, s2.length() - 1));
        sc.close();

    }

    static int helper(String s1, String s2, int index1, int index2) {
        if (index1 < 0)
            return index2 + 1;
        if (index2 < 0)
            return index1 + 1;
        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = helper(s1, s2, index1 - 1, index2 - 2);
        }

        int add = 1 + helper(s1, s2, index1, index2 - 1);
        int delete = 1 + helper(s1, s2, index1 - 1, index2);
        int replace = 1 + helper(s1, s2, index1 - 1, index2 - 1);
        return dp[index1][index2] = Math.min(add, Math.min(delete, replace));

    }
}

