/**
 * If G becomes disconnected when we remove node i from G,
 * then i is called an articulation node;
 * its weight can be calculated as how many nodes ar isolated
 * from b because of its removal.
 */
package greedyGrowingTree;
import java.util.*;

public class ArticulationNode {
		private VNode[] V;
		private int cnt; //cntæŽ§åˆ¶åº�å�·é€’å¢ž
		int[] ord,low;
		Map<Integer,Integer> result = new HashMap<Integer,Integer>();
		Map<Integer,Integer> tempResult = new HashMap<Integer,Integer>();
		Map<Integer,Integer> Articulation = new HashMap<Integer,Integer>();
		
		ArticulationNode(VNode[] v){
			V = v;
			cnt=0;
			ord = new int[V.length];
			low = new int[V.length];
				for(int i=0;i<V.length;i++){
					ord[i] = -1;
					low[i] = -1;
				}

		}
		
	//æ·±åº¦ä¼˜å…ˆæ�œç´¢åˆ¤æ–­å…³é”®ç‚¹
	public Map<Integer,Integer> DFSSearch(int from,int to)throws Exception{
		int w = to;
		int NodeIFrom,NodeITo;
		for(NodeIFrom=0;NodeIFrom<V.length;NodeIFrom++){ //foræŸ¥æ‰¾wä¸ŽVä¸­å¯¹åº”èŠ‚ç‚¹åº�å�·NodeIFrom
//			System.out.println(V[NodeIFrom].from);
			if(V[NodeIFrom].from == w)break;
			}
		ord[NodeIFrom]=cnt++;
		low[NodeIFrom] = ord[NodeIFrom];
		Edge A = V[NodeIFrom].first;
	
	//	for(char t = A.to;A!=null;t = A.next.to){ 
		while(A!=null){
			int t=A.to;
		
			for(NodeITo=0;NodeITo<V.length;NodeITo++){
				if(V[NodeITo].from == t)break;
				}
				if(NodeITo<V.length&&ord[NodeITo]==-1){
					DFSSearch(V[NodeIFrom].from,V[NodeITo].from);
					if(low[NodeIFrom] > low[NodeITo]) low[NodeIFrom] = low[NodeITo];
					if(low[NodeITo] ==ord[NodeITo]){
						//å�³ordä¸Žlowç›¸ç­‰ï¼Œåˆ™è¯¥èŠ‚ç‚¹è¾¹ä¸ºæ¡¥
						//NodeIFromä¸ŽNodeIToå�‡ä¸ºå…³é”®èŠ‚ç‚¹
						if(NodeIFrom!=0&&V[NodeIFrom].degreeNum>2){  //è¯¥èŠ‚ç‚¹ä¸�ä¸ºæ ¹èŠ‚ç‚¹
							int k=0;
							//é€šè¿‡åŽ»æŽ‰è¯¥èŠ‚ç‚¹è®¡ç®—å­¤ç«‹ç‚¹
							k=cacluWeight(V[NodeIFrom].from);
							Articulation.put(V[NodeIFrom].from,k);
						}
						if(NodeITo!=0&&V[NodeITo].degreeNum>2){
							int m=0;
							m=cacluWeight(V[NodeIFrom].from);
							Articulation.put(V[NodeITo].from, m);
						}
					}
				}
//				else if(t!=V[NodeIFrom].from){
				else if(t!=from){
					if(NodeITo<V.length&&NodeIFrom<V.length&&low[NodeIFrom]>ord[NodeITo]) 
						low[NodeIFrom]=ord[NodeITo];
					}
				A=A.next;
		}
		return Articulation;
	}
	
