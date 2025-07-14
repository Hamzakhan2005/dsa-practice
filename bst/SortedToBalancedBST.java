public class SortedToBalancedBST{
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
     public static void inorder(Node root){
          if (root==null) {
               return;
          }

          inorder(root.left);
          System.out.print(root.data+" ");
          inorder(root.right);

     }

     public static Node getElements(Node root,int arr[],int si,int ei){
         if (si>ei) {
               return root;
         }
         int mid=(si+ei)/2;
         root=insert(root, arr[mid]);
         getElements(root, arr, si, mid-1);
         getElements(root, arr, mid+1, ei);
         return root;
     }

     public static void main(String args[]){
          int arr[]={3,5,6,8,10,11,12};

          Node root=null;
          // for(int i=0;i<arr.length;i++){
          //      root=insert(root, arr[i]);
          // }

          root=getElements(root,arr,0,arr.length-1);
          inorder(root);
     }
}