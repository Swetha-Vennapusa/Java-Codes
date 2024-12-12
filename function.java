import java.util.*;
public class function {
    public static void printHelloWorld(){
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
    }
    public static void printHello(String name){
        System.out.println(name);
        return;
    }
    public static int calSum(int a,int b){
        return a+b;
    }
    public static int calMult(int a,int b){
        return a*b;
    }
    public static void fact(int a){
        if(a<0){
            System.out.println("Invalid Number");
            return;
        }
        int factorial=1;
        for(int i=a;i>=1;i--){
            factorial*=i;
        }
        System.out.println(factorial);
    }
    public static void avg(int a,int b,int c){
        int sum=a+b+c;
        float avg=sum/3;
        System.out.println(avg);
    }
    public static void oddSum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                sum=sum+i;
            }
        }
        System.out.println(sum);
    }
    public static int greatestOfTwo(int a,int b){
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    public static double circumference_of_circle(float r){
            return 2*(3.14f)*(r);
    }
    public static void vote_eligibility(int age){
        if(age>18){
            System.out.print("Eligible");
            return;
        }
        else{
            System.out.print("Not Eligible");
            return;
        }
    }
    public static void infiniteloop(int n){
        do{
            System.out.println(n);
        }while(true);
    }
    public static void count_p_n_z(){
        Scanner sc=new Scanner(System.in);
        int p=0;
        int q=0;
        int r=0;
        System.out.println("Press 1 to cntinue & 0 to stop");
        int i=sc.nextInt();
        while(i==1){
            System.out.println("Enter the number:");
            int m=sc.nextInt();
            if(m>0){
                p++;
            }else if(m<0){
                q++;
            }
            else{
                r++;
            }
            System.out.println("Press 1 to cntinue & 0 to stop");
            i=sc.nextInt();
        }
        System.out.println(p);
        System.out.println(q);
        System.out.println(r);
    }
    public static int exponential(int n,int x){
        int val=1;
        for(int i=1;i<=n;i++){
            val=val*x;
        }
        return val;
    } 
    public static int gcd(int n1,int n2){
        while(n1!=n2){
            if(n1>n2){
                n1=n1-n2;
            }
            else{
                n2=n2-n1;
            }
        }
        return n2;
    }
    public static int gcds(int n1,int n2,int n3){
        int g=gcd(n1,n2);
        return gcd(g,n3);
    }
    public static void chageA(int a){
        a=10;
    }
    public static int fac(int a){
        int f=1;
        for(int i=a;i>=1;i--){
            f*=i;
        }
        return f;
    }
    public static int binomail_coefficient(int n,int r){
        int n_fact=fac(n);
        int r_fact=fac(r);
        int nmr=fac(n-r);
        int res=n_fact/(r_fact*nmr);
        return res;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //String str=sc.next();
        //int n=sc.nextInt();
        int a=sc.nextInt();
        //int b=sc.nextInt();
        //float r=sc.nextInt();
        //int c=sc.nextInt();
        //int n1=sc.nextInt();
        //int n2=sc.nextInt();
        //printHelloWorld();
        //printHello(str);
        //int sum=calSum(n1,n2);
        //System.out.println(sum);
        //int prod=calMult(n1,n2);
        //System.out.println(prod);
        //fact(n);
        //avg(a,b,c);
        //oddSum(n);circumference_of_circle(
        //int res=greatestOfTwo(a,b);
        //System.out.println("the greater is "+res);
        //double resu=circumference_of_circle(r);
        //System.out.println(resu);
        //vote_eligibility(a);
        //infiniteloop(a);
        //count_p_n_z();
        //System.out.println(exponential(n,a));
        //System.out.println(gcd(n1,n2));
        //System.out.println(gcds(n1,n2,a));
        //chageA(a);
        //System.out.println(a);
        //System.out.println(fac(a));
        int r=sc.nextInt();
        System.out.println(binomail_coefficient(a,r));
    }
}
