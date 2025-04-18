import java.util.Scanner;


public class Array {
     public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          int numbers[]={1,-2,6,-1,3};
          // int key=sc.nextInt();
          // if(linear(numbers, key)==0){
          //      System.out.println(key+" is not present");
          // }

          // reverse(numbers);
          // for(int i=0;i<numbers.length;i++){
          //      System.out.print(numbers[i]+" ");
          // }

          // pairs(numbers);
          subArray(numbers);

          // int idx=binary(numbers, key);
          // if(idx!=-1){
          //      System.out.println(key+" is present at "+idx);
          // }else{
          //      System.out.println(key+" is not present");
          // }
     }     
     public static int linear(int numbers[],int key){
          for(int i=0;i<numbers.length;i++){
               if(numbers[i]==key){
                    System.out.println(key+" is present at index "+i);
                    return 1;
               }
          }
          return 0;
     }
     public static int binary(int numbers[],int key){
          int start=0;int end=numbers.length-1;
          while (start<=end) {
               int mid=(start+end)/2;
               if(numbers[mid]==key){
                    return mid;
               }else if(numbers[mid]<key){
                    start=mid+1;
               }else{
                    end=mid-1;
               }
          }
          return -1;
     }
     public static void reverse(int numbers[]){
          int l=numbers.length-1;
          for(int i=0;i<=l/2;i++){
               int temp=numbers[i];
               numbers[i]=numbers[l-i];
               numbers[l-i]=temp;
          }
     }
     public static void pairs(int numbers[]){
          for(int i=0;i<numbers.length-1;i++){
               for(int j=i+1;j<numbers.length;j++){
                    System.out.print("("+numbers[i]+","+numbers[j]+")");
               }
               System.out.println();
          }
     }

     // time complexity=O(n^3)
     public static void subArray(int numbers[]){
          int sum=0;int min=numbers[0];
          int max=Integer.MIN_VALUE;
          System.out.println(max);
          for(int i=0;i<numbers.length;i++){
               for(int j=i;j<numbers.length;j++){
                    System.out.print("[");
                    for(int k=i;k<=j;k++){
                         System.out.print(numbers[k]+",");
                         sum+=numbers[k];
                    }
                    System.out.print("] sum="+sum);
                    if(min>=sum){
                         min=sum;
                    }
                    if(max<=sum){
                         max=sum;
                    }
                    sum=0;
               }
               System.out.println();
          }
          System.out.println("minimum= "+min+" maximum= "+max);
     }
}
