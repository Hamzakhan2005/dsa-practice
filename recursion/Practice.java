public class Practice {
     public static void main(String[] args) {
          // int arr[]={3, 2, 4, 5, 6, 2, 7, 2,2};
          // printAllOccur(arr,2,0);
          
          // String spell[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
          // numToString(2019, new StringBuilder(""),spell);

          // String str="abcdef";
          // lengthOfString(str, 0);
          System.out.println(countContiguous("aba", 0, 0, 0));
     }
     public static void printAllOccur(int arr[],int key,int i){
          if(i==arr.length){
               return;
          }

          if(arr[i]==key){
               System.out.println(i);
          }
          printAllOccur(arr, key, i+1);
     }
     public static void numToString(int n,StringBuilder str,String spell[]){
          if(n==0){
               System.out.println(str);
               return;
          }

          int dig=n%10;
          numToString(n/10, str.insert(0, " "+spell[dig]), spell);
     }
     public static void lengthOfString(String str,int l){
          if(str.length()==0){
               System.out.println(l);
               return;
          }

          lengthOfString(str.substring(1), l+1);
     }
     public static int countContiguous(String str,int count,int s,int e){
          if(s==str.length()){
               return count;
          }
          if(e==str.length()){
               return countContiguous(str, count, s+1, s+1);
          }

          if(str.charAt(s)==str.charAt(e)){
               return countContiguous(str, count+1, s, e+1);
          }
          return countContiguous(str, count, s, e+1);
     }
}
