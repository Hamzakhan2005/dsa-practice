public class Practice3 {
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

     public static int greaterSum(Node root,int upperSum){
          if (root==null) {
               return 0;
          }

          if(root.left==null && root.right==null ){
               int temp=root.data;
               root.data+=upperSum;
               return temp;
          }
          int rightSum=greaterSum(root.right, upperSum);
          int currData=root.data;
          root.data+=rightSum+upperSum;
          int leftSum=greaterSum(root.left, root.data);
          return currData+rightSum+leftSum;
          
     }
     
     public static void inorder(Node root){
          if (root==null) {
               return;
          }

          inorder(root.left);
          System.out.print(root.data+" ");
          inorder(root.right);
     }
     public static void main(String[] args) {
          int arr[]={4,1,0,2,3,6,5,7,8};
          Node root=null;
          for(int i=0;i<arr.length;i++){
               root=insert(root, arr[i]);
          }

          greaterSum(root, 0);
          inorder(root);
     }
}
