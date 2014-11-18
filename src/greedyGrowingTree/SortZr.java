package greedyGrowingTree;
import java.util.*;
import java.lang.Math;
public class SortZr {
	private List<Map.Entry<Character,Integer>> ArNode; 
	private List<Map.Entry<Character,Integer>> PiNode;		 
	private List<Map.Entry<Character,Integer>> CriNode;	 
	private List<Character> NormalNode;
	private List<Integer> list;
	private VNode[] v1,v2,v3;
	private List<Character> Ztemp=new ArrayList<Character>();
	public List<Character> ISortZr(VNode[] v,List<Character> Tr,List<Character> Zr)throws Exception{
		//TEST
		System.out.print("Trï¼š");
		for(int i=0;i<Tr.size();i++){
			System.out.print(Tr.get(i)+" ");
		}
		System.out.println();
		System.out.print("Zr: ");
		for(int i=0;i<Zr.size();i++){
			System.out.print(Zr.get(i)+" ");
		}
		System.out.println();
	/*	System.out.println("The Link from SortZr:");
		VNode[] vv=v;
		for(int i=0;i<vv.length;i++){
			System.out.print(vv[i].from+" ");
			while(vv[i].first!=null){
				System.out.print(vv[i].first.to+" ");
				vv[i].first=vv[i].first.next;
		}
		System.out.println();	
		}*/
	/*	DeepClone deepClone = new DeepClone();
		for(int i=0;i<v.length;i++){
			vn[i]=deepClone.getObject(v[i]);
		}*/
	
		v1=v;
		List<Character> zr = new ArrayList<Character>();
		zr=Zr;
		list = new ArrayList<Integer>();
		BFS bfs = new BFS(v);
		list=bfs.BFSearch();   //å°†æ‰€æœ‰ç»“ç‚¹åˆ†å±‚ç¼–å�·
		//findArticulationNode
		
		Draw G1 = new Draw();
		v2= G1.DrawG();
		ArticulationNode articu = new ArticulationNode(v);
		ArNode=articu.IArticulationNode(Zr);
		System.out.print("ArNode:");
		for(int i=0;i<ArNode.size();i++)
			System.out.print(ArNode.get(i)+" ");
		System.out.println();
		Draw G2 = new Draw();
		v2= G2.DrawG();
		PilotNode pnode = new PilotNode();
		PiNode=pnode.IPilotNode(v2, list,Zr, ArNode);
		System.out.print("PiNode:");
		for(int i=0;i<PiNode.size();i++)
			System.out.println(PiNode.get(i)+" ");
		System.out.println();
		Draw G3 = new Draw();
		v3= G3.DrawG();
		CriticalNode criNode = new CriticalNode();
		CriNode=criNode.ICriticalNode(v3,Zr,ArNode,PiNode);
		System.out.print("CriNode:");
		for(int i=0;i<CriNode.size();i++)
			System.out.println(CriNode.get(i)+" ");
		System.out.println();
		//normal list
		for(int i=0;i<zr.size();i++){
			for(int j=0;j<ArNode.size();j++){
				if(zr.get(i)==ArNode.get(j).getKey())zr.remove(i);
			}
			for(int j=0;j<PiNode.size();j++){
				if(zr.get(i)==PiNode.get(j).getKey())zr.remove(i);
			}
			for(int k=0;k<CriNode.size();k++){
				if(zr.get(i)==CriNode.get(k).getKey())zr.remove(i);
			}
		}
		NormalNode=zr;
		//å¯¹è¿”å›žçš„åº�åˆ—æŽ’åº�
		for(int i=0;i<ArNode.size();i++){
			double LowerBound =Math.log((v.length-Tr.size()-ArNode.get(i).getValue())/Tr.size())/Math.log(2); 
			if(ArNode.get(i).getValue()>LowerBound){
				Ztemp.add(ArNode.get(i).getKey());
			}
		}
		for(int j=0;j<PiNode.size();j++){
			Ztemp.add(PiNode.get(j).getKey());
		}
		for(int k=0;k<CriNode.size();k++){
			Ztemp.add(CriNode.get(k).getKey());
		}
		
		for(int l=0;l<NormalNode.size();l++){ //ç®€åŒ–äº†
			Ztemp.add(NormalNode.get(l));
		}
		
	return Ztemp;
	}
}

