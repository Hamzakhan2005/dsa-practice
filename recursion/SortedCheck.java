public class SortedCheck {
     public static void main(String[] args) {
          int arr[]={1,2,7,4,5};
          System.out.println(checkSort(arr, 0));
     }

     // TC = O(n)   SC= O(n)
     public static boolean checkSort(int arr[],int i){
          if(i==arr.length-1){
               return true;
          }
          if(arr[i]<arr[i+1]){
               return checkSort(arr, i+1);
          }else{
               return false;
          }
     }
}