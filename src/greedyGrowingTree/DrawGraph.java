package greedyGrowingTree;

import java.util.Scanner;
import java.io.*;

//class VNode implements Cloneable,Serializable{
class VNode{
	char from;        
	Edge first;         //fromå�Žè¿žæŽ¥çš„first edge
	int degreeNum;      
	boolean visit;
/*	protected VNode clone(){  
        VNode cloned = null;  
        try {  
            cloned = (VNode) super.clone();  
        } catch (CloneNotSupportedException e) {  
 
            e.printStackTrace();  
        }  
        return cloned;  
    }  */
	public VNode(char from){
		this.from = from;
		visit = false;
		first = null;
	}
}
class Edge{
	char to;
	Edge next;          //next edge
	public Edge(char to){
		this.to = to;
		next = null;
	}
}

class Draw{
	public int nodeNum;
	public int edgeNum;
	
	public VNode[] DrawG()throws FileNotFoundException{
	Scanner sc1 = new Scanner(new File("E:/aa.txt")); 
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
	
	char u = 'A';
	char v = 'A';
//	System.out.println("the first one must be the Sink node");
	for(int i=0;i<edgeNum;i++){
	//	System.out.println("from...to...");
		u = sc1.next("[A-Z]").charAt(0);         
		v = sc1.next("[A-z]").charAt(0);		
		
		
		e = new Edge(v);
		e.next = V[u-'A'].first;               
		V[u-'A'].first = e;
		V[u-'A'].degreeNum++;                  
		
		//å¯¹ç§°è¾¹
		eContra=new Edge(u);                     
		eContra.next=V[v-'A'].first; 			
        V[v-'A'].first=eContra;
        V[v-'A'].degreeNum++;
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