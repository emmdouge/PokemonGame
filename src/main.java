
import ai.AIContext;
import environment.Environment;
import pokemon.Blastoise;
import pokemon.Charmander;
import pokemon.PokeFactory;
import pokemon.Pokemon;
import pokemon.Poliwag;
import pokemon.Squirtle;
import pokemon.Vulprix;
import pokemon.Wartortle;
import Display.MockDisplayFrame;


public class main extends Thread{
	
	public static void main(String[] args) 
	{

	
		new main().start();
	
	}

	@Override
	public void run() {
		PokeFactory p = new PokeFactory();
		Environment.clearEnv();
		Environment.createMockEnv();
		Environment e = Environment.getMockEnv();
		AIContext ai = new AIContext(e);
		e.setAI(ai);
		Pokemon[] t = e.getTeam("target");
		e.setCurrentTarget(t[1]);
		Pokemon p1 = p.generatePokemon(p.Wartortle,3);
		Pokemon p2 = p.generatePokemon(p.Blastoise,22);
		Pokemon p3 = p.generatePokemon(p.Vulpix);
		Pokemon p4 = p.generatePokemon(p.Squirtle,50);
		Pokemon p5 = p.generatePokemon(p.Poliwag,80);
		Pokemon p6 = p.generatePokemon(p.Charmander,80);
		
		e.addPokemon(p1, 0, 0);
		e.addPokemon(p2, 0, 1);
		e.addPokemon(p3, 1, 0);
		e.addPokemon(p4, 1, 1);
		e.addPokemon(p5, 2, 0);
		e.addPokemon(p6, 2, 1);
		e.update();
	}
}