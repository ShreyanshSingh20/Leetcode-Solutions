class Solution {
    public int maxResult(int[] arr, int k) {
        
        int n=arr.length;
        int dp[]=new int[n];
        
        SegmentTrees st=new SegmentTrees(n);
        st.pointUpdate(dp,0,0,n-1,0,arr[0]);
        
        for(int i=1;i<n;i++){
            int left=Math.max(0,i-k);
            int right=i-1;
            int max=st.query(0,0,n-1,left,right);
            // System.out.print(max+" ");
            int toAdd=arr[i]+max;
            st.pointUpdate(dp,0,0,n-1,i,toAdd);
        }
        
        // for(int x:dp) System.out.print(x+" ");
        
        return st.query(0,0,n-1,n-1,n-1);
    }
}

class SegmentTrees{
    int seg[];
    public SegmentTrees(int n){
        seg=new int[4*n];
    }
    
    public void pointUpdate(int dp[],int ind,int low,int high,int idx,int val){
        
        if(low==high){
            seg[ind]=val;
            dp[low]=val;
            return;
        }
        
        int mid=(low+high)/2;
        if(idx<=mid){
            pointUpdate(dp,2*ind+1,low,mid,idx,val);
        }else{
            pointUpdate(dp,2*ind+2,mid+1,high,idx,val);
        }
        
        seg[ind]=Math.max(seg[2*ind+1],seg[2*ind+2]);
    }
    
    public int query(int ind,int low,int high,int l,int r){
        
        //out of range
        if(low>r||high<l||low>high) return Integer.MIN_VALUE;
        
        //completely inside
        if(low>=l&&high<=r) return seg[ind];
        
        int mid=(low+high)/2;
        int left=query(2*ind+1,low,mid,l,r);
        int right=query(2*ind+2,mid+1,high,l,r);
        return Math.max(left,right);
    }
}