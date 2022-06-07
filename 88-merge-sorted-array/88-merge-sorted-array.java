class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int pt=m;
        int l=0;int r=0;
        if(n==0) return;
        while(l<m&&r<n){
            if(a[l]<=b[r]){
                a[pt]=a[l];
                l++;
            }else{
                a[pt]=b[r];
                r++;
            }
            pt=(pt+1)%a.length;
        }
        
        while(l<m){
            a[pt]=a[l];
            l++;
            pt=(pt+1)%a.length;
        }
        while(r<n){
            a[pt]=b[r];
            r++;
            pt=(pt+1)%a.length;
        }
        
        for(int x:a) System.out.print(x+" ");
        
        int ind=-1;
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]){
                ind=i;
                break;
            }
        }
        if(ind==-1) return;
        int k=a.length-ind;
        
        int len=a.length;
        k=k%len;
        reverse(a,0,len-1);//reverse whole array
        reverse(a,0,k-1);//reverse first k elements
        reverse(a,k,len-1);//reverse the last n-k elements
        
    }
    
     public void reverse(int arr[],int l,int r){
        while(l<=r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;r--;
        }
    }
}