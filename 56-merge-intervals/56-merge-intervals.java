class Solution {
    public int[][] merge(int[][] arr) {
        
        Arrays.sort(arr,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        
        List<int[]> list=new ArrayList<>();
        int currStart=arr[0][0];int currEnd=arr[0][1];
        
        int pt=0;
        
        while(pt<arr.length){
            while(pt+1<arr.length&&arr[pt+1][0]<=currEnd){
                currEnd=Math.max(currEnd,arr[pt+1][1]);
                pt++;
            }
            pt++;
            list.add(new int[]{currStart,currEnd});
            if(pt<arr.length){
                currStart=arr[pt][0];
                currEnd=arr[pt][1];
            }
        }
        
        int size=list.size();
        int res[][]=new int[size][2];
        for(int i=0;i<size;i++){
            res[i][0]=list.get(i)[0];
            res[i][1]=list.get(i)[1];
        }
        
        return res;
    }
}