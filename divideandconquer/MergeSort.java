public class MergeSort{
     public static void main(String[] args) {
          int arr[]={6,3,9,5,2,8};
          mergeSort(arr,0,arr.length-1);
          for(int i=0;i<arr.length;i++){
               System.out.print(arr[i]+" ");
          }     
     }

     public static void mergeSort(int arr[],int si,int ei){
          if(si>=ei){
               return;
          }
          int mid=si+(ei-si)/2;
          // left part divide
          mergeSort(arr, si, mid);
          // right part divide
          mergeSort(arr, mid+1, ei);
          // merging each part
          merge(arr,si,mid,ei);
     }
     public static void merge(int arr[],int si,int mid,int ei){
          int i=si;
          int j=mid+1;
          int k=0;
          int temp[]=new int[ei-si+1];

          while(i<=mid && j<=ei){
               if(arr[i]<arr[j]){
                    temp[k]=arr[i];
                    i++;
               }else{
                    temp[k]=arr[j];
                    j++;
               }
               k++;
          }
          // for leftover elements of 1st part
          while (i<=mid) {
               temp[k++]=arr[i++];
          }
          // for leftover elements of 2nd part
          while (j<=ei) {
               temp[k++]=arr[j++];
          }
          // copying temp array to original array
          for(k=0,i=si;k<temp.length;i++,k++){
               arr[i]=temp[k];
          }
     }
}