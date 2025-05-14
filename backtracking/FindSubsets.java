public class FindSubsets {
     public static void main(String[] args) {
          String str="abc";
          printSubsets(str, "", 0);
     }
     public static void printSubsets(String str,String ans,int i){
          // base case
          if(i==str.length()){
               if(ans.length()==0){
                    System.out.println("null");
               }else{
                    System.out.println(ans);
               }
               return;
          }

          // yes choice
          printSubsets(str, ans+str.charAt(i), i+1);
          // no choice
          printSubsets(str, ans, i+1);
     }
}
