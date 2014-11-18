package leetcode;
import java.util.Stack;

public class MinStack4_API {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> t = new Stack<Integer>();
	
	public static void main(String[] args){
		MinStack4_API msA = new MinStack4_API();
		msA.push(1);
		msA.pop();
		msA.push(2);
		System.out.println(msA.getMin());
	}
	public void push(int x){
		s.push(x);
		if(t.isEmpty()||x<=t.peek())t.push(x); //***//
	}
	public void pop(){
		if (s.pop().equals(t.peek())) t.pop(); //***//
	}
	public int top(){
		return s.peek();
	}
	public int getMin(){
		return t.peek();
	}
}
