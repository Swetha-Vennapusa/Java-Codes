import java.util.*;
public class bitmanupulation {
    public static void get_manp(){
        int n=5;
        int pos=2;
        int bitMask=1<<pos;

        if((bitMask&n)==0){
            System.out.println("bit was zero");
        }
        else{
            System.out.println("bit was one");
        }
    }
    public static void set_manp(){
        int n=5;
        int pos=2;
        int bitMask=1<<pos;

        int newNumber=bitMask|n;
        System.out.println(newNumber);
    }
    public static void main(String args[]){
        //get_manp();
        set_manp();
    }
}
