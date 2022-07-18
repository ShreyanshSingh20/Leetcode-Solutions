class Solution {
		public HashMap<List<String>, Integer> result;

		public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
			int n = username.length;
			List<Triplet> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(new Triplet(username[i], timestamp[i], website[i]));
			}

			Collections.sort(list, new Comparator<Triplet>() {
				@Override
				public int compare(Triplet o1, Triplet o2) {
					return o1.time - o2.time;
				}
			});

			HashMap<String, List<String>> userVisitOrder = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String user = list.get(i).person;
				String sitename = list.get(i).website;
				userVisitOrder.putIfAbsent(user, new ArrayList<>());
				userVisitOrder.get(user).add(sitename);
			}

			this.result = new HashMap<>();
			generatePattern(list, userVisitOrder);

			List<String> res = new ArrayList<>();
			int maxScore = Integer.MIN_VALUE;
			for (Map.Entry<List<String>, Integer> entry : result.entrySet()) {
				if (entry.getValue() > maxScore) {
					maxScore = entry.getValue();
					res = entry.getKey();
				} else if (entry.getValue() == maxScore) {
					if (entry.getKey().toString().compareTo(res.toString()) < 0) {
						res = entry.getKey();
					}
				}
			}

			return res;

		}

		public void generatePattern(List<Triplet> list, HashMap<String, List<String>> userVisitOrder) {

			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					for (int k = j + 1; k < list.size(); k++) {
						List<String> perm = new ArrayList<>();
						perm.add(list.get(i).website);
						perm.add(list.get(j).website);
						perm.add(list.get(k).website);
						processThisPattern(perm, userVisitOrder);
					}
				}
			}
		}

		public void processThisPattern(List<String> perm, HashMap<String, List<String>> userVisitOrder) {

			int score = 0;

			for (Map.Entry<String, List<String>> e : userVisitOrder.entrySet()) {
				List<String> order = e.getValue();
				if (doesMatch(perm, order))
					score++;
			}

			result.put(new ArrayList<>(perm), score);
		}

		public boolean doesMatch(List<String> perm, List<String> order) {
			int l = 0;
			int r = 0;
			while (r < order.size()) {
				if (order.get(r).equals(perm.get(l))) {
					l++;
				}
				r++;
				if (l == perm.size())
					return true;
			}
			return false;
		}

	}

	class Triplet {
		String person;
		int time;
		String website;

		public Triplet(String person, int time, String website) {
			this.person = person;
			this.time = time;
			this.website = website;
		}
	}