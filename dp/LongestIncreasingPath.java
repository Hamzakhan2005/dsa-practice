public class LongestIncreasingPath {
     public static int max=Integer.MIN_VALUE;
     public static int maxLength(int mat[][],int i,int j,int length){
          if (i<0 || i>=mat.length || j<0 || j>=mat[0].length) {
               return Math.max(max, length);
          }

          
          int right=maxLength(mat, i, j+1, length+1);
          int left=maxLength(mat, i+1, j, length+1);

          return Math.max(right, left);
     }
     public static int LIP(int mat[][]){
          int dp[][]=new int[mat.length][mat[0].length];
          int max=Integer.MIN_VALUE;

          int rows = mat.length;
          int cols = mat[0].length;
          int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
  
          for(int i=0;i<rows;i++){
               for(int j=0;j<cols;j++){
                    for (int k = 0; k < 4; k++) {
                         int newRow = i + dRow[k];
                         int newCol = j + dCol[k];
     
                         // Check if the neighbor is within bounds
                         if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                              if(mat[i][j]<mat[newRow][newCol])
                             dp[i][j]=Math.max(dp[i][j],dp[newRow][newCol]+1);
                         }
                     }
                     max=Math.max(max, dp[i][j]);
               }
               
          }
          return max;
     }
     public static void main(String[] args) {
          int mat[][]={ { 1, 2 },{ 3, 4 } } ;
          System.out.println(maxLength(mat, 0, 0, 0));
          System.out.println(LIP(mat));
     }
}
