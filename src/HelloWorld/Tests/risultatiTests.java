package HelloWorld.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import riccardoAmaraA.Pedine;
import riccardoAmaraA.Scacchiera;

public class risultatiTests {

	
	@Before
	public void init() throws FileNotFoundException{
		Scacchiera sc=new Scacchiera("Res/scacchiera.txt");
		sc.creaScacchiera();
		Pedine pd=new Pedine("Res/pedine.txt");
		pd.scritturaFilePedine();
		
		
		String pedina=pd.scegliPedina();
		String posizione="1,2";
		
		
			//String pedina2 = pd.scegliPedina();
			//String posizione2 ="2,4";
			

			//sc.posizionaPedina(posizione, pedina);
			//sc.posizionaPedina(posizione2, pedina2);
	}
	
	
	@Test
	public void prossimoTurno() {		
		      
		//Scacchiera sc=new Scacchiera("Res/scacchiera.txt");
	
	
	//assertEquals(0, sc.risultati());
	
	
	}
	

}
	
