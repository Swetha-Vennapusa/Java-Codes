import java.util.*;

public class strings {
    public static void string_basics(String name){
        System.out.println("My name is: "+name);
        System.out.println(name.length());            //String length method
        //String full_name=name+"@"+"Vennapusa";    //Concatenation
        //System.out.println(full_name);
        //System.out.println("My name is: "+name+" @"+name);
        for(int i=0;i<name.length();i++){
            System.out.println(name.charAt(i));  //Each character of the string
        }
        String name2="Praveen";
        if(name.compareTo(name2)==0){
            System.out.println("Equal Strings");
        }
        else{
            System.out.println("Not Equal Strings");
        }

    }
    public static void string_sum(int n){
        String str[]=new String[n];
        Scanner sc=new Scanner(System.in);
        int c=0;
        for(int i=0;i<n;i++){
            str[i]=sc.next();
            c+=str[i].length();
        }
        System.out.println(c);
        sc.close();
    }
    public static void replace_char(String str) {
        int size=str.length();
        String res="";
        for(int i=0;i<size;i++){
            if (str.charAt(i)=='e'){
                res+='i';
            }
            else{
                res+=str.charAt(i);
            }
        }
        System.out.println(res);
    }
    public static void username(String str) {
        int size=str.length();
        String res="";
        for(int i=0;i<size;i++){
            if (str.charAt(i)=='@'){
                break;
            }
            else{
                res+=str.charAt(i);
            }
        }
        System.out.println(res);
    }
    public static void string_builder(String str){
        StringBuilder sb=new StringBuilder(str);
        System.out.println(sb);
        System.out.println(sb.charAt(0));  //charAt() fumction        sb.
        sb.setCharAt(0,'P');    //set char at particular index
        System.out.println(sb);
        sb.insert(0,'S');   //Inserting at particular index
        System.out.println(sb);
        sb.delete(2,3);   //DEleting at particukar indices
        System.out.println(sb);
        sb.append("Swetha");    //Appending the chars or String at the end
        System.out.println(sb);
    }
    public static void reverse_string(String str){
        StringBuilder sb=new StringBuilder(str);
        for(int i=0;i<sb.length()/2;i++){     //Time Complexity=O(n)
            int front=i;
            int back=sb.length()-1-i;
            char frontChar=sb.charAt(front);
            char backChar=sb.charAt(back);
            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);
        }
        System.out.println(sb);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        //string_basics(str);
        //int n=sc.nextInt();
        //string_sum(n);
        //replace_char(str);
        //username(str);
        //string_builder(str);
        reverse_string(str);
    }
}
