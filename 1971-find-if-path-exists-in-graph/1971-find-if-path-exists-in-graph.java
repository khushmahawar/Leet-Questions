class Solution {
    public boolean bfs(List<List<Integer>> adj 
,int destination,boolean[] visited,int source){
        Queue<Integer> q=new LinkedList<>();
        q.offer(source);
        while(!q.isEmpty()){
            int curr=q.poll();
            visited[curr]=true;
            for(int ad:adj.get(curr)){
                if(!visited[ad])q.offer(ad);
                visited[ad]=true;
            }
            if(curr==destination) return true;
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);  }

            boolean[] visited=new boolean[adj.size()];
        for(int i=0;i<n;i++){
            if(!visited[i]&&i==source){
                return bfs(adj,destination,visited,source);
            }
        }
        return false;
    }
}