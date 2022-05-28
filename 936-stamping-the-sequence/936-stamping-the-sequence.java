class Solution {
    public int[] movesToStamp(String s, String t) {
        char stamp[] = s.toCharArray();
		char target[] = t.toCharArray();
		int limit = 10 * target.length;
		int stars = 0;
		List<Integer> res = new ArrayList<>();
		while (limit > 0 && stars < target.length) {
			int i = 0;
            boolean didMatch=false;
			while (i <= target.length - stamp.length) {
				int left = i;
				if (!isMatch(stamp, target, i)) {
					i++;
					continue;
				}
                didMatch=true;
				res.add(left);
				stars += replace(target, left, stamp.length);
				i += stamp.length;
			}
            
            if(!didMatch) return new int[]{};
		}
		Collections.reverse(res);
		int ans[] = new int[res.size()];
		for (int i = 0; i < res.size(); i++)
			ans[i] = res.get(i);
        
        return ans;
    }
    
    public int replace(char target[], int ind, int len) {
		int nonStars = 0;
		while (len > 0) {
			if (target[ind] != '*')
				nonStars++;
			target[ind] = '*';
			ind++;
			len--;
		}
		return nonStars;
	}

	public boolean isMatch(char stamp[], char target[], int ind) {
		int i = 0;
		int j = ind;
		int nonStar = 0;
		while ((i < stamp.length && j < target.length) && ((stamp[i] == target[j]) || target[j] == '*')) {
			if (target[j] != '*')
				nonStar++;
			i++;
			j++;
		}
		return i == stamp.length && nonStar > 0;
	}
}