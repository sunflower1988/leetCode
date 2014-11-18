package leetcode;

public class MinStack3_Array {
	private	int[] arrs = new int[5];   
	private int[] minArrs = new int[5];
	int size=0;
	int minsize=0;
	int min=0;
	public static void main(String[] args){

		MinStack3_Array ms = new MinStack3_Array();
		ms.push(395);
		System.out.println("getmin "+ms.getMin());
		ms.top();
		System.out.println("top "+ms.top());
		ms.push(276);
		ms.push(29);
		System.out.println("getmin "+ms.getMin());
		ms.push(-428);
		System.out.println("getmin "+ms.getMin());
		ms.pop();
		ms.push(-108);
		ms.push(-251);
		System.out.println("getmin "+ms.getMin());
		ms.push(-439);
		System.out.println("top "+ms.top());
		ms.push(370);
		ms.pop();
		ms.pop();
		System.out.println("getmin "+ms.getMin());
		ms.pop();
		System.out.println("getmin "+ms.getMin());
		System.out.println("getmin "+ms.getMin());
		ms.pop();
		System.out.println("getmin "+ms.getMin());
		ms.push(-158);
		ms.push(82);
		ms.pop();
		ms.push(-176);
		System.out.println("getmin "+ms.getMin());
	}

	public void push(int x){
		if(size>=arrs.length)resize();  
		arrs[size++]=x;
		if(size-1==0){
		   	minArrs[minsize++]=x;
		}  
		else if(x<=minArrs[minsize-1]){
		    if(minsize>=minArrs.length)resize1();
			minArrs[minsize++]=x;
		}
		
	}
	public void pop(){
	    if(minArrs[minsize-1]==arrs[size-1])minsize--;
		if(size!=0)size--;
	}
	public int top(){
		if(size!=0)return arrs[size-1];
		return -1;
	}
	public int getMin(){
		if(size!=0)
			return minArrs[minsize-1];
		return -1;
	}
	public void resize(){
		int[] temp =new int[arrs.length*2];
		for(int i=0;i<arrs.length;i++){
			temp[i]=arrs[i];
		}
		arrs=temp;
	}
	public void resize1(){
		int[] temp =new int[minArrs.length*2];
		for(int i=0;i<minArrs.length;i++){
			temp[i]=minArrs[i];
		}
		minArrs=temp;
	}
}

