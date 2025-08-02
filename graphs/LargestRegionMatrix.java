import java.util.LinkedList;
import java.util.Queue;

public class LargestRegionMatrix {
     static class Address {
          int i, j;
  
          public Address(int i, int j) {
              this.i = i;
              this.j = j;
          }
     }
     public static int max=Integer.MIN_VALUE;
     public static int MaxRegion(int mat[][]){
          int rows=mat.length;
          int cols=mat[0].length;
          boolean vis[][]=new boolean[rows][cols];
          
          Queue<Address> q=new LinkedList<>();
          for(int i=0;i<rows;i++){
               for(int j=0;j<cols;j++){
                    if (mat[i][j]==1 && !vis[i][j]) {
                         q.add(new Address(i, j));
                         vis[i][j]=true;
                         int[] dRow = {-1, 1, 0, 0,-1,-1,1,1};
                         int[] dCol = {0, 0, -1, 1,-1,1,-1,1};
                         int tmax=0;
                         while (!q.isEmpty()) {
                              Address a=q.remove();
                              tmax++;
                              for(int d=0;d<dCol.length;d++){
                                   int newRow=a.i+dRow[d];
                                   int newCol=a.j+dCol[d];
                                   if (newRow >= 0 && newRow < rows && newCol >= 0 
                                   && newCol < cols && mat[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                                        vis[newRow][newCol]=true;
                                        q.add(new Address(newRow, newCol));
                                    }
                              }
                              
                         }
                         max=Math.max(max,tmax);
                    }
               }
          }
         
          return max;
     }
     public static void main(String[] args) {
          int mat[][]={ {0, 0, 1, 1, 0}, {0, 0, 1, 1, 0},{0, 0, 0, 0, 0}, {0, 0, 0, 0 ,1}};
          System.out.println(MaxRegion(mat));
     }
}
