public class Practice2 {
     static class Node{
          int data;
          Node left;
          Node right;

          Node(int data){
               this.data=data;
          }
     }
     public static Node insert(Node root,int val){
          if (root==null) {
               root=new Node(val);
               return root;
          }

          if (root.data>val) {
               root.left=insert(root.left, val);
          }else{
               root.right=insert(root.right, val);
          }
          return root;
     }
     public static int closest=0;
     public static void findClosest(Node root,int k,int minDiff){
          if (root==null) {
               return ;
          }

          int diff=Math.abs(root.data-k);
          if (minDiff>diff) {
               minDiff=Math.min(minDiff, diff);
               closest=root.data;
          }
          if (minDiff==0) {
               return;
          }
          findClosest(root.left, k, minDiff);
          findClosest(root.right, k, minDiff);
          
     }
     public static void main(String[] args) {
          int arr[]={8,5,3,6,11,20};
          Node root=null;
          for(int i=0;i<arr.length;i++){
               root=insert(root, arr[i]);
          }
          findClosest(root, 19,Integer.MAX_VALUE);
          System.out.println(closest);

     }
}
