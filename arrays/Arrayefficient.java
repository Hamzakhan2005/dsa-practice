import java.util.Scanner;

public class Arrayefficient {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int numbers[]={-2,-3,4,-1,-2,1,5,-3};
          // prefixArray(numbers);
          KADANE(numbers);
     }

     // time complexity=O(n^2)
     public static void prefixArray(int numbers[]){
          int max=Integer.MIN_VALUE;
          int currSum=0;
          int prefix[]=new int[numbers.length];
          prefix[0]=numbers[0];
          // calculate prefix array
          for(int i=1;i<numbers.length;i++){
               prefix[i]=prefix[i-1]+numbers[i];
          }

          for(int i=0;i<numbers.length;i++){
               int start=i;
               for(int j=i;j<numbers.length;j++){
                    int end=j;
                    currSum=start==0?prefix[end]:prefix[end]-prefix[start-1];
                    if(max<currSum){
                         max=currSum;
                    }
               }
          }
          System.out.println(max);
     }

     // KADANE'S ALGORITHM
     public static void KADANE(int numbers[]){
          int ms=Integer.MIN_VALUE;
          int cs=0;

          for(int i=0;i<numbers.length;i++){
               cs+=numbers[i];
               if(cs<0){
                    cs=0;
               }
               if(ms<cs){
                    ms=cs;
               }
          }
          System.out.println(ms);
     }
}
