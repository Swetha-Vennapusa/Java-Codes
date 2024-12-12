import java.util.Deque;
import java.util.LinkedList;

public class QueueDeque {
    static class Queue{
        Deque<Integer> deque=new LinkedList<>();
        public void add(int data){
             deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue qu=new Queue();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        System.out.println("peek ="+qu.peek());
        System.out.println(qu.remove());
        System.out.println(qu.remove());
        System.out.println(qu.remove()); 
    }
}
