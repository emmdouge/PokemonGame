package Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import environment.Environment;
import exceptions.ItemException;

/**
 * MockDisplay for testing th invoker
 * @author Joshua Bartle
 *
 */
public class MockPokemonDisplay implements Display{
	
			ImageIcon i[] = {new ImageIcon(getClass().getResource("/Icons/blastoise.jpg")),
					new ImageIcon(getClass().getResource("/Icons/charizard.jpg")),
					new ImageIcon(getClass().getResource("/Icons/bulbasaur1.jpg")),
					new ImageIcon(getClass().getResource("/Icons/caterpie.jpg")),
					new ImageIcon(getClass().getResource("/Icons/charmander.jpg")),
					new ImageIcon(getClass().getResource("/Icons/charmeleon.jpg")),
					new ImageIcon(getClass().getResource("/Icons/ivysaur.jpg")),
					new ImageIcon(getClass().getResource("/Icons/poliwag.jpg")),
					new ImageIcon(getClass().getResource("/Icons/squirtle.jpg")),
					new ImageIcon(getClass().getResource("/Icons/venusaur.jpg")),
					new ImageIcon(getClass().getResource("/Icons/vulprix.jpg")),
					new ImageIcon(getClass().getResource("/Icons/wartortle.jpg"))};
			Environment e;
			JPanel choices[][] = new JPanel[3][2];
			//JFrame frame = new JFrame("Pokemon Game");
			JPanel screen = new JPanel(new GridLayout(3,2));
			
			JLabel selected = new JLabel();
			JLabel pok[][] = new JLabel[3][2];
			JLabel stats[][] = new JLabel[3][2];
			int sx = 0;
			int sy = 2;
	
			public MockPokemonDisplay(){
				
				for(int y = 0; y < 3; y++){
					for(int x = 0; x < 2; x++){
						choices[y][x] = new JPanel(new GridLayout(1,2));
						stats[y][x] = new JLabel(" TEST", JLabel.CENTER);
						pok[y][x] = new JLabel("", JLabel.CENTER);
					}
				}
				screen = getScreen();
			}
			
			public JPanel getScreen(){
				for(int y = 0; y < 3; y++){
					for(int x = 0; x < 2; x++){
						pok[y][x].setOpaque(true);
						choices[y][x].add(pok[y][x]);
						screen.add(choices[y][x]);
					}
				}
				return screen;
			}
			

			public MockPokemonDisplay getDisplay(){
				return this;
			}
			
			public void draw(){
				e = e.getMockEnv();
				try {
					e.setSelected(0, 0);
				} catch (ItemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				screen.revalidate();
				for(int y = 0; y < 3; y++)
					for(int x = 0; x < 2; x++){
						if(e.getPokemon(y, x) == e.getCurrentPlayer()){
							pok[y][x].setIcon(i[getIndex(e.getPokemon(y, x).getName())]);
							stats[y][x].setText("<html>" + e.getPokemon(y,x).getName() + "<br> HP: " + e.getPokemon(y, x).getCurrentHitpoints() + "</html>");
							choices[y][x].add(stats[y][x]);
							choices[y][x].add(pok[y][x], BorderLayout.CENTER);
							choices[y][x].setBackground(Color.GREEN);
							pok[y][x].setBackground(Color.green);
					}else
						if(e.getPokemon(y, x) == null){
							pok[y][x].setBackground(Color.GRAY);}
						else{
							pok[y][x].setIcon(i[getIndex(e.getPokemon(y, x).getName())]);
							stats[y][x].setText("<html>" + e.getPokemon(y,x).getName() + "<br> HP: " + e.getPokemon(y, x).getCurrentHitpoints() + " </html>");
							choices[y][x].add(stats[y][x]);
							choices[y][x].add(pok[y][x], BorderLayout.CENTER);
							choices[y][x].setBackground(Color.GRAY);
							pok[y][x].setBackground(Color.gray);}
				}
				screen.revalidate();
				screen.repaint();
				//System.out.println(e.getCurrentPlayer());
				//System.out.println(e.getPokemon(1,0));
			}
			
			public int getIndex(String s){
				if(s == "Blastoise")
					return 0;
				if(s == "Charizard")
					return 1;
				if(s == "Bulbasaur")
					return 2;
				if(s == "Caterpie")
					return 3;
				if(s == "Charmander")
					return 4;
				if(s == "Charmeleon")
					return 5;
				if(s == "Ivysaur")
					return 6;
				if(s == "Poliwag")
					return 7;
				if(s == "Squirtle")
					return 8;
				if(s == "Venusaur")
					return 9;
				if(s == "Vulpix")
					return 10;
				if(s == "Wartortle")
					return 11;
				return 0;
			}
}
