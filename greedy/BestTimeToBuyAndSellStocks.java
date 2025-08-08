import java.util.*;
public class BestTimeToBuyAndSellStocks {
     public static void main(String[] args) {
          int prices[]={7, 6, 4, 3, 1};
          int buy=prices[0];int maxProfit=0;
          for(int i=1;i<prices.length;i++){
               if(buy>prices[i]){
                    buy=prices[i];
               }else if(prices[i]-buy>maxProfit){
                    maxProfit=prices[i]-buy;
               }
          }

          System.out.println(maxProfit);
     }
}
