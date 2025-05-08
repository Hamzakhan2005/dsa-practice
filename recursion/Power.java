public class Power {
     public static void main(String[] args) {
          System.out.println(power(2, 8));
          System.out.println(powOptim(2, 8));
     }
     // TC=O(n)
     public static int  power(int x,int n){
          if(n==0){
               return 1;
          }
          return x*power(x, n-1);
     }
     // OPTIMISED APPROACH
     // TC=O(logn)
     public static int powOptim(int x,int n){
          if(n==0){
               return 1;
          }
          int halfPow=powOptim(x, n/2);
          int halfPowsq=halfPow*halfPow;
          if(n%2==0){
               return halfPowsq;
          }
          return x*halfPowsq;
     }
}
