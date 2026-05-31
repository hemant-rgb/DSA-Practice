class Solution {
    int [][]dp;
    private int dfs(int[] prices,int i,int buy){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int profit;
        if(buy==1){
            int buyStock = -prices[i] + dfs(prices,i+1,0);
            int skip = dfs(prices,i+1,1);
            profit = Math.max(buyStock,skip);
        }else{
            int sellStock = prices[i]+ dfs(prices,i+2,1);
            int hold = dfs(prices,i+1,0);
            profit= Math.max(sellStock,hold);
        }

        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dfs(prices,0,1);
        
    }
}