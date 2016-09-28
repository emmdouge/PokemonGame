package Display;

import moves.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.Environment;
import moves.Move;

/**
 * Mock display for testing invoker
 * @author Joshua Bartle
 *
 */
public class MockFightDisplay implements Display{

	ImageIcon p[] = { new ImageIcon(getClass().getResource("/player/3.png")),
					new ImageIcon(getClass().getResource("/player/2.png")),
					new ImageIcon(getClass().getResource("/player/1.png")),
					new ImageIcon(getClass().getResource("/player/6.png")),
					new ImageIcon(getClass().getResource("/player/5.png")),
					new ImageIcon(getClass().getResource("/player/10.png")),
					new ImageIcon(getClass().getResource("/player/8.png")),
					new ImageIcon(getClass().getResource("/player/7.png")),
					new ImageIcon(getClass().getResource("/player/9.png")),
					new ImageIcon(getClass().getResource("/player/37.png")),
					new ImageIcon(getClass().getResource("/player/60.png")),
					new ImageIcon(getClass().getResource("/player/charmander.png"))};
	
	ImageIcon ai[] = { new ImageIcon(getClass().getResource("/icons/3.png")),
			new ImageIcon(getClass().getResource("/icons/2.png")),
			new ImageIcon(getClass().getResource("/icons/1.png")),
			new ImageIcon(getClass().getResource("/icons/6.png")),
			new ImageIcon(getClass().getResource("/icons/5.png")),
			new ImageIcon(getClass().getResource("/icons/10.png")),
			new ImageIcon(getClass().getResource("/icons/8.png")),
			new ImageIcon(getClass().getResource("/icons/7.png")),
			new ImageIcon(getClass().getResource("/icons/9.png")),
			new ImageIcon(getClass().getResource("/icons/37.png")),
			new ImageIcon(getClass().getResource("/icons/60.png")),
			new ImageIcon(getClass().getResource("/icons/4.png"))};
	
	Environment e;
	
	JPanel screen = new JPanel(new GridLayout(4,2));
	JPanel options = new JPanel(new GridLayout(2,2));
	JLabel fight = new JLabel("FIGHT", JLabel.CENTER);
	JLabel bag = new JLabel("BAG", JLabel.CENTER);
	JLabel switchpok = new JLabel("Swap", JLabel.CENTER);
	JLabel run = new JLabel("Run", JLabel.CENTER);
	JLabel attack1 = new JLabel("", JLabel.CENTER);
	JLabel attack2 = new JLabel("", JLabel.CENTER);
	JLabel attack3 = new JLabel("", JLabel.CENTER);
	JLabel attack4 = new JLabel("", JLabel.CENTER);
	JLabel pstat = new JLabel("", JLabel.CENTER);
	JLabel aistat = new JLabel("", JLabel.CENTER);
	
	JPanel selected = new JPanel();
	JLabel pok[][] = new JLabel[4][2];
	JPanel back[][] = new JPanel[4][2];
	int sx = 0;
	int sy = 2;
	Move moves[];

	public MockFightDisplay(){
		for(int y = 0; y < 4; y++){
			for(int x = 0; x < 2; x++){
				back[y][x] = new JPanel(new BorderLayout());
				pok[y][x] = new JLabel("", JLabel.CENTER);
			}
		}
		screen = getScreen();
	}
	
	public JPanel getScreen(){
		for(int y = 0; y < 4; y++)
			for(int x = 0; x < 2; x++){
				if(x == 1 && y == 3){
					screen.add(options);
				}else{
					pok[y][x].setBackground(Color.BLACK);
					back[y][x].add(pok[y][x]);
				}
		}
		options.add(fight);
		options.add(bag);
		options.add(switchpok);
		options.add(run);
		return screen;
	}
	

	public MockFightDisplay getDisplay(){
		return this;
	}
	
	public void draw(){
		e = e.getMockEnv();
		screen.revalidate();
		for(int y = 0; y < 4; y++)
			for(int x = 0; x < 2; x++){
				if(x == 1 && y == 3){
					screen.add(options);
				}else{
					if(x == 1 && y == 0){
						aistat.setText("HP: " + e.getCurrentTarget().getCurrentHitpoints() +"");
						back[y][x].add(aistat);
						back[y][x].setBackground(Color.GRAY);
					}else
					if(x == 0 && y == 2){
						pok[y][x].setIcon(p[getPokemon(e.getCurrentPlayer().getName())]);
						back[y][x].setBackground(Color.black);
					}else
					if(x == 1 && y == 1){
						pok[y][x].setIcon(ai[getPokemon(e.getCurrentTarget().getName())]);
						back[y][x].add(pok[y][x], BorderLayout.CENTER);
						back[y][x].setBackground(Color.BLACK);
					}else
					if(x == 0 && y == 3)
					{
						pstat.setText("HP: " + e.getCurrentPlayer().getCurrentHitpoints() +"");
						back[y][x].add(pstat);
						back[y][x].setBackground(Color.GRAY);
					}else
					back[y][x].setBackground(Color.black);
					screen.add(back[y][x]);
				}
		}
	if(e.areAttacking() == false){
		options.removeAll();
		bag.setBackground(Color.green);
		switchpok.setBackground(Color.green);
		run.setBackground(Color.green);
		fight.setBackground(Color.green);
		options.setBackground(Color.white);
		
		bag.setOpaque(false);
		run.setOpaque(false);
		fight.setOpaque(false);
		switchpok.setOpaque(false);
		
		if(e.getfightOption() == 0)
			fight.setOpaque(true);
		if(e.getfightOption() == 1)
			bag.setOpaque(true);
		if(e.getfightOption() == 2)
			switchpok.setOpaque(true);
		if(e.getfightOption() == 3)
			run.setOpaque(true);
		
		options.add(fight);
		options.add(bag);
		options.add(switchpok);
		options.add(run);
		//System.out.println(e.areAttacking());
	}
	else{
		options.removeAll();
		attack1.setBackground(Color.green);
		attack2.setBackground(Color.green);
		attack3.setBackground(Color.green);
		attack4.setBackground(Color.green);
		//options.setBackground(Color.white);
		
		attack1.setOpaque(false);
		attack2.setOpaque(false);
		attack3.setOpaque(false);
		attack4.setOpaque(false);
		
		if(e.getAttackIndex() == 0)
			attack1.setOpaque(true);
		if(e.getAttackIndex() == 1)
			attack2.setOpaque(true);
		if(e.getAttackIndex() == 2)
			attack3.setOpaque(true);
		if(e.getAttackIndex() == 3)
			attack4.setOpaque(true);
	
		moves = e.getCurrentPlayer().getAttacks();
		attack1.setText(moves[0].getName());
		attack2.setText(moves[1].getName());
		attack3.setText(moves[2].getName());
		attack4.setText(moves[3].getName());
		options.add(attack1);
		options.add(attack2);
		options.add(attack3);
		options.add(attack4);
		//System.out.println("attacks being chosen");
	}
		screen.revalidate();
		screen.repaint();

	}

	public int getPokemon(String s){
		if(s == "Venusaur")
			return 0;
		if(s == "Ivysaur")
			return 1;
		if(s == "Bulbasaur")
			return 2;
		if(s == "Charizard")
			return 3;
		if(s == "Charmeleon")
			return 4;
		if(s == "Caterpie")
			return 5;
		if(s == "Wartortle")
			return 6;
		if(s == "Squirtle")
			return 7;
		if(s == "Blastoise")
			return 8;
		if(s == "Vulpix")
			return 9;
		if(s == "Poliwag")
			return 10;
		if(s == "Charmander")
			return 11;
		
		return 0;
	}
}
