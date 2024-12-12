import java.util.*;
public class loops {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //FOR LOOP

        /*for(int i=0;i<11;i++){
            System.out.println(i);
        }*/

        //WHILE LOOP

        /*int i=0;
        while(i<11){
            System.out.println(i);;
            i++;
        }*/

        //DO-WHILE LOOP

        /*int i=0;
        do{
            System.out.println(i);
            i++;
        }while(i<11);*/

        //PRINT SUM OF N NUMBERS

        /*int n=sc.nextInt();
        int sum=0;
        for (int i=0;i<=n;i++){
            sum+=i;
        }
        System.out.println(sum);*/

        //TABLE OF A GIVEN NUMBER

        /*int n=sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(n+" * "+i+" = "+n*i);
        }*/

        //PRIME NUMBER OR NOT

        /*int n=sc.nextInt();
        boolean isPrime=true;
        for(int i=2;i<(n-1);i++){     //i<=sqrt(n) 
            if(n%i==0){
                isPrime=false;
            }
        }
        if(isPrime==true){
            System.out.println("n is prime");;
        }
        else{
            System.out.println("n is not a prime");
        }*/

        //FACTORIAL OF A NUMBER

        /*int n=sc.nextInt();
        int p=1;
        for(int i=1;i<=n;i++){
            p=p*i;
        }
        System.out.println(p);*/

        //Singing Champ
        int n=sc.nextInt();
        int pos=0;
        for(int i=1;i<=n;i=i*2){
            pos=i;
        }
        System.out.println(pos);
    }
}
