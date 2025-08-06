import java.util.*;
public class FloodFill {
     public static void helper(int image[][],int sr,int sc,int color,boolean vis[][],int origColor){
          if (sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=origColor) {
               return;
          }
          image[sr][sc]=color;

          helper(image,sr,sc-1,color,vis,origColor);

          helper(image,sr,sc+1,color,vis,origColor);

          helper(image,sr-1,sc,color,vis,origColor);

          helper(image,sr+1,sc,color,vis,origColor);

     }
     public static int[][] floodFill(int image[][],int sr,int sc,int color){
          boolean vis[][]=new boolean[image.length][image[0].length];
          helper(image,sr,sc,color,vis,image[sr][sc]);
          return image;
     }

     public static void main(String[] args) {
          int image[][]={{1,1,1},{1,1,0},{1,0,1}};
          int sr=1,sc=1,color=2;
          floodFill(image, sr, sc, color);
          System.out.println(image[2][2]);
     }
}
