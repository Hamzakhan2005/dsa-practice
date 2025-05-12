public class RemoveDuplicate {
     public static void main(String[] args) {
          String str="appnnacollege";
          remove(str, new StringBuilder(""), 0, new boolean [26]);
     }
     public static void remove(String str,StringBuilder newStr,int idx,boolean map[]){
          if(idx==str.length()){
               System.out.println(newStr);
               return;
          }
          // kaam
          char currChar=str.charAt(idx);
          if(map[currChar-'a']){
               // duplicate
               remove(str, newStr, idx+1, map);
          }else{
               map[currChar-'a']=true;
               remove(str, newStr.append(currChar), idx+1, map);
          }
     }
}
