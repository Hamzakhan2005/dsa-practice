public class Bitmanipulation {
     public static void main(String[] args) {
          // oddOrEven(3);
          // oddOrEven(26);
          // oddOrEven(11);
          // System.out.println(getIthBit(10, 3));
          // System.out.println(setIthBit(10, 2));
          // System.out.println(clearIthBit(10, 1));
          // System.out.println(updateIthBit(10, 2,1));
          // System.out.println(clearLastIBits(15, 2));
          // System.out.println(clearBitsInRange(10, 2,4));
          System.out.println(isPowerOfTwo(5));
          System.out.println(countSetBits(16));
          System.out.println(fastExponentiation(3,3));
     }
     public static void oddOrEven(int n){
          int bitmask=1;
          if((n & bitmask)==0){
               System.out.println("Even no.");
          }else{
               System.out.println("Odd no.");
          }
     }
     public static int getIthBit(int n,int i){
          int bitmask=1<<i;
          if((n & bitmask)==0){
               return 0;
          }else{
               return 1;
          }
     }
     public static int setIthBit(int n,int i){
          int bitmask=1<<i;
          return (n | bitmask);
     }
     public static int clearIthBit(int n,int i){
          int bitmask=~(1<<i);
          return (n & bitmask);
     }
     public static int updateIthBit(int n,int i,int newBit){
          if(newBit==0){
               return clearIthBit(n, i);
          }else{
               return setIthBit(n, i);
          }
     }
     public static int clearLastIBits(int n,int i){
          int bitmask=(~0)<<i;
          return (n & bitmask);
     }
     public static int clearBitsInRange(int n,int i,int j){
          int a=(~0)<<j+1;
          int b=1<<i-1;
          int bitmask=a|b;
          return (n & bitmask);
     }
     public static boolean isPowerOfTwo(int n){
          if((n & (n-1))==0){
               return true;
          }else{
               return false;
          }
     }
     public static int countSetBits(int n){
          int count=0;
          while(n>0){
               if((n & 1)==1){
                    count++;
               }
              n=( n>>1);
          }
          return count;
     }
     public static int fastExponentiation(int a,int n){
          int ans=1;
          while (n>0) {
               if((n & 1)==1){
                    ans=ans*a;
               }
               a=a*a;
               n=n>>1;
          }
          return ans;
     }
}
