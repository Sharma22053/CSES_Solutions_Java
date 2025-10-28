public class TwoSetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        System.out.println(helper(nums,sum/2,0));

    }
    static int helper(int[] nums, int target,int index){
        if(index == nums.length) return 0;
        if(target == 0) return 1;

        int leave = helper(nums,target,index+1);
        int take = 0;
        if(target - nums[index] >= 0){
            take += helper(nums,target-nums[index],index+1);
        }
        return take + leave;
    }
}
