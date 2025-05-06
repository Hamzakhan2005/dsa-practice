public class Fibonacci {
     public static void main(String[] args) {
          System.out.println(printNthFib(25));
     }
     public static int printNthFib(int n){
          if(n==1||n==0){
               return n;
          }
          
          return printNthFib(n-1)+printNthFib(n-2);
     }
}
