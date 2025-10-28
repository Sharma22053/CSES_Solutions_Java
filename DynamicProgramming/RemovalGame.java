public class RemovalGame {
    public static void main(String[] args) {
        int[] nums = {4,5,1,3};
        System.out.println(helper(nums,0,nums.length-1));
    }
    static int helper(int[] nums,int i,int j){
        if(i > j) return 0;
        int first = nums[i] + Math.min(helper(nums,i+2,j) , helper(nums,i+1,j-1));
        int last = nums[j] + Math.min(helper(nums,i+1,j-1) , helper(nums,i,j-2));
        return Math.max(first,last);
    }
}
