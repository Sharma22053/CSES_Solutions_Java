public class ArrayDescriptionIterative2 {
    public static void main(String[] args){
        int m = 5;
        int n = 3;
        int[] nums = {2,0,2};
        int[][] dp = new int[n][m+1];
        for(int i=1;i<=m;i++){
            if(nums[0] == 0 || nums[0] == i){
                dp[0][i] = 1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=m;j++){
                if(nums[i] != 0 && nums[i] != j) continue;
                for(int k = j-1;k<=j+1;k++){
                    if(k>=1 && k<=m){
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }
        int total =0;
        for(int j=1;j<=m;j++){
            total += dp[n-1][j];
        }
        System.out.println(total);


}
}
