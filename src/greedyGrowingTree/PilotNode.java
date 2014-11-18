/**
 * if  a node i is on the shortest path from sink b to an articulation node
 * then i is called a pilot node;
 * its weight can calculated as the summation of 
 * the articulation node weight and its hops to the articulation node. 
 **/
package greedyGrowingTree;

import java.util.*;

//ä»…åœ¨Zrä¸­åˆ¤æ–­
public class PilotNode {
	private VNode[] vn;
	private char node;
	private int layer;
	Map<Character,Integer> Pilot = new HashMap<Character,Integer>();
	Map<Character,Integer> result = new HashMap<Character,Integer>();
	int vnodeLen=0;
	public List<Map.Entry<Character,Integer>> IPilotNode(VNode[] v,List<Integer> list,
			List<Character> Zr,List<Map.Entry<Character,Integer>> ArNode) throws Exception{
/*		System.out.println("The Link from PilotNode:");
		VNode[] vv=v;
		for(int i=0;i<vv.length;i++){
			System.out.print(vv[i].from+" ");
			while(vv[i].first!=null){
				System.out.print(vv[i].first.to+" ");
				vv[i].first=vv[i].first.next;
		}
		System.out.println();	
		}*/
		//é��åŽ†ArNodeèŠ‚ç‚¹ï¼Œåˆ†å±‚æŸ¥æ‰¾æœ€çŸ­è·¯å¾„ä¸Šçš„èŠ‚ç‚¹
		vnodeLen=v.length;
	//	System.out.println("I am the IPilotNode test");
		for(int i=0;i<ArNode.size();i++){
			Draw G = new Draw();
			vn= G.DrawG();
			int j=1;
			
			for(;j<vnodeLen;j++){  //å�–ArNodeç»“ç‚¹åœ¨VNodeä¸­çš„åº�å�·
				if(vn[j].from==ArNode.get(i).getKey())
					{
						node=vn[j].from;
						layer=list.get(j);
						break;
					}
			}
			int p=1;
				
				//é€�å±‚æŸ¥æ‰¾pilontèŠ‚ç‚¹
				while(node!=vn[0].from){ //nodeä¸�ä¸ºsinkèŠ‚ç‚¹ 
					int q=0;
					for(q=0;q<vnodeLen;q++){
						if(node==vn[q].from)break;
					}
					Edge e=vn[q].first;
					while(e!=null){ //è‹¥vn[q].fromçš„é‚»å±…èŠ‚ç‚¹ä¸�ä¸ºç©º
						//å¦‚æžœè¯¥èŠ‚ç‚¹ä¸ºArNodeèŠ‚ç‚¹åˆ™è·³è¿‡è¯¥èŠ‚ç‚¹
				//		boolean flag = true;
				//		while(flag){
							for(int n=0;n<ArNode.size();n++){
								if(ArNode.get(n).getKey()==e.to){
									vn[q].first=vn[q].first.next;
						//			flag = true;
								}
						//		else {
						//				flag=false;
									//	break;
						//		}
							}
				//		}
		
					int k=0;
					for(k=0;k<vnodeLen;k++){ //æŸ¥è¯¢nodeçš„é‚»å±…èŠ‚ç‚¹
						if(e.to==vn[k].from)break;
					}
					if(list.get(k)==layer-p&&layer-p>0){ //å¦‚æžœvn[j].fromçš„é‚»å±…èŠ‚ç‚¹æ‰€åœ¨å±‚æ•°ä¸ºlayer-p åˆ™è®°ä¸ºPilotèŠ‚ç‚¹
						{
							result.put(vn[k].from,ArNode.get(i).getValue()+(layer-list.get(k)));//map.getè¿”å›žæŒ‡å®šé”®å¯¹åº”çš„å€¼
							p++;
							node=vn[k].from; //å°†nodeèµ‹å€¼ä¸ºå½“å‰�pilotèŠ‚ç‚¹
//							e=null;
					//		break; //æ‰¾åˆ°ä¸Šä¸€å±‚åˆ™è¿›å…¥ä¸Šä¸Šå±‚æŸ¥æ‰¾
						}
					}
					else e=e.next;
				}
				
			}
		
		}
		//ä¿�ç•™æ—¢åœ¨resultä¸­çš„èŠ‚ç‚¹å�ˆåœ¨Zrä¸­çš„èŠ‚ç‚¹
		Set<Map.Entry<Character, Integer>> resultEntry = result.entrySet();  //mapçš„entrySetæ–¹æ³•
		for(Map.Entry<Character, Integer> rentry:resultEntry){
			for(int j=0;j<Zr.size();j++){
				if(rentry.getKey()==Zr.get(j))
					Pilot.put(rentry.getKey(),rentry.getValue());
			}
		}
		//åŽ»é™¤Pilotä¸­åœ¨ArticulationNodeä¸­çš„èŠ‚ç‚¹
		Set<Map.Entry<Character, Integer>> resultEntry2 = Pilot.entrySet();
		for(Map.Entry<Character, Integer> rentry1:resultEntry2){
			for(int j=0;j<ArNode.size();j++){
				if(rentry1.getKey()==ArNode.get(j).getKey())Pilot.remove(rentry1.getKey());
			}
		}
		//hashmapæ— æ³•æ·»åŠ ç›¸å�Œçš„key,å¦‚æžœkeyç›¸å�Œåˆ™è¦†ç›–ä¹‹å‰�çš„key value.
		//æŒ‰valueæŽ’åº�.
		List<Map.Entry<Character,Integer>> resultNodes= 
			new ArrayList<Map.Entry<Character,Integer>>(Pilot.entrySet()); 
		
		Collections.sort(resultNodes, new Comparator<Map.Entry<Character, Integer>>() {   
		    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {      
		        //return (o2.getValue() - o1.getValue()); 
		        return (o1.getValue().compareTo(o2.getValue()));
		    }
		}); 
		
		return resultNodes;
	}
	
}
