class Solution {
    private void helper(List<List<Integer>> ans,List<Integer> list,int i,int target,int[] arr){
        if(i==arr.length||target<=0){
            if(target==0){
                ans.add(new ArrayList(list));}
            return;
        }
        
        //take
        list.add(arr[i]);
        helper(ans,list,i,target-arr[i],arr);
        list.remove(list.size()-1);
        helper(ans,list,i+1,target,arr);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>(); 
        helper(ans,new ArrayList<>(),0,target,arr);
        return ans;
    }
}