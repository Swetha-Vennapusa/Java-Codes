import java.util.*;
public class BinaryTrees2 {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(rh,lh)+1;
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftCount=count(root.left);
        int rightCount=count(root.right);
        return rightCount+leftCount+1;
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sum(root.left);
        int rightSum=sum(root.right);
        return rightSum+leftSum+root.data;
    }
    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int leftDiam=diameter(root.left);
        int leftHt=height(root.left);
        int rightDiam=diameter(root.right);
        int rightHt=height(root.right);
        int selfDiam=leftHt+rightHt+1;
        return Math.max(selfDiam,Math.max(leftDiam,rightDiam));
    }
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter2(Node root){ 
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo=diameter2(root.left);
        Info rightInfo=diameter2(root.right);
        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),rightInfo.ht+leftInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);
    }
    public static boolean isIdentical(Node node,Node subRoot){
        if(node==null && subRoot==null){
            return true;
        }
        else if(node==null || subRoot==null || node.data!=subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot); 
    }
    static class Infor{
        Node node;
        int hd;
        public Infor(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topview(Node root){
        //LEVEL ORDER 
        Queue<Infor> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0,max=0;
        q.add(new Infor(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Infor currt=q.remove();
            if(currt==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(currt.hd)){  //first time my hd is occurring
                    map.put(currt.hd,currt.node);
                }
                if(currt.node.left!=null){
                    q.add(new Infor(currt.node.left,currt.hd-1));
                    min=Math.min(min,currt.hd-1);
                }
                if(currt.node.right!=null){
                    q.add(new Infor(currt.node.right,currt.hd+1));
                    max=Math.max(min,currt.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        /*  
                    1
                   /  \
                   2   3
                  / \ /  \
                 4   5 6  7
         */
        
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        /*   
                2
               / \
               4  5
         */
        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));
        // System.out.println(diameter(root));
        // System.out.println(diameter2(root).diam);
        // System.out.println(diameter2(root).ht);
        // System.out.println(isSubtree(root, subroot));
        topview(root);
    }
}
 