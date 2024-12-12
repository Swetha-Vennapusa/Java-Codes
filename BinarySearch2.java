import java.util.*;
public class BinarySearch2 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node createBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr,st,mid-1);
        root.right=createBST(arr,mid+1,end);
        return root;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print (root.data+" "); 
        preorder(root.left);
        preorder(root.right); 
    }
    public static void getInorder(Node root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node createSortBST(ArrayList<Integer> inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left=createSortBST(inorder,st,mid-1);
        root.right=createSortBST(inorder,mid+1,end);
        return root;
    }
    public static Node balanceBST(Node root){
        //inorder seq
        ArrayList<Integer> inorder=new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balanced BST
        root=createSortBST(inorder, 0, inorder.size()-1);
        return root;
    }

    // SIZE OF LARGEST BST IN BT
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true, 0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        if(root.data<=leftInfo.max ||root.data>=rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    // MERGE 2BSTs
    
    public static Node mergeBSTs(Node root1,Node root2){
        //step1
        ArrayList<Integer> inorder1=new ArrayList<>();
        getInorder(root1, inorder1);

        //step2
        ArrayList<Integer> inorder2=new ArrayList<>();
        getInorder(root2, inorder2);

        //merge
        int i=0,j=0;
        ArrayList<Integer> finalArr=new ArrayList<>();
        while(i<inorder1.size() && j<inorder2.size()){
            if(inorder1.get(i)<=inorder2.get(j)){
                finalArr.add(inorder1.get(i));
                i++;
            }else{
                finalArr.add(inorder2.get(j));
                j++;
            }
        }
        while(i<inorder1.size()){
            finalArr.add(inorder1.get(i));
                i++;
        }
        while(j<inorder2.size()){
            finalArr.add(inorder2.get(j));
            j++;
        }
        //sorted AL -> balanced BST
        return    createSortBST(finalArr, 0, finalArr.size()-1);
    }
    public static void main(String[] args) {
    //    int arr[]={3,5,6,8,10,11,12};
        /*
                      8
                     / \
                    5   11
                   / \  / \
                  3  6 10  12
         */
        // Node root=createBST(arr, 0, arr.length-1);
        // preorder(root);
        /*
                        8
                       / \
                      6  10
                     /     \
                    5      11
                   /        \
                  3         12
                given BST
         
         */
        /*Node root=new Node(8);
        root.left=new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);

        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);
        root=balanceBST(root);
        preorder(root);*/
        /*
                        50
                      /    \
                     30    60
                    /  \  /  \
                   5  20 45  70
                            /  \
                           65   80

        */
        /*Node root=new Node(50);
        root.left=new Node(30);
        root.left.left=new Node(5);
        root.left.right=new Node(20);

        root.right=new Node(60);
        root.right.left=new Node(45);
        root.right.right=new Node(70);
        root.right.right.left=new Node(65);
        root.right.right.right=new Node(80);
        Info info=largestBST(root);
        System.out.println("Largest BST size = "+maxBST);*/
        /*       2        
                / \
               1  4
         */
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        /*
                    9
                   / \
                  3  12
         */
        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);
        //O(n+m) -> linear
        Node root=mergeBSTs(root1, root2);
        preorder(root);
    } 
}
