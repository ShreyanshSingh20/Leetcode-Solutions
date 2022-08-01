class Solution {
    public int[] findPermutation(String s) {
        
        char c[]=s.toCharArray();
        int res[]=new int[c.length+1];
        for(int i=0;i<c.length+1;i++){
            res[i]=i+1;
        }
        
        int l=0;int r=0;
        for(r=0;r<c.length;r++){
            if(c[r]=='I'){
                reverse(res,l,r);
                l=r+1;
            }
        }
        reverse(res,l,r);
        return res;
    }
    
    public void reverse(int arr[],int l,int r){
        int templ=l;int tempr=r;
        while(templ<=tempr){
            int temp=arr[templ];
            arr[templ]=arr[tempr];
            arr[tempr]=temp;
            templ++;tempr--;
        }
    }
}