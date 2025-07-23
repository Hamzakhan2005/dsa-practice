import java.util.*;

public class Practice3 {
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
     public static String giveDuplicate(Node root,ArrayList<Node> list,HashMap<String,Integer> hm){
          if (root==null) {
               return "";
          }

          String left=giveDuplicate(root.left, list,hm);
          String right=giveDuplicate(root.right, list,hm);
          String curr=Integer.toString(root.data);

          String str="("+left+","+curr+","+right+")";

          if (!hm.containsKey(str)) {
               hm.put(str, 1);
          }
          else if (hm.containsKey(str) && hm.get(str)==1) {
               hm.replace(str, 2);
               list.add(root);
          }

          return str;
     }
     public static void main(String[] args) {
          int nodes[]={1,2,4,-1,-1,-1,3,2,4,-1,-1,-1,4,-1,-1};
          BinaryTree tree=new BinaryTree();
          Node root=tree.buildTree(nodes);

          // tree.levelOrder(root);
          ArrayList<Node> list=new ArrayList<>();
          HashMap<String,Integer> hm=new HashMap<>();

          giveDuplicate(root, list,hm);
          for(int i=0;i<list.size();i++){
               System.out.print(list.get(i).data+" ");
          }
     }
}
