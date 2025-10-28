public class ArrayDescriptionRecursive {
    public static void main(String[] args){
        int m = 5;
        int[] nums = {2,0,2};
        int result = helper(nums,m,0,-1);
        System.out.println(result);
    }
    static int helper(int[] nums,int m,int index,int previous){
        if(index == nums.length) return 1;
        if(nums[index] != 0){
            int current = nums[index];
            if(index == 0 || Math.abs(current - previous) >= 1){
                return helper(nums,m,index+1,current);
            } else return 0;
        }
        int total = 0;
        for(int i=1;i<=m;i++){
            if(index == 0 || Math.abs(i-previous)<=1){
                total += helper(nums,m,index+1,i);
            }
        }
        return total;
    }
}
