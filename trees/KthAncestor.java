import java.util.*;
public class KthAncestor {
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
          
     }

     public static int kthAncestor(Node root,int n,int k){
          if (root==null) {
               return -1;
          }
          if (root.data==n) {
               return 0;
          }

          int leftDist=kthAncestor(root.left, n, k);
          int rightDist=kthAncestor(root.right, n, k);

          if (leftDist==-1 && rightDist==-1) {
               return -1;
          }
          int max=Math.max(leftDist, rightDist);
          if (max+1==k) {
               System.out.println(root.data);
          }
          return max+1;
     }
     public static void main(String[] args) {
          int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);

          int n1=4,k=1;
          kthAncestor(root, n1, k);
     }
}
