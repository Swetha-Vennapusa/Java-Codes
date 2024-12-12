import java.util.*;
public class arraypractice {
    public static boolean repeat(int arr[]){
        for(int i=0;i<arr.length;i++){
            int m=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(m==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void secondmaxminDiff(int arr[]){
        int max1=arr[0];
        int max2=arr[0];
        int min1=arr[0];
        int min2=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max1){
                max2=max1;
                max1=arr[i];
            }
            else if(arr[i]>max2 && arr[i]!=max1){
                max2=arr[i];
            }
            if(arr[i]<min1){
                min2=min1;
                min1=arr[i];
            }
            else if(arr[i]<min2 && arr[i]!=min1){
                min2=arr[i];
            }
        }
        System.out.println(max2);
        System.out.println(min2);
        int diff=max2-min2;
        System.out.println(diff);
        for(int i=2;i<diff;i++){
            if(diff%i!=0){
                System.out.println("Win");
                return;
            }else{
                System.out.println("Lost");
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int arr[]={1,2,3,4};
        /*int arr[]=new int[n];
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int m=sc.nextInt();
            arr[i]+=[m];
        }*/
        // System.out.println(repeat(arr));
        int arr[]={11,25,50,30,35,10,20,10,40,28};
        secondmaxminDiff(arr);
    }
}
