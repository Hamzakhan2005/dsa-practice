public class BinaryString {
     public static void main(String[] args) {
          binString(3, 0, "");
     }
     public static void binString(int n,int lastPlace,String str){
          if(n==0){
               System.err.println(str);
               return;
          }

          binString(n-1, 0, str+"0");
          if(lastPlace==0){
               binString(n-1, 1, str+"1");
          }       
     }
}
