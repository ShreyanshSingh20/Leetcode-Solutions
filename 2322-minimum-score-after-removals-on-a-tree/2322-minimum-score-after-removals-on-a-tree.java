class Solution {
        public int minimumScore(int[] vals, int[][] edges) {

                //construct the graph
                List < List < Integer >> g = new ArrayList < > ();
                int n = vals.length;
                for (int i = 0; i < n; i++) g.add(new ArrayList < > ());
                for (int i = 0; i < edges.length; i++) {
                        int u = edges[i][0];
                        int v = edges[i][1];
                        addEdge(g, u, v);
                }

                //store the xors of each subtree->O(N)
                int xors[] = new int[n];
                for (int i = 0; i < n; i++) xors[i] = vals[i];
                HashSet < Integer > vis = new HashSet < > ();
                dfsXOR(g, 0, xors, vis);

                //calculating the universal xor
                int V = 0;
                for (int x: vals) V = V ^ x;

                //making a list of ancestors mapped to their children->O(N^2)
                vis.clear();
                HashMap < Integer, HashSet < Integer >> map = new HashMap < > ();
                dfsRelationships(g, 0, map, vis);

                int res = Integer.MAX_VALUE;

                for (int i = 0; i < edges.length; i++) {
                        int b = edges[i][0];
                        int a = edges[i][1];
                        for (int j = i + 1; j < edges.length; j++) {
                                int d = edges[j][0];
                                int c = edges[j][1];

                                if (!map.get(b).contains(a)) {
                                        int temp = b;
                                        b = a;
                                        a = temp;
                                }

                                if (!map.get(d).contains(c)) {
                                        int temp = d;
                                        d = c;
                                        c = temp;
                                }

                                if (map.get(a).contains(c)) {
                                        int xor1 = V ^ xors[a];
                                        int xor2 = xors[a] ^ xors[c];
                                        int xor3 = xors[c];
                                        int max = Math.max(xor1, Math.max(xor2, xor3));
                                        int min = Math.min(xor1, Math.min(xor2, xor3));
                                        res = Math.min(res, max - min);
                                } else if (map.get(c).contains(a)) {
                                        int xor1 = V ^ xors[c];
                                        int xor2 = xors[a] ^ xors[c];
                                        int xor3 = xors[a];
                                        int max = Math.max(xor1, Math.max(xor2, xor3));
                                        int min = Math.min(xor1, Math.min(xor2, xor3));
                                        res = Math.min(res, max - min);
                                } else {
                                        int xor1 = V ^ xors[a] ^ xors[c];
                                        int xor2 = xors[a];
                                        int xor3 = xors[c];
                                        int max = Math.max(xor1, Math.max(xor2, xor3));
                                        int min = Math.min(xor1, Math.min(xor2, xor3));
                                        res = Math.min(res, max - min);
                                }

                        }
                }

                return res;
        }

        public HashSet < Integer > dfsRelationships(List < List < Integer >> g, int source, HashMap < Integer, HashSet < Integer >> map, HashSet < Integer > vis) {
                vis.add(source);
                HashSet < Integer > curr = new HashSet < > ();
                for (int next: g.get(source)) {
                        if (!vis.contains(next)) {
                                HashSet < Integer > set = dfsRelationships(g, next, map, vis);
                                Iterator e = set.iterator();
                                while (e.hasNext()) {
                                        int node = (int) e.next();
                                        curr.add(node);
                                }
                        }
                }
                curr.add(source);
                map.putIfAbsent(source, new HashSet < Integer > ());
                map.get(source).addAll(curr);
                return curr;
        }

        public int dfsXOR(List < List < Integer >> g, int source, int xors[], HashSet < Integer > vis) {

                vis.add(source);
                int xor = 0;
                for (int x: g.get(source)) {
                        if (!vis.contains(x)) {
                                xor = xor ^ dfsXOR(g, x, xors, vis);
                        }
                }

                return xors[source] = xor ^ xors[source];
        }

        public void addEdge(List < List < Integer >> g, int u, int v) {
                g.get(u).add(v);
                g.get(v).add(u);
        }
}