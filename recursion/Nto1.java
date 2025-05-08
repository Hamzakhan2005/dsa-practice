public class Nto1{
     public static void main(String[] args) {
          nTo1(10);
          print1ToN(10);
     }
     public static void nTo1(int n){
          if(n==1){
               System.out.print(n);
               return;
          }
          System.out.print(n+",");
          nTo1(n-1);
     }
     public static void print1ToN(int n){
          if(n==1){
               System.out.print(n+",");
               return;
          }
          print1ToN(n-1);
          System.out.print(n+",");
     }
}