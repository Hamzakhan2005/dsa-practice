public class Practice1 {
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

     public static int rangeSum(Node root,int l,int r){
          if (root==null) {
               return 0;
          }

          if (root.data>=l && root.data<=r ) {
               return root.data +rangeSum(root.left, l, r)+rangeSum(root.right, l, r);
          }else if (root.data<l) {
               return rangeSum(root.right, l, r);
          }else if (root.data>r) {
               return rangeSum(root.left, l, r);
          }

          return root.data;
          
     }
     public static void main(String[] args) {
          int arr[]={8,5,3,6,11,20};
          Node root=null;
          for(int i=0;i<arr.length;i++){
               root=insert(root, arr[i]);
          }

          System.out.println(rangeSum(root, 4, 7));
     }
}
