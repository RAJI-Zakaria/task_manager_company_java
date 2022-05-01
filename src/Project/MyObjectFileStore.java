package Project;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class MyObjectFileStore {
	  public void storeObject(Projet project){
	         
	        FileOutputStream ops = null;
	        ObjectOutputStream objOps = null;
	        try {
	            ops = new FileOutputStream("Project.bin");
	            objOps = new ObjectOutputStream(ops);
	            
	            objOps.writeObject(project);
	            
	            objOps.flush();
	            objOps.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally{
	            try{
	                if(objOps != null) objOps.close();
	            } catch (Exception ex){
	                 
	            }
	        }
	         
	    }
	     
	    public Projet readProjet(){
	         
	        FileInputStream fileIs = null;
	        ObjectInputStream objIs = null;
	        try {
	        	
	            fileIs = new FileInputStream("Project.bin");
	            objIs = new ObjectInputStream(fileIs);
	            Projet obj = (Projet) objIs.readObject();
	           
	            
	            return obj;
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(objIs != null) objIs.close();
	            } catch (Exception ex){
	                 
	            }
	        }
	        
	        return null;
	         
	    }
}
