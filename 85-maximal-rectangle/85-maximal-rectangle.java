class Solution {
    public int maximalRectangle(char[][] mat) {
        if(mat.length==0) return 0;
        int r=mat.length;int c=mat[0].length;
		
		int val[][]=new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(j==0) {
					if(mat[i][j]=='1') {
						val[i][j]=1;
					}
				}else {
					if(mat[i][j]=='1') {
						val[i][j]=val[i][j-1]+1;
					}
				}
			}
		}
		
		int maxArea=0;
		for(int j=0;j<c;j++) {
			int arr[]=new int[r];
			for(int i=0;i<r;i++) {
				arr[i]=val[i][j];
			}
            maxArea=Math.max(maxArea, largestRectangleArea(arr));
		}
        
        return maxArea;
    }
    
    
	 public int largestRectangleArea(int[] arr) {
	        int n=arr.length;
	        int maxArea=0;
	        Stack<Integer> stack=new Stack<>();
	        stack.push(-1);
	        for(int i=0;i<n;i++){
	            while(stack.peek()!=-1&&arr[stack.peek()]>=arr[i]){
	                int currHeight=arr[stack.pop()];
	                int currWidth=i-stack.peek()-1;
	                maxArea=Math.max(maxArea,currWidth*currHeight);
	            }
	            stack.push(i);
	        }
	        
	        while(stack.peek()!=-1){
	            int currHeight=arr[stack.pop()];
	            int currWidth=n-stack.peek()-1;
	            maxArea=Math.max(maxArea,currWidth*currHeight);
	        }
	        
	        return maxArea;
	    }
}