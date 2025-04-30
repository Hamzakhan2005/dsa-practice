public class SpiralMatrix {
     public static void main(String[] args) {
          int mat[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
          spiral(mat);
     }
     public static void spiral(int mat[][]){
         int startRow=0,
         startCol=0,
         endRow=mat.length-1,
         endCol=mat[0].length-1;
         while (startCol<=endCol&& startRow<=endRow) {
               // top
               for(int j=startCol;j<=endCol;j++){
                    System.out.print(mat[startRow][j]+" ");
               }
               // right
               for(int i=startRow+1;i<=endRow;i++){
                    System.out.print(mat[i][endCol]+" ");
               }
               // bottom
               for(int j=endCol-1;j>=startCol;j--){
                    if(startRow==endRow){
                         break;
                    }
                    System.out.print(mat[endRow][j]+" ");
               }
               // left
               for(int i=endRow-1;i>startRow;i--){
                    if(startCol==endCol){
                         break;
                    }
                    System.out.print(mat[i][startCol]+" ");
               }
               startCol++;
               endCol--;
               startRow++;
               endRow--;
           
         }
     }
}
