public class ShortestPath {
     public static void main(String[] args) {
          String str="WNEENESENNN";
          getPath(str);
     }
     public static void getPath(String str){
          int x=0,y=0;
          for(int i=0;i<str.length();i++){
               char ch=str.charAt(i);
               // North
               if(ch=='N'){
                    y++;
               }
               // South
               else if(ch=='S'){
                    y--;
               }
               // East
               else if(ch=='E'){
                    x++;
               }
               // West
               else if(ch=='W'){
                    x--;
               }
          }
          int X2=x*x;
          int Y2=y*y;
          System.out.println(Math.sqrt(X2+Y2));
     }
}
