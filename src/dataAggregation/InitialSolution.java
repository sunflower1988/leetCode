package dataAggregation;

import java.util.ArrayList;
import java.util.List;

/*
 * The result is a tree.
 */
class TreeNode{
	int data;
	int parent;
	TreeNode children;
	int timeTide;
	boolean flag;
}
public class InitialSolution {
	int nodenum;
	VNode[] VN;
	int timeTides=1;
	TreeNode root;
	List<TreeNode> tr = new ArrayList<TreeNode>();
	List<Integer> oc = new ArrayList<Integer>();
	 
	 InitialSolution(VNode[] V){

		nodenum = V.length;
		VN = new VNode[nodenum];
		VN=V; 							//shallow clone
		for(int i=0;i<nodenum;i++){     //deep clone?
			VN[i]=V[i];
		}
		
		TreeNode root = new TreeNode();  //initial root node
		root.data = VN[0].from;
		root.parent = 0;
		root.timeTide = timeTides;
		root.children = null;
		root.flag = false;
	}

	 public TreeNode[] ResultTree(){
//		 System.out.println(nodenum);
		 TreeNode[] tn = new TreeNode[nodenum];
		 tr.add(root);
		 //option collection
		 while(tr.isEmpty()){    //wrong
			 for(int i=0;i<nodenum;i++){
				 if(tr.get(i).data == VN[i].from)
					 while(VN[i].first!=null){
						 oc.add(VN[i].first.to);
						 VN[i].first = VN[i].first.next;
					 }
			 }
		 }
		 return tn;
	 }
}
