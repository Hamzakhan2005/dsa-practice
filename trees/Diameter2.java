import java.util.*;
public class Diameter2 {
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
     static class BinaryTree2 {
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
          
          public static Info diameter2(Node root){
               if (root==null) {
                    return new Info(0, 0);
               }

               Info leftInfo=diameter2(root.left);
               Info rightInfo=diameter2(root.right);

               int diam=Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
               int ht=Math.max(leftInfo.ht, rightInfo.ht)+1;

               return new Info(diam, ht);
          }
          static class Info {
               int diam,ht;
               Info(int diam,int ht){
                    this.diam=diam;
                    this.ht=ht;
               }
          }
     }
     public static void main(String[] args) {
          int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
          BinaryTree2 tree=new BinaryTree2();
          Node root=tree.buildTree(nodes);
          
          System.out.println(tree.diameter2(root).diam);
     }
}
