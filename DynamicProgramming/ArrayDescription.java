public class ArrayDescription {
    public static void main(String[] args) {
        
        int m = 5;
        int[] nums = {2,0,2};
        System.out.println(helper(nums,0,-1,m));

    }
    static int helper(int[] nums,int index,int previous,int m){
        if(index == nums.length) return 1;
        if(nums[index] != 0){
            int current = nums[index];
            if(index == 0 || Math.abs(current- previous) <= 1){
                return helper(nums,index+1,current,m);
            } else return 0;
        }
        int total = 0;
        for(int i=1;i<=m;i++){
            if(index == 0 || Math.abs(i-previous) <= 1){
                total += helper(nums,index+1,i,m);
            }
        }
        return total;
    }
}
