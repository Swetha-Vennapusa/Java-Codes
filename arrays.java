import java.util.*;
public class arrays {
    public static void basicArray(){
        int []marks=new int[3];
        marks[0]=97;  //phy
        marks[1]=98;  //chem
        marks[2]=95;  //eng
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
    }
    public static void search_number(int n){
        int  numbers[]= new int[n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==x){
                System.out.println("x found at index: "+i);
            }
        }
        sc.close();
    }
    
    public static void names_array(int n){
        String  names[]= new String[n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            names[i]=sc.next();
        }
        for(int i=0;i<names.length;i++){
                System.out.println("names: "+(i+1)+" is: "+names[i]);
        }
        //sc.close();
    }
    public static void min_max(int n){
        int[] nums=new int[n];
        Scanner sc=new Scanner(System.in);
        //int[] nums=new int[n];
        for(int i=1;i<=n;i++){
            nums[i]=sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        sc.close();
    }
    public static int LinearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void WordSearch(String arr[],String key){
        for(int i=0;i>arr.length;i++){
            if(arr[i].equals(key)){
                System.out.println(i);
            }
            else{
                System.out.println("Not Found");
            }
        }
    }
    public static int getLargest(int numbers[]){
        int largest=Integer.MIN_VALUE;   //-infinity
        int smallest=Integer.MAX_VALUE;   //+infinity
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>largest){
                largest=numbers[i];
            }
            if(numbers[i]<smallest){
                smallest=numbers[i];
            }
        }
        System.out.println("smallest value is :"+smallest);
        return largest; 
    }
    public static int binarySearch(int numbers[],int key){
        int start=0,end=numbers.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(numbers[mid]==key){
                return mid;
            }
            if(numbers[mid]<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void reverse(int nums[]){
        int first=0,last=nums.length-1;
        while(first<last){
            //SWAP
            int temp=nums[first];
            nums[first]=nums[last];
            nums[last]=temp;
            first++;
            last--;
        }
    }
    public static void printPair(int nums[]){
        int tp=0;
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            for(int j=i+1;j<nums.length;j++){
                System.out.print("("+current+","+nums[j]+") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs = "+tp);
    }
    public static void subArrays(int numbers[]){
        int ts=0;
        for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(numbers[k]+" ");  
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total subarrays = "+ts);
    }
    public static void maxSubArrays(int numbers[]){
        int ts=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                int currSum=0;
                for(int k=start;k<=end;k++){
                    //System.out.print(numbers[k]+" ");
                    //SUBARRAY
                    currSum+=numbers[k];
                }
                System.out.println(currSum);
                if(max<currSum){
                    max=currSum;
                }
                if(min>currSum){
                    min=currSum;
                }
            }
        }
        System.out.println("max Sum is : "+max);
        System.out.println("min Sum is : "+min);
    }
    public static void prefixSubArray(int numbers[]){
        int currSum=0;
        int max=Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];
        prefix[0]=numbers[0];
        for(int i=1;i<numbers.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }

        for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                currSum=start==0?prefix[end]:prefix[end]-prefix[start-1];
                if(max<currSum){
                    max=currSum;
                }
            }
        }
        System.out.println("max sum = "+max);
    }
    public static void kadanes(int numbers[]){
        int ms=Integer.MIN_VALUE;
        int cs=0; 
        
        for(int i=0;i<numbers.length;i++){
            cs=cs+numbers[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(ms,cs);
        }
        System.out.println("our max subarray sum is :"+ms);
    }
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static void main(String args[]){
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        // basicArray();
        //search_number(n);
        //names_array(n);
        //min_max(n);
        int[] numbers={2,4,10,8,10};
        //int key=sc.nextInt();
        /*int index=LinearSearch(numbers,key);
        if(index==-1){
            System.out.println("Not Found");
        }
        else{
            System.out.println(key+" is at index "+index);
        }*/
        /*String[] list={"Apple","Banana","Cat","dog","eagle"};
        String key=sc.next();
        WordSearch(list,key);*/
        //int numbers[]={1,2,6,3,5};
        //System.out.println("largest value is :"+getLargest(numbers));
        //System.out.println("Index for key is : "+binarySearch(arr, key));
        /*reverse(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();*/
        //printPair(numbers);
        //subArrays(numbers);
        //maxSubArrays(numbers);
        /*int arr[]={1,-2,6,-1,3};
        prefixSubArray(arr);*/
        /*int nums[]={-2,-3,4,-1,-2,1,5,-3};
        kadanes(nums);
        sc.close();*/
    }

}
