import java.util.*;
public class linkedlist2 {
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
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true; //cycle exists
            }
        }
        return false; //cycle doesn't exist
    }
    public static void removeCycle(){

        //DETECT CYCLE
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return;
        }

        //FIND MEETING POINT
        slow=head;
        Node prev=null;  //lastnode
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        //REMOVE CYCLE -- lastnode.next=null
        prev.next=null;
    }
    public static void main(String[] args) {
        Node temp=new Node(2);
        head=new Node(1);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;
        //1->2->3->1 
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

    }
}
