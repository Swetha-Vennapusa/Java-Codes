import java.util.*;
public class StackDeque {
    static class Stack{
        Deque<Integer> deque=new LinkedList<>();
        public void push(int data){
             deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
        public static void main(String[] args) {
            Stack s1=new Stack();
            s1.push(1);
            s1.push(2);
            s1.push(3);
            System.out.println("peek ="+s1.peek());;
            System.out.println(s1.pop());
            System.out.println(s1.pop());
            System.out.println(s1.pop());
        }
    }
}
