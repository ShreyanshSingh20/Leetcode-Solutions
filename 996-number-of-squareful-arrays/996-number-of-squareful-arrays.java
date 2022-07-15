class Solution {
    public int numSquarefulPerms(int[] arr) {
        
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        
        return solver(map,-1,0,n);
        
    }
    
    public int solver(HashMap<Integer,Integer> map,int prevElement,int num,int total){
        
        if(num==total){
            return 1;
        }
        
        int res=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key=e.getKey();
            int freq=e.getValue();
            if(freq==0) continue;
            
            map.put(key,freq-1);
            if((prevElement==-1)||(prevElement!=-1&&isPerfectSquare(prevElement,key))){
                res+=solver(map,key,num+1,total);
            }
            
            map.put(key,freq);
        }
        
        return res;
    }
    
    public boolean isPerfectSquare(int a, int b) {

		long n = (long) a + (long) b;
		if (Math.ceil((double) Math.sqrt(n)) == Math.floor((double) Math.sqrt(n))) {
			return true;
		}
		return false;
	}
}