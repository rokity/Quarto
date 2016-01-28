package HelloWorld.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import riccardoAmaraA.Pedine;
import riccardoAmaraA.Scacchiera;

public class fileControlloTest  {
	public fileControlloTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void esistenzaFileTest(){
		Pedine p = new Pedine("Res/pedine.txt");
		Scacchiera s = new Scacchiera ("Res/scacchiera.txt");
		
		Pedine pe = new Pedine("Res/nnnnn.txt");
	
		assertTrue(p.esistenzaFile());
		assertFalse(pe.esistenzaFile());
		
		assertTrue(s.esistenzaFile());
	}
	
	@Test
	public void controlloFileCorrotto(){
		Pedine p = new Pedine("Res/pedine.txt");
		assertTrue( p.leggibilitaFile());
	}

}
