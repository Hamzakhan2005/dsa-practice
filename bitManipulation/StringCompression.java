public class StringCompression {
     public static void main(String[] args) {
          String str="aaabbcccdd";
          System.out.println(compress(str));
     }    
     public static String compress(String str){
          StringBuilder sb=new StringBuilder("");
          
          for(int i=0;i<str.length();i++){
               char ch=str.charAt(i);
               sb.append(ch);
               Integer count=1;
               while (i<str.length()-1 && str.charAt(i+1)==ch) {
                    count++;
                    i++;
               }
               
               if(count>1){
                    sb.append(count.toString());
               }
          }
          return sb.toString();
     }
}
