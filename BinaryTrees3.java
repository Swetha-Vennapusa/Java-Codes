import java.util.*;
public class BinaryTrees3 {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    //Kth Level of a Tree
    public static void KLevel(Node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    //Lowest common Ancestor
    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean foundLeft=getPath(root.left, n, path);
        boolean foundRight=getPath(root.right, n, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);

        //Last common Ancesor
        int i=0;
        for(;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        //last equal node ->(i-1)th 
        Node lca=path1.get(i-1);
        return lca;
    }
    public static Node lca2(Node root,int n1,int n2){
        if(root==null|| root.data==n1 || root.data==n2){
            return root;
        }
        Node leftLca=lca2(root.left,n1,n2);
        Node rightLca=lca2(root.right,n1,n2);
        //leftLca=val rightLca=null
        if(leftLca==null){
            return rightLca;
        }
        if(rightLca==null){
            return leftLca;
        }
        return root;
    }
    public static int lcaDist(Node root,int n){
        if(root==null){
            return -1;
        }
        else if(root.data==n){
            return 0;
        }
        int leftDist=lcaDist(root.left,n);
        int rightDist=lcaDist(root.right,n);
        if(leftDist==-1 && rightDist==-1){
            return -1;
        }else if(leftDist==-1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }
    public static int minDist(Node root,int n1,int n2){
        Node lca=lca2(root,n1,n2);
        int dist1=lcaDist(lca,n1);
        int dist2=lcaDist(lca,n2);
        return dist1+dist2;
    }
    public static int KAncestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist=KAncestor(root.left,n,k);
        int rightDist=KAncestor(root.right,n,k);
        if(leftDist==-1 && rightDist==-1){
            return -1;
        }
        int max=Math.max(leftDist,rightDist);
        if(max+1==k){
            System.out.println(root.data);;
        }
        return max+1;
    }  
    public static int transform(Node root){
        if(root==null){
            return 0;
        }
        int leftChild=transform(root.left);
        int rightChild=transform(root.right);
        int data=root.data;

        int newLeft=root.left==null?0:root.left.data;
        int newRight=root.right==null?0:root.right.data;

        root.data=newLeft+leftChild+newRight+rightChild;
        return data;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        /*  
                     1
                    /  \
                    2   3
                   / \ / \
                  4   5 6  7
            */
        
        
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        // int k=2;
        // KLevel(root, 1, k);
        int n1=4,n2=7  ;
        // System.out.println(lca(root, n1, n2).data);
        // System.out.println(lca2(root, n1, n2).data);
        // System.out.println(minDist(root, n1, n2));
        int n=5,k=2;
        // KAncestor(root, n, k);
        // System.out.println(KAncestor(root, n, k));
        /* 
         EXCEPTED TREE
                     27
                    /  \
                    9   13
                   / \  / \
                  0   00   0
         */
        transform(root);
        preorder(root);
    }
}
