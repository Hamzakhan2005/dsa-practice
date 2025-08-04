import java.lang.reflect.Array;
import java.util.*;
public class WordLadder {
     public static int min=Integer.MAX_VALUE;
     public static int shortestChain(String dic[],String start,String target){
          if (dic.length==0) {
               return 0;
          }
          int len=dic.length;
          Queue<String> s=new LinkedList<>();
          s.add(start);
          boolean vis[]=new boolean[len];
          int chain=1;
          while (!s.isEmpty()) {
               
               String curr=s.remove();
               for(int i=0;i<len;i++){
                    int check=curr.length()-1;
                    if (!vis[i]) {
                         for(int j=0;j<curr.length();j++){
                              for(int k=0;k<curr.length();k++){
                                   if (curr.charAt(j)==dic[i].charAt(k)) {
                                        check-=1;
                                        break;
                                   }
                              }
                              if (check==0) {
                                   break;
                              }
                         }
                    }
                    
                    
                    if (check==0) {
                         if (dic[i].equals(target)) {
                              chain++;
                              min=Math.min(min,chain);
                         }else{
                              
                              chain++;
                              
                         }
                         s.add(dic[i]);
                         vis[i]=true;
                         
                    }
               }
          }
          return chain;
     }
     public static void main(String[] args) {
          String Dic[]={"hot","dot","dog","lot","log","cog"};
          String start="hit";
          String target="cog";
          shortestChain(Dic, start, target);
          System.out.println(min);
          
     }
}
