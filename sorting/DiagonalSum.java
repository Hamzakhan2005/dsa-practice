public class DiagonalSum {
     public static void main(String[] args) {
          int mat[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
          System.out.println(diagonal(mat));
     }
     public static int diagonal(int mat[][]){
          int sum=0;

          // O(n^2)
          // for(int i=0;i<mat.length;i++){
          //      for(int j=0;j<mat.length;j++){
          //           if(i==j){
          //                sum+=mat[i][j];
          //           }else if(i+j==mat.length-1){
          //                sum+=mat[i][j];
          //           }
          //      }
          // }

          // O(n)
          for(int i=0;i<mat.length;i++){
               sum+=mat[i][i];
               if(i!=mat.length-i-1){
                    sum+=mat[i][mat.length-i-1];
               }
          }
          return sum;
     }
}
