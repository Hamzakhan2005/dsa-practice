public class ValidateaBST {
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
     
     public static boolean validateBST(Node root,Node min,Node max){
          if (root==null) {
               return  true;
          }

          if (min!=null && min.data>=root.data) {
               return false;
          }
          if (max!=null && max.data<=root.data) {
               return false;
          }

          return validateBST(root.left, min, root)&&validateBST(root.right, root, max);
     }

     public static void main(String[] args) {
          int values[]= {1,1,1};
          Node root=null;
 
          for(int i=0;i<values.length;i++){
                root=insert(root, values[i]);
          }

          System.out.println(validateBST(root, null, null));
     }
}
