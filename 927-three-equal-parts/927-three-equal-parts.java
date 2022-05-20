class Solution {
    public int[] threeEqualParts(int[] arr) {
        int n=arr.length;
        int cnt1s=0;
        for(int x:arr){
            if(x==1) cnt1s++;
        }
        
        if(cnt1s==0) return new int[]{0,2};
        if(cnt1s%3!=0) return new int[]{-1,-1};
        
        int res[]=new int[2];
        
        int divisions=cnt1s/3;
        
        
        StringBuilder thirdPart=new StringBuilder();
        
        int upperLimit=-1;int cnt=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]==1) cnt++;
            upperLimit=i;
            thirdPart.append(arr[i]);
            if(cnt==divisions) break;
        }
        
        String toCompare=thirdPart.reverse().toString();
        
        int i=0;
        while(i<upperLimit&&arr[i]==0) i++;
        
        int comPt=0;
        while(i<upperLimit&&comPt<toCompare.length()){
            if(arr[i]!=toCompare.charAt(comPt)-'0') return new int[]{-1,-1};
            i++;comPt++;
        }
        
        if(comPt<toCompare.length()) return new int[]{-1,-1};
        
        i--;
        
        res[0]=i;
        
        int j=i+1;
        while(j<upperLimit&&arr[j]==0) j++;
        
        comPt=0;
        while(j<upperLimit&&comPt<toCompare.length()){
            if(arr[j]!=toCompare.charAt(comPt)-'0') return new int[]{-1,-1};
            j++;comPt++;
        }
        
        if(comPt<toCompare.length()) return new int[]{-1,-1};
        
        res[1]=j;
        
        return res;
        
    }
}