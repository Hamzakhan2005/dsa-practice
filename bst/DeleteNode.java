public class DeleteNode {
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
     public static void inorder(Node root){
          if (root==null) {
               return;
          }
          inorder(root.left);
          System.out.print(root.data+" ");
          inorder(root.right);

     }
     public static Node deleteNode(Node root,int val){
          if(root==null){
               return null;
          }

          if (root.data>val) {
               root.left=deleteNode(root.left,val);
          }else if(root.data<val){
               root.right=deleteNode(root.right, val);
          }else{
               // case1
               if (root.left==null && root.right==null) {
                    return null;
               }
               // case2
               if (root.right==null) {
                    return root.left;
               }else if (root.left==null) {
                    return root.right;
               }
               // case3
               Node inorderSuccessor=findInorderSuccessor(root.right);
               root.data=inorderSuccessor.data;
               root.right=deleteNode(root.right, inorderSuccessor.data);
          }
          return root;
     }

     public static Node findInorderSuccessor(Node root){
          while (root.left!=null) {
               findInorderSuccessor(root.left);
          }
          return root;
     }

     public static void main(String[] args) {
          int values[]= {8,5,3,1,4,6,10,11,14};
         Node root=null;

          for(int i=0;i<values.length;i++){
               root=insert(root, values[i]);
          }

          deleteNode(root, 1);
          inorder(root);
     }
}
