public class RemovingDigits {
    public static void main(String[] args) {
        System.out.println(helper(27));
    }
    static int helper(int n){
        if(n == 0) return 0;
        int min = Integer.MAX_VALUE;
        int temp = n;

        while(temp > 0){
            int digit = temp % 10;
            
            temp = temp / 10;
            if(digit == 0) continue;

            min = Math.min(min,1 + helper(n-digit));
        }
        return min;
    }
}
