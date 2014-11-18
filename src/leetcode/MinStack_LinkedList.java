package leetcode;

/*****Time limited exceeded****/


import java.util.LinkedList;
import java.util.List;

public class MinStack_LinkedList {
	
	List<Integer> list = new LinkedList<Integer>();
	public static void main(String[] args){
		int pre=(int) System.currentTimeMillis();
		MinStack_LinkedList ms = new MinStack_LinkedList();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(1);
		System.out.println(ms);
		ms.pop();
		System.out.println(ms);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		int post=(int) System.currentTimeMillis();
		int time = post-pre;
		System.out.println(time);
		}
    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        int min = list.get(list.size()-1) ;
        for(int i=1;i<list.size();i++){
        	if(list.get(i)<min)min=list.get(i);
    }
        return min;
    }
}
