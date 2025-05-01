public class ConvertUpper {
     public static void main(String[] args) {
          String str="hi i am hamza";
          System.out.println(convert(str));
     }
     public static String convert(String str){
          StringBuilder sb=new StringBuilder();
          char ch=Character.toUpperCase(str.charAt(0));
          sb.append(ch);
          for(int i=1;i<str.length();i++){
               if(str.charAt(i-1)==' '){
                    sb.append(Character.toUpperCase(str.charAt(i)));
               }else{
                    sb.append(str.charAt(i));
               }
          }
          return sb.toString();
     }
}
