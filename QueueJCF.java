import java.util.*;

public class QueueJCF {
    public class Queuec{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //ADD
        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //REMOVE
        public  int remove(){
            if(s1.isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            return s1.pop();
        }
        public  int peek(){
            if(s1.isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            return s1.peek();
        }  
    }
    public static void main(String[] args) {
        Queue r=new LinkedList<>();
        r.add(1);
        r.add(2);
        r.add(3);
        while(!r.isEmpty()){
            System.out.println(r.peek());
            r.remove();
        }
    }
    
}
