class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            while(s.peek()!=-1&&arr[i]<=arr[s.peek()]){
                int height=arr[s.pop()];
                int width=i-s.peek()-1;
                res=Math.max(res,height*width);
            }
            s.push(i);
        }
        while(s.peek()!=-1){
                int height=arr[s.pop()];
                int width=n-s.peek()-1;
                res=Math.max(res,height*width);
        }
        return res;
    }
}