import java.util.*;
public class pattern {
    public static void solidrect(int m,int n){
        //SOLID RECTANGLE
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollowrect(int m,int n){
        //HOLLOW RECTANGLE
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (i==1 || j==1 || i==n || j==m){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void halfpyramid(int n){
        //HALF PYRAMID
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void invertedhalfpyramid(int a){
        //INVERTED HALF PYRAMID
        for (int i=0;i<=a;i++){
            for(int j=1;j<=(a-i);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void invertedhalfpyramidrotate(int n){
        //INVERTED HALF PYRAMID( ROTATE 180 DEG)
        //int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){  //----->space loop
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){    //----->star loop
                System.out.print("*"); 
            }
            System.out.println();
        }
    }
    public static void halfpyramidnumbers(int n){
        //HALF PYRAMID WITH NUMBERS

        //int n=sc.nextInt();
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void invertedhalfpyramidnumbers(int n){
        //INVERTED HALF PYRAMID WITH NUMBERS

        //int n=sc.nextInt();
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void floydtriangle(int n){
        //FLOYD'S TRIANGLE

        //int n=sc.nextInt();
        int num=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num);
                num++;
            }
            System.out.println();
        }
    }
    public static void triangle_0_1(int n){
        //0-1 TRIANGLE

        //int n=sc.nextInt();
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void butterfly(int n){
        //BUTTERFLY PATTERN

        //int n=sc.nextInt();
        //upper half

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();  
        }
        //lower half
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();  
        }
    }
    public static void solidrhombus(int n){
        //SOLID RHOMBUS

        //int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollowrhombus(int n){
        //HOLLOW RHOMBUS

        //int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 ||j==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void numberpyramid(int n){
        //NUMBER PYRAMID

        //int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void palindrome(int n){
        //PALINDROME PATTERN

        //int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void diamond(int n){
        //DIAMOND PATTERN

        //int n=sc.nextInt();
        //upper half
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //lower half
        for(int i=n;i>=1;i--){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void character(int n){
        //CHARACTER PATTERN

        //int n=sc.nextInt();
        char ch='A';
        for(int line=1;line<=n;line++){
            for(int chars=1;chars<=line;chars++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
    public static void hollowdiagonal(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if (i==1 || j==1 || i==n || j==n||i==j||i+j==(n+1)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // int a=sc.nextInt();
        int b=sc.nextInt();
        //solidrect(a,b);
        //hollowrect(a,b);
        //halfpyramid(b);
        //invertedhalfpyramid(b);
        // invertedhalfpyramidrotate(b);
        //halfpyramidnumbers(b);
        //invertedhalfpyramidnumbers(b);
        //floydtriangle(b);
        //triangle_0_1(b);
        //butterfly(b);
        //solidrhombus(b);
        //hollowrhombus(b);
        //numberpyramid(b);
        //palindrome(b);
        //diamond(b);
        //character(b);
        hollowdiagonal(b);

    }
}
