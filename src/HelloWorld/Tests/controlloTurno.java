package HelloWorld.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import riccardoAmaraA.Pedine;
import riccardoAmaraA.Scacchiera;

public class controlloTurno {
	public controlloTurno(){
		
	}
	
	@Test
	public void turnoTest(){
		Pedine p = new Pedine("Res/pedine.txt");
		Scacchiera s = new Scacchiera ("Res/scacchiera.txt");
		
		assertTrue(p.turno());
		//System.out.println(s.turno());
		assertFalse(s.turno());
	}
	
	
	
	@Test
	public void statoPartita(){
	int partitaIniziata;
	
	Pedine p = new Pedine("Res/pedine.txt");
	Scacchiera s = new Scacchiera ("Res/scacchiera.txt");
	
	if ((p.turno() == true) && (s.turno()== true))
		partitaIniziata = 1;
		else if ((p.turno() == false) && (s.turno()== false))
			partitaIniziata = 2;
		else
			partitaIniziata = 0;
	
	if (partitaIniziata == 1){
		assertEquals(p.scegliPedina(), "ANTF");
		String pedina=p.scegliPedina();
		String posizione="1,2";
		
		
		
//		pedina = posizionaPedina();
		
		
	}
		
	
	}	
	
}
