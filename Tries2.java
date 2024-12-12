import java.util.*;
public class Tries2 {
    static class Node{
        Node children[]=new Node[26];
        boolean  eow=false;
        int freq; 
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true; 
    }
    public static boolean search(String key){
        int level=0;
        int len=key.length();
        int idx=0;
        Node curr=root;
        for(;level<len;level++){
            idx=key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    public static boolean startsWith(String prefix){  //O(L)
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void findPrefix(Node root,String ans){
        if(root==null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        } 
    }
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        // String arr[]={"zebra","dog","duck","dove"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);
        // }
        // root.freq=-1;
        // findPrefix(root, "");
        // String words[]={"apple","app","mango","man","woman"};
        // String prefix1="app";
        // String prefix2="moon";
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));
        String str="ababa";
        //suffix -> insert in trie
        for(int i=0;i<str.length();i++){
            String suffix=str.substring(i);
            insert(suffix);
        }
        System.out.println(countNodes(root));
    }
}
