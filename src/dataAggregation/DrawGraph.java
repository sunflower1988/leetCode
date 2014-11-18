package dataAggregation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class VNode{
	int from;        
	Edge first;         //first edge  
	int degreeNum;      
	boolean visit;
	public VNode(int from){
		this.from = from;
		visit = false;
		first = null;
	}
}
class Edge{
	int to;
	Edge next;          //next edge
	public Edge(int to){
		this.to = to;
		next = null;
	}
}

public class DrawGraph {
	public int nodeNum;
	public int edgeNum;
	public VNode[] DrawG()throws FileNotFoundException{
		
		Scanner sc1 = new Scanner(new File("C:/Users/i312902/Private/algorithm/test.txt"));   //from 0 to n
		nodeNum=sc1.nextInt();
		edgeNum = sc1.nextInt();
		
		VNode[] V = new VNode[nodeNum];
		for(int i=0;i<nodeNum;i++){ 
			V[i] = new VNode(i);   
			V[i].degreeNum = 0;
			} 
		Edge e = null;                       
		Edge eContra = null;			     
		
		int u = 1;
		int v = 1;
//		System.out.println("the first one must be the Sink node");
		for(int i=0;i<edgeNum;i++){
			u = sc1.nextInt();          //from 0 to n
			v = sc1.nextInt();	
//			System.out.println("from"+u+"to"+v);
			e = new Edge(v);
			e.next = V[u].first;               
			V[u].first = e;
			V[u].degreeNum++;                  
			
			eContra=new Edge(u);                     
			eContra.next=V[v].first; 			
	        V[v].first=eContra;
	        V[v].degreeNum++;
	        }
		return V;
	}
}
