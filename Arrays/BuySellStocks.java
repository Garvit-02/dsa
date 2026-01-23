public class BuySellStocks {
    public static int BuySellStocks(int price[]){
        //make to variable buy price which is max when we initialize 
        //other is max profit which we get which we will initialize with zero if we not get any profit then it value will be zero
        
        int buyprice = Integer.MAX_VALUE;
        int maxprofit =0;

        //loop from 0 to n
        for(int i=0; i<price.length;i++){
            // check that buy price is less than today price(selling price) ,if it is then print profit
            if(buyprice < price[i]){
                int profit = price[i]-buyprice;
                maxprofit = Math.max(maxprofit, profit);
            }
            else{
                //otherwise update the buy price  
                buyprice = price[i];
            }
        }
        return maxprofit; 
    }
    public static void main(String[] args) {
        int price[]={7,1,5,3,6,4};
        BuySellStocks(price);
        System.out.println(BuySellStocks(price));
    }
}
