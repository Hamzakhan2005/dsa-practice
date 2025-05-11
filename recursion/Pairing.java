public class Pairing{
     public static void main(String[] args) {
          System.out.println(pairing(5));
     }
     public static int pairing(int n){
          if(n==1||n==2){
               return n;
          }

          // choice
          // single
          int fnm1=pairing(n-1);
          // pairs
          int fnm2=(n-1)*pairing(n-2);
          // totways
          int totWays=fnm1+fnm2;
          return totWays;
     }
}