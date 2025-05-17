public class RatInAmaze {
     public static void main(String[] args) {
          int maze[][]= { { 1, 0, 0, 0 },{ 1, 1, 0, 1 },{ 1, 1, 0, 0 },{ 1, 1, 1, 1 } };
          int sol[][]=new int[maze.length][maze.length];
          sol[0][0]=1;
          mazeSolver(maze, 4, 0, 0,sol);
     }
     public static void mazeSolver(int maze[][],int n,int r,int c,int sol[][]){
          if(r==n-1 && c==n-1){
               sol[r][c]=1;
               printPath(sol);
               sol=new int[n][n];
               return;
          }else if(r==n || c==n-1){
               return;
          }

         if(isSafe(maze, r, c)){
               sol[r][c]=1;
               mazeSolver(maze, n, r+1, c, sol);
               mazeSolver(maze, n, r, c+1, sol);
               sol[r][c]=0;
         }

         return;
     }

     public static boolean isSafe(int maze[][],int x,int y){
          if(maze[x][y]==1){
               return true;
          }
          return false;
     }
     public static void printPath(int sol[][]){
          for(int i=0;i<sol.length;i++){
               for(int j=0;j<sol.length;j++){
                    System.out.print(sol[i][j]+" ");
               }
               System.out.println();
          }
          System.out.println("----------");
     }
}
