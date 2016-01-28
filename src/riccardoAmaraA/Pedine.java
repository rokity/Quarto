package riccardoAmaraA;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.ArrayList;

public class Pedine {
	
	private String path;
	
	public Pedine(String p) {
		this.path= p;
	}
	
  public void scritturaFilePedine() {
	  
	  
    try {
    	File a = new File(this.path);
    			a.delete();
    			
      FileOutputStream pedine = new FileOutputStream(this.path);
      PrintStream scrivi = new PrintStream(pedine);
      
      
    scrivi.println("AWTF*\nANTF\nAWQF\nANQF\nAWTP\nANTP\nAWQP\nANQP\nBWTF\nBNTF\nBWQF\nBNQF\nBWTP\nBNTP\nBWQP\nBNQP");
      
    } catch (IOException e) {
      System.out.println("Errore: " + e);
      System.exit(1);
    }
  }

public boolean esistenzaFile() {
	// TODO Auto-generated method stub
	File a = new File(this.path);
	
	return a.exists();
} 

public boolean leggibilitaFile() {
	// TODO Auto-generated method stub
	
	
		FileReader f;
		ArrayList<String> doppioni = new ArrayList<String>();
	    try {
			f=new FileReader(path);
	    BufferedReader b;
	    b=new BufferedReader(f);    
	    String s=" ";	    
	    while(s==null) {
	      s=b.readLine();
	       if (s.length()>4 || s.length()<4)
	    	  return false;	      
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
			   if (l == doppioni.get(x)){
				   			return false;
			   }
			  }
		   }
	
	
	return true;
}

public boolean turno() {
	
	FileReader f;
	int i=0;
	try {
		f=new FileReader(this.path);
		BufferedReader b;
	    b=new BufferedReader(f);
	    String s=" ";	
	    
	    while(s==null) {
	      s=b.readLine();
	      i++;
	      
	    }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		return false;
	}
    
	 i=i-1;
    if (i==16)
    	return false;//partita non iniziata
    else
    	return true;//partita iniziata
    
}



public String scegliPedina(){
	FileReader f;
	
    String appoggio=null;
	ArrayList<String> file = new ArrayList<String>();
	
	try {
		f=new FileReader(this.path);
		BufferedReader b;
	    b=new BufferedReader(f);
	    String s=" ";	
	    
	    while(s==null) {
	      s=b.readLine();
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
	    
	    while(s==null) {
	      s=b.readLine();
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
	
    String appoggio=null;
	ArrayList<String> file = new ArrayList<String>();
	
	
		try {
			f=new FileReader(this.path);
		
		BufferedReader b;
	    b=new BufferedReader(f);
	    String s=" ";	
	    
	    while(s==null) {
	      s=b.readLine();
	      if(s==pedina)
	      file.add(s+"*");
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
		return true;
}




}