package greedyGrowingTree;

import java.util.Scanner;
import java.io.*;

//class VNode implements Cloneable,Serializable{
class VNode{
	int from;        
	Edge first;         //fromå�Žè¿žæŽ¥çš„first edge
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

class Draw{
	public int nodeNum;
	public int edgeNum;
	
	public VNode[] DrawG()throws FileNotFoundException{
	Scanner sc1 = new Scanner(new File("C:/test.txt")); 
	nodeNum=sc1.nextInt();
	
	edgeNum = sc1.nextInt();
//	System.out.println(nodeNum);
//	System.out.println(edgeNum);
/*	Scanner sc = new Scanner(System.in); 
	System.out.println("Input VNode sum:");
	nodeNum = sc.nextInt();
	System.out.println("Input edge sum:");
	edgeNum = sc.nextInt();*/
	
	VNode[] V = new VNode[nodeNum];      
	
	for(int i=0,j=65;i<nodeNum;i++,j++){ 
		V[i] = new VNode((char)j);   
		V[i].degreeNum = 0;
		} 
	
	Edge e = null;                       
	Edge eContra = null;			     
	
	int u;
	int v;
//	System.out.println("the first one must be the Sink node");
	for(int i=0;i<edgeNum;i++){
	//	System.out.println("from...to...");
		u = sc1.nextInt();         
		v = sc1.nextInt();		
		
		
		e = new Edge(v);
		e.next = V[u].first;               
		V[u].first = e;
		V[u].degreeNum++;                  
		
		//å¯¹ç§°è¾¹
		eContra=new Edge(u);                     
		eContra.next=V[v].first; 			
        V[v].first=eContra;
        V[v].degreeNum++;
        }
/*		for(int i=0;i<nodeNum;i++){		
			System.out.println("èŠ‚ç‚¹i"+V[i].from+"åº¦ä¸º"+V[i].degreeNum);		
		}*/
/*	   	System.out.println("The Link");
		VNode[] vv=V;
		for(int i=0;i<nodeNum;i++){
			System.out.print(vv[i].from+" ");
			while(vv[i].first!=null){
				System.out.print(vv[i].first.to+" ");
				vv[i].first=vv[i].first.next;
		}
		System.out.println();	
		}*/
		return V;
	}
}

	public class DrawGraph {	
	public static void main(String[] args) throws Exception{
		Draw D = new Draw();
		D.DrawG();
	}
}