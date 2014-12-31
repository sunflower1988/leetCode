package dataAggregation;

import java.io.FileNotFoundException;
/*
 * Main
 */
import java.util.ArrayList;
import java.util.List;

public class DataAggregation {
	static List<VNode> list = new ArrayList<VNode>();
	public static void main(String[] args) throws FileNotFoundException{
		DrawGraph dg = new DrawGraph();
		InitialSolution is = new InitialSolution(dg.DrawG());
		list=is.ResultTree();
		for(int i=0;i<list.size();i++)
		{
			System.out.println("node "+list.get(i).from+"  father "+list.get(i).father+" round "+list.get(i).round);
		}
	}
}
