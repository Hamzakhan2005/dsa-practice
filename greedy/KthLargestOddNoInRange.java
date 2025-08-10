import java.util.*;
public class KthLargestOddNoInRange {
     public static void main(String[] args) {
          int L=-3,R=3;
          int k=11;
          int start,end;
          if(R>L){
               start=R;
               end=L;
          }else{
               start=L;
               end=R;
          }
          int count=0;
          for (int i = start; i >=end ; i--) {
               if(i%2!=0){
                    count++;
               }
               if(count==k){
                    System.out.println(i);
                    break;
               }
          }
          if (count<k) {
               System.out.println(0);
          }
     }
}
