public class CountInversion {
     public static void main(String[] args) {
          int arr[]={2,4,1,3,5};
          System.out.print(mergeSort(arr, 0, arr.length-1));
     }
     public static int mergeSort(int arr[],int si,int ei){
       int inversions=0;   

       if(si<ei){
          int mid=(si+ei)/2;
          inversions=mergeSort(arr, si, mid);
          inversions+=mergeSort(arr, mid+1, ei);
          inversions+=merge(arr, si, mid+1, ei);
       }

       return inversions;
     }
     public static int merge(int arr[],int si,int mid,int ei){
          int i=si;int j=mid;int k=0;
          int temp[]=new int[ei-si+1];
          int invCount=0;

          while (i<mid && j<=ei) {
               if(arr[i]<=arr[j]){
                    temp[k++]=arr[i++];
               }else{
                    temp[k++]=arr[j++];
                    invCount+=(mid-i);
               }
          }

          while(i<mid){
               temp[k++]=arr[i++];
          }
          while(j<=ei){
               temp[k++]=arr[j++];
          }

          for(i=si,k=0;i<ei;i++,k++){
               arr[i]=temp[k];
          }
          return invCount;
     }
}
