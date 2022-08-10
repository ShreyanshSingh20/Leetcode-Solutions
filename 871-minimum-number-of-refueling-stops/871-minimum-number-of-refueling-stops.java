class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        int cnt=0;int prev=0;
        for(int x[]:stations){
            int location=x[0];
            int capacity=x[1];
            //subtract the fuel from tank which we have used up from moving from i-1 to i;
            tank-=(location-prev);
            
            //if the tank becomes negative then we should have refilled the tank before
            while(!pq.isEmpty()&&tank<0){
                tank+=pq.poll();
                cnt++;
            }
            
            //if the tank is still empty then we can't do anything
            if(tank<0) return -1;
            
            //add the current offering at the current gas station
            pq.add(capacity);
            
            //set the prev to the current location
            prev=location;
        }
        
        
        //check again for target
        tank-=(target-prev);
        while(!pq.isEmpty()&&tank<0){
            tank+=pq.poll();
            cnt++;
        }
        
        if(tank<0) return -1;
        return cnt;
    }
}