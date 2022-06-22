class Solution {
    public int uniqueLetterString(String s) {
        char c[]=s.toCharArray();
		int n=c.length;
		int lastOccurence[]=new int[26];
		int secLastOccurence[]=new int[26];
		int times[]=new int[26];
		Arrays.fill(lastOccurence, -1);
		Arrays.fill(secLastOccurence, -1);
		lastOccurence[c[0]-'A']=0;
		times[c[0]-'A']++;
		int dp[]=new int[n];
		dp[0]=1;
		for(int i=1;i<n;i++) {
			int currChar=c[i]-'A';
			int P=dp[i-1];
			int Q=0;int R=0;
			times[currChar]++;
			if(times[currChar]==1) {//first time encounter
				Q=i;R=0;
				lastOccurence[currChar]=i;
			}else if(times[currChar]==2) {//second time
				Q=i-lastOccurence[currChar]-1;
				R=i-Q;
				secLastOccurence[currChar]=lastOccurence[currChar];
				lastOccurence[currChar]=i;
			}else {//third or more times
				Q=i-lastOccurence[currChar]-1;
				R=lastOccurence[currChar]-secLastOccurence[currChar];
				secLastOccurence[currChar]=lastOccurence[currChar];
				lastOccurence[currChar]=i;
			}
			
			dp[i]=P+Q-R+1;
		}
		
		int ans=0;
		for(int x:dp) ans+=x;
		return ans;
    }
}