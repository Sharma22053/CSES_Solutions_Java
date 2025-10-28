import java.util.*;

public class BooksShopIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price = sc.nextInt();
        int[] pages = new int[n];
        int[] booksPrices = new int[n];
        for (int i = 0; i < n; i++) {
            booksPrices[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        int[] dp = new int[price + 1];
        for (int i = 0; i < n; i++) {
            for (int j = price; j >= booksPrices[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - booksPrices[i]] + pages[i]);
            }
        }
        System.out.println(dp[price]);
        sc.close();

    }
}
