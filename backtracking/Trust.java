public class Trust {
     public static void main(String[] args) {
          int n=4;
          int trust[][]={{1,3},{2,3},{1,4},{2,4},{4,3}};
          System.out.println(mayor(trust, n));
     }
     public static int mayor(int trust[][],int n){
          int mayor=-1;int count=0;
         for(int i=0;i<trust.length;i++){
          int num=trust[i][1];
          for(int j=0;j<trust.length;j++){
               if(trust[j][1]==num){
                    count+=1;
               }
          }
          if(count==(n-1)){
               mayor=num;
          }
          count=0;
         }
         return mayor;
     }
}
