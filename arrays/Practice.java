import java.util.*;

public class Practice {
     public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          int nums[]={4,  5, 6, 7, 0, 1, 2};
          // System.out.println(repeat(nums));
          System.out.println(binarySearch(nums,3));
          // String s=sc.nextLine();
          // check(s);
     }
     public static void check(String s){
          int max=0 ,c=0;String str="";
          for(int i=0;i<s.length();i++){
               char ch=s.charAt(i);
               for(int j=0;j<str.length();j++){
                    if(ch==str.charAt(j)){
                         c=1;
                         break;
                    }
               }
               if(c==0){
                    str+=ch;
               }else{
                    if(max<str.length())
                    max=str.length();
                    c=0;
                    str=""+ch;
               }
          }
          if(max<str.length())
          max=str.length();
          System.out.println(max);
     }

     public static boolean repeat(int nums[]){
          for(int i=0;i<nums.length;i++){
               for(int j=i+1;j<nums.length;j++){
                    if(nums[i]==nums[j]){
                         return true;
                    }
               }
          }
          return false;

     }
     public static int minSearch(int nums[]){
          int min=0;
          for(int i=1;i<nums.length;i++){
               if(nums[min]>nums[i]){
                    min=i;
               }
          }
          return min;
     }

     public static int binarySearch(int nums[],int target){
          int min=minSearch(nums);int l,r;
          if(nums[min]<=target&&target<=nums[nums.length-1]){
               l=min;r=nums.length-1;
          }else{
               l=0;r=min;
          }

          while(l<=r){
               int mid=l+(r-l)/2;
               if(nums[mid]==target){
                    return mid;
               }else if(nums[mid]>target){
                    r=mid-1;
               }else{
                    l=l+1;
               }
          }

          return -1;
     }
}
