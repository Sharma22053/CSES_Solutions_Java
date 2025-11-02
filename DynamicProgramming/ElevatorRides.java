import java.util.*;

public class ElevatorRides {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long maxWeight = sc.nextLong();
        long[] weight = new long[n];
        for (int i = 0; i < n; i++) weight[i] = sc.nextLong();
        sc.close();

        int totalMasks = 1 << n;
        Pair[] dp = new Pair[totalMasks];
        dp[0] = new Pair(1, 0);  

        for (int mask = 1; mask < totalMasks; mask++) {
            dp[mask] = new Pair(Integer.MAX_VALUE, Long.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    int prevMask = mask ^ (1 << i);
                    Pair prev = dp[prevMask];

                    Pair option;
                    if (prev.weight + weight[i] <= maxWeight) {
                        option = new Pair(prev.rides, prev.weight + weight[i]);
                    } else {
                        option = new Pair(prev.rides + 1, weight[i]);
                    }

                    if (option.rides < dp[mask].rides ||
                        (option.rides == dp[mask].rides && option.weight < dp[mask].weight)) {
                        dp[mask] = option;
                    }
                }
            }
        }

        System.out.println(dp[totalMasks - 1].rides);
    }

    static class Pair {
        int rides;
        long weight;
        Pair(int r, long w) {
            rides = r;
            weight = w;
        }
    }
}
