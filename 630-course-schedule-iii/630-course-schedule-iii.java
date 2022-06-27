class Solution {
    public int scheduleCourse(int[][] courses) {
        
        int n=courses.length;
        
        //sort the array in ascending order of last days
        Arrays.sort(courses,(a,b)->(a[1]-b[1]));
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
        
        int time=0;
        for(int i=0;i<n;i++){
            int duration=courses[i][0];
            int lastDay=courses[i][1];
            if(time+duration<=lastDay){
                time+=duration;
                pq.add(new int[]{duration,lastDay});
            }else{
                if(pq.isEmpty()) continue;
                int top[]=pq.peek();
                if(top[0]<duration) continue;
                int diff=top[0]-duration;
                time-=(diff);
                pq.poll();
                pq.add(new int[]{duration,lastDay});
            }
        }
        
        return pq.size();
    }
}