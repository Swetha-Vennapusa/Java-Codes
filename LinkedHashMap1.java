import java.util.*;

public class LinkedHashMap1 {
    public static void MajorityElement(int arr[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            /*if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }*/
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        // Set<Integer> keySet=map.keySet();
        for (Integer key : map.keySet()) {
            if(map.get(key)>arr.length/3){
                System.out.println(key);
            }
        }
    }
    public static boolean isAnagram(String s,String t){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        } 
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();
        lhm.put("India",100);
        lhm.put("China",150);
        lhm.put("US",50);
        lhm.put("Nepal",5);

        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("Nepal",5);

        TreeMap<String,Integer> thm=new TreeMap<>();
        thm.put("India",100);
        thm.put("China",150);
        thm.put("US",50);
        thm.put("Nepal",5);
        thm.put("Indonesia",6);

        // System.out.println(lhm);
        // System.out.println(hm);
        // System.out.println(thm);
        /*int arr[]={1,3,2,5,1,3,1,5,1};
        MajorityElement(arr);*/
        String s="tulip";
        String t="lipid";
        System.out.println(isAnagram(s, t));

    }
}
