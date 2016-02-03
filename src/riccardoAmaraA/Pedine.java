package riccardoAmaraA;


import java.io.*;
import java.util.ArrayList;

public class Pedine {
	
	private String path;
	
	public Pedine(String p) {
		this.path= p;
	}
	


public boolean esistenzaFile() {
	// TODO Auto-generated method stub
	FileReader f;	
    try {
		f=new FileReader(path);
    BufferedReader b=new BufferedReader(f);    
    String s=" ";	    
    while((s=b.readLine())!=null) {          
      
    }    
   
    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
    	return false;
	} catch (IOException e) {
		return false;
	}
    return true;
    
} 

public boolean leggibilitaFile() {
		
	
		FileReader f;
		ArrayList<String> doppioni = new ArrayList<String>();
	    try {
			f=new FileReader(path);
	    BufferedReader b=new BufferedReader(f);    
	    String s=" ";	    
	    while((s=b.readLine())!=null) {
	      //s=b.readLine();
	       
	    doppioni.add(s);    
	      
	    }    
	   
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
	    	return false;
		} catch (IOException e) {
			return false;
		}
	    
	    
	    for(int i=0; i<doppioni.size(); i++) {	
		    String l = doppioni.get(i);
			   for (int x=0; x<doppioni.size(); x++) {
				   if(i!=x){
			   if (l == doppioni.get(x)){
				   			return false;
			   }
				   }
			  }
		   }
	
	
	return true;
}





public String dammiPedinaScelta(){
	FileReader f;
	
    String appoggio=null;
	ArrayList<String> file = new ArrayList<String>();
	
	try {
		f=new FileReader(this.path);
		BufferedReader b;
	    b=new BufferedReader(f);
	    String s=" ";	
	    
	    while((s=b.readLine())!=null) {
	     
	      int x=s.indexOf('*');
	     if (x != -1)
	    	 appoggio = s.substring(0,4);
	     else
	    	 file.add(s);
	     
	    }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		return null;
	}
    File eliminaFile = new File (this.path);
    eliminaFile.delete();
    
    
    FileOutputStream pedine;
	try {
		pedine = new FileOutputStream(this.path);
		PrintStream scrivi = new PrintStream(pedine);
		for(int i=0; i<file.size(); i++){
			scrivi.println(file.get(i));
		}
			
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
	return appoggio;
	
	
	
}





public ArrayList<String> getPedine(){
	
FileReader f;
	
    String appoggio=null;
	ArrayList<String> file = new ArrayList<String>();
	
	
		try {
			f=new FileReader(this.path);
		
		BufferedReader b;
	    b=new BufferedReader(f);
	    String s=" ";	
	    
	    while((s=b.readLine())!=null) {
	     
	      file.add(s);
	    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	
}


public boolean inserisciAsterisco(String pedina){
FileReader f;
	boolean check=false;
    
	ArrayList<String> file = new ArrayList<String>();
	
	
		try {
			f=new FileReader(this.path);
		
		BufferedReader b;
	    b=new BufferedReader(f);
	    String s=" ";	
	    
	    while((s=b.readLine())!=null) {
	     
	      if(s.equals(pedina)){	    	  
	      file.add(s+"*");
	      check=true;
	      }
	      else
	    	  file.add(s);
	    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
		try {
	    	File a = new File(this.path);
	    			a.delete();
	    			
	      FileOutputStream pedine = new FileOutputStream(this.path);
	      PrintStream scrivi = new PrintStream(pedine);
	      
	      for(int i=0;i<file.size();i++)
	    	  scrivi.println(file.get(i));
	      
	    } catch (IOException e) {
	      return false;
	    }
		return check;
}




}