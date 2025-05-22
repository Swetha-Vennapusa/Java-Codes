import java.util.*;
public class DynamicProgramming1 {
    //Recursion
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    //MEMOIZATION
    public static int fibinocci(int n, int fab[]){
        if(n==0 ||n==1){
            return 1;
        }
        if(fab[n]!=0){
            return fab[n];
        }
        fab[n]=fibinocci(n-1,fab)+fibinocci(n-2, fab);
        return fab[n];

    }
    //TABULATION
    public static int fibTabulation(int n){
        if(n<=1){
            return n;
        }
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //CLIMBING STAIRS - RECURSION
    public static int climbingStairs(int n){//O(2^n)
        if(n==0){
            return 1;
        }if(n<0){
            return 0;
        }
        return climbingStairs(n-1)+climbingStairs(n-2);
    }

    //CLIMBING STAIRS - MEMOIZATION
    public static int climbingStairsMemo(int n, int ways[]){//O(n)
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n]= climbingStairsMemo(n-1,ways)+climbingStairsMemo(n-2,ways);
        return ways[n];
    }

     //CLIMBING STAIRS - TABULATION
     public static int countWaysTab(int n){//O(n)
        int dp[] = new int[n+1];
        dp[0]= 1;
        for(int i=1;i<=n;i++){
          if(i==1){
            dp[i]= dp[i-1];
          }else{
            dp[i]= dp[i-1]+dp[i-2];
          }
        }
        return dp[n];
     }

    //0-1 Knapsack -recursion
    public static int knapsack(int val[],int wt[],int W,int n){
        if(n==0||W==0){
            return 0;
        }
        if(wt[n-1]<=W){  //Valid
            //include
            int ans1=val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
            //exclude 
            int ans2=knapsack(val, wt, W, n-1);
            return Math.max(ans1,ans2);
        }else{ //not valid
            return knapsack(val, wt, W, n-1);

        }
    }
    //0-1 Knapsack - MEMOIZATION
    public static int knapsack2(int val[],int wt[],int dp[][],int W,int n){
        if(n==0|| W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            //include
            int ans1=val[n-1]+knapsack2(val, wt,dp, W-wt[n-1], n-1);
            //exclude
            int ans2=knapsack2(val, wt,dp, W, n-1);
            dp[n][W]=Math.max(ans1,ans2);
            return dp[n][W];
        }
        dp[n][W]=knapsack2(val, wt, dp, W, n-1);
        return dp[n][W];
    }

    //o-1 Knapsack - TABULATION
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int knapsack3(int val[],int wt[],int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w<=j){
                    int incProfit=v+dp[i-1][j-w];
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit,excProfit);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

