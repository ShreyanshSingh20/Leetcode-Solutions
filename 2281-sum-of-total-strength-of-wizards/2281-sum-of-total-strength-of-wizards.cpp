typedef long long int ll;
const int mod = 1e9+7;

class Solution {
public:
    int totalStrength(vector<int>& str) {
        int n = str.size();
        vector<int> prev (n);
        vector<int> next (n);
        
        stack<int> s;
        for (int j = 0; j < n; j ++) {
            while (!s.empty() && str[s.top()] > str[j]) s.pop();
            prev[j] = s.empty()? -1 : s.top();
            s.push(j);
        }
        
        while (!s.empty()) s.pop();
        for (int j = n-1; j >= 0; j --) {
            while (!s.empty() && str[s.top()] >= str[j]) s.pop();
            next[j] = s.empty()? n : s.top();
            s.push(j);
        }
        
        vector<ll> pref(n+2);
        for (int j = 1; j <= n; j ++) {
            pref[j] = (pref[j-1] + str[j-1]) % mod;
        }
        vector<ll> pref_pref (n+2);
        for (int j = 1; j <= n; j ++) {
            pref_pref[j] = (pref_pref[j-1] + pref[j]) % mod;
        } 
        
        ll ans = 0;
        for (int j = 1; j <= n; j ++) {
            int prv = prev[j-1]+1, nxt = next[j-1]+1;
            
            ll minus = (pref_pref[j-1] - (prv == 0? 0 : pref_pref[prv-1]) + mod) % mod;
            ll plus = (pref_pref[nxt-1] - pref_pref[j-1] + mod) % mod;
            
            ll before = j - prv;
            ll after = nxt - j;
            ll total = ((plus * before) % mod - (minus * after) % mod  + mod) % mod;
            
            // cout << j << " " << str[j-1] << " --> " << prv << " " << nxt << ": " << total << " " << minus << " " << plus << endl;
            
            ans = (ans + (total * str[j-1]) % mod) % mod;
        }
        
        return ans;
    }
};