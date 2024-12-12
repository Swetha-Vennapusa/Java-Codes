import java.util.*;

public class practice {
       public static boolean isPrime(int n) {
            boolean isPrime=true;  
            for(int i=2;i<n;i++){
                if(n%i==0){
                    isPrime=false;
                    break;
                }
            }
            return isPrime;
       }
       public static boolean isPrimes(int n) {  
            if(n==2){
                return true;
            }
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
        public static void print_primes(int n) { 
            for(int i=2;i<=n;i++){
                if(isPrime(i)){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
        public static float avg(int a,int b,int c){
            int sum=a+b+c;
            return sum/3;
        }
        public static boolean is_Even(int n){
            if(n%2==0){
                return true;
            }
            return false;
        }
        public static boolean palindrome(int n){
            int num=n;
            int sum=0;
            while(n>0){
                int rem=n%10;
                sum=sum*10+rem;
                n=n/10;
            }
            if(sum==num){
                return true;
            }
            return false;
        }
        public static int sumOfDigits(int n){
            int sum=0;
            while(n>0){
                int rem=n%10;
                sum+=rem;
                n=n/10;
            }
            return sum;
        }

       public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            //System.out.println(isPrime(n));
            //System.out.print(isPrimes(n));
            //print_primes(n);
            //int a=sc.nextInt();
            //int b=sc.nextInt();
            //int c=sc.nextInt();
            //System.out.println(avg(a,b,c));
            System.out.println(is_Even(n));
            //System.out.println(palindrome(n));
            //System.out.println(sumOfDigits(n));
       }
}
