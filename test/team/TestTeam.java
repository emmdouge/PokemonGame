package team;

import static org.junit.Assert.*;

import java.util.Iterator;

import javax.swing.JOptionPane;

import org.junit.Test;

import pokemon.Pokemon;

public class TestTeam 
{

	@Test
	public void testInitialization() 
	{
		Team p = new PokeTeam();
		Team t = new TargetTeam();
		
		Iterator<Pokemon> pIterator = p.createIterator();
		Iterator<Pokemon> tIterator = t.createIterator();
		
		String msg = "";
		int countP = 0;
		while(pIterator.hasNext())
		{
			msg += pIterator.next().getName() + "\n";
			countP++;
		}
		
		assertEquals(6, countP);
		JOptionPane.showMessageDialog(null, msg);
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Were there six different Pokemon listed for the Pokemon team?"));
		
		msg = "";
		int countT = 0;
		while(tIterator.hasNext())
		{
			msg += tIterator.next().getName() + "\n";
			countT++;
		}
		
		assertEquals(6, countT);
		JOptionPane.showMessageDialog(null, msg);
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null,  "Were there six different Pokemon listed for the Target team?"));
	}

}
