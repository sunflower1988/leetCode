package greedyGrowingTree;
import java.util.*;

class GGT{
	private VNode[] V,v,vn;
	public int r =1;
	public int Edgenum,Nodenum;
	public List<Character> SortResult = new ArrayList<Character>() ;

	public GGT()throws Exception{						//å»ºå›¾
		Draw G = new Draw();
		V= G.DrawG();    
		Edgenum = G.edgeNum;
		Nodenum = G.nodeNum;
		//Clone
	/*	myClone c = new myClone();
		c.setvClone(V);
		v=(VNode[])c.clone();*/
		vn = V;	//å¼•ç”¨å�˜é‡�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�ï¼�
		ControlGGT();
		}
	
	public void ControlGGT()throws Exception{
		List<Character> Tr = new ArrayList<Character>();
		List<Character> Zr = new ArrayList<Character>();
		List<Character> Sr = new ArrayList<Character>();
		List<Character> Dr = new  ArrayList<Character>();
/*		System.out.println("The Link from GreedyGrowingTree:");
		VNode[] vvv=V;
		for(int i=0;i<vvv.length;i++){
			System.out.print(vvv[i].from+" ");
			while(vvv[i].first!=null){
				System.out.print(vvv[i].first.to+" ");
				vvv[i].first=vvv[i].first.next;
			}
			System.out.println();	
		}*/
		Tr.add(vn[0].from); //Tr[0]å¿…é¡»ä¸ºæ ¹èŠ‚ç‚¹
//		System.out.println(Tr.get(0));
		int k=0;
		while(Tr.size()!=Nodenum){	
			Draw G = new Draw();
			vn= G.DrawG(); 
			Zr.clear();
			Dr.clear();
			Sr.clear();
			for(int i=0;i<Tr.size();i++){       //Trä¸­æ¯�ä¸€ä¸ªèŠ‚ç‚¹æŸ¥æ‰¾å…¶å­�èŠ‚ç‚¹
				k=0;
				while(k<Nodenum){
					if(vn[k].from==Tr.get(i)){ 		//å°†Tr.get(i)ä¸­å…ƒç´ ä¸Žvn[k].fromç›¸å¯¹åº”
						while(vn[k].first!=null){	//å¦‚æžœvn[k]è¿˜æœ‰å­�æ ‘
							if(!Tr.contains(vn[k].first.to)&&!Zr.contains(vn[k].first.to)){ //è¯¥èŠ‚ç‚¹ä¸�åœ¨Trä¸­
								Zr.add(vn[k].first.to);	//å°†vn[k]çš„å­�æ ‘æ”¾å…¥zrä¸­
								vn[k].first = vn[k].first.next; //vnç»“æž„æœ‰å�˜
							}
							else 
								vn[k].first = vn[k].first.next;
						}
						break;
					}
					k++;
				}
			}
//			System.out.print("Zr:");
//			System.out.print(" "+Zr.size());
/*			for(int i=0;i<Zr.size();i++){
				System.out.print(Zr.get(i));
			}
			System.out.println();
*/
			//åŽ»é‡�
			NoDuplicates noDu = new NoDuplicates();
			Zr=noDu.INoDuplicate(Zr);
			
			//æŒ‰ç…§è¦�æ±‚æŽ’åº�
	    	SortZr sort = new SortZr(); 
	    	Draw GG = new Draw();
			v= GG.DrawG();    
			SortResult=sort.ISortZr(v, Tr, Zr);
			System.out.print("SortResult:");
			for(int i=0;i<SortResult.size();i++)
				System.out.print(SortResult.get(i)+" ");
			System.out.println();
			
			int p=0;
			char z;
			List<Character> Neibor = new ArrayList<Character>();
			List<Character> D = new ArrayList<Character>();
			//é€‰æ‹©Zrä¸­çš„èŠ‚ç‚¹æ”¾å…¥Træˆ–Srã€�Drä¸­
			while(Sr.size()!=SortResult.size()&&p<SortResult.size()){
				if(!Sr.contains(SortResult.get(p))){ //SortResultä¸­èŠ‚ç‚¹ä¸�åœ¨Srä¸­ node in Zr/Sr
					z=SortResult.get(p);
					Neibor = Neighbor(v,z,Tr);//zåœ¨Trä¸­çš„neighbor dçš„é›†å�ˆ
					if(Neibor!=null){
						D.clear();
						D = NeighborNum(Neibor,SortResult);
						InterferenceJudge interfere = new InterferenceJudge();
						for(int i=0;i<D.size();i++){
							if(interfere.IInterferenceJudge(Sr,Dr,z,D.get(i))){
//								D.remove(i);//Neibor(z,Tr)<-Neibor(z,Tr)\d
								continue; 
							}
							else{
								Sr.add(z);
								Dr.add(D.get(i));
								break;
							}
						
					}
					//	SortResult.remove(p);
						p++;  //??????
					}
				}
				else {
					p++;
					continue;
				}
			}
			for(int mm=0;mm<Sr.size();mm++){
				if(!Tr.contains(Sr.get(mm)))
					Tr.add(Sr.get(mm));
			}
			
			r++;	
			System.out.print("Sr: ");
			for(int i=0;i<Sr.size();i++){
				System.out.print(Sr.get(i)+" ");
			}
			System.out.println();
			System.out.print("Dr: ");
			for(int i=0;i<Dr.size();i++){
				System.out.print(Dr.get(i)+" ");
			}
			System.out.println();
			System.out.println("*********The "+r+" Round***********");
			
		}
		System.out.println("r = "+r);
	}
	