     //ROD CUTTING
     //weight=> length; val=price;w=>totRod
    public static int rodCutting(int length[],int price[],int totRod){
        int n=price.length;
        int dp[][]=new int[n+1][totRod+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                //valid
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }
    // tabulation - UNBOUNDED KNAPSNACK
    public static int unboundedKnapsack(int val[],int wt[],int W){
        int n = val.length;
        int dp [][] = new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int i=0;i<W+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];

    }
    //targetsum - TABULATION
    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
     }
     public static boolean targetsum(int arr[],int sum){//O(n*sum)
        int n= arr.length;
        boolean dp[][]= new boolean[n+1][sum+1];
        //i=items && j= targetsum
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }else if(dp[i-1][j]==true){
                     //exclude
                     dp[i][j] = true;
                }
               
            }
        }
        print(dp);
        return dp[n][sum];
    }
    //LONGEST COMMON SUBSEQUENCE --RECURSION
    public static int lcSubsequence(String str1,String str2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){  //same
            return lcSubsequence(str1, str2, n-1, m-1)+1;
        }
        else{  //different
            int ans1=lcSubsequence(str1, str2, n-1, m);
            int ans2=lcSubsequence(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
        }
    }

    //LONGEST COMMON SUBSEQUENCE --MEMOIZATION
    public static int lcsMemoization(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }  
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){  //same
            return dp[n][m]=lcsMemoization(str1, str2, n-1, m-1,dp)+1;
        }
        else{  //different
            int ans1=lcsMemoization(str1, str2, n-1, m,dp);
            int ans2=lcsMemoization(str1, str2, n, m-1,dp);
            return dp[n][m]=Math.max(ans1,ans2);
        }
    }

    //LONGEST COMMON SUBSEQUENCE --TABULATION  O(n*m)
    public static int lcsTabulation(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }

    //LONGEST COMMON SUBSTRING -- TABULATION   T.C = O(n*m)
    public static int longestCommonSubstring(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        int ans=0;

        //initialize
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
    
    //LONGEST INCREASING SUBSEQUENCE -- TABULATION
    public static int lcs(int arr1[],int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        int dp[][]=new int[n+1][m+1];

        //initialize
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int longestIncreasingSubsequence(int arr1[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int arr2[]=new int[set.size()]; //sorted unique elements
        int i=0;
        for (int num : set) {
            arr2[i]=num;
            i++;
        }
        Arrays.sort(arr2);  //ascending order 
        return lcs(arr1,arr2);
    }

    //EDIT DISTANCE    O(n*m)
    public static int editDistance(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];

        //initialise
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){  //same
                    dp[i][j]=dp[i-1][j-1];
                }else{ //diff
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(add,Math.min(del,rep)); 
                }
            }
        }
        return dp[n][m];
    }

    //CATALAN'S NUMBER -- RECURSION
    public static int catalanRec(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans+=catalanRec(i)*catalanRec(n-i-1);  
        }
        return ans;
    }

    //CATALAN'S NUMBER -- MEMOIZATION
    public static int catalanMem(int n,int dp[]){
        if(n==0 ||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanMem(i, dp)*catalanMem(n-i-1, dp);
        }
        return dp[n]=ans;
    }

    //CATALAN'S NUMBER -- TABULATION   //O(n*m)
    public static int catalanTab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1]; //Ci=Cj*Ci-j-1
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        // int n=5;
        // System.out.println(fibonacci(n));
        // int fab[] = new int[n+1];
        // System.out.println(fibinocci(n, fab)); 
        // System.out.println(fibTabulation(n));
        // System.out.println();
        // int n=3; 
        // System.out.println(climbingStairs(n));
        // int ways[] = new int[n+1];
        // Arrays.fill(ways,-1);
        // System.out.println(climbingStairsMemo(n, ways));
        // System.out.println(countWaysTab(n));
        // int val[]={15,14,10,45,30};
        // int wt[]={2,5,1,3,4};
        // int W=7;
        // int dp[][] = new int [val.length+1][W+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(knapsack(val, wt, W, val.length));
        // System.out.println(knapsack2(val, wt, dp,W,val.length));
        // print(dp);
        // System.out.println(knapsack3(val, wt, W));
        // int length[]={1,2,3,4,5,6,7,8};
        // int price[]={1,5,8,9,10,17,17,20};
        // int totRod=8;
        // System.out.println(rodCutting(length, price, totRod));ko
        // System.out.println(unboundedKnapsack(val, wt, W));

        // //TARGETSUM- TABULATION
        // int arr[] = {4,2,7,1,3};
        // int sum = 10;
        // System.out.println(targetsum(arr, sum));
        // String str1="abcdge";
        // String str2="abedg";
        // int n=str1.length();
        // int m=str2.length();
        // System.out.println(lcSubsequence(str1, str2, str1.length(), str2.length()));

        //initialization
        // int dp[][]=new int[n+1][m+1];
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(lcsMemoization(str1, str2, n, m, dp));
        // System.out.println(lcsTabulation(str1, str2));
        // String str1="ABCDE";
        // String str2="ABGCE";  //2 "AB"
        // // System.out.println(longestCommonSubstring(str1, str2));
        // int arr1[]={50,3,10,7,40,80};
        // System.out.println(longestIncreasingSubsequence(arr1));
        // String word1="intention";
        // String word2="execution";
        // System.out.println(editDistance(word1, word2));
        int n=4 ;
        // System.out.println(catalanRec(n));
        // int dp[]=new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(catalanMem(n, dp));
        System.out.println(catalanTab(n));
    }
}
