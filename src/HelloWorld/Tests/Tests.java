package HelloWorld.Tests;

import static org.junit.Assert.*;
import org.junit.Test;


import riccardoAmaraA.Pedine;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tests {
	public Tests() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void scriviPedineTest() throws IOException{
		ArrayList<String> Pedine = new ArrayList<String>();
		Pedine.add("AWTF*");
		Pedine.add("ANTF");
		Pedine.add("AWQF");
		Pedine.add("ANQF");
		Pedine.add("AWTP");
		Pedine.add("ANTP");
		Pedine.add("AWQP");
		Pedine.add("ANQP");
		Pedine.add("BWTF");
		Pedine.add("BNTF");
		Pedine.add("BWQF");
		Pedine.add("BNQF");
		Pedine.add("BWTP");
		Pedine.add("BNTP");
		Pedine.add("BWQP");
		Pedine.add("BNQP");
		String path="Res/pedine.txt";
		Pedine p=new Pedine(path);
		p.scritturaFilePedine();
		FileReader f;
	    f=new FileReader(path);

	    BufferedReader b;
	    b=new BufferedReader(f);

	    String s;
	    int i=0;
	    while(true) {
	      s=b.readLine();
	      if(s==null)
	        break;	      
	      
	      assertEquals(Pedine.get(i).toString(),s);
	      i++;
	      
	    }
		
		
	}

}