public class Practice {
     public static void main(String[] args) {
          int nums[]=new int[4];
          int n=0;
          for(int i=2;i<=4;i++){
               if(i%2!=0){
                    nums[n]=i;
                    n++;
               }
          }
          nums[n]=1;
          n++;
          for(int i=1;i<=4;i++){
               if(i%2==0){
                    nums[n]=i;
                    n++;
               }
          }
          for(int i=0;i<4;i++){
               System.out.println(nums[i]);
          }
     }
     
}
