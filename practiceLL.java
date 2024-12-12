import java.util.*;
public class practiceLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public Node getIntersection(Node head1,Node head2){
        while(head2!=null){
            Node temp=head1;
            while(temp!=null){
                if(head2==temp){
                    return head2;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return null;
    }
    public static void main(String[] args) {
        practiceLL ll=new practiceLL();
        Node head1=new Node(1);
        Node head2=new Node(4);

        Node newNode=new Node(5);
        head2.next=newNode;

        newNode=new Node(2);
        head1.next=newNode; 

        newNode=new Node(3);
        head1.next.next=newNode;


        newNode=new Node(6);
        head2.next.next=newNode;
        head1.next.next.next=newNode;

        newNode=new Node(7);
        head1.next.next.next.next=newNode;

        Node intersection=ll.getIntersection(head1, head2);
        if(intersection==null){
            System.out.println("No Intersection");
        }
        else{
            System.out.println("Intersection Point: "+intersection.data);
        }
    }
}
