class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;
        HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String sender = senders[i];
			String words[] = messages[i].split(" ");
			int cnt = words.length;
			map.put(sender, map.getOrDefault(sender, 0) + cnt);
		}

		List<Pair> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String sender = entry.getKey();
			int cnt = entry.getValue();
			list.add(new Pair(sender, cnt));
		}

		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.cnt == o2.cnt) {
					return o2.sender.compareTo(o1.sender);
				}
				return o2.cnt - o1.cnt;
			}

		});

		return (list.get(0).sender);
    }
}

class Pair {
		String sender;
		int cnt;

		public Pair(String sender, int cnt) {
			super();
			this.sender = sender;
			this.cnt = cnt;
		}

	}