public class Practice {
     public static void main(String[] args) {
          int mat[][]= { {1,4},{11,4},{2,2} };
          // sevens(mat);
          // secondSum(mat);
          transpose(mat);
     }
     public static void sevens(int mat[][]){
          int count=0;
          for(int i=0;i<mat.length;i++){
               for(int j=0;j<mat[0].length;j++){
                    if(mat[i][j]==7){
                         count++;
                    }
               }
          }
          System.out.println(count);
     }

     public static void secondSum(int mat[][]){
          int sum=0,i=1;
          for(int j=0;j<mat[0].length;j++){
               sum+=mat[i][j];
          }
          System.out.println(sum);
     }

     public static void transpose(int mat[][]){
          int n=mat.length;int m=mat[0].length;
          int trans[][]=new int [m][n];
          for(int i=0;i<n;i++){
               for(int j=0;j<m;j++){
                    trans[j][i]=mat[i][j];
               }
          }
          for(int i=0;i<m;i++){
               for(int j=0;j<n;j++){
                    System.out.print(trans[i][j]+" ");
               }
               System.out.println();
          }
     }
}
