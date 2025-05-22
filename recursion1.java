import java.util.*;
public class recursion1 {
    public static void printBackNum(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printBackNum(n-1);
    }
    public static void printNumb(int n){
        if(n==6){
            return;
        }
        System.out.println(n);
        printNumb(n+1);
    }
    public static void printSum(int i,int n,int sum){
        if(i==n){
            sum+=i;
            System.out.println(sum);
            return;
        }
        sum=sum+i;
        printSum(i+1,n,sum);
        System.out.println(i);
    }
    public static int calcfactorial(int n,int f){
        if(n==1 || n==0){
            return 1;
        }
        f=f*n*calcfactorial(n-1,f);
        return f;
    }
    public static void printFib(int a,int b,int n){
        if(n==0){
            return;
        }
        int c=a+b;
        System.out.println(c);
        printFib(b, c, n-1);
    }
    public static int calcPower(int x,int n){  //(stack height=n)
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int xPowm1=calcPower(x, n-1);
        int xPown=x*xPowm1;
        return xPown;
    }
    public static int calcPowers(int x,int n){ //(stack height=logn)
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        //if n is even
        if(n%2==0){
            return calcPowers(x, n/2)*calcPowers(x, n/2);
        }
        else{
            return calcPowers(x, n/2)*calcPowers(x, n/2)*x;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printBackNum(n);
        // printNumb(n);
        //printSum(1,n,0);
        //System.out.println(calcfactorial(n, 1));
        /*int a=0,b=1;
        System.out.println(a);
        System.out.println(b);
        printFib(a, b, n-2);*/
        // int x=sc.nextInt();
        //System.out.println(calcPower(x,n));
        // System.out.println(calcPowers(x,n));
    }
}
