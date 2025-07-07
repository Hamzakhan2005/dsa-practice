public class SearchInBST {
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

     public static Node  searchBST(Node root,int val){
          if (root==null) {
               return null;
          }

          if (root.data==val) {
               return root;
          }

          if (root.data>val) {
               return searchBST(root.left, val);
          }else{
               return searchBST(root.right, val);
          }

     }

     public static void main(String[] args) {
         int values[]= {4,2,7,1,3};
         Node root=null;

          for(int i=0;i<values.length;i++){
               root=insert(root, values[i]);
          }
          System.out.println(searchBST(root, 1).data);
          
     }
}
