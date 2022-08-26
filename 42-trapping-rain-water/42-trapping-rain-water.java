class Solution {
    public int trap(int[] arr) {
        
        int n=arr.length;
        
        //O(N)~O(N)
        int lmax=Integer.MIN_VALUE;
        int rmax[]=new int[n];
        
        
        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(rmax[i+1],arr[i+1]);
        }
        
        // for(int x:lmax) System.out.print(x+" ");
        // System.out.println();
        // for(int x:rmax) System.out.print(x+" ");
        
        int totalWater=0;
        
        //O(3*N)~O(N)
        for(int i=1;i<n;i++){
            lmax=Math.max(lmax,arr[i-1]);
            int min=Math.min(lmax,rmax[i]);
            if(min<arr[i]) continue;
            totalWater+=(min-arr[i]);
        }
        
        return totalWater;
        
    }
}


//      0 1 0 2 1 0 1 3 2 1 2 1
// lmax 0 0 1 1 2 2 2 2 3 3 3 3
// rmax 3 3 3 3 3 3 3 2 2 2 1 0 
         
