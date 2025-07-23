import java.util.*;
public class Practice2{
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
     static class BinaryTree{
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
     static int max=Integer.MIN_VALUE;
     public static int getMaxPath(Node root){
          if (root==null) {
               return 0;
          }

          int l=getMaxPath(root.left);
          int r=getMaxPath(root.right);

          int max_single=Math.max(Math.max(l, r)+root.data,root.data);

          int max_top=Math.max(max_single, l+r+root.data);

          max=Math.max(max_top,max);

          return max_single;
     }
     

     public static void main(String[] args) {
          int nodes[]={-10,9,-1,-1,20,15,-1,-1,7,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);

          // tree.levelOrder(root);
          getMaxPath(root);
          System.out.println(max);
     }
}