import java.util.*;
public class arrays2d {
    public static void search_number(int m,int n){
        int  numbers[][]= new int[m][n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                numbers[i][j]=sc.nextInt();
            }
        }
        int x=sc.nextInt();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(numbers[i][j]==x){
                    System.out.println("x found at index: ("+i+", "+j+")");
                }
            }
        }
        sc.close();
    }
    public static void spiral_order_matrix(int m,int n){
        int  nums[][]= new int[m][n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[i][j]=sc.nextInt();
            }
        }
        int rowstart=0;
        int colstart=0;
        int rowEnd=m-1;
        int colEnd=n-1;
        //PRINT SPIRAL ORDER MATRIX
        while(rowstart<=rowEnd && colstart<=colEnd){
            //1
            for(int col=colstart;col<=colEnd;col++){
                System.out.print(nums[rowstart][col]+" ");
            }
            rowstart++;
            //2
            for(int row=rowstart;row<=rowEnd;row++){
                System.out.println(nums[row][colEnd]+" ");
            }
            colEnd--;
            //3
            for(int col=colEnd;col>=colstart;col--){
                System.out.print(nums[rowEnd][col]+" ");
            }
            rowEnd--;
            //4
            for(int row=rowEnd;row>=rowstart;row--){
                System.out.print(nums[row][colstart]+" ");
            }
            colstart++;
            System.out.println();
        }
    }
    public static void transpose_matrix(int m,int n){
        int  nums[][]= new int[m][n];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[i][j]=sc.nextInt();
            }
        }
        //TRANSPOSE MATRIX
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(nums[j][i]);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        //search_number(rows,cols);
        //spiral_order_matrix(rows,cols);
        //spiral_order_matrix(rows,cols);
        transpose_matrix(rows,cols);
        sc.close();
    }
}
