class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int boxLen=boxes.length;
        TreeMap<Integer,Integer> boxMap=new TreeMap<>();
        for(int i=0;i<boxLen;i++){
            boxMap.put(boxes[i],boxMap.getOrDefault(boxes[i],0)+1);
        }
        
        int warehouseLen=warehouse.length;
        int minTillNow[]=new int[warehouseLen];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<warehouseLen;i++){
            min=Math.min(min,warehouse[i]);
            minTillNow[i]=min;
        }
        
        int placed=0;
        
        for(int i=warehouseLen-1;i>=0;i--){
            int maxBoxHeight=minTillNow[i];
            Integer floor=boxMap.floorKey(maxBoxHeight);
            if(floor==null) continue;
            int freq=boxMap.get(floor);
            if(freq==1) boxMap.remove(floor);
            else boxMap.put(floor,freq-1);
            placed++;
        }
        
        return placed;
    }
}