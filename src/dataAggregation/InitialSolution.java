package dataAggregation;

import java.util.ArrayList;

/*
 * The result is a tree.
 */
class TreeNode{
	int data;
	int parent;
	TreeNode children;
	int timeTide;
}
public class InitialSolution {
	int nodenum;
	 InitialSolution(VNode[] V){
/*		VNode[] VN = new VNode[V.length];
		VN=V; 							//shallow clone
*/
		 nodenum = V.length;
		 TreeNode root = new TreeNode();
		 root.data = 0;
		 root.parent = 0;
		 root.timeTide = 1;
		 root.children = null;
	}

	 public TreeNode[] ResultTree(){
		 System.out.println(nodenum);
		 TreeNode[] tn = new TreeNode[nodenum];
		 return tn;
	 }
}
