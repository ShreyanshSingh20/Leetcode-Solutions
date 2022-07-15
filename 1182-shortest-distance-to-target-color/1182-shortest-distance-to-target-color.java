class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        
        int n=colors.length;
        int l1[]=new int[n];
        int r1[]=new int[n];
        int l2[]=new int[n];
        int r2[]=new int[n];
        int l3[]=new int[n];
        int r3[]=new int[n];
        
        int ind1=-1;int ind2=-1;int ind3=-1;
        for(int i=0;i<n;i++){
            if(colors[i]==1) ind1=i;
            l1[i]=ind1;
            
            if(colors[i]==2) ind2=i;
            l2[i]=ind2;
            
            if(colors[i]==3) ind3=i;
            l3[i]=ind3;
        }
        
        
        ind1=-1;ind2=-1;ind3=-1;
        for(int i=n-1;i>=0;i--){
            if(colors[i]==1) ind1=i;
            r1[i]=ind1;
            
            if(colors[i]==2) ind2=i;
            r2[i]=ind2;
            
            if(colors[i]==3) ind3=i;
            r3[i]=ind3;
        }
        
        
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int ind=queries[i][0];
            int col=queries[i][1];
            if(col==1){
                if(l1[ind]==-1&&r1[ind]==-1) {res.add(-1); continue;}
                if(l1[ind]==-1&&r1[ind]!=-1) {res.add(r1[ind]-ind); continue;}
                if(l1[ind]!=-1&&r1[ind]==-1) {res.add(ind-l1[ind]); continue;}
                if(l1[ind]!=-1&&r1[ind]!=-1) {res.add(Math.min(ind-l1[ind],r1[ind]-ind)); continue;}
            }else if(col==2){
                if(l2[ind]==-1&&r2[ind]==-1) {res.add(-1); continue;}
                if(l2[ind]==-1&&r2[ind]!=-1) {res.add(r2[ind]-ind); continue;}
                if(l2[ind]!=-1&&r2[ind]==-1) {res.add(ind-l2[ind]); continue;}
                if(l2[ind]!=-1&&r2[ind]!=-1) {res.add(Math.min(ind-l2[ind],r2[ind]-ind)); continue;}
            }else if(col==3){
                if(l3[ind]==-1&&r3[ind]==-1) {res.add(-1); continue;}
                if(l3[ind]==-1&&r3[ind]!=-1) {res.add(r3[ind]-ind); continue;}
                if(l3[ind]!=-1&&r3[ind]==-1) {res.add(ind-l3[ind]); continue;}
                if(l3[ind]!=-1&&r3[ind]!=-1) {res.add(Math.min(ind-l3[ind],r3[ind]-ind)); continue;}
            }
        }
        
        return res;
    }
}