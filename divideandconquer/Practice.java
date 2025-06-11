public class Practice {
     public static void main(String[] args) {
          // String arr[]={"sun","earth","mars","mercury"};
          // mergeSort(arr, 0, arr.length-1);
          // for(int i=0;i<arr.length;i++){
          //      System.out.print(arr[i]+" ");
          // }

          int arr[]={2,2,1,1,1,2,2};
          System.out.println(countMajority(arr, 0,arr.length-1));

         
     }

     public static void mergeSort(String arr[],int si,int ei){
          if(si>=ei){
               return;
          }

          int mid=si+(ei-si)/2;

          mergeSort(arr, si, mid);
          mergeSort(arr, mid+1, ei);

         merge(arr, si, ei, mid);
     }

     public static void merge(String arr[],int si,int ei,int mid){
          int i=si;
          int j=mid+1;
          int k=0;
          String temp[]=new String[ei-si+1];

          while(i<=mid && j<=ei){
               if(arr[i].compareTo(arr[j])<0){
                    temp[k]=arr[i];
                    i++;
               }else{
                    temp[k]=arr[j];
                    j++;
               }
               k++;
          }

          while (i<=mid) {
               temp[k++]=arr[i++];
          }
          while (j<=ei) {
               temp[k++]=arr[j++];
          }

          for(k=0,i=si;k<temp.length;k++,i++){
               arr[i]=temp[k];
          }
     }

     public static int countMajority(int arr[],int si,int ei){
          if(si>=ei){
               return arr[si];
          }

          int mid=si+(ei-si)/2;
          int left=countMajority(arr, si, mid);

          int right=countMajority(arr,mid+1,ei);

          int leftMajority=countInRange(arr,left,si,mid);
          int rightMajority=countInRange(arr,right,mid+1,ei);

          return (leftMajority >rightMajority ?left:right);
     }
     public static int countInRange(int arr[],int num,int si,int ei){
          int count=0;
          for(int i=si;i<=ei;i++){
               if(arr[i]==num){
                    count++;
               }
          }
          return count;
     }
}
