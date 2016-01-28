package HelloWorld.Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import riccardoAmaraA.Scacchiera;

public class scacchieraTests{
	
	public scacchieraTests() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void scritturaTest() throws IOException{
		String path="Res/scacchiera.txt";
		Scacchiera sc=new Scacchiera(path);
		sc.creaScacchiera();
		
		 FileReader f;
		    f=new FileReader(path);

		    BufferedReader b;
		    b=new BufferedReader(f);

		    String s;

		    while(true) {
		      s=b.readLine();
		      if(s==null)
		        break;
		      assertEquals("* * * *",s);
		    }
		
	}
}