class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        int cnt=0;int prev=0;
        for(int x[]:stations){
            int location=x[0];
            int capacity=x[1];
            tank-=(location-prev);
            while(!pq.isEmpty()&&tank<0){
                tank+=pq.poll();
                cnt++;
            }
            
            if(tank<0) return -1;
            pq.add(capacity);
            prev=location;
        }
        
        tank-=(target-prev);
        while(!pq.isEmpty()&&tank<0){
            tank+=pq.poll();
            cnt++;
        }
        
        if(tank<0) return -1;
        return cnt;
    }
}