import java.math.BigDecimal;
class Solution {
    public int minimumLines(int[][] arr) {
        int n=arr.length;
        if(n==1) return 0;
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        int res=n-1;
       for (int i = 1; i < n-1; i++) {
           int x1=arr[i-1][0];int y1=arr[i-1][1];
           int x2=arr[i][0];int y2=arr[i][1];
           int x3=arr[i+1][0];int y3=arr[i+1][1];
           if(1L*(y2-y1)*(x3-x2)==1L*(y3-y2)*(x2-x1)) res--;
		}
        return res;
    }
}