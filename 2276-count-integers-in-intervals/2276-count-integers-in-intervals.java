class CountIntervals {

		TreeMap<Integer, Integer> map;
		int cnt;

		public CountIntervals() {
			this.map = new TreeMap<>();
			this.cnt = 0;
		}

		public void add(int left, int right) {
			if (map.floorKey(right) == null || map.get(map.floorKey(right)) < left) {
				map.put(left, right);
				cnt += (right - left + 1);
			} else {
				int newLeft = left;
				int newRight = right;
				while (true) {

					int l1 = map.floorKey(newRight);
					int r1 = map.get(l1);

					cnt -= (r1 - l1 + 1);

					newLeft = Math.min(newLeft, l1);
					newRight = Math.max(newRight, r1);
                    
                    map.remove(l1);

					if (map.floorKey(newRight) == null || map.get(map.floorKey(newRight)) < newLeft) {
						break;
					}
				}

				map.put(newLeft, newRight);
				this.cnt += (newRight - newLeft + 1);
			}
		}

		public int count() {
			return this.cnt;
		}
	}
/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */