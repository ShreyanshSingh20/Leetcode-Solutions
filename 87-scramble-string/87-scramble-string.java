class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String, HashMap<String, Boolean>> dp = new HashMap<>();
		return (mcm(s1, s2, dp));
    }
    
    public boolean mcm(String a, String b, HashMap<String, HashMap<String, Boolean>> dp) {

		if (a.equals(b))
			return true;
		if (a.length() == 0 && b.length() == 0)
			return true;
		if (a.length() != b.length())
			return false;

		if (dp.containsKey(a)) {
			if (dp.get(a).containsKey(b)) {
				return dp.get(a).get(b);
			}
		}

		int n = a.length();
		boolean res = false;
		for (int i = 1; i < n; i++) {
			boolean swapped = mcm(a.substring(0, i), b.substring(n - i, n), dp)
					&& mcm(a.substring(i, n), b.substring(0, n - i), dp);

			boolean notSwapped = mcm(a.substring(0, i), b.substring(0, i), dp)
					&& mcm(a.substring(i, n), b.substring(i, n), dp);

			if (swapped || notSwapped) {
				res = true;
				break;
			}
		}

		dp.putIfAbsent(a, new HashMap<>());
		dp.get(a).put(b, res);
		return res;
	}
}