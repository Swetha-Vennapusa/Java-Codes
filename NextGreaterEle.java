import java.util.Stack;

public class NextGreaterEle {
    public static boolean validParenthesis(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //OPENING
            if(ch=='(' || ch=='[' || ch=='{'){
                s.push(ch);
            }else{
                //CLOSING
                if(s.isEmpty()){
                    return false;
                }
                if( (s.peek()=='(' && ch==')') //()
                    || (s.peek()=='{' && ch=='}') //{}
                    || (s.peek()=='[' && ch==']')) { //[]
                        s.pop() ;
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuplicate(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //CLOSING
            if(ch==')'){
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true; //duplicates
                }else{
                    s.pop();  //opening pair
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void maxArea(int[] arr){
        int maxArea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];
    //NEXT SMALLER RIGHT
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
            s.pop();
            }
            if(s.isEmpty())
            {
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
    //NEXT SMALLER LEFT
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
            s.pop();
            }
            if(s.isEmpty())
            {
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
    //CURRENT AREA: width=j-i-1=nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxArea=Math.max(maxArea,currArea);
        }
        System.out.println("MaxArea in histogram ="+maxArea);
    }
    public static void main(String[] args) {
        /*int arr[]={6,8,0,1,3};
        Stack<Integer> s=new Stack<>();
        int[] nextGreater=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            //1. WHILE
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }

            //2. IF-ELSE
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }

            //3. PUSH ELEMENT
            s.push(i);
        }
        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();*/

        //next Greate Right
        //next Greater Left
        //next Smaller Right
        //next Smaller Left
        // String str="({})[]";
        // System.out.println(validParenthesis(str));
        String str="((a+b))";
        String str2="(a-b)";
        // System.out.println(isDuplicate(str));
        // System.out.println(isDuplicate(str2));
        int arr[]={2,1,5,6,2,3};
        maxArea(arr);
    }
}
 