package Main;

import java.util.ArrayList;
import java.util.Random;

import riccardoAmaraA.Pedine;
import riccardoAmaraA.Scacchiera;

public class Main {

	public static void main(String[] args) {
		
		Pedine p=new Pedine("Res/pedine.txt");
		Scacchiera sc=new Scacchiera("Res/scacchiera.txt");
		
		//CONTROLLO SE I FILE ESISTONO E NON SIANO ILLEGGIBILI
		if(p.esistenzaFile()==false || sc.esistenzaFile()==false)
			System.exit(11);
			
			
		
		//CONTROLLO SE LA CONFIGURAZIONE DEI FILE pedine.txt È ERRATA
		if(p.leggibilitaFile()==false )
			System.exit(12);
		
		//CONTROLLO SE LA CONFIGURAZIONE DEI FILE scacchiera.txt È ERRATA
		if(sc.leggibilitaFile()==false )
			System.exit(13);
		
		
		//CONTROLLO ESITO
		int risultato=sc.risultati();
		//VITTORIA
		if(risultato==1)
		System.exit(1);
		//PAREGGIO
		if(risultato==2)
		System.exit(2);
		
		
		
			//INIZIA IL GIOCO , POSIZIONO PEDINA SCELTA DALL'UTENTE PRIMA 
			String pedina=p.dammiPedinaScelta();				
			String posizione;boolean check=true;
			Random random = new Random();
			do{			
			int r = random.nextInt(4);
			int c= random.nextInt(4);
			posizione=r+","+c;		
			int index=posizione.indexOf(",");
			check=true;
			if(index==-1){
				check=false;				
			}
			if(posizione.contains("[a-zA-Z]+")==true)
				{
				check=false;				
				}			
			}while(check==false);			
			sc.posizionaPedina(posizione, pedina);
			
			
			
			
			
			//SCELGO PEDINA PER PROSSIMO GIOCATORE
			check=true;
			do{
			ArrayList<String> pedine=p.getPedine();					
			String pScelta=pedine.get(random.nextInt(pedine.size()));
			if(pScelta.length()!=4){
				check=false;			
			}else{									
			check=p.inserisciAsterisco(pScelta);
			}			
			}while(check==false);
			
			
			
			 
			//CONTROLLO ESITO
			 risultato=sc.risultati();
			//VITTORIA
			if(risultato==1)
				System.exit(1);
			//PAREGGIO
			if(risultato==2)
			    System.exit(2);
			//PROSSIMO TURNO
			if(risultato==0)
				System.exit(0);
			
		
		
		
		
		
		

	}

}
