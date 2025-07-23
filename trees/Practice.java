import java.util.*;
public class Practice {
     static class Node {
          int data;
          Node left;
          Node right;

          Node(int data){
               this.data=data;
               this.left=null;
               this.right=null;
          }
     }
     static class BinaryTree {
          public static int idx=-1;
          public static Node buildTree(int nodes[]){
               idx++;
               if(nodes[idx]==-1){
                    return null;
               }

               Node newNode=new Node(nodes[idx]);
               newNode.left=buildTree(nodes);
               newNode.right=buildTree(nodes);

               return newNode;
          }
          public static void levelOrder(Node root){
               if(root==null){
                    return;
               }
               Queue<Node> q=new LinkedList<>();
               q.add(root);
               q.add(null);

               while (!q.isEmpty()) {
                    Node currNode=q.remove();
                    if (currNode==null) {
                         System.out.println();
                         if (q.isEmpty()) {
                              break;
                         }else{
                              q.add(null);
                         }
                    }else{
                         System.out.print(currNode.data+" ");
                         if(currNode.left!=null){
                              q.add(currNode.left);
                         }
                         if (currNode.right!=null) {
                              q.add(currNode.right);
                         }
                    }

               }
          }
     }
     public static boolean isUnivalued(Node root,int val){
          if (root==null) {
               return true;
          }
          
          if (root.data!=val) {
               return false;
          }

          if (isUnivalued(root.left, val) && isUnivalued(root.right, val)) {
               return true;
          }else{
               return false;
          }

          
     }

     public static void invertTree(Node root){
          if (root==null) {
               return;
          }

          invertTree(root.left);
          invertTree(root.right);

          Node temp=root.left;
          root.left=root.right;
          root.right=temp;
     }

     public static boolean deleteNodesWithTarget(Node root,int target){
          if (root==null) {
               return true;
          }

          if (deleteNodesWithTarget(root.left, target) && deleteNodesWithTarget(root.right, target) && root.data==target) {
               return true;
          }
          if (deleteNodesWithTarget(root.left, target)) {
             root.left=null;  
          }
          if(deleteNodesWithTarget(root.right, target)){
               root.right=null;
          }
          return false;
     }
     public static void main(String[] args) {
          int nodes[]={1,3,3,-1,-1,2,-1,-1,3,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);
          // tree.levelOrder(root);
          // System.out.println(isUnivalued(root,root.data));

          // invertTree(root);
          // tree.levelOrder(root);

          deleteNodesWithTarget(root, 3);
          tree.levelOrder(root);

     }
}
