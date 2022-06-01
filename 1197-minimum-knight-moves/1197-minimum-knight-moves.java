class Solution {
    public int minKnightMoves(int x, int y) {
        int res=BFS(x,y);
        return res;
    }
    
    static int BFS(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0, 0));
		HashMap<Integer,HashMap<Integer, Boolean>> hashMap=new HashMap<>();
		hashMap.put(0, new HashMap<Integer, Boolean>());
		hashMap.get(0).put(0, true);
		
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				Pair currPair=queue.poll();
				int cx=currPair.x;
				int cy=currPair.y;
				int steps=currPair.steps;
				if(cx==x&&cy==y) {
					return steps;
				}
				for(int j=0;j<8;j++) {
					int newx=cx+offx[j];
					int newy=cy+offy[j];
					int newsteps=steps+1;
					if(hashMap.containsKey(newx)) {
						if(hashMap.get(newx).containsKey(newy)) {
							if(hashMap.get(newx).get(newy)==true) {
								continue;
							}
						}else {
							hashMap.get(newx).put(newy, true);
						}
					}else {
						hashMap.put(newx, new HashMap<Integer, Boolean>());
						hashMap.get(newx).put(newy, true);
					}
					
					queue.add(new Pair(newx,newy,newsteps));
				}
			}
		}
		
		return -1;
	}
    
    static class Pair {
		int x;
		int y;

		public Pair(int x, int y, int steps) {
			super();
			this.x = x;
			this.y = y;
			this.steps = steps;
		}

		int steps;

	}
    
    static int offx[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int offy[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
}