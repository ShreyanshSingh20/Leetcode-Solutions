class Solution {
    public List<Integer> countSmaller(int[] arr){
        int n=arr.length;
        int size=20001;
        List<Integer> res=new ArrayList<>();
        SegmentTree st=new SegmentTree(size);
        for(int i=n-1;i>=0;i--){
            int num=arr[i]+10000;
            res.add(st.query(0,0,size-1,0,num-1));
            st.pointUpdate(0,0,size-1,num,1);
        }
        
        Collections.reverse(res);
        return res;
        
    }
}

class SegmentTree{
    int seg[];
    public SegmentTree(int n){
        seg=new int[4*n];
    }
    
    
    public int query(int ind,int low,int high,int l,int r){
        
        //completely outside
        if(low>r||high<l||low>high) return 0;
        
        //completely inside
        if(low>=l&&high<=r) return seg[ind];
        
        //overlap-then travel to both the nodes to find the answer
        int mid=low+(high-low)/2;
        int left=query(2*ind+1,low,mid,l,r);
        int right=query(2*ind+2,mid+1,high,l,r);
        return left+right;
    }
    
    public void pointUpdate(int ind,int low,int high,int i,int add){
        
        if(low==high){
            seg[ind]+=add;
            return;
        }
        
        int mid=low+(high-low)/2;
        if(i>=low&&i<=mid) pointUpdate(2*ind+1,low,mid,i,add);
        else pointUpdate(2*ind+2,mid+1,high,i,add);
        seg[ind]=seg[2*ind+1]+seg[2*ind+2];
    }
    
    
}