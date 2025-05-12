public class Tiling {
     public static void main(String[] args) {
          System.out.println(calcWays(4));
     }
     public static int calcWays(int n){
          if(n==0||n==1){
               return 1;
          }
          // kaam
          // vertical choice
          int fnm1=calcWays(n-1);
          // horizontal choice
          int fnm2=calcWays(n-2);

          int totalWays=fnm1+fnm2;
          return totalWays;
     }
}