package leetcode;

public class MinStack2{
	private Object[] objs = new Object[16];   //Array[Object]
	private int size = 0;             //the array do not use the length,but a flag size
	public static void main(String[] args){
		int pre=(int) System.currentTimeMillis();
		MinStack2 ms = new MinStack2();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(1);
		System.out.println(ms);
		ms.pop();
		System.out.println(ms);
		System.out.println(ms.top());
		System.out.println(ms);
		System.out.println(ms.getMin());
		int post=(int) System.currentTimeMillis();
		int time = post-pre;
		System.out.println(time);
	}
	public boolean isEmpty() {  
		 return size == 0;  
	}
	public void clear() {  
		for (int i = 0; i < size; i++) {  
			 objs[size] = null;  
		}
		size = 0;  
	}
	public int length() {  
		 return size;  
	}
	public boolean push(int data) {  
		if (size >= objs.length) {  
			resize();  
		}
		objs[size++] = data;  
		return true;  
	}
	 private void resize() {  
	        Object[] temp = new Object[objs.length * 3 / 2 + 1];  
	        for (int i = 0; i < size; i++) {  
	            temp[i] = objs[i];  
	            objs[i] = null;  
	        }  
	        objs = temp;  
	    }  
	 public void pop() {  
	        if (size != 0) {  
	        	size--;
	        }  
	       
	    }  
	 public int top(){
		 if(size == 0)
			 return (Integer)null;
		 return (Integer)objs[size-1];
	 }
	 public int getMin(){
		 int min=(Integer)objs[0];
		 for(int i=1;i<size;i++){
			 if((Integer)objs[i]<min)min=(Integer)objs[i];
		 }
		 return min;
	 }
	  public String toString() {  
	        StringBuilder sb = new StringBuilder();  
	        sb.append("MyArrayStack: [");  
	        for (int i = 0; i < size; i++) {  
	            sb.append(objs[i].toString());  
	            if (i != size - 1) {  
	                sb.append(", ");  
	            }  
	        }  
	        sb.append("]");  
	        return sb.toString();  
	    }
}
