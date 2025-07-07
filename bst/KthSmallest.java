public class KthSmallest {
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
     public static int smallest=0;
     public static int i=0;
     public static void getKthSmallest(Node root,int k){
          if (root==null) {
               return ;         
          }
          
          getKthSmallest(root.left, k);
          i++;
          
          if (i==k) {
               smallest=root.data;
               return;
          }
          getKthSmallest(root.right, k);

          
     }

     public static void main(String[] args) {
          int arr[]={8,5,3,6,11,20};
          Node root=null;
          for(int i=0;i<arr.length;i++){
               root=insert(root, arr[i]);
          }

          getKthSmallest(root, 3);
          System.out.println(smallest);
     }
}
