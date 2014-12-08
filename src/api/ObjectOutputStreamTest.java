package api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ObjectA implements Serializable {    //yiding yao shixian xu lie hua
	ObjectA(){
		String aa = "AHAHA";
		String ss= "Hello World";
	}
}
public class ObjectOutputStreamTest {
	public static void main(String[] args) throws IOException{
		ObjectA OA = new ObjectA();
		System.out.println(OA.toString());
		System.out.println("------------");
		testStream(OA);
		
	}
	public static void testStream(ObjectA OA) throws IOException{
		ByteArrayOutputStream  output = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(output);
		objectOut.writeObject(OA);
		objectOut.close();
		output.close();
		System.out.println(output.toByteArray().toString());
	}
}
