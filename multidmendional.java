import java.util.ArrayList;
import java.util.*;
public class multidmendional {
    public static void multiArray(ArrayList<ArrayList<Integer>> compList){
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();

        for(int i=1;i<=5;i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        compList.add(list1);
        compList.add(list2);
        compList.add(list3);
        System.out.println(compList);

        //nested Loops
        for(int i=0;i<compList.size();i++){
            ArrayList<Integer> currLists=compList.get(i);
            for(int j=0;j<currLists.size();j++){
                System.out.print(currLists.get(j)+" ");
            }
            System.out.println();
        }

    }
    //TC --O(n^2)
    public static int storeWater(ArrayList<Integer> height){
        int maxWater=0;
        //Brute force
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currWater=ht*width;
                maxWater=Math.max(maxWater,currWater);

            }
        }
        return maxWater;
    }

    // 2 Pointer Approach -- O(n)

    public static int storewater(ArrayList<Integer> height){
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;
        while(lp<rp){
            //calculate water area
            int ht=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int currWater=ht*width;
            maxWater=Math.max(maxWater,currWater);
            //Update ptr
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }
    //TC --O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list,int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }
    //2 Pointer Approach  TC --O(n)
    public static boolean pairsum1(ArrayList<Integer> list,int target){
        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp){
            //case1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case2
            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }
            else{
                //cas3
                rp--;
            }
        }
        return false;
    }

    //TC --O(n)
    public static boolean pairSum2(ArrayList<Integer>list,int target){
        int bp=-1;
        int n=list.size();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1;//smallest
        int rp=bp;//largest
        while(lp!=rp){
            //case1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case 2
            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            }else{
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);list1.add(2);
        mainList.add(list1);

        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(3);list2.add(4);
        mainList.add(list2);
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList=mainList.get(i);
            for(int j=0;j<currList.size();j++){
                //System.out.print(currList.get(j)+" ");
            }
            //System.out.println();
        }
        //System.out.println(mainList);
       ArrayList<ArrayList<Integer>> compList=new ArrayList<>();
        //multiArray(compList);
        ArrayList<Integer> height=new ArrayList<>();
        //1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeWater(height));
        // System.out.println(storewater(height));
       /* ArrayList<Integer> list=new ArrayList<>();
        //1,2,3,4,5
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);*/
        //System.out.println(pairSum1(list, 5));
        //System.out.println(pairsum1(list, 8));
        ArrayList<Integer> list_1=new ArrayList<>();
        //1,2,3,4,5
        list_1.add(11);
        list_1.add(15);
        list_1.add(6);
        list_1.add(8);
        list_1.add(9);
        list_1.add(10);
        System.out.println(pairSum2(list_1,16));
    }
    
}
