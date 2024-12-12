import java.util.*;
public class GreedyPractice {
    public static void MaxBalancedStringParti(String str,int n){
        int r=0,l=0;
        int bString=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='R'){
                r++;
            }else if(str.charAt(i)=='L'){
                l++;
            }
            if(r==l){
                bString++;
            }
        }
        System.out.println("The no.of (max)Balanced Strings = "+bString);
    }
    public static void main(String[] args) {
        String str="LRRRRLLRLLRL";
        int n=str.length();
        MaxBalancedStringParti(str, n);

    }
}
