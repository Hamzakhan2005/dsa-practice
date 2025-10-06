import java.util.*;

public class KnapsackZeroOne {
     public static int maxValue(int val[],int wt[],int W,int n,int dp[][]){
          if (W==0 || n==0) {
               return 0;
          }
          if (dp[n][W]!=-1) {
               return dp[n][W];
          }

          if (wt[n-1]<=W) {
               // include
               int ans1= val[n-1]+maxValue(val, wt, W-wt[n-1], n-1,dp);

               // exclude
               int ans2=maxValue(val, wt, W, n-1,dp);
               dp[n][W]=Math.max(ans1,ans2);
               return dp[n][W];
          }else{
               dp[n][W]=maxValue(val, wt, W, n-1,dp);
               return dp[n][W];
          }
     }
     public static int knapsackTab(int val[],int wt[],int W){
          int n=val.length;
          int dp[][]=new int[n+1][W+1];
          for(int i=0;i<dp.length;i++){
               dp[i][0]=0;
          }
          for(int i=0;i<dp.length;i++){
               dp[0][i]=0;
          }

          for(int i=1;i<n+1;i++){
               for(int j=1;j<W+1;j++){
                    int v=val[i-1];
                    int w=wt[i-1];
                    if (w<=j) {
                         int include=v+dp[i-1][j-w];
                         int exlude=dp[i-1][j];
                         dp[i][j]=Math.max(include,exlude);
                    }else{
                         dp[i][j]=dp[i-1][j];
                    }
               }
          }
          return dp[n][W];
     }
     public static void main(String[] args) {
          int wt[]={2,5,1,3,4};
          int val[]={15,14,10,45,30};
          int W=7;
          int dp[][]=new int[wt.length+1][W+1];
          for(int i=0;i<dp.length;i++){
               for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
               }
          }
          System.out.println(maxValue(val, wt, W, 5,dp));

          System.out.println(knapsackTab(val, wt, W));
     }
}
