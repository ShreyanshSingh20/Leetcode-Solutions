class Solution {
		public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

			HashMap<Integer, HashSet<Integer>> block = new HashMap<>();
			for (int i = 0; i < blocked.length; i++) {
				int u = blocked[i][0];
				int v = blocked[i][1];
				block.putIfAbsent(u, new HashSet<Integer>());
				block.get(u).add(v);
			}
            
            boolean a=forSource(block,source,target);
            boolean b=forTarget(block,source,target);
            
            if(a==false||b==false) return false;
            return true;

		}

		public boolean forSource(HashMap<Integer, HashSet<Integer>> block, int source[], int target[]) {
			HashMap<Integer, HashSet<Integer>> vis = new HashMap<>();
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] { source[0], source[1], 0 });
			vis.putIfAbsent(source[0], new HashSet<Integer>());
			vis.get(source[0]).add(source[1]);

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int curr[] = q.poll();
					int x = curr[0];
					int y = curr[1];
					int dist = curr[2];
					if (dist > 200)
						return true;
					if (x == target[0] && y == target[1])
						return true;
					for (int k = 0; k < 4; k++) {
						int newx = x + offset[k][0];
						int newy = y + offset[k][1];
						if (newx < 0 || newy < 0 || newx >= 1000000 || newy >= 1000000
								|| (vis.containsKey(newx) && vis.get(newx).contains(newy))) {
							continue;
						}

						if (block.containsKey(newx) && block.get(newx).contains(newy))
							continue;
						q.add(new int[] { newx, newy, dist + 1 });
						vis.putIfAbsent(newx, new HashSet<Integer>());
						vis.get(newx).add(newy);
					}
				}
			}

			return false;
		}

		public boolean forTarget(HashMap<Integer, HashSet<Integer>> block, int source[], int target[]) {
			HashMap<Integer, HashSet<Integer>> vis = new HashMap<>();
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] { target[0], target[1], 0 });
			vis.putIfAbsent(target[0], new HashSet<Integer>());
			vis.get(target[0]).add(target[1]);

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int curr[] = q.poll();
					int x = curr[0];
					int y = curr[1];
					int dist = curr[2];
					if (dist > 200)
						return true;
					if (x == source[0] && y == source[1])
						return true;
					for (int k = 0; k < 4; k++) {
						int newx = x + offset[k][0];
						int newy = y + offset[k][1];
						if (newx < 0 || newy < 0 || newx >= 1000000 || newy >= 1000000
								|| (vis.containsKey(newx) && vis.get(newx).contains(newy))) {
							continue;
						}

						if (block.containsKey(newx) && block.get(newx).contains(newy))
							continue;
						q.add(new int[] { newx, newy, dist + 1 });
						vis.putIfAbsent(newx, new HashSet<Integer>());
						vis.get(newx).add(newy);
					}
				}
			}

			return false;
		}

		public int offset[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	}
