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
            int largest=pq.poll();
            int sumOfRest=currSum-largest;
            if(sumOfRest==1) return true;
            int x=largest%(sumOfRest);
            if(x==0||x==largest) return false;
            pq.add(x);
            currSum=currSum-largest+x;
        }
        
        return true;
    }
}