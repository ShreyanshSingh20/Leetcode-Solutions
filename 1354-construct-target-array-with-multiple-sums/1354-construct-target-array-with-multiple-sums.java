class Solution {
    public boolean isPossible(int[] arr) {
        int n=arr.length;
        if(n==1&&arr[0]==1) return true;
        if(n==1&&arr[0]!=1) return false;
        int currSum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:arr){
            currSum+=x;
            pq.add(x);
        }
        
        while(pq.element()>1){
            int sum=pq.poll();
            int sumOfRest=currSum-sum;
            if(sumOfRest==1) return true;
            int x=sum%(sumOfRest);
            if(x==0||x==sum) return false;
            pq.add(x);
            currSum=currSum-sum+x;
        }
        
        return true;
    }
}