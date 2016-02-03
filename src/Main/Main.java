package Main;

import java.util.ArrayList;
import java.util.Scanner;

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
			System.out.println("La pedina da posizionare è "+pedina);
			Scanner in = new Scanner(System.in);
			String posizione;boolean check=true;
			do{
			System.out.println("Dammi le coordinate (riga,colonna):");
			posizione=in.nextLine();		
			int index=posizione.indexOf(",");
			check=true;
			if(index==-1){
				check=false;
				System.out.println("Input errato");
			}
			if(posizione.contains("[a-zA-Z]+")==true)
				{
				check=false;
				System.out.println("Input errato");
				}
			
			
			}while(check==false);			
			sc.posizionaPedina(posizione, pedina);
			
			
			
			
			
			//SCELGO PEDINA PER PROSSIMO GIOCATORE
			check=true;
			do{
			System.out.println("Scegli Pedina per il prossimo turno:");
			ArrayList<String> pedine=p.getPedine();
			for(int i=0;i<pedine.size();i++)
				System.out.println(pedine.get(i));
			String pScelta=in.nextLine();
			if(pScelta.length()!=4){
				check=false;
			System.out.println("Input errato");
			}
									
			check=p.inserisciAsterisco(pScelta);		
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
