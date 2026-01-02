public class MinimumPartition {
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
     public static int minPartition(int num[]){
          int sum=0;
          for(int i=0;i<num.length;i++){
               sum+=num[i];
          }

          int W=sum/2;

          int sum1=knapsackTab(num, num, W);
          int sum2=sum-sum1;
          return Math.abs(sum2-sum1);
     }
     public static void main(String[] args) {
          int num[]={1,6,11,5};
          String str="hello";
          String s="he";
          System.out.println(str.contains(s));
          System.out.println(minPartition(num));          
     }
}
