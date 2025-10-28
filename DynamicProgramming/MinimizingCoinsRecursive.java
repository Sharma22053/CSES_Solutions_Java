import java.util.Scanner;

public class MinimizingCoinsRecursive {
     public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int target = sc.nextInt();
       int[] nums = new int[n];
       for(int i=0;i<n;i++){
        nums[i] = sc.nextInt();
       }
       System.out.println(helper(nums,target,0));
       sc.close();
    }

    static int helper(int[] nums,int target,int index){
        if(target == 0) return 0;
           
        if(index == nums.length) return Integer.MAX_VALUE;
        int leave = helper(nums,target,index+1);
        int take = Integer.MAX_VALUE;
        if(target >= nums[index]){
            int sub = helper(nums,target-nums[index],index);
            if(sub != Integer.MAX_VALUE){
                take = 1 + sub;
            }
        }
        return Math.min(take,leave);
    }
}
