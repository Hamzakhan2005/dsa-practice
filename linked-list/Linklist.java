public class Linklist{
     public static class Node{
          int data;
          Node next;
          public Node(int data){
               this.data=data;
               this.next=null;
          }
     }
     public static Node head;
     public static Node tail;
     public static int size;

     public static void addFirst(int data){
          Node newNode=new Node(data);
          size++;
          if(head==null){
               head=tail=newNode;
               return;
          }
          newNode.next=head;
          head=newNode;
     }

     public static void addLast(int data){
          Node newNode=new Node(data);
          size++;
          if(head==null){
               head=tail=newNode;
               return;
          }
          tail.next=newNode;
          tail=newNode;
     }
     public int removeFirst(){
          if(size==0){
               System.out.println("ll is empty");
               return Integer.MAX_VALUE;
          }
          if(size==1){
               int val=head.data;
               head=tail=null;
               size--;
               return val;
          }
          int val=head.data;
          head=head.next;
          size--;
          return val;
     }
     public int removeLast(){
          if(size==0){
               System.out.println("ll is empty");
               return Integer.MAX_VALUE;
          }
          if(size==1){
               int val=head.data;
               head=tail=null;
               size--;
               return val;
          }
          Node prev=head;
          int i=0;
          while(i<size-2){
               prev=prev.next;
               i++;
          }
          int val=tail.data;
          prev.next=null;
          tail=prev;
          size--;
          return val;
     }
     public void deleteNthFromEnd(int n){
          
           if(n==size){
               head=head.next;
               return;
          }
          Node temp=head;
          int i=1;
          while (i!=(size-n)) {
               temp=temp.next;
               i++;
          }
         temp.next=temp.next.next;
     }
     public static void main(String[] args) {
          Linklist ll=new Linklist();
          // ll.print();
   
          // ll.print();
          ll.addFirst(2);
          // ll.print();
          ll.addFirst(1);
          ll.addLast(2);
          // ll.print();
          ll.addLast(1);
          ll.addFirst(3);
          // ll.addInMiddle(0, 3);
          ll.print();
          // System.out.println(ll.size);
          // System.out.println(ll.removeFirst());
          // ll.print();
          // System.out.println(ll.removeLast());
          // // ll.print();
          // System.out.println(ll.iteratSrch(3));
          // System.out.println(ll.recurSrch(0, head, 0));
          // ll.reverse();
          // // ll.print();
          // ll.deleteNthFromEnd(1);
          // ll.print();
          System.out.println(ll.checkPalindrome());
     }
     // slow fast approach (finding middle node)
     public Node findMid(Node head){
          Node slow=head;
          Node fast=head;
          while(fast!=null && fast.next!=null){
               slow=slow.next;
               fast=fast.next.next;
          }
          return slow;
     }

     public boolean checkPalindrome(){
          if(head==null || head.next==null){
               return true;
          }
          Node mid=findMid(head);

          Node prev=null;
          Node curr=mid;
          Node next;
          while(curr!=null){
               next=curr.next;
               curr.next=prev;
               prev=curr;
               curr=next;
          }
          Node right=prev;
          Node left=head;
          while (right!=null) {
               if(right.data!=left.data){
                    return false;
               }
               right=right.next;
               left=left.next;
          }
          return true;
     }
     public void print (){
          Node temp=head;
          while(temp!=null){
               System.out.print(temp.data+"->");
               temp=temp.next;
          }
          System.out.println();
     }
     public int iteratSrch(int key){
          Node temp=head;
          int idx=0;
          while(temp.next!=null){
               if(temp.data==key){
                    return idx; 
               }
               temp=temp.next;
               idx++;
          }
          return -1;
     }
     public int recurSrch(int key,Node head,int idx){
          if(head==null){
               return -1;
          }
          if(head.data==key){
               return idx;
          }
          return recurSrch(key, head.next, idx+1);
     }
     public void reverse(){
          Node prev=null;
          Node curr=tail=head;
          Node next;
          while (curr!=null) {
               next=curr.next;
               curr.next=prev;
               prev=curr;
               curr=next;
          }
          head=prev;
     }
     public void addInMiddle(int data,int idx){
          Node newNode=new Node(data);
          size++;
          Node temp=head;
          int i=0;
          while(i<idx-1){
               temp=temp.next;
               i++;
          }
          newNode.next=temp.next;
          temp.next=newNode;
     }
}