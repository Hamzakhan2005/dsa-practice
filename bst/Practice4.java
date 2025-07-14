import java.util.ArrayList;

public class Practice4 {
     static class Node{
          int data;
          Node left;
          Node right;

          Node(int data){
               this.data=data;
          }
     }
     static class BinaryTree3 {
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
     static class Info{
          boolean isBst;
          int min;
          int max;
          int currSum;

          Info(boolean isBst,int min,int max,int currSum){
               this.isBst=isBst;
               this.max=max;
               this.min=min;
               this.currSum=currSum;
          }
     }
     public static int finalSum=0;
     public static Info maxSum(Node root){
          if (root==null) {
               return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
          }
          
          Info leftInfo=maxSum(root.left);
          Info rightInfo=maxSum(root.right);

          int min=Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
          int max=Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));
          int currSum=root.data+leftInfo.currSum+rightInfo.currSum;
          
             
               if (root.data<=leftInfo.max || root.data>=rightInfo.min) {
                    return new Info(false, min, max, currSum);
               }
               if (leftInfo.isBst && rightInfo.isBst) {
                    finalSum=Math.max(finalSum, currSum);
                    return new Info(true, min, max, currSum);
               }

          return new Info(false, min, max, currSum);

     }

     public static void main(String[] args) {
          int arr[]={1,4,2,-1,-1,4,-1,-1,3,2,-1,-1,5,4,-1,-1,6,-1,-1};
          BinaryTree3 tree=new BinaryTree3();
          Node root=tree.buildTree(arr);


          maxSum(root);
          System.out.println(finalSum);
     }
}
