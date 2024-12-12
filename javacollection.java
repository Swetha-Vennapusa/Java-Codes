import java.util.*;
import java.util.LinkedList;
public class javacollection {
    public static void main(String[] args) {
        //CREATE -- objects,int,float,boolean -->Integer,Float,Character
        LinkedList<Integer> ll=new LinkedList<>();

        //ADD
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        System.out.println(ll);
        //REMOVE
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
