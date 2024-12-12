import java.util.*;
public class linkedlist {
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
        //step1= Ceate new Node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //step 2 - newNode next=head
        newNode.next=head;  //link

        //step3 - head=newNode
        head=newNode;
    }
    public static void addLast(int data){
        //step1= Ceate new Node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //step 2 - newNode next=head
        tail.next=newNode;  //link

        //step3 - head=newNode
        tail=newNode;
    }
    public void print(){
        Node temp=head;
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        //i=idx-1  
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        //pre: i=size-2
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public int itrSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){   //key found
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public static int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1 ;
    }
    public static int recursiveSearch(int key){
        return (helper(head,key));
    }
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void removeNthfromEnd(int n){
        //Calculate size
        int size=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(n==size){
            head=head.next;//removeFirst
        }
        //size-n
        int i=1;
        int iToFind=size-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;   //slow=+1
            fast=fast.next.next;  //fast=+2
        }
        return slow;  //slow is my middleNode
    }
    public boolean checkPalindrome(){
        if(head==null || head.next!=null){
            return true;
        }
        //STEP 1:FIND THE MIDDLENODE
        Node midNode=findMid(head);

        //STEP 2: REVERSE THE 2ND HALF
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;  //right half head
        Node left=head;

        //STEP 3:CHECK LEFT HALF & RIGHT HALF 
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    //MERGESORT ON A LINKEDLIST

    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;   //mid node
    }
    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        //FIND MID
        Node mid=getMid(head);
        //LEFT & RIGHT MERGESORT
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //MERGE
        return merge(newLeft,newRight);
    } 
    
    //ZIGZAG LL
    public void zigZag(){

        //FIND MID
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        //REVERSE THE 2ND HALF
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;

        //alt merge -- zigzag merge
        while(left !=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }
    public static void main(String[] args) {
        linkedlist ll=new linkedlist();
        //ll.print();
      //  ll.addFirst(2);
        //ll.print();
      //  ll.addFirst(1);
        // ll.print();
      //  ll.addLast(3);
        // ll.print();
      //  ll.addLast(4);
        // ll.print();
        // ll.add(2,9);
        // ll.print();
        // System.out.println(ll.size);
        // System.out.println(ll.removeFirst());
        // ll.print();
        // System.out.println(ll.size);
        // ll.removeLast();
      //  ll.print();
        //System.out.println(ll.itrSearch(3));
        //System.out.println(ll.itrSearch(10));
        //System.out.println(ll.recursiveSearch(3));
        //System.out.println(ll.recursiveSearch(10));
        //ll.reverse();
        //ll.print();
        // ll.removeNthfromEnd(5);
        // ll.print();
        // ll.removeNthfromEnd(3);
        // ll.print();
        /*ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(1);*/
        //System.out.println(ll.checkPalindrome());
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // //ll.addFirst(5);
        // ll.print();
        // ll.head=ll.mergeSort(ll.head);
        // ll.print();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6  );
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
