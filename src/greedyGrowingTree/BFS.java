package greedyGrowingTree;
import java.util.*;
//ç»™æ‰€æœ‰ç»“ç‚¹åˆ†å±‚æ ‡å�·
public class BFS {
	VNode[] v;
	List<Integer> zr=new ArrayList<Integer>();
	List<Integer> arNode = new ArrayList<Integer>();
	
	BFS(VNode[] v){
		this.v=v;
	}
	   public List<Integer> BFSearch(){ //é˜Ÿåˆ—å¹¿åº¦ä¼˜å…ˆæ�œç´¢
		   	 int cc;
		   	 
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
		       
		          Edge e=v[i].first;
		      while(e!=null){
		    	   for(j=0;j<v.length;j++){
				    	 if(v[j].from==e.to)break;
				     }
		  
		          if((j<v.length&&!v[j].visit)&&(!que.contains(e.to))){
		        	  que.add(e.to);
		        	  int k = list.get(i)+1;
		        	  list.set(j,k);
		          }
		          e=e.next;
		      }
		    
		    }
	   }
	/*	     System.out.println("èŠ‚ç‚¹ä¾�æ¬¡å±‚å�·ï¼š");
		     for(int i=0;i<list.size();i++){
		    	 System.out.print(list.get(i)+" ");
		     }
		     System.out.println();*/
		     return list;  
	   }
}
