public class GetIntersection {
     public static class Node{
          int data;
          Node next;
          Node prev;

          public Node(int data){
               this.data=data;
               this.next=null;
               this.prev=null;
          }
     }
     public static Node head;
     public static Node tail;
     public static int size;

     public static Node getIntersectionNode(Node head1, Node head2){
          while (head2 != null) {
               Node temp = head1;
               while (temp != null) {
                    if (temp == head2) {
                         return head2;
                    }
                    temp = temp.next;
               }
               head2 = head2.next;
          }
          return null;
     }
     public static void main(String[] args) {
          GetIntersection ll=new GetIntersection();
          Node head1=new Node(2);
          Node head2=new Node(4);

          Node newNode=new Node(6);
          head1.next=newNode;

          newNode=new Node(8);
          head1.next.next=newNode;
          
          newNode=new Node(1);
          head2.next=newNode;

          newNode=new Node(3);
          head2.next.next=newNode;

          newNode=new Node(9);
          head1.next.next.next=newNode;
          head2.next.next.next=newNode;

          newNode=new Node(11);
          head2.next.next.next.next=newNode;
          
          if(ll.getIntersectionNode(head1,head2)==null){
               System.out.println("No Intersection point");
          }else {
               System.out.print("Intersection Point: "+ ll.getIntersectionNode(head1,head2).data);
          }
               
     }
     
}
