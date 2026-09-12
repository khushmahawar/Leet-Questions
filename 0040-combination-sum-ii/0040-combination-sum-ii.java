class Solution {
    private void helper(int ind,int target,List<List<Integer>> ans,List<Integer> list,int[] arr){
        if(target<=0){
        if(target==0){
            ans.add(new ArrayList(list));
        }
            return;
        }
        for(int i=ind;i<arr.length;i++){
        if(ind!=i&&arr[i]==arr[i-1])continue;
            list.add(arr[i]);
            helper(i+1,target-arr[i],ans,list,arr);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,target,ans,new ArrayList<>(),arr);
        return ans;
    }
}