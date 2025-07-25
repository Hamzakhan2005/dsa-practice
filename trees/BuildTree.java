import java.util.*;
public class BuildTree {
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
          static int idx=-1;
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
          public static void preOrder(Node root){
               if(root==null){
                    return;
               }
               System.out.print(root.data+" ");
               preOrder(root.left);
               preOrder(root.right);
          }
          public static void inOrder(Node root){
               if (root==null) {
                    return;
               }
               inOrder(root.left);
               System.out.print(root.data+" ");
               inOrder(root.right);
          }
          public static void postOrder(Node root){
               if (root==null) {
                    return;
               }
               postOrder(root.left);
               postOrder(root.right);
               System.out.print(root.data+" ");
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
          public static int height(Node root){
               if (root==null) {
                    return 0;
               }
               int lh=height(root.left);
               int rh=height(root.right);
               return Math.max(lh, rh)+1;
          }
          public static int countOfNodes(Node root){
               if (root==null) {
                    return 0;
               }
               int lcount=countOfNodes(root.left);
               int rcount=countOfNodes(root.right);
               return lcount+ rcount+1;
          }
          public static int sumOfNodes(Node root){
               if(root==null){
                    return 0;
               }
               int leftSum=sumOfNodes(root.left);
               int rightSum=sumOfNodes(root.right);
               return leftSum+rightSum+root.data;
          }
          //TC=O(n^2)
          public static int diameter1(Node root){
               if (root==null) {
                    return 0;
               }
               int ld=diameter1(root.left);
               int lh=height(root.left);
               int rd=diameter1(root.right);
               int rh=height(root.right);

               int selfDiam=lh+rh+1;

               return Math.max(selfDiam,Math.max( ld,rd));
          }
     }
     public static void main(String[] args) {
          int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);
          
          // tree.preOrder(root);
          // tree.inOrder(root);
          // tree.postOrder(root);

          // tree.levelOrder(root);
          // System.out.println(tree.height(root));
          // System.out.println(tree.countOfNodes(root));
          // System.out.println(tree.sumOfNodes(root));

          System.out.println(tree.diameter1(root));
     }
}