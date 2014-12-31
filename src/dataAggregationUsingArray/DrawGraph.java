package dataAggregationUsingArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Vertex{
	int[] vertexSet = new int[2];
}
public class DrawGraph {
	int nodeNum,edgeNum;
	Vertex[] v;
	public Vertex[] drawGraph() throws FileNotFoundException{
		Scanner sc = new Scanner(new File("C:/Users/i312902/Private/algorithm/test.txt"));   //from 0 to n
		nodeNum=sc.nextInt();
		edgeNum = sc.nextInt();
		v = new Vertex[edgeNum];
		for(int i=0;i<edgeNum;i++){
			v[i].vertexSet[0]=sc.nextInt();
			v[i].vertexSet[1]=sc.nextInt();
		}
		System.out.println("("+v);
		return v;
	} 
	public static void main(String[] args) throws FileNotFoundException{
		DrawGraph d = new DrawGraph();
		Vertex[] vv = d.drawGraph();
		System.out.print(vv);
	}
}
