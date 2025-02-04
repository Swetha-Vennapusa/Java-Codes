import java.util.*;

public class BinaryToDecimal {
    public static void binToDec(int binNum){
        int myNum=binNum;
        int pow=0;
        int decNum=0;
        while (binNum>0) {
            int lastDigit=binNum%10;
            decNum=decNum+(lastDigit*(int)Math.pow(2,pow));

            pow++;
            binNum=binNum/10;
        }
        System.out.println("decimal of "+myNum+" = "+decNum);
    }
    public static void decTobin(int decNum){
        int myNum=decNum;
        int pow=0;
        int binNum=0;
        while (decNum>0) {
            int rem=decNum%2;
            binNum=binNum+(rem*(int)Math.pow(10,pow));

            pow++;
            decNum=decNum/2;
        }
        System.out.println("binary of "+myNum+" = "+binNum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //binToDec(n);
        decTobin(n);
    }
}
