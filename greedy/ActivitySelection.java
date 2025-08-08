import java.util.*;
public class ActivitySelection{
     public static void main(String[] args) {
          int start[]={1,3,0,5,8,5};
          int end[]={2,4,6,7,9,9};
          ArrayList<Integer> ans=new ArrayList<>();

          int activity[][]=new int[start.length][3];
          for(int i=0;i<start.length;i++){
               activity[i][0]=i;
               activity[i][1]=start[i];
               activity[i][2]=end[i];
          }

          Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));

          // int maxAct=1;
          // int lastEnd=activity[0][2];
          // ans.add(activity[0][0]);
          // for(int i=1;i<end.length;i++){
          //      if(activity[i][1]>=lastEnd){
          //           lastEnd=activity[i][2];
          //           maxAct++;
          //           ans.add(activity[i][0]);
          //      }
          // }
          

          int maxAct=1;
          int lastEnd=end[0];
          ans.add(0);
          for(int i=1;i<end.length;i++){
               if(start[i]>=lastEnd){
                    lastEnd=end[i];
                    maxAct++;
                    ans.add(i);
               }
          }

          System.out.println("maximum activity= "+maxAct);
          for (int i = 0; i < ans.size(); i++) {
               System.out.print("A"+ans.get(i)+"\t");
          }
     }
}