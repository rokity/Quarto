package riccardoAmaraA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Scacchiera{
	private String path;
	public Scacchiera(String p) {
		this.path= p;
	}
	
	public void creaScacchiera() throws FileNotFoundException{
		File f=new File(this.path);
		f.delete();
		
		FileOutputStream prova = new FileOutputStream(this.path);
        PrintStream scrivi = new PrintStream(prova);
        for(int i=0;i<4;i++)
        {
              scrivi.println("* * * *");
        }
	}

	public boolean esistenzaFile() {
		File a = new File(this.path);
		
		return a.exists();
	}

	public boolean turno() {
		 int i=0;
		FileReader f;
		try {
			f=new FileReader(this.path);
			BufferedReader b;
		    b=new BufferedReader(f);
		    String s=" ";	
		   
		    while(s!=null) {
		      s=b.readLine();
		      
		      if(s!=null)
		      if (s.length()!=7){	  
		    	  return false;
		    	  
		      }
		       
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
		return false;
		}
	    
	 return true;
	 
	}
	
	
	public boolean posizionaPedina(String posizione, String pedina){
		FileReader f;
		
		int riga = Integer.valueOf(posizione.substring(0,1));
		int colonna = Integer.valueOf(posizione.substring(1,2));
		ArrayList<String> fileScacchiera = new ArrayList<String>();
		
		
		try {
			f=new FileReader(this.path);
			BufferedReader b;
		    b=new BufferedReader(f);
		    String s=" ";	
		    int i = 0;
		    while(s==null) {
		      s=b.readLine();
		    if (i==riga){
		    	String[] array=s.split(" ");
		    	if (array[colonna]!="*")
		    			return false;
		    	else
		    	{
			    	array [colonna] = pedina;
		    		String appoggio = array [0] + " " + array [1] + " " ;
		    		appoggio = appoggio + array [2] + " " + array [3];
		    		fileScacchiera.add(appoggio);
		    		
		    	}
		    
		    }
		    
		    else {fileScacchiera.add(s);
		    
		    }
		      i++;
		    
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
		File file = new File(this.path);
		file.delete();
		
		FileOutputStream prova;
		try {
			prova = new FileOutputStream(this.path);
			PrintStream scrivi = new PrintStream(prova);
	        for(int i=0;i<4;i++)
	        {
	              scrivi.println(fileScacchiera.get(i));
	        }
	        return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
        
	
	}

	public int risultati() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}//end class