import java.util.*;
public class breakcontinue {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        //BREAK STATEMENT
        /*do{
            System.out.print("enter your number:");
            int n=sc.nextInt();
            if((n%10)==0){
                break;
            }
            System.out.println(n);
            
        }while(true);
        System.out.println("i am out");*/

        //CONTINUE STATEMENT

        /*int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            if(i==3){
                continue;
            }
            System.out.println(i);
        }*/

        do{
            System.out.print("enter your number:");
            int n=sc.nextInt();
            if((n%10)==0){
                continue;
            }
            System.out.println(n);
        }while(true);
    }
}
