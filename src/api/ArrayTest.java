package api;
/**
 * 
 * @author I312902
 * 空引用 会产生运行时错误
 */
public class ArrayTest {
	static char[] bbb; 
	public static void main(String[] args){
		char[] aaa={'a','a','a'};
		char ccc[];
		System.out.println(aaa);
		//System.out.println(bbb);
		//System.out.println(ccc);
		Integer.parseInt("123");   //java.lang自动被包含
		System.getProperties().list(System.out);
	}
}