	public List<Map.Entry<Integer,Integer>> IArticulationNode(List<Integer> Zr) throws Exception{
		
		Map<Integer,Integer> ANode = new HashMap<Integer,Integer>();
		
		for(int i=0;i<V.length;i++){
			if(ord[i]==-1)
			{
				tempResult=DFSSearch(V[i].from,V[i].from);  //è¿”å›žæœ‰é”™
				result.putAll(tempResult);
			}
			
		}
		
	/*	System.out.println("print from IArticulation,ord[],low[]");
			//TEST
		for(int i=0;i<ord.length;i++)
			{
				System.out.print(ord[i]+"  ");
			}
		System.out.println();
		for(int i=0;i<ord.length;i++)
		{
			System.out.print(low[i]+"  ");
		}
		System.out.println();*/
		
		//ä¿�ç•™æ—¢åœ¨resultä¸­çš„èŠ‚ç‚¹å�ˆåœ¨Zrä¸­çš„èŠ‚ç‚¹
		Set<Map.Entry<Integer, Integer>> resultEntry = result.entrySet();  //mapçš„entrySetæ–¹æ³•
		for(Map.Entry<Integer, Integer> rentry:resultEntry){
			for(int j=0;j<Zr.size();j++){
				if(rentry.getKey()==Zr.get(j))
					ANode.put(rentry.getKey(),rentry.getValue());
			}
		}
		//hashmapæ— æ³•æ·»åŠ ç›¸å�Œçš„key,å¦‚æžœkeyç›¸å�Œåˆ™è¦†ç›–ä¹‹å‰�çš„value.
		//æŒ‰valueæŽ’åº� ä»Žå¤§åˆ°å°�.
		List<Map.Entry<Integer,Integer>> resultNodes= 
			new ArrayList<Map.Entry<Integer,Integer>>(ANode.entrySet()); 
		
		Collections.sort(resultNodes, new Comparator<Map.Entry<Integer, Integer>>() {   
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {      
		        //return (o2.getValue() - o1.getValue()); 
		        return (o2.getValue().compareTo(o1.getValue()));
		    }
		}); 
		return resultNodes;
}
	public static void main(String[] args){
		
	}
	//åŽ»æŽ‰æŸ�èŠ‚ç‚¹è®¡ç®—å›¾ä¸­ç‚¹æ•°
	public int cacluWeight(int Node)throws Exception{
		Draw G = new Draw();
		VNode[] vv= G.DrawG();
		int len=vv.length;
		int Weight=0;
		int nodei=0;
		for(nodei=0;nodei<vv.length;nodei++){
			if(vv[nodei].from==Node){
				break;
			}
		}
		for(int k=0;k<len;k++){
			Edge e=vv[k].first;
			Edge prior=vv[k].first;
			while(e!=null){  
				if(e.to==vv[nodei].from){
					if(e==vv[k].first&&e.next!=null){//é¡¶ç‚¹çš„ç¬¬ä¸€æ�¡è¾¹ï¼�
						vv[k].first=e.next;
					}
					else
						if(e.next!=null)
							prior.next=e.next;
						else
							prior.next=null;
				}	
				else
					prior=e;
					e=e.next;
				
			}
			
		}
					//åŽ»æŽ‰vvä¸­çš„è¯¥èŠ‚ç‚¹
					for(int p=nodei;len-1-p>0;p++){
						vv[p]=vv[p+1];
					}
					VNode[] cc=new VNode[vv.length-1];
			    	System.arraycopy(vv, 0, cc, 0, vv.length-1);
		//å¹¿åº¦ä¼˜å…ˆæ�œç´¢é��åŽ†
		int k=0;
		k=BFSearch(cc);
		Weight=len-k-1;
		return Weight;
	}
	   public int BFSearch(VNode[] v){ //é˜Ÿåˆ—å¹¿åº¦ä¼˜å…ˆæ�œç´¢
		   	 int cc;
		   	 int noIsolate=0;
		     Queue<Integer> que=new LinkedList<Integer>();    
		     List<Integer> list = new ArrayList<Integer>();
		     for(int t=0;t<v.length;t++){
		    	 list.add(t,0);
		     }
		     que.add(v[0].from); 
		     list.set(0, 1);
//		     System.out.println("BFS result:");
		     while(!que.isEmpty()){
		    	 int i = 0, j = 0;
		    	 cc=que.poll();    //poll() method is used to retrieve and remove the head of this queue, or returns null if this queue is empty.
		     for(i=0;i<v.length;i++){
		    	 if(v[i].from==cc)break;
		     }
		       if(!v[i].visit){
//		          System.out.print(v[i].from+"  ");
		          v[i].visit=true;
		          noIsolate++;
		          Edge e=v[i].first;
		      while(e!=null){
		    	   for(j=0;j<v.length;j++){
				    	 if(v[j].from==e.to)break;
				     }
		          if((!v[j].visit)&&(!que.contains(e.to))){
		        	  que.add(e.to);
		        	  int k = list.get(i)+1;
		        	  list.set(j,k);
		          }
		          e=e.next;
		      }
		    
		    }
	   }
		     return noIsolate;  
	   }
}
