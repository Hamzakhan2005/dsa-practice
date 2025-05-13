public class TowerOfHanoi {
     public static void main(String[] args) {
          stepsForTower("A", "B", "C", 2);
     }
     public static void stepsForTower(String source,String helper,String dest,int n){
          if(n==1){
               System.out.println("transfer disk "+n+" from "+source+" to "+dest);
               return;
          }
          
          // n-1 disks from src to helper
          stepsForTower(source, dest, helper, n-1);
          // nth disk from src to dest
          System.out.println("transfer disk "+n+" from "+source+" to "+dest);
          // nth disk from helper to dest
          stepsForTower(helper, source, dest, n-1);
     }
}
