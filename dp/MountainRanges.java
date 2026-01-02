public class MountainRanges {
     public static int findWays(int pairs){
          int dp[]=new int[pairs+1];
          dp[0]=dp[1]=1;

          for(int i=2;i<pairs+1;i++){
               for(int j=0;j<i;j++){
                    dp[i]+=dp[j]*dp[i-j-1];
               }
          }
          return dp[pairs];
     }
     public static void main(String[] args) {
          int pairs=4;

          System.out.println(findWays(pairs));
          int n=5,p=2;
          System.out.println(n>>p);

     }
}
