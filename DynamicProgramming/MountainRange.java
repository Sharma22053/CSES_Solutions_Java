public class MountainRange {
    public static void main(String[] args) {
        int[] nums = {20,15,17,35,25,40,12,19,13,12};
        System.out.println(helper(nums,0,-1));
    }
    static int helper(int[] nums,int index,int previous){
        if(index == nums.length) return 0;

        int leave = helper(nums,index+1,previous);
        int take = 0;
        if(previous == -1 || previous >= nums[index]){
            take = 1 + helper(nums,index + 1,nums[index]);
        }
        return Math.max(take,leave);
    }
}
