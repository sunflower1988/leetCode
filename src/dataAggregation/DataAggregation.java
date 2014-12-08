package dataAggregation;

import java.io.FileNotFoundException;
/*
 * Main
 */

public class DataAggregation {
	public static void main(String[] args) throws FileNotFoundException{
		DrawGraph dg = new DrawGraph();
		InitialSolution is = new InitialSolution(dg.DrawG());
		is.ResultTree();
	}
}
