class NumArray {
    
    SegmentTree st;
    int n;
    int arr[];
    public NumArray(int[] nums) {
        this.n=nums.length;
        this.arr=nums;
        this.st=new SegmentTree(n,nums);
    }
    
    public void update(int index, int val) {
        int toAdd=val-arr[index];
        arr[index]=val;
        this.st.update(0,0,n-1,index,toAdd);
    }
    
    public int sumRange(int left, int right) {
        return this.st.query(0,0,n-1,left,right);
    }
}

class SegmentTree{
    int seg[];
    
    public SegmentTree(int n,int arr[]){
        seg=new int[4*n];
        build(arr,0,0,n-1);
    }
    
    public void build(int arr[],int ind,int low,int high){
        if(low==high){
            seg[ind]=arr[low];
            return;
        }
        int mid=low+(high-low)/2;
        build(arr,2*ind+1,low,mid);
        build(arr,2*ind+2,mid+1,high);
        seg[ind]=seg[2*ind+1]+seg[2*ind+2];
    }
    
    public int query(int ind,int low,int high,int l,int r){
        
        //outside the range
        if(low>r||high<l||low>high) return 0;
        
        //exactly inside
        if(low>=l&&high<=r) return seg[ind];
        
        //overlap
        int mid=low+(high-low)/2;
        int left=query(2*ind+1,low,mid,l,r);
        int right=query(2*ind+2,mid+1,high,l,r);
        return (left+right);
    }
    
    public void update(int ind,int low,int high,int index,int val){
        
        if(low==high){
            seg[ind]+=val;
            return;
        }
        
        int mid=(low+high)/2;
        if(index<=mid&&index>=low){
            update(2*ind+1,low,mid,index,val);
        }else{
            update(2*ind+2,mid+1,high,index,val);
        }
        
        seg[ind]=seg[2*ind+1]+seg[2*ind+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */