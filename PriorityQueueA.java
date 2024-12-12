import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueA {
    static class Student implements Comparable<Student>{  //overriding
        String name;
        int rank;
        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    
    public static void main(String[] args) {
        /*PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder()  );
        pq.add(3); //O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");  //O(1)
            pq.remove(); //O(logn)
        } */
        PriorityQueue<Student> stu = new PriorityQueue<>(Comparator.reverseOrder());
        stu.add(new Student("A",4));
        stu.add(new Student("B",5));
        stu.add(new Student("C",2));        
        stu.add(new Student("D",12));
        while(!stu.isEmpty()){
            System.out.println(stu.peek().name+"->"+stu.peek().rank);  //O(1)
            stu.remove(); //O(logn)
        }
    }
}
