package Excel_Properties_Files_Operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {
	
	 static File file;
	 
	 public static void main(String[] args)
	    {
	        file = new File("Excel_Files/Write.properties");
	        Properties table = new Properties();
	        
	        table.setProperty("Chambu","Bane");
	        
	        table.setProperty("Bamboo","Maverick");
	        
	        System.out.println("Properties has been set in HashTable: " + table);
	        // saving the properties in file
	        saveProperties(table);
	        // changing the property
	        table.setProperty("Chambu", "Swagger");
	        System.out.println("After the change in HashTable: " + table);
	        // saving the properties in file
	        saveProperties(table);
	        // loading the saved properties
	        loadProperties(table);
	    }

	 
	 
	 
	   public static void saveProperties(Properties p)   {
	        try {
				FileOutputStream fr = new FileOutputStream(file);
				p.store(fr, "Properties");
				fr.close();
				System.out.println("After saving properties: " + p);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    public static void loadProperties(Properties p)
	    {
	        try {
				FileInputStream fi=new FileInputStream(file);
				p.load(fi);
				fi.close();
				System.out.println("After Loading properties: " + p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    

}
