import java.util.Arrays;
import java.util.Collections;

public class BasicSorting{
     public static void main(String[] args) {
          int nums[]={1,4,1,3,2,4,3,7};
          // Integer nums[]={5,4,1,3,2};
          // bubble(nums);
          // selection(nums);
          // Arrays.sort(nums,Collections.reverseOrder());
          // insertion(nums);
          counting(nums);
          printArr(nums);
     }
     public static void bubble(Integer nums[]){
          int swap=0;
          for(int i=0;i<nums.length-1;i++){
               for(int j=0;j<nums.length-i-1;j++){
                    if(nums[j]>nums[j+1]){
                         int temp=nums[j];
                         nums[j]=nums[j+1];
                         nums[j+1]=temp;
                         swap++;
                    }
               }
               if(swap==0)
               break;
          }
     }
     public static void selection(Integer nums[]){
          for(int i=0;i<nums.length-1;i++){
               int minPos=i;
               for(int j=i+1;j<nums.length;j++){
                    if(nums[minPos]>nums[j]){
                         minPos=j;
                    }
               }
               int temp=nums[minPos];
               nums[minPos]=nums[i];
               nums[i]=temp;
          }
     }

     public static void insertion(Integer nums[]){
          for(int i=1;i<nums.length;i++){
               int prev=i-1;
               int curr=nums[i];
               while (prev>=0&& nums[prev]>curr) {
                    nums[prev+1]=nums[prev];
                    prev--;
               }
               nums[prev+1]=curr;
          }
     }

     public static void counting(int nums[]){
          int largest=Integer.MIN_VALUE;
          for(int i=0;i<nums.length;i++){
               largest=Math.max(largest,nums[i]);
          }
          int count[]=new int[largest+1];
          for(int i=0;i<nums.length;i++){
               count[nums[i]]++;
          }
          int j=0;
          for(int i=0;i<count.length;i++){
               while (count[i]>0) {
                    nums[j]=i;
                    j++;
                    count[i]--;
               }
          }
     }

     public static void printArr(int nums[]){
          for(int i=0;i<nums.length;i++){
               System.err.print(nums[i]+",");
          }
     }
}