import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
public class arrayList {
    public static void reverseArrayList(ArrayList<Integer> list){
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static void maxInArrayList(ArrayList<Integer> list ){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(max<list.get(i)){
                max=list.get(i);
            }
            //max=Math.max(max,list.get(i));
        }
        System.out.println("max element: "+max);
    }
    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String[] args) {
        //ArrayList<data type> list_name=new ArrayList<>();
        //data type=Integer|Float|String|Boolean
        ArrayList<Integer> list=new ArrayList<>();

        //ADD FUNCTION -- O(1)
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);

        //list.add(1,9);  //O(n)
        System.out.println(list);
        //reverseArrayList(list);
        //maxInArrayList(list);
    /*   //GET FUNCTION -- O(1)
        int element=list.get(2);
        System.out.println(element);

        //REMOVE/DELETE FUNCTION -- O(n)
        list.remove(2);
        System.out.println(list);

        //SET AT INDEX -- O(n)
        list.set(2,10);
        System.out.println(list);

        //CONTAINS IN THE LIST
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }*/
        int idx1=1,idx2=3;
        swap(list,idx1,idx2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        //DESCENDING ORDER
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
