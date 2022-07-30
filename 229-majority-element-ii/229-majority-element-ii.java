class Solution {
    public List<Integer> majorityElement(int[] arr) {
        
        int n=arr.length;
        long pc1=Long.MAX_VALUE;
        int fpc1=0;
        long pc2=Long.MAX_VALUE;
        int fpc2=0;
        
        for(int i=0;i<n;i++){
            if(arr[i]==pc1){
                fpc1++;
            }else if(arr[i]==pc2){
                fpc2++;
            }else if(fpc1==0){
                pc1=arr[i];
                fpc1=1;
            }else if(fpc2==0){
                pc2=arr[i];
                fpc2=1;
            }else{
                fpc1--;
                fpc2--;
            }
        }
        
        int cnta=0;int cntb=0;
        for(int i=0;i<n;i++){
            if((long)arr[i]==pc1) cnta++;
            else if((long)arr[i]==pc2) cntb++;
        }
        
        List<Integer> res=new ArrayList<>();
        if(cnta>n/3) res.add((int)pc1);
        if(cntb>n/3) res.add((int)pc2);
        
        return res;
        
    }
}