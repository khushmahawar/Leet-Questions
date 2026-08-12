/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*int[] arr=new int [2]; 
    TreeNode ans=new TreeNode;
    public TreeNode helper(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return (root);
        if(arr[0]==2&&arr[1]==2){
            ans=root;
            return (root);}
        if(root==p){
            arr[0]++;
        }
        if(root==q){
            arr[1]++;
        }
        helper(root.left,p,q);
        helper(root.right,p,q);
        return (root);
    }*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null)return root;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null)return root;
        else if(l!=null)return l;
        else if(r!=null)return r;
        return null;
    }
}