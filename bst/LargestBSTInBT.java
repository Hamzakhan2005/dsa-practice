public class LargestBSTInBT{
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
          boolean isBST;
          int size;
          int min;
          int max;

          public Info(boolean isBST,int size,int min,int max){
               this.isBST=isBST;
               this.size=size;
               this.min=min;
               this.max=max;
          }
     }
     public static int maxSize=0;

     public static Info largestBST(Node root){
          if (root==null) {
               return new Info(true, 0, Integer.MAX_VALUE,Integer.MIN_VALUE);
          }

          Info leftInfo=largestBST(root.left);
          Info rightInfo=largestBST(root.right);

          int size=leftInfo.size+rightInfo.size+1;
          int min=Math.min(root.data,Math.min(leftInfo.min, rightInfo.min));
          int max=Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));
          if (root.data<=leftInfo.max || root.data>=rightInfo.min) {
                    return new Info(false, size, min, max);

          }

          if (leftInfo.isBST&&rightInfo.isBST) {
               maxSize=Math.max(maxSize, size);
               return new Info(true, size, min, max);
          }

          return new Info(false, size, min, max);

     }

     
     public static void main(String[] args) {
          int val[]={50,30,5,-1,-1,20,-1,-1,60,45,-1,-1,70,65,-1,-1,80,-1,-1};
          BinaryTree3 tree=new BinaryTree3();
          Node root=tree.buildTree(val);
          largestBST(root);
         System.out.println(maxSize);
     }
}