import java.util.*;
import java.util.HashSet;
public class recursion2 {
    public static int first=-1;
    public static int last=-1;
    public static boolean[] map=new boolean[26];
    public static void towerOfHanoi(int n,String src,String helper,String dest){
        if(n==1){
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("transfer disk "+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);
    }
    public static void printRevString(int idx,String str){
        if(idx==0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        printRevString(idx-1, str);
        
    }
    public static void findOccurance(int idx,String str,char element){
        if(idx==str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currChar=str.charAt(idx);
        if(currChar==element){
            if(first==-1){
                first=idx;
            }
            else{
                last=idx;
            }
        }
        findOccurance(idx+1, str, element);
    }
    public static void moveAllX(String str,int idx,int count,String newStr){
        if(idx==str.length()){
            for(int i=0;i<count;i++){
                newStr+='x';
            }
            System.out.println(newStr);
            return;
        }
        char currChar=str.charAt(idx);
        if(currChar=='x'){
            count++;
            moveAllX(str, idx+1, count, newStr);
        }
        else{
            newStr+=currChar;
            moveAllX(str, idx+1, count, newStr);
        }
    }
    public static void removeDuplicates(int idx,String str,String newStr){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar=str.charAt(idx);
        if(map[currChar-'a']==true){
            removeDuplicates(idx+1, str, newStr);
        }else{
            newStr+=currChar;
            map[currChar-'a']=true;
            removeDuplicates(idx+1, str, newStr);
        }
    }
    public static void subsequences(String str,int idx,String newString){
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar=str.charAt(idx);
        //to be 
        subsequences(str, idx+1, newString+currChar);
        //or not to be
        subsequences(str, idx+1, newString);
    }
    public static void unique_subsequences(String str,int idx,String newString,HashSet<String> set){
        if(idx==str.length()){
            if(set.contains(newString)){
                return;
            }
            else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
            
        }
        char currChar=str.charAt(idx);
        //to be 
        unique_subsequences(str, idx+1, newString+currChar,set);
        //or not to be
        unique_subsequences(str, idx+1, newString,set);
    }
    public static String[] keypad={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printComb(String str,int idx,String combination){
        if(idx==str.length()){
            System.out.println(combination);
            return;
        }
        char currChar=str.charAt(idx);
        String mapping=keypad[currChar - '0'];
        for(int i=0;i<mapping.length();i++){
            printComb(str, idx+1, combination+mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // towerOfHanoi(n, "S", "H", "D");
        // String str=sc.next();
        // int idx=str.length()-1;
        // printRevString(idx, str);
        String str=sc.next();
        // findOccurance(0, str, 'a');
        // moveAllX(str, 0, 0, "");
        // removeDuplicates(0, str, "");
        // subsequences(str, 0, "");
        // HashSet<String> set=new HashSet<>();
        // unique_subsequences(str, 0, "",set);
        printComb(str, 0, "");
    }
}
