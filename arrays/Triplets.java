public class Triplets {
     public static void main(String[] args) {
          int nums[]={-1,0,1,2,-1,-4};
          triplets(nums);
     }
     public static void triplets(int nums[]){
          for(int i=0;i<nums.length;i++){
               for(int j=0;j<nums.length;j++){
                    if(j==i)
                    continue;
                    for(int k=0;k<nums.length;k++){
                         if(j==k||i==k)
                         continue;
                         if(nums[i]+nums[j]+nums[k]==0){
                              System.out.println("["+nums[i]+","+nums[j]+","+nums[k]+"]");
                         }
                         
                    }
               }
          }
     }
}
