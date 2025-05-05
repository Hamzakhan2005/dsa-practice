import java.util.ArrayList;

public class PairSum2 {

     public static void main(String[] args) {
          ArrayList<Integer> list=new ArrayList<>(); 
          list.add(11);
          list.add(15);
          list.add(6);
          list.add(8);
          list.add(9);
          list.add(10);
          int target=16;
          System.err.println(pairSum2(list, target));
     }
     public static boolean pairSum2(ArrayList<Integer> list,int target){
          int pivot=-1;
          int n=list.size();
          for(int i=0;i<list.size();i++){
               if(list.get(i)>list.get(i+1)){
                    pivot=i;
                    break;
               }
          }
          int lp=pivot+1;
          int rp=pivot;

          while(lp!=rp){
               if(list.get(rp)+list.get(lp)==target){
                    return true;
               }

               if(list.get(rp)+list.get(lp)<target){
                    lp=(lp+1)%n;
               }
               if(list.get(rp)+list.get(lp)>target){
                    rp=(n+rp-1)%n;
               }
          }
          return false;
     }
}