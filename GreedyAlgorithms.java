import java.util.*;
public class GreedyAlgorithms {
    public static void activityselect(int[] start,int[] end) {
        //sorting
          int activities[][]=new int[start.length][3];
          for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
          }

          //lambda function ->shortform
          Arrays.sort(activities,Comparator.comparingDouble(o->o[2]) );
        //end time basis sorted
        int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();

        //last activity
        maxAct=1;    
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastEnd){
                //activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.println("maxAct is:"+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
    public static void fractionalKnapsack(int[] val,int[] weight,int W){
        double ratio[][]=new double[val.length][2];
        //0t col =>idx,1st col => ratio
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        //ascending order
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int capacity=W;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                finalVal+=val[idx];
                capacity-=weight[idx];
            }else{
                finalVal+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("final value= "+finalVal);
    }
    public static void minAbsDiffPairs(int[] A,int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int MinDiff=0;
        for(int i=0;i<A.length;i++){
            MinDiff+=Math.abs(A[i]-B[i]);
        }
        System.out.println("Min Absolute Difference Pairs = "+MinDiff);
    }
    public static void MaxLengthChainPairs(int[][] pairs){
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int chainLength=1;
        int chainEnd=pairs[0][1];
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>chainEnd){
                chainLength++;
                   chainEnd=pairs[i][1];
            }
        }
        System.out.println("Max Length of Chain = "+chainLength);
    }
    public static void IndianCoins(Integer[] coins,int amount){
        Arrays.sort(coins,Comparator.reverseOrder());
        
         int countOfCoins=0;
         ArrayList<Integer> ans=new ArrayList<>();
         for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount-=coins[i];
                } 
            }
         }
         System.out.println("Total (min) coins used = "+countOfCoins);
         for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
         }
         System.out.println();
    } 
    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static void JobSequencing(int[][] jobsInfo){
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit); 
        //descending order of profit

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);  
                time++;
            }
        }
        //print seq
        System.out.println("max jobs = "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    } 
    public static void Chocola(Integer costVer[],Integer costHor[],int n,int m){
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;
        int cost=0;
        while(h < costHor.length && v < costVer.length){
            if(costVer[v]<=costHor[h]){  //horizontal cut
                cost+=(costHor[h]*vp);
                hp++;
                h++;
            }else{ //vertical cut
                cost+=(costVer[v]*hp);
                vp++;
                v++;
            }
        }
        while(h < costHor.length){
            cost+=(costHor[h]*vp);
                hp++;
                h++;
        }
        while(v<costVer.length){
            cost+=(costVer[v]*hp);
                vp++;
                v++;
        }
        System.out.println("The (min)cost of Chocola = "+cost);
    }
    public static void main(String[] args) {
        /*int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        activityselect(start,end);*/
        /*int val[]={60,100,120};
        int weight[]={10,20,30};
        int W=50;
        fractionalKnapsack(val, weight, W);*/
        /*int[] A={4,1,8,7};
        int[] B={2,3,6,5};
        minAbsDiffPairs(A, B);*/
        /*int[][] pairs={{5,24},{39,60},{5,28},{27,40},{50,90}};
        MaxLengthChainPairs(pairs);*/
        /*Integer coins[]={1,2,5,10,20,50,100,500,2000};
        int amount=590;
        IndianCoins(coins,amount);*/
        /*int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        JobSequencing(jobsInfo);*/
        int n=4,m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        Chocola(costVer, costHor,n,m);

    }
}
