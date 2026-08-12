class Solution {
    public int maxArea(int[] h) {
        int max=0,n=h.length,min=10000;
        int i=0,j=h.length-1;
        while(j>=i){
            min=Math.min(h[i],h[j]);
            max=Math.max(max,(min*(j-i)));
            if(h[j]>h[i]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}