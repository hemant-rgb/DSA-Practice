class Solution {
    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxprice=0;
        for(int price:prices){
            if(price<minprice){
                minprice=price;
            }
            else{
                maxprice=Math.max(maxprice,price-minprice);
            }
        }
        return maxprice;
        
    }
}