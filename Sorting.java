import java.util.*;
public class Sorting {
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void bubbleSort(int arr[]){
        //int arr[]={7,8,3,1,2};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        printArray(arr);
    }
    public static void selection_sort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int smallest=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest]>arr[j]){
                    smallest=j;
                }
            }
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
        }
        printArray(arr);
    }
    public static void conquer(int arr[],int si,int mid,int ei){
        int merge[]=new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;
        int x=0;

        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2]){
                merge[x++]=arr[idx1++];
            }
            else{
                merge[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid){
            merge[x++]=arr[idx1++];
        }
        while(idx2<=ei){
            merge[x++]=arr[idx2++];
        }
        for(int i=0,j=si;i<merge.length;i++,j++){
            arr[j]=merge[i];
        }
    }
    public static void divide(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        divide(arr,si,mid);
        divide(arr, mid+1, ei);
        conquer(arr,si,mid,ei);
    }
    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        int n=arr.length;
        //bubbleSort(arr);
        //selection_sort(arr);
        divide(arr, 0, n-1);
        //print
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }  
}
