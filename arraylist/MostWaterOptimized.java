import java.util.ArrayList;

public class MostWaterOptimized {
     public static void main(String[] args) {
          ArrayList<Integer> height=new ArrayList<>();
          height.add(1);
          height.add(8);
          height.add(6);
          height.add(2);
          height.add(5);
          height.add(4);
          height.add(8);
          height.add(3);
          height.add(7);
          System.out.println(storeWater(height));
     }
     // 2 Pointer Approach TC=O(n)
     public static int storeWater(ArrayList<Integer> height){
          int Lp=0;int Rp=height.size()-1;
          int maxWater=Integer.MIN_VALUE;
          while(Lp<Rp){
               int ht=Math.min(height.get(Lp), height.get(Rp));
               int width=Rp-Lp;
               maxWater=Math.max(maxWater, ht*width);
               if(height.get(Lp)<height.get(Rp)){
                    Lp++;
               }else{
                    Rp--;
               }
          }
          return maxWater;
     }
}
