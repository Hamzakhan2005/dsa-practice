import java.math.*;
import java.util.*;

public class Stocks {
     public static void main(String[] args) {
          int prices[]={7, 6, 4,  3, 1};
          
          System.out.println(buyAndSellStocks(prices));
     }
     public static int buyAndSellStocks(int prices[]){
          int buyPrice=Integer.MAX_VALUE;
          int maxProfit=0;

          for(int i=0;i<prices.length;i++){
               
               if(buyPrice < prices[i]){
                    int profit=prices[i]-buyPrice;
                    maxProfit=Math.max(maxProfit,profit);
               }else{
                    
                    buyPrice=prices[i];
               }
          }

          return maxProfit;
     }
}
