import java.util.*;
public class MaxBalancedSubString {
     public static void main(String[] args) {
          String s="LRRRRLLRLLRL";
          int subStrings=0;int l=0,r=0;
          for(int i=0;i<s.length();i++){
               char ptr=s.charAt(i);
               
               if(ptr=='L'){
                    l++;
               }else{
                    r++;
               }

               if(l==r){
                    subStrings++;
                    l=0;
                    r=0;
               }
          }
          if(subStrings==0){
               System.out.println(1);
          }else{
               System.out.println(subStrings);  
          }
          
     }
     
}