package greedyGrowingTree;
import java.util.*;
public class InterferenceJudge {
	char p;
	VNode[] v;
	public boolean IInterferenceJudge(List<Character> Sr,List<Character> Dr,char z,char d) throws Exception{
		
		for(int i=0;i<Sr.size();i++){
		/*	for(int m=0;m<Dr.size();m++){   //Sr��parents
				if(Dr.get(m)==Sr.get(i))
					p=Sr.get(m);
			}*/
			p=Dr.get(i);
			if(HasEdge(p,z)){	 //�ж�p��z��û�б�
				return true;
			}            
			if(HasEdge(Sr.get(i),d)){
				return true;
			}
		}
			return false;
		}
	public boolean HasEdge(char p,char z) throws Exception{
		Draw G = new Draw();
		v= G.DrawG(); 
		for(int i=0;i<v.length;i++){
			if(v[i].from==p){
				for(int j=0;j<v[i].degreeNum;j++){
					if(v[i].first.to==z)return true;
					else
						v[i].first=v[i].first.next;
				}
			}
			else continue;
		}
		return false;
	}
}

