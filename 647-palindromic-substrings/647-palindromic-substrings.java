class Solution {
    public int countSubstrings(String s) {
        char c[]=s.toCharArray();
        int n=c.length;
        // FOR ODD LENGTH PALINDROMES
		int oc[] = new int[n];
		for (int i = 0, pt = -1, dis = -1; i < n; i++) {
			// if there's no currently maintained palindrome
			if (i > pt + dis)
				oc[i] = 1;
			// well within case
			else if (i + oc[pt - (i - pt)] - 1 < pt + dis) {
				oc[i] = oc[pt - (i - pt)];
			}
			// coincide or out of bound from currently maintained palindrome
			else {
				oc[i] = ((pt + dis) - i) + 1;
			}
			// Expansion
			while (i - oc[i] >= 0 && i + oc[i] < n && c[i - oc[i]] == c[i + oc[i]]) {
				oc[i]++;
			}

			if (i + oc[i] - 1 > pt + dis) {
				pt = i;
				dis = oc[i] - 1;
			}

		}

		// FOR Even LENGTH PALINDROMES
		int ec[] = new int[n + 1];
		for (int i = 1, pt = -1, dis = -1; i < n; i++) {
			// if there's no currently maintained palindrome
			if (i > pt + dis)
				ec[i] = 0;
			// well within case
			else if (i + ec[pt - (i - pt)] - 1 < pt + dis) {
				ec[i] = ec[pt - (i - pt)];
			}
			// coincide or out of bound from currently maintained palindrome
			else {
				ec[i] = ((pt + dis) - i);
			}
			// Expansion
			while (i - ec[i] - 1 >= 0 && i + ec[i] < n && c[i - ec[i] - 1] == c[i + ec[i]]) {
				ec[i]++;
			}

			if (i + ec[i] > pt + dis) {
				pt = i;
				dis = ec[i];
			}

		}

		// total sum
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += oc[i] + ec[i];
		}
        return ans;
    }
}