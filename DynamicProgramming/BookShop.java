public class BookShop {
    public static void main(String[] args) {
        int[] prices = {4,8,5,3};
        int[] pages = {5,12,8,1};
        int cost = 10;
        System.out.println(helper(prices,pages,cost,0));

    }
    static int helper(int[] prices,int[] pages,int cost,int index){
        if(cost == 0 || index == prices.length){
            return 0;
        }
        
        int leave = helper(prices,pages,cost,index+1);
        int take = Integer.MIN_VALUE;
        if(cost >= prices[index]){
            
            take = pages[index] + helper(prices,pages,cost-prices[index],index+1);
        }
        return Math.max(take ,leave);
    }
}
