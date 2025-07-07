import java.util.ArrayList;

public class ConvertBSTToBalancedBST {
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
     public static void getInorder(Node root,ArrayList<Integer> arr){
          if (root==null) {
               return;
          }

          getInorder(root.left,arr);
          arr.add(root.data);
          getInorder(root.right,arr);

     }

     public static Node getElements(ArrayList<Integer> arr,int si,int ei){
         if (si>ei) {
               return null;
         }
         int mid=(si+ei)/2;
         Node root=new Node(mid);
         root.left=getElements( arr, si, mid-1);
         root.right=getElements( arr, mid+1, ei);
         return root;
     }
     public static void preorder(Node root){
          if (root==null) {
               return;
          }
          System.out.print(root.data+" ");
          preorder(root.left);
          preorder(root.right);

     }
     public static void main(String args[]){
          int arr[]={8,5,3,6,11,10,12};

          Node root=null;
          for(int i=0;i<arr.length;i++){
               root=insert(root, arr[i]);
          }
          ArrayList<Integer> sorted=new ArrayList<>();
          getInorder(root,sorted);
          root=getElements(sorted,0,arr.length-1);
          preorder(root);
     }
}
