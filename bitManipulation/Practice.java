
import java.util.Arrays;

public class Practice {
     public static void main(String[] args) {
          // String fruits[]={"apple","mango","banana"};

          // String largest=fruits[0];
          // // O(x*n)
          // for(int i=1;i<fruits.length;i++){
          //      if(largest.compareTo(fruits[i])<0){
          //           largest=fruits[i];
          //      }
          // }
          // System.out.println(largest);

          // String str="HEllo World";
          // System.out.println(lowercase(str));
          String str1="race";
          String str2="care";
          System.out.println(anagram(str1, str2));
     }

     public static int lowercase(String str){
          int count=0;
          for(int i=0;i<str.length();i++){
               char ch=str.charAt(i);
               if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    count++;
               }
          }
          return count;
     }
     public static boolean anagram(String str1,String str2){
          str1=str1.toLowerCase();
          str2=str2.toLowerCase();
          if(str1.length()==str2.length()){
               char str1Array[]=str1.toCharArray();
               char str2Array[]=str2.toCharArray();
               Arrays.sort(str1Array);
               Arrays.sort(str2Array);
               if(Arrays.equals(str1Array, str2Array)){
                    return true;
               }else{
                    return false;
               }
          }else{
               return false;
          }
     }
}
