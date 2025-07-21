import java.util.*;
public class KthLevel{
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
          public static void levelOrder(Node root,int k){
               if(root==null){
                    return;
               }
               int level=1;
               if(level==k){
                    System.out.print(root.data);
                    return;
               }
               Queue<Node> q=new LinkedList<>();
               q.add(root);
               q.add(null);
               
               while (!q.isEmpty()) {
                    Node currNode=q.remove();
                    if (currNode==null) {
                         // System.out.println();
                         if (q.isEmpty()) {
                              break;
                         }else{
                              q.add(null);
                              level++;
                         }
                    }else{
                         if (level==k) {
                              System.out.print(currNode.data+" ");
                         }
                         
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
     

     public static void KLevel(Node root,int level,int k){
          if (root==null) {
               return;
          }
          if (level==k) {
               System.out.print(root.data+" ");
               return;
          }
          KLevel(root.left, level+1, k);
          KLevel(root.right, level+1, k);
     }
     public static void main(String[] args) {
          int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);
          int k=3;
          // KLevel(root,1,k);
          tree.levelOrder(root, k);
     }
}