class Solution {
    public boolean find132pattern(int[] arr) {
        int n=arr.length;
		TreeMap<Integer,Integer> left=new TreeMap<>();
		TreeMap<Integer,Integer> right=new TreeMap<>();
		
		int min=arr[0];
		for(int i=n-1;i>0;i--)
           right.put(arr[i], right.getOrDefault(arr[i], 0)+1);
		
		for(int i=1;i<n-1;i++) {
			int freq=right.get(arr[i]);
			if(freq==1) right.remove(arr[i]);
			else right.put(arr[i], freq-1);
			
			Integer isLessLeft=(min<arr[i])?min:null;
			if(isLessLeft==null){ 
                min=Math.min(min,arr[i]);
                continue;
            }

			Integer isLessRight=right.lowerKey(arr[i]);
			if(isLessRight==null) {
                min=Math.min(min,arr[i]);
                continue;
            }
			
			if(isLessRight>isLessLeft) return true;
			
			min=Math.min(min,arr[i]);
		}
        
        return false;
    }
}