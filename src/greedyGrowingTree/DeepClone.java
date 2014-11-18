package greedyGrowingTree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeepClone{
	  public  VNode getObject(VNode obj){  
	        VNode cloneobj = null;  
//	        ByteArrayInputStream bin = null;  
	        ByteArrayOutputStream bout = null;  
	        try {  
	            //æŠŠå¯¹è±¡å¯¹åˆ°å†…å­˜ä¸­åŽ»  
	            bout = new ByteArrayOutputStream();  
	            ObjectOutputStream oos = new ObjectOutputStream(bout);  
	            oos.writeObject(obj);  
	            oos.close();  
	            //æŠŠå¯¹è±¡ä»Žå†…å­˜ä¸­è¯»å‡ºæ�¥            
	            ByteArrayInputStream bais = new ByteArrayInputStream(bout.toByteArray());  
	            ObjectInputStream ois = new ObjectInputStream(bais);  
	            cloneobj = (VNode)ois.readObject(); 
	            ois.close();  
	            return cloneobj;  
	        } catch (IOException e) {  
	    
	            e.printStackTrace();  
	        } catch (ClassNotFoundException e) {  
	      
	            e.printStackTrace();  
	        }  
	        return cloneobj;  
	    }  
}