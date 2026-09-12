class Solution {
    private void helper(int ind,int[] arr,List<Integer> list,List<List<Integer>> ans,boolean[] visited){
        ans.add(new ArrayList(list));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind&&arr[i]==arr[i-1])continue;
        list.add(arr[i]);
        visited[i]=true;
        helper(i+1,arr,list,ans,visited);
        list.remove(list.size()-1);
        visited[i]=false;
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[arr.length];
        helper(0,arr,list,ans,visited);
        return ans;
    }
}