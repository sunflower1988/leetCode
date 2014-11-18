package leetcode;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
	 }
public class PathSum {
	
	public static void main(String[] args){
		int sum=0;
		PathSum ps = new PathSum();
		TreeNode root = ps.CreateTree();
		ps.hasPathSum(root, sum);
		
	}
	public TreeNode CreateTree(){
		TreeNode root = 
	}
	public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;
        
        return result;
    }
}
