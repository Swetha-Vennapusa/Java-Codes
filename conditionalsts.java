import java.util.*;
public class conditionalsts {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        /*int a=1;
        int b=5;
        if (a>b){
            System.out.println("a");
        }
        else{
            System.out.println("b");
        }*/

        /*int a=sc.nextInt();
        int b=sc.nextInt();    
        if (a>b){
            System.out.print("a is larger");
        }
        else{
            System.out.print("b is larger");
        }*/

        /*int n=sc.nextInt();    
        if (n%2==0){
            System.out.print("even");
        }
        else{
            System.out.print("odd");
        }*/

        //PRINT LARGEST OF 3 NUMBERS
        /*int a=sc.nextInt();
        int b=sc.nextInt(); 
        int c=sc.nextInt(); 
        if (a>=b && a>=c){
            System.out.print("largest is A");
        }
        else if(b>=c){
            System.out.print("largest is B");
        }
        else{
            System.out.print("largest is C");
        }*/
        /*int marks=sc.nextInt();
        String res=marks>=33?"Pass":"Fail";
        System.out.print(res);*/

        //INCOME TAX

        /*int income=sc.nextInt();
        int tax;
        if (income<500000){
            tax=0;
        }
        else if(income>500000 && income<1000000){
            tax=(int)(income*0.2);
        }
        else{
            tax=(int)(income*0.3);
        }
        System.out.print("Your Tax is:"+tax);*/

        /*int a=sc.nextInt();
        int b=sc.nextInt(); 
        char operator=sc.next().charAt(0);
        switch(operator){
            case '+':System.out.println(a+b);
            case '-':System.out.println(a-b);
            case '*':System.out.println(a*b);
            case '/':System.out.println(a/b);
            case '%':System.out.println(a%b);
        }*/

        /*int a=sc.nextInt();
        if(a>0){
            System.out.print("Positive");
        }
        else{
            System.out.print("Negative");
        }*/

        /*double temp=sc.nextDouble();
        if(temp>100){
            System.out.print("Fever");
        }
        else{
            System.out.print("No Fever");
        }*/

        // int num=sc.nextInt();
        // switch(num){
        //     case 1:System.out.println("Sunday");
        //     break;
        //     case 2:System.out.println("Monday");
        //     break;
        //     case 3:System.out.println("Tuesday");
        //     break;
        //     case 4:System.out.println("Wednesday");
        //     break;
        //     case 5:System.out.println("Thursday");
        //     break;
        //     case 6:System.out.println("Friday");
        //     break;
        //     case 7:System.out.println("Saturday");
        //     break;
        //     default:System.out.println("Not a valid day");
        // }
        // int d=sc.nextInt();
        // int m=sc.nextInt();
        // int y=sc.nextInt();
    //     if(d>=1&&d<=31 && m>=1&&m<=12 && y>0)
	// {
	//   if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12)
	//     System.out.print("Valid");
	//     else if(m==4 ||m==6 || m==9 || m==11)
	//     {
	//       if(d<=30)
	//         System.out.print("Valid");
	//       else 
	//         System.out.print("Invalid");
	//     }
	//   else if(m==2)
	//   {
	//       if(y%400==0 || y%100!=0&&y%4==0)
	//       {
	//           if(d<=29)
	//           System.out.print("Valid");
	//           else
	//           System.out.print("Invalid");
	          
	//       }
	//       else
	//       {
	//           if(d<=28)
	//           System.out.print("Valid");
	//           else
	//           System.out.print("Invalid");
	//       }
	      
	//   }
	//   }else{
    //     System.out.println("Invalid");
    //   }
       /*  int cd=0;
        switch(m-1){
            case 12:
                cd+=31;
            case 11:
                cd+=30;
            case 10:
                cd+=31;
            case 9:
                cd+=30;
            case 8:
                cd+=31;
            case 7:
                cd+=31;
            case 6:
                cd+=30;
            case 5:
                cd+=31;
            case 4:
                cd+=30;
            case 3:
                cd+=31;
            case 2:
                if(y%400==0 || y%100!=0&&y%4==0){
                    cd+=29;
                }
                else
                {
                    cd+=28;
                }
            case 1:
                cd+=31;
        }
        if(y%400==0 || y%100!=0&&y%4==0){
            System.out.println(366-(cd+d));
        }
        else
        {
            System.out.println(365-(cd+d));
        }*/
        /*int m=sc.nextInt();
        char g=sc.next().charAt(0);
        char a=sc.next().charAt(0);
        int t=0;
        if(g=='N'){
            if(a=='Y'){
                System.out.println("No discount");
            }else{
                t+=m*0.3;
            }
        }else if(g=='Y'){
            if(a=='N'){
                t+=m*0.35;
            }else{
                t+=m*0.05;
            }
        }
        System.out.println((float)(m-t)); */
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        /*int n=Math.max(n1,n2);
        while(true)
        {
            if(n1%n==0 && n2%n==0)
            {
                System.out.print(n);
                return;
            }
            n++;
        }*/
       /* int m=Math.min(n1,n2);
        for(int i=m;i>0;i--){
            if(n1%i==0 && n2%i==0){
                System.out.println(i);
                return;
            }
        }*/
    
    }
}

