package thinkingInJavaPractice;
class Tax{
	float tax;
}
public class Alias {
	public static void main(String[] args){
		Tax t1 = new Tax();
		Tax t2 = new Tax();
		t1.tax=100f;
		t2.tax=(float)200;
		System.out.println("t1="+t1.tax + " t2="+t2.tax);
		t1.tax=t2.tax;
		t2.tax=300;
		System.out.println("t1="+t1.tax+" t2="+t2.tax);
	}
}
