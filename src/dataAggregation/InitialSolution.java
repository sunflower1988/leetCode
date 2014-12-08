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
	VNode[] VN;
	 InitialSolution(VNode[] V){

		nodenum = V.length;
		VN = new VNode[nodenum];
		VN=V; 							//deep clone
		for(int i=0;i<nodenum;i++){
			VN[i]=V[i];
		}
		
		TreeNode root = new TreeNode();
		root.data = VN[0].from;
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
