import java.util.*;
public class Iterator1 {
    public static void countDistinctNumbers(int arr[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        System.out.println("ans = "+set.size());
    }
    public static void union(int arr1[],int arr2[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println(set);
        System.out.println("union = "+set.size());
    }
    public static void intersection(int arr1[],int arr2[]){
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int count=0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                set1.add(arr2[i]);
            }
        }
        System.out.println(set1 );
        System.out.println("intersection = "+count);
    }
    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap=new HashMap<>();
        for(String key:tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }
        for(String key:tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void largestsubarray(int arr[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int len=0;
        for(int j=0;j<arr.length;j++){
            sum+=   arr[j];
            if(map.containsKey(sum)){
                len=Math.max(len,j-map.get(sum));
            }else{
                map.put(sum,j);
            }
        }
        System.out.println("Largest SubArray with sum as 0 =>"+len);
    }
    public static void subarraysumk(int arr1[],int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int ans=0;
        for(int j=0;j<arr1.length;j++){
            sum+=arr1[j];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        System.out.println("Largest SubArray with sum as k =>"+ans);
    }
    public static void main(String[] args) {
        HashSet<String> cities=new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Nodia");
        cities.add("Bengaluru");
        // System.out.println(cities);

      /* Iterator it=cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

        /*for (String city : cities) {
            System.out.println(city);
        }*/
        LinkedHashSet<String> lhs=new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Nodia");
        lhs.add("Bengaluru");
        System.out.println(lhs);
        lhs.remove("Delhi");
        // System.out.println(lhs);

       TreeSet<String> ts=new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Nodia");
        ts.add("Bengaluru");
        // System.out.println(ts);
        // int arr[]={4,3,2,5,6,7,3,4,2,1};
        // countDistinctNumbers(arr);
        // int arr1[]={7,3,9};
        // int arr2[]={6,3,9,2,9,4};
        // union(arr1, arr2);
        // intersection(arr1, arr2);

        // HashMap<String,String> tickets=new HashMap<>();
        // tickets.put("Chennai","Bengaluru");
        // tickets.put("Mumbai","Delhi");
        // tickets.put("Goa","Chennai");
        // tickets.put("Delhi","Goa");

        // String start=getStart(tickets);
        // System.out.print(start);
        // for (String key : tickets.keySet()) {
        //     System.out.print(" -> "+tickets.get(start));
        //     start=tickets.get(start);
        // }
        // System.out.println();

        // int arr[]={15,-2,2,-8,1,7,10,23};
        // largestsubarray(arr);

        int arr1[]={10,2,-2,-20,10};
        int k=-10;
    subarraysumk(arr1, k);
    }
} 
