import java.util.*;
public class MostWater{
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
     public static int storeWater(ArrayList<Integer> height){
          int max=Integer.MIN_VALUE;
          for(int i=0;i<height.size();i++){
               int water=0;
               for(int j=i+1;j<height.size();j++){
                    int h=Math.min(height.get(i),height.get(j));
                    int w=j-i;
                    water=h*w;
                    if(max<water){
                         max=water;
                    }
               }
          }
          return max;
     }
}