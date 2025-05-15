public class KeypadCombination {
     public static void main(String[] args) {
          char mapping[][]={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
          {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
          String keys="24";
          getCombination(mapping,0,keys.length(),keys,"");
     }
     public static void getCombination(char mapping[][],int pos,int len,String keys,String str){
          if(pos==len){
               System.out.println(str);
               str=str.substring(0,len-1);
               
               return;
          }
             

          int dig=Character.getNumericValue(keys.charAt(pos));
          for(int i=0;i<mapping[dig].length;i++){
               getCombination(mapping, pos+1, len, keys,str+mapping[dig][i]);
               
          }
          str="";
     }
}
