class Solution {
    public boolean find132pattern(int[] arr) {
        int n=arr.length;
		TreeMap<Integer,Integer> left=new TreeMap<>();
		TreeMap<Integer,Integer> right=new TreeMap<>();
		
		left.put(arr[0], 1);
		for(int i=n-1;i>0;i--)
           right.put(arr[i], right.getOrDefault(arr[i], 0)+1);
		
		for(int i=1;i<n-1;i++) {
			int freq=right.get(arr[i]);
			if(freq==1) right.remove(arr[i]);
			else right.put(arr[i], freq-1);
			
			Integer isLessLeft=left.lowerKey(arr[i]);
			if(isLessLeft==null){ 
                left.put(arr[i], left.getOrDefault(arr[i], 0)+1);
                continue;
            }
			int leftVal=left.firstKey();
			
			Integer isLessRight=right.lowerKey(arr[i]);
			if(isLessRight==null) {
                left.put(arr[i], left.getOrDefault(arr[i], 0)+1);
                continue;
            }
			
			if(isLessRight>leftVal) return true;
			
			left.put(arr[i], left.getOrDefault(arr[i], 0)+1);
		}
        
        return false;
    }
}