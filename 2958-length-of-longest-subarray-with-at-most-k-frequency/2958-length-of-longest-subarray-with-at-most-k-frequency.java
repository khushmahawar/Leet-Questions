class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,n=nums.length,max=0;
        boolean flag=false;
        for(int j=0;j<n;j++){
            if(map.containsKey(nums[j])){
            int value=map.get(nums[j]);
            map.put(nums[j],value+1);
            if(value+1>k){
                max=Math.max(max,j-i);
                flag=true;
            }
            }
            else{
                map.put(nums[j],1);
            }
            while(flag&&nums[i]!=nums[j]){
                int value=map.get(nums[i]);
                map.put(nums[i],value-1);
                i++;
            }
            if(flag){
                int value=map.get(nums[i]);
                map.put(nums[i],value-1);
                i++;
            }
            flag=false;
        }
        max=Math.max(max,nums.length-i);
        //if(max==0)return nums.length;
        return max;
    }
}