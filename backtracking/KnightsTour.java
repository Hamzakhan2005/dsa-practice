public class KnightsTour {
     public static void main(String[] args) {
          int board[][]=new int[8][8];
          for(int i=0;i<board.length;i++){
               for(int j=0;j<board.length;j++){
                    board[i][j]=-1;
               }
          }
          int dr[]={2,1,-1,-2,-2,-1,1,2};
          int dc[]={1,2,2,1,-1,-2,-2,-1};
          knightsTour(board, 0, 0, 0,dr,dc);
     }
     public static boolean knightsTour(int board[][],int count,int r,int c,int dr[],int dc[]){
          if(count==64){
               printTour(board);
               return true ;
          }
          if(r<0 || r>=board.length || c<0 ||c>=board.length|| board[r][c]!=-1){
               return false;
          }

          board[r][c]=count;
          for(int i=0;i<board.length;i++){
               int newRow=r+dr[i];
               int newCol=c+dc[i];
               boolean res=knightsTour(board, count+1, newRow, newCol, dr, dc);
               if(res==true)return res;
          }
          board[r][c]=-1;
          
          return false;
     }
     public static void printTour(int board[][]){
          for(int i=0;i<board.length;i++){
               for(int j=0;j<board.length;j++){
                    System.out.print(board[i][j]+" ");
               }
               System.out.println();
          }
     }
}
