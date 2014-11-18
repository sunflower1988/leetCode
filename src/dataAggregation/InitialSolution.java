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
	 public InitialSolution(VNode[] V){
/*		VNode[] VN = new VNode[V.length];
		VN=V; 							//shallow clone
*/
		 TreeNode root = new TreeNode();
		 root.data = 0;
		 root.parent = 0;
		 root.timeTide = 1;
	}
	 VNode[] optionalSet = new VNode[5];
	 public ResultTree[] solve(){
		 
	 }
}
