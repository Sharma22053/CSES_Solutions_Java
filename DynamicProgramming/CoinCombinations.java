public class CoinCombinations {
    static final int mod = 1000000007;
    public static void main(String[] args){
        int[] nums = {2,5,3};
        System.out.println(helper(nums,9,0));

    }
    static int helper(int[] nums,int target,int index){
        if(target == 0 ) return 1;
        if(target < 0 || index == nums.length) return 0;
        int take = helper(nums,target-nums[index],index);
        int leave = helper(nums,target,index+1);
        
        return (take + leave) % mod;
    }
}
