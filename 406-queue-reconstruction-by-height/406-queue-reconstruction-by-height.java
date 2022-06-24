class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n=people.length;
        Arrays.sort(people,(a,b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));
        
        List<int[]> res=new ArrayList<>();
        for(int x[]:people){
            int h=x[0];int p=x[1];
            res.add(p,x);
        }
        
        return res.toArray(new int[n][2]);
    }
}