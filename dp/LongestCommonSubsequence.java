public class LongestCommonSubsequence {
     public static int findLcs(String str1,String str2,int n,int m){
          if(n==0 || m==0){
               return 0;
          }
          char c1=str1.charAt(n-1);
          char c2=str2.charAt(m-1);
          if (c1==c2) {
               return 1+findLcs(str1, str2, n-1, m-1);
          }else{
               int a=findLcs(str1, str2, n-1, m);
               int b=findLcs(str1, str2, n, m-1);
               return Math.max(a, b);
          }
     }
     // memoization
     public static int findLcs2(String str1,String str2,int n,int m,int dp[][]){
          if(n==0 || m==0){
               return 0;
          }
          if (dp[n][m]!=-1) {
               return dp[n][m];
          }
          char c1=str1.charAt(n-1);
          char c2=str2.charAt(m-1);
          if (c1==c2) {
               return dp[n][m]=1+findLcs(str1, str2, n-1, m-1);
          }else{
               int a=findLcs(str1, str2, n-1, m);
               int b=findLcs(str1, str2, n, m-1);
               return dp[n][m]=Math.max(a, b);
          }
     }

     // tabulation 
     public static int findLcs3(String str1,String str2){
          int n=str1.length();
          int m=str2.length();

          int dp[][]=new int[n+1][m+1];
          for(int i=1;i<n+1;i++){
               for(int j=1;j<m+1;j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                         dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                         dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                    }
               }
          }
          return dp[n][m];
     }
     public static void main(String[] args) {
          String str1="abcdge";
          String str2="abedg";
          int dp[][]=new int[str1.length()+1][str2.length()+1];
          System.out.println(findLcs(str1, str2, str1.length(), str2.length()));
          for(int i=0;i<dp.length;i++){
               for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=-1;
               }
          }
          System.out.println(findLcs2(str1, str2, str1.length(), str2.length(), dp));

          System.out.println(findLcs3(str1, str2));
     }
}
