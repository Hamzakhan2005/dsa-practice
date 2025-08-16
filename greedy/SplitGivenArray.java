import java.util.*;
public class SplitGivenArray {
     public static int ans=Integer.MAX_VALUE;
     public static void subSets(int arr[],int n,int idx,int k,int sum,int maxSum){
          if(k==1){
               maxSum=Math.max(maxSum, sum);
               sum=0;
               for(int i=idx;i<n;i++ ){
                    sum+=arr[i];
               }
               maxSum=Math.max(maxSum, sum);
               ans=Math.min(maxSum, ans);
               return ;
          }
          sum=0;
          for(int i=idx;i<n;i++){
               sum+=arr[i];
               maxSum=Math.max(maxSum, sum);
               subSets(arr, n, i+1, k-1,sum,maxSum);
          }
          
     }
     public static void main(String[] args) {
          int arr[]={1,2,3,4};
          int k=3;
          subSets(arr, arr.length, 0, k, 0, 0);
          System.out.println(ans);
          
     }
     
}
