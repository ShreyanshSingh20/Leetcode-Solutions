class Solution {
    public boolean isIdealPermutation(int[] arr) {
        
        int l=0;int r=arr.length-1;int n=arr.length;
        
        int localInversions=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]) localInversions++;
        }
        
        int temp[]=new int[n];
        
        int globalInversions=solver(arr,temp,0,r);
        // System.out.println(globalInversions);
        
        return localInversions==globalInversions;
    }
    
    public int solver(int arr[],int temp[],int l,int r){
        
        if(l>=r) return 0;
        
        int mid=(l+r)/2;
        int left=solver(arr,temp,l,mid);
        int right=solver(arr,temp,mid+1,r);
        int count=merge(arr,temp,l,mid,r);
        return left+right+count;
    }
    
    public int merge(int arr[],int temp[],int l,int mid,int r){
        
        int count=0;
        int i=l;int j=mid+1;int pt=l;
        while(i<=mid&&j<=r){
            if(arr[i]<=arr[j]){
                temp[pt]=arr[i];
                pt++;i++;
            }else{
                temp[pt]=arr[j];
                pt++;j++;
                count+=(mid+1-i);
            }
        }
        
        while(i<=mid) {
            temp[pt]=arr[i];
            pt++;i++;
        }
        
        while(j<=r){
            temp[pt]=arr[j];
            pt++;j++;
        }
        
        for(int x=l;x<=r;x++){
            arr[x]=temp[x];
        }
        
        return count;
    }
}