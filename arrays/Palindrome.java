public class Palindrome {
     public static void main(String[] args) {
          String s="abcabaab";
          
          System.out.println(palindrome(s));
     }
     public static String palindrome(String s){
          String max="";int flag;int r=s.length()-1;int l;String sub="";
          for(int i=0;i<s.length();i++){
               for(int j=i;j<s.length();j++){
                    flag=0;l=0;  
                    if(j+1!=s.length()){
                         sub=s.substring(i, j);
                    }else{
                         sub=s.substring(i);
                    }
                    r=sub.length()-1;
                    
                    while (l<=r) {
                         if(sub.charAt(l)!=sub.charAt(r)){
                              flag=1;
                              break;
                         }
                         l++;
                         r--;
                    }
                    if(flag!=1&&max.length()<sub.length()){
                         max=sub;
                    }
               }
              
          }
          return max;
     }
}
