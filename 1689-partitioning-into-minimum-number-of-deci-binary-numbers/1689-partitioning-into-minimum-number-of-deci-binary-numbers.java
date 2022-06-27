class Solution {
    public int minPartitions(String n) {
        char c[]=n.toCharArray();
        int max=-1;
        for(int i=0;i<c.length;i++){
            max=Math.max(max,c[i]-'0');
        }
        return max;
    }
}