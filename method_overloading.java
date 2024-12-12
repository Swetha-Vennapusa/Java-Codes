import java.util.*;
public class method_overloading {
    //Sum of 2 numbers(int data type)
    public static int sum(int a,int b){
        return a+b;
    }
    //Sum of 3 numbers
    public static int sum(int a,int b,int c){
        return a+b+c;
    }
    //Sum of 2 numbers(float data type)
    public static float sum(float a,float b){
        return a+b;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        //int c=sc.nextInt();
        System.out.println(sum(a,b));
        //System.out.println(sum(a,b,c));
        System.out.println(sum(1.9f,2.1f));
    }
}
