class Solution {
    public int maxPoints(int[][] points) {
        
        int n=points.length;
        if(n==1) return 1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            HashMap<String,HashSet<Integer>> map=new HashMap<>();
            Point a=new Point(points[i][0],points[i][1]);
            for(int j=i+1;j<n;j++){
                Point b=new Point(points[j][0],points[j][1]);
                String slope=slope(a,b);
                // System.out.println(slope+" "+i+" "+j);
                map.putIfAbsent(slope,new HashSet<Integer>());
                map.get(slope).add(i);
                map.get(slope).add(j);
            }
            for(Map.Entry<String,HashSet<Integer>> entry:map.entrySet()){
                int size=entry.getValue().size();
                // System.out.println(entry.getKey()+" "+size);
                max=Math.max(max,size);
            }
        }
        
        
    
        
        return max;
    }
    
    public String slope(Point a,Point b){
        if(a.x==b.x) return Double.MAX_VALUE+"";
        if(a.y==b.y) return (double)0+"";
        double val = (double)((double)(b.y-a.y)/(double)(b.x-a.x));
        String str=String.format("%.5f",val);
        return str;
    }
}

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}