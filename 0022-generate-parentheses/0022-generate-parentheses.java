class Solution {
    private void helper(int i,int n,List<String> list,String str,int open,int close){
        if(str.length()==n*2){
            list.add(str);
        }
        if(open>close){
            helper(i,n,list,str+")",open,close+1);
        }
        if(n>open){
            helper(i,n,list,str+"(",open+1,close);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        helper(0,n,list,"",0,0);
        return list;    
    }
}