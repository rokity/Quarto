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

	
//	
	
	
	public boolean posizionaPedina(String posizione, String pedina){
		FileReader f;
		
		posizione=posizione.toLowerCase();
		int riga = Integer.valueOf(posizione.charAt(0))-48;
		//System.out.println(riga);
		int colonna = Integer.valueOf(posizione.charAt(2))-48;
		//System.out.println(colonna);
		ArrayList<String> fileScacchiera = new ArrayList<String>();
		
		
		try {
			f=new FileReader(this.path);
			BufferedReader b;
		    b=new BufferedReader(f);
		    String s=" ";	
		    int i = 0;
		    while((s=b.readLine())!=null) {
		       
		    if (i==riga){
		    	String[] array=s.split(" ");	    	
		    		    	
			    	array [colonna] = pedina;
		    		String appoggio = array [0] + " " + array [1] + " " ;
		    		appoggio = appoggio + array [2] + " " + array [3];
		    		fileScacchiera.add(appoggio);
		    		
		    	
		    
		    }		    
		    else {
		    	fileScacchiera.add(s);
		    
		    }
		      i++;
		    
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("NN HA SCRITTO");
			//return false;
		}
		
		
		File file = new File(this.path);
		file.delete();
		
		FileOutputStream prova;
		try {
			prova = new FileOutputStream(this.path);
			PrintStream scrivi = new PrintStream(prova);
	        for(int i=0;i<fileScacchiera.size();i++)
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
		FileReader f;
		String[][] matrice= new String[4][4];
		
		try {
			f=new FileReader(this.path);		
		BufferedReader b=new BufferedReader(f);
	    String s=null;	
	    int r=0;
	    
	    
	    while((s=b.readLine())!=null) {
		      
		      String[] riga=s.split(" ");
		      
		      for(int i=0;i<riga.length;i++){
		    	   matrice[r][i]=riga[i];
		    	  }
		      r++;
		      
	    }
	    
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		boolean result=false;
		//CONTROLLO RIGA
		for(int i=0;i<4;i++)
		if(this.controlloCongruenzaCaratteristica(matrice[i]))return 1;
		//CONTROLLO COLONNA
		for(int i=0;i<4;i++){
		String[] array={matrice[0][i],matrice[1][i],matrice[2][i],matrice[3][i]};
		if(this.controlloCongruenzaCaratteristica(array))return 1;
		}
		//CONTROLLO DIAGONALE
		String[] array={matrice[0][0],matrice[1][1],matrice[2][2],matrice[3][3]};
		String[] array1={matrice[0][3],matrice[1][2],matrice[2][1],matrice[3][0]};
		if(this.controlloCongruenzaCaratteristica(array))return 1;
		if(this.controlloCongruenzaCaratteristica(array1))return 1;
		
		
		
		
			if(this.pareggio()==true){
				System.out.println("PAREGGIO");
				return 2;//PAREGGIO
			}
			else{System.out.println("PROSSIMO TURNO");
				return 0;//NESSUN VINCITORE,NESSUNA PARITA
			}
					
	}
	
	private boolean pareggio(){
		FileReader f;
		int r=0;
		try {
			f=new FileReader(this.path);		
		BufferedReader   b=new BufferedReader(f);
	    String s=" ";		    
	    while((s=b.readLine())!=null) {
		       
		      if(s.length()==19)
		      r++;
		      
	    }
	    
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.exit(0);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.exit(0);
	}
		if(r==4)
			return true;
		else
			return false;
					
		
	
	}
	
	private boolean controlloCongruenzaCaratteristica(String[] rigaScacchiera){
		int count=0;
		
		for(int i=0;i<rigaScacchiera[0].length();i++){			
			for(int j=1;j<rigaScacchiera.length;j++){
				if(rigaScacchiera[j].length()==4){
				if(rigaScacchiera[j].charAt(i)==rigaScacchiera[0].charAt(i))
					count++;
				}
			}
			if(count==3)
				return true;
			else
				count=0;
			}
	
		return false;
	}

	public boolean leggibilitaFile() {
		
		FileReader f;
		int r=0;
		try {
			f=new FileReader(this.path);		
		BufferedReader   b=new BufferedReader(f);
	    String s=" ";		    
	    while((s=b.readLine())!=null) {
		     
		      String[] riga=s.split(" ");
		      for(int i=0;i<riga.length;i++){
		    	  if(riga[i].length()!=4) 
		    		  if(riga[i].charAt(0)!='*')
		    			  return false;
		      }
	    }
	    
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.exit(0);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.exit(0);
	}
		return true;
	}
	
	
	
	
}//end class