	//ï¿½ï¿½ï¿½ï¿½Neiborï¿½ï¿½dï¿½Ä¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Zrï¿½ï¿½ï¿½Ú¾Ó½Úµï¿½ï¿½ï¿½ï¿½Ä½Úµï¿½
	public List<Character> NeighborNum(List<Character> Neibor,List<Character> Zr) throws Exception{
		int num=0;
		Draw GG = new Draw();
		VNode[] vv= GG.DrawG();
		int[] neiNum = new int[Neibor.size()];
//		List<Character> temp = new ArrayList<Character>();
		for(int i=0;i<Neibor.size();i++){  //Neiborï¿½ï¿½vï¿½Ð½Úµï¿½Æ¥ï¿½ï¿½ï¿½ï¿½ï¿½Ú²ï¿½ï¿½ï¿½Neiborï¿½Ðµï¿½ï¿½Ú¾Ó½Úµï¿½
			for(int j=0;j<Nodenum;j++){
				if(Neibor.get(i)==vv[j].from){  //ï¿½ï¿½ï¿½Òµï¿½Neibo[i]ï¿½ï¿½vnï¿½Ð¶ï¿½Ó¦ï¿½ï¿½Ôªï¿½ï¿½
					while(vv[j].first!=null){
						for(int k=0;k<Zr.size();k++){
							if(vv[j].first.to==Zr.get(k)){ //È¡vn[j].first.toï¿½ï¿½Ôªï¿½ï¿½ï¿½ï¿½Zrï¿½Ð±È½ï¿½
								neiNum[num]++; 
					//			temp.add(Zr.get(k));
							}
						}
						vv[j].first = vv[j].first.next;
					}
					num++;
				}
				else continue;
			}
		}
		//æ ¹æ�®Neiborçš„Neibornumå¯¹NeiboræŽ’åº�    //ä»Žå°�åˆ°å¤§
		int p=0,q=0;
		char tmp;
		for(p=neiNum.length-1;p>0;--p){
			for(q=0;q<p;++q){
				if(neiNum[q+1]<neiNum[q]){
					tmp = Neibor.get(q);
					Neibor.add(q, Neibor.get(q+1));
					Neibor.add(q+1,tmp);
				}
			}
		}
		return Neibor;
	}
	
	//zåœ¨Trä¸­çš„neibor
	public List<Character> Neighbor(VNode[] vv,char z,List<Character> Tr) throws Exception{
		List<Character> Neibor = new ArrayList<Character>();
		//heap OutOfMemory
	/* int i=0; 
		for(i=0;i<Nodenum;i++){
			if(vv[i].from==z)break;
		}
		Edge e =  vv[i].first;
		while(e!=null)
		{
			if(Tr.contains(e.to)){
				Neibor.add(e.to);
			}
			else
				e=e.next;
		}*/
		for(int i=0;i<Nodenum;i++){
			if(z==vv[i].from){	
				Edge e=vv[i].first;
				while(e!=null){
					for(int k=0;k<Tr.size();k++){	
						if(e.to==Tr.get(k)){  
							Neibor.add(Tr.get(k));
							break;
						}
					}
						e=e.next;
				}
			}
		}
		return Neibor;
	}
	
}
public class GreedyGrowingTree {
	public static void main(String[] args) throws Exception{
		GGT G = new GGT();
	}
}	
