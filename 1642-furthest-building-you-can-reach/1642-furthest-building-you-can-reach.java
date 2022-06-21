class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        int n=arr.length;
        PriorityQueue<Integer> l=new PriorityQueue<>();//ladder minheap
        PriorityQueue<Integer> b=new 
            PriorityQueue<>(Collections.reverseOrder());//bricks maxheap
        
        int maxDistance=0;
        for(int i=1;i<n;i++){
            if(arr[i]<=arr[i-1]){
                maxDistance=Math.max(maxDistance,i);
                continue;
            }
            
            int diff=arr[i]-arr[i-1];
            //check if I have ladder available
            if(ladders>0){
                l.add(diff);
                ladders--;
                maxDistance=Math.max(maxDistance,i);
            }else{
                //if I can replace a ladder with bricks
                if(!l.isEmpty()&&diff>l.peek()){
                    if(bricks>=l.peek()){
                        b.add(l.peek());
                        bricks-=l.poll();
                        l.add(diff);
                        maxDistance=Math.max(maxDistance,i);
                    }else return maxDistance;
                }else if(bricks>=diff){
                    bricks-=diff;
                    b.add(diff);
                    maxDistance=Math.max(maxDistance,i);
                }else{
                    return maxDistance;
                }
            }
        }
        
        return maxDistance;
        
    }
}