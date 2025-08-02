import java.util.ArrayList;

public class FindMinDepth {
     
     static class Node{
          int data;
          Node left;
          Node right;
          public Node(int data){
               this.data=data;
               left=right=null;
          }
     }
     public static Node root=null;
     public static int findMinDepth(Node root,int depth){
          if (root==null) {
               return depth;
          }
          if(root.left==null){
               return findMinDepth(root.right,depth)+1;
             }
             if(root.right==null){
               return findMinDepth(root.left,depth)+1;
             }
   
             return Math.min(findMinDepth(root.left,depth),findMinDepth(root.right,depth))+1;

     }
    
     public static void main(String[] args) {
          Node root=new Node(1);
          
          root.left=new Node(8);
          root.right=new Node(2);
          root.left.left=new Node(6);
          root.right.left=new Node(9);
          root.right.right=new Node(5);

          System.out.println(findMinDepth(root, 0));
          
          
     }
}
