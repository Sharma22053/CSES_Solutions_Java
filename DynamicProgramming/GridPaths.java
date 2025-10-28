import java.util.Scanner;

public class GridPaths {
    static int[][] directions = {{0,1},{1,0}};
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] nums = new char[n][n];
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<n;j++){
                nums[i][j] = line.charAt(j);
            }
        }
        
        dp = new int[n][n];
        int result = helper(nums,0,0,n);
        System.out.println(result);
        sc.close();

    }
    static int helper(char[][] nums,int row,int column,int n){
        //if(nums[0][0] == '*') return 0;
        if(row == n-1 && column == n-1) return 1;
        if(dp[row][column] != 0) return dp[row][column];
        int paths = 0;
        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            if(isValid(newRow, newColumn,n) && nums[newRow][newColumn] == '.'){
                paths += helper(nums,newRow,newColumn,n);
            }
        }
        return dp[row][column] = paths;
    }
    static boolean isValid(int row,int column,int n){
        return row>=0 && column >=0 && row < n && column < n;
    }
}
