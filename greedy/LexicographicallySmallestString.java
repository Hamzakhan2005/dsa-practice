import java.util.*;
public class LexicographicallySmallestString {
     public static void main(String[] args) {
          int n=5, k=42;
          StringBuilder sb=new StringBuilder();


          while(n>0){
               if((n-1)*26>=(k-1)){
                    sb.append('a');
                    n--;
                    k--;
               }else{
                    int pos=k%26;
                    if(pos==0){
                         sb.append('z');
                         n--;
                         k-=26;
                    }else{
                         sb.append((char)(pos-1+'a'));
                         n--;
                         k-=pos;
                    }
               }
          }          
          System.out.println(sb);
          
     }
}
