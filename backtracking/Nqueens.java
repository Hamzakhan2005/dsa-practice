public class Nqueens {
     public static void main(String[] args) {
          int n=2;
          char board[][]=new char[n][n];
          // initialize
          for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                    board[i][j]='x';
               }
          }

          nQueens(board,0);
          System.out.println(count);
          if(print1NQueen(board, 0)){
               System.out.println("possible");
               printBoard(board);
          }else{
               System.out.println("impossible");
          }
     }
     static int count=0;
     public static void nQueens(char board[][],int row){
          if(row==board.length){
               // printBoard(board);
               count++;
               return;
          }

          // column loop
          for(int j=0;j<board.length;j++){
               if(isSafe(board,row,j)){
                    board[row][j]='Q';
                    nQueens(board, row+1);
                    board[row][j]='x';//backtracking step
               }
          }
     }

     public static boolean isSafe(char board[][],int row,int col){
          // verical up
          for(int i=row-1;i>=0;i--){
               if(board[i][col]=='Q'){
                    return false;
               }
          }
          // left diagonal up
          for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
               if(board[i][j]=='Q'){
                    return false;
               }
          }
          // right diagonal up
          for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
               if(board[i][j]=='Q'){
                    return false;
               }
          }
          return true;
     }
     public static boolean print1NQueen(char board[][],int row){
          if(row==board.length){
               // printBoard(board);
               count++;
               return true;
          }

          // column loop
          for(int j=0;j<board.length;j++){
               if(isSafe(board,row,j)){
                    board[row][j]='Q';
                    if( print1NQueen(board, row+1)){
                         return true;
                    }
                    board[row][j]='x';//backtracking step
               }
          }

          return false;
     }
     public static void printBoard(char board[][]){
          for(int i=0;i<board.length;i++){
               for(int j=0;j<board.length;j++){
                    System.out.print(board[i][j]+" ");
               }
               System.out.println();
          }
          System.out.println("--------");
     }
}
