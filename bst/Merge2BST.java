import java.util.*;
public class Merge2BST {
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
     public static void preorder(Node root){
          if (root==null) {
               return;
          }
          
          System.out.print(root.data+" ");
          preorder(root.left);
          preorder(root.right);

     }
     public static void inorder(Node root,ArrayList<Integer> a){
          if (root==null) {
               return;
          }

          inorder(root.left,a);
          a.add(root.data);
          inorder(root.right,a);

     }
     public static Node mergeBST(Node root1,Node root2){
          ArrayList<Integer> a1=new ArrayList<>(); 
          ArrayList<Integer> a2=new ArrayList<>(); 

          inorder(root1,a1);
          inorder(root2,a2);

          // merge
          ArrayList<Integer> sorted=new ArrayList<>();
          int i=0,j=0;
          while (i<a1.size() && j<a2.size()) {
               if (a1.get(i)<=a2.get(j)) {
                    sorted.add(a1.get(i++));
               }else{
                    sorted.add(a2.get(j++));
               }
          }
          while (i<a1.size()) {
               sorted.add(a1.get(i++));
          }
          while (j<a2.size()) {
               sorted.add(a2.get(j++));
          }

          return getBalanced(sorted, 0, sorted.size()-1);
     }

     public static Node getBalanced(ArrayList<Integer> arr,int si,int ei){
          if (si>ei) {
               return null;
          }
          int mid=(si+ei)/2;
          Node root=new Node(arr.get(mid));
          root.left=getBalanced(arr, si, mid-1);
          root.right=getBalanced(arr, mid+1,ei );
          
          return root;
     }

     public static void main(String[] args) {
          int arr1[]={2,1,4};
          int arr2[]={9,3,12};
          Node root1=null;
          Node root2=null;
          for(int i=0;i<arr1.length;i++){
               root1=insert(root1, arr1[i]);
          }
          for(int i=0;i<arr2.length;i++){
               root2=insert(root2, arr2[i]);
          }

          Node root=mergeBST(root1, root2);
          preorder(root);
     }
}
