/**
 * the distance from sink b to all nodes can be summed up;
 * if the summation increases when we remove node if from G,
 * then i is called a critical node;
 * its weight can be calculated as the gap between the old summation and new summation.
 */
package greedyGrowingTree;

import java.util.*;
//ä¿®æ”¹è¡¨
public class CriticalNode {
	VNode[] vn;
	public List<Map.Entry<Character,Integer>> ICriticalNode(VNode[] vv,List<Character> Zr,List<Map.Entry<Character,Integer>> ArNode,List<Map.Entry<Character,Integer>> PiNode) throws Exception{
		//ç­›é€‰æ—¢ä¸�åœ¨ArNodeå�ˆä¸�åœ¨PiNodeä¸­çš„èŠ‚ç‚¹ä½†åœ¨Zrä¸­çš„èŠ‚ç‚¹
		List<Integer> list = new ArrayList<Integer>();
		Map<Character,Integer> Critical = new HashMap<Character,Integer>();
		int sum=0;
		for(int i=0;i<ArNode.size();i++){
			for(int j=0;j<Zr.size();j++){
				if(ArNode.get(i).getKey()==Zr.get(j))Zr.remove(j);
			}
		}
		for(int i=0;i<PiNode.size();i++){
			for(int j=0;j<Zr.size();j++){
				if(PiNode.get(i).getKey()==Zr.get(j))Zr.remove(j);
			}
		}
        //è®¡ç®—åŽŸå›¾ä¸­çš„distanceä¹‹å’Œ
		BFS bfs = new BFS(vv);
		list=bfs.BFSearch();
		for(int i=0;i<list.size();i++){
			int temp=list.get(i);
			while(temp>0){
				sum=sum+temp;
				temp--;
			}
		}
		//ä¾�æ¬¡åŽ»æŽ‰Zrä¸­é™¤åŽ»ArNode,PiNodeèŠ‚ç‚¹å‰©ä½™èŠ‚ç‚¹ï¼Œè®¡ç®—distanceä¹‹å’Œ
		for(int i=0;i<Zr.size();i++){//ä¾�æ¬¡åŽ»æŽ‰åœ¨vn[]ä¸­çš„æŸ�èŠ‚ç‚¹
			Draw G3 = new Draw();
			vn= G3.DrawG();
			int len=vn.length;
			int j=0;
			for(j=0;j<len;j++){//æ‰¾åˆ°è¯¥èŠ‚ç‚¹åŒ¹é…�èŠ‚ç‚¹
				if(Zr.get(i)==vn[j].from){ //åŽ»æŽ‰è¯¥èŠ‚ç‚¹é‡�æ–°å¹¿åº¦ä¼˜å…ˆæ�œç´¢  vn[j].from=c???
					break;
				}
			}
				//åŽ»æŽ‰å�„å­�èŠ‚ç‚¹ä¸Žè¯¥èŠ‚ç‚¹çš„è¾¹
			for(int k=0;k<len;k++){
				Edge e=vn[k].first;
				Edge prior=vn[k].first;
				while(e!=null){  
					if(e.to==Zr.get(i)){
						if(e==vn[k].first&&e.next!=null){//é¡¶ç‚¹çš„ç¬¬ä¸€æ�¡è¾¹ï¼�
							vn[k].first=e.next;
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
						//åŽ»æŽ‰vnä¸­çš„è¯¥èŠ‚ç‚¹
						for(int p=j;len-1-p>0;p++){
							vn[p]=vn[p+1];
						}
						VNode[] cc=new VNode[vn.length-1];
				    	System.arraycopy(vn, 0, cc, 0, vn.length-1);
					
				
			//å¯¹vnå¯¹åº”çš„æ–°å›¾æ±‚list
			BFS b = new BFS(cc);
			List<Integer> l = new ArrayList<Integer>();
			l=b.BFSearch();
			int sum1=0,temp=0;
			for(int m=0;m<l.size();m++){
				temp=list.get(i);
				while(temp>0){
					sum1=sum1+temp;
					temp--;
				}
			}
			if(sum1>sum)Critical.put(Zr.get(i),sum1-sum);
		}
	
		//æ ¹æ�®valueæŽ’åº�
		List<Map.Entry<Character,Integer>> resultNodes= 
			new ArrayList<Map.Entry<Character,Integer>>(Critical.entrySet()); 
		
		Collections.sort(resultNodes, new Comparator<Map.Entry<Character, Integer>>() {   
		    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {      
		        //return (o2.getValue() - o1.getValue()); 
		        return (o1.getValue().compareTo(o2.getValue()));
		    }
		}); 
		return resultNodes;
	}
}
