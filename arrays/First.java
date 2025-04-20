import java.util.Scanner;

public class First{
     public static void main(String args[]){
          First obj=new First();
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          // obj.primeInRange(n);
          // obj.decimal(n);
          obj.binary(n);
     }
     
     public void decimal(int n){
          int c=n;int rem,count=0;double sum=0.0;
          while (c!=0) {
               rem=c%10;
               sum+=(rem*Math.pow(2, count));
               count++;
               c/=10;
          }
        System.out.println(sum);
     }

     public void binary(int n){
          int sum=0;int dig,c=0;
          while (n!=0) {
               dig=n%2;
               sum+=(dig*Math.pow(10, c));
               c++;
               n=n/2;
          }
          System.out.println(sum);
     }

     public void primeInRange(int n){
          for(int i=2;i<=n;i++){
               if(isPrime(i)){
                    System.out.print(i+" ,");
               }
          }
     }

     public boolean isPrime(int n){
          if(n==2){
               return true;
          }
               for(int i=2;i<=Math.floor(Math.sqrt(n));i++){
                   if(n%i==0)
                   return false;
               }
               return true;
          
     }
}