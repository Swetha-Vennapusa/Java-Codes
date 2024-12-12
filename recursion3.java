import java.util.*;
public class recursion3 {
    public static void printPerm(String str,String permutation){
        if(str.length()==1){
            System.out.println(permutation);;
            return;
        }
        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            String newStr=str.substring(0, i)+str.substring(i+1);
            printPerm(newStr, permutation+currChar);
        }
    }
    
    public static int countPaths(int i,int j,int n,int m){
        if(i==n || j==m){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        //move downwards
        int downPaths=countPaths(i+1, j, n, m);

        //move rightwards
        int rightPaths=countPaths(i, j+1, n, m);

        return downPaths+rightPaths;
    }
    public static int placeTitles(int n,int m){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        int vertical=placeTitles(n-m, m);
        int horizontal=placeTitles(n-1, m);
        return vertical+horizontal;
    }
    public static int callGuests(int n){
        if(n<=1){
            return 1;
        }
        int ways1=callGuests(n-1);
        int ways2=(n-1)*callGuests(n-2);
        return ways1+ways2;
    }
    public static void printSubset(ArrayList<Integer> subset){
        for(int i=0;i<subset.size();i++){
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void findSubsets(int n,ArrayList<Integer> subset){
        if(n==0){
            printSubset(subset);
            return;
        }
        //add hoga
        subset.add(n);
        findSubsets(n-1,subset);

        //add nahi hoga
        subset.remove(subset.size()-1);
        findSubsets(n-1, subset);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //String str="abc";
        //printPerm(str, "");
        int n=sc.nextInt();
        //int m=sc.nextInt();
        //System.out.println(countPaths(0, 0, n, m));
        //System.out.println(placeTitles(n, m));
        //System.out.println(callGuests(n));
        ArrayList<Integer>subset=new ArrayList<>();
        findSubsets(n, subset);
    }
}